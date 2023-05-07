package BusinessLayer;

import DataLayer.FileWriter;
import PresentationLayer.Observer;

import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @invariant menu != null && user!= null
 */
public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {

    private List<MenuItem> menu;
    private HashMap<Order,ArrayList<MenuItem>> hashMap;
    private ArrayList<Observer> observers;
    private ArrayList<User> users;
    private FileWriter fileWriter;

    public DeliveryService(){
        menu = new ArrayList<MenuItem>();
        hashMap = new HashMap<Order,ArrayList<MenuItem>>();
        observers = new ArrayList<Observer>();
        users = new ArrayList<User>();
        fileWriter = new FileWriter();
    }

    /**
     * Method that add a new user
     * @param user the new user
     */
    public void addUser(User user){
        users.add(user);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    /**
     * Method that create the menu from a csv file
     */
    @Override
    public void importProduct() {
        try {
            List<MenuItem> menuAux = new ArrayList<MenuItem>();
            FileReader fileReader = new FileReader("products.csv");
            BufferedReader bufferReader = new BufferedReader(fileReader);
            String line;
            bufferReader.readLine();
            line = bufferReader.readLine();
            while(line!=null){
                line=line.replaceAll("\"","");
                String[] fields = line.split(",");
                BaseProduct baseProduct = new BaseProduct(fields[0],Double.parseDouble(fields[1]),Double.parseDouble(fields[2]),Double.parseDouble(fields[3]),Double.parseDouble(fields[4]),Double.parseDouble(fields[5]),Double.parseDouble(fields[6]));
                menuAux.add(baseProduct);
                line = bufferReader.readLine();
            }
            menu = menuAux.stream().filter(distinctByKey((p->p.getTitle()))).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method to add a new baseProduct to menu
     * @param product baseProduct to add in menu
     */
    @Override
    public void addProduct(BaseProduct product) {
        assert product != null;
        menu.add(product);
    }

    /**
     * Method to delete a menuItem from menu
     * @param productName name of the product to be deleted
     */
    @Override
    public void deleteProduct(String productName) {
        assert productName!=null;
        int index=-1;
        for(int i=0;i< menu.size();i++){
            if(menu.get(i).getTitle().equals(productName)){
                index=i;
            }
        }
        if(index!=-1) {
            menu.remove(index);
        }
    }

    /**
     * Method to modify the price of a baseProduct from the menu
     * @param title name of the product
     * @param price the new price
     */
    @Override
    public void modifyProduct(String title, double price) {
        assert title!=null && price>0;
        for(MenuItem item : menu){
            if(item.getTitle().equals(title)){
                item.setPrice(price);
            }
        }
    }

    /**
     * Method to create a new CompositeProduct from a list of baseProduct
     * @param list list of base baseProduct
     * @param title name of the new CompositeProduct
     */
    @Override
    public void createCompositeProduct(List<BaseProduct> list,String title) {
        assert title!=null && list != null;
        CompositeProduct product = new CompositeProduct(title);
        for(BaseProduct baseProduct : list){
            product.add(baseProduct);
        }
        menu.add(product);
    }

    /**
     * Method to generate report1
     * @param startHour
     * @param endHour
     */
    @Override
    public void generateReport1(int startHour, int endHour) {
        assert startHour>0 && startHour<24 && endHour>0 && endHour<24;
        List<Order> list = hashMap.keySet().stream().filter(e->e.compareHour(startHour,endHour)).collect(Collectors.toList());
        if(list.size()!=0) {
            fileWriter.createReportFile(list, "Report1.pdf");
        }
    }

    /**
     * Method to generate report3
     * @param totalPriceMin minimum total price of the order
     * @param nrOrdersMin minimum number of orders
     */
    @Override
    public void generateReport3(double totalPriceMin, int nrOrdersMin) {
        assert totalPriceMin>0 && nrOrdersMin>0;
        List<Order> listAux = hashMap.entrySet().stream().filter(e->e.getKey().computeTotalPrice(e.getValue())>totalPriceMin).map(Map.Entry::getKey).collect(Collectors.toList());
        List<Order> listAux2 = new ArrayList<>();
        for(Order order : listAux){
            long number = listAux.stream().filter(e->e.getUsername().equals(order.getUsername())).count();
            if((int)number>nrOrdersMin){
                listAux2.add(order);
            }
        }
        List<Order> result = listAux.stream().distinct().collect(Collectors.toList());
        if(result.size()!=0) {
            fileWriter.createReportFile(result, "Report3.pdf");
        }
    }

    /**
     * Method to generate report2
     * @param numberOfOrders minimum number of orders
     */
    public void generateReport2(int numberOfOrders){
        assert numberOfOrders>0;
        List<ArrayList<MenuItem>> listAux = hashMap.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        List <MenuItem> listAux2 = listAux.stream().flatMap(List::stream).collect(Collectors.toList());
        List<MenuItem> result = new ArrayList<>();
        for(MenuItem menuItem : listAux2){
            long number = listAux2.stream().filter(e->e.getTitle().equals(menuItem.getTitle())).count();
            if((int)number>numberOfOrders){
                result.add(menuItem);
            }
        }
        List<MenuItem> result2 = result.stream().distinct().collect(Collectors.toList());
        if(result2.size()!=0) {
            fileWriter.createReportFileWithProduct(result, "Report2.pdf");
        }

    }

    /**
     * Method to generate report4
     * @param date the date of the orders
     * @param numberOfOrders minimum number of orders
     */
    public void generateReport4(Date date, int numberOfOrders){
        assert date!=null && numberOfOrders>0;
        System.out.println(date);
        Map<Order,ArrayList<MenuItem>> hashMapAux = hashMap.entrySet().stream().filter(e->e.getKey().compareDate(date)).collect(Collectors.toMap(e->e.getKey(),e->e.getValue()));
        List<ArrayList<MenuItem>> listAux = hashMapAux.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
        List <MenuItem> listAux2 = listAux.stream().flatMap(List::stream).collect(Collectors.toList());
        System.out.println(listAux2);
        List<MenuItem> result = new ArrayList<>();
        for(MenuItem menuItem : listAux2){
            long number = listAux2.stream().filter(e->e.getTitle().equals(menuItem.getTitle())).count();
            if((int)number==numberOfOrders){
                result.add(menuItem);
            }
        }
        List<MenuItem> result2 = result.stream().distinct().collect(Collectors.toList());
        if(result2.size()!=0) {
            fileWriter.createReportFileWithProduct(result, "Report4.pdf");
        }
    }


    /**
     * Method to register a new client
     * @param username client's username
     * @param password client's password
     * @throws IllegalArgumentException
     */
    @Override
    public void registerClient(String username, String password) throws IllegalArgumentException{
        assert username!=null && password!=null;
        for(User user : users){
            if(user.getUsername().equals(username)){
                throw new IllegalArgumentException("User already exist");
            }
        }
        User client = new User(username,password,"Client");
        users.add(client);
    }

    /**
     * Method to create a new order
     * @param list list of products
     * @param username name of the client
     */
    @Override
    public void createOrder(ArrayList<MenuItem> list, String username) {
        assert list!=null && username!=null;
        Order order = new Order(hashMap.size(),username,new Date());
        hashMap.put(order,list);
        fileWriter.creatPDF(order,list);
        notifyObservers(order,list);
    }

    /**
     * Method to search products
     * @param keyword keyword for search
     * @param rating rating of the products we want to search
     * @param calories calories of the products we want to search
     * @param protein protein of the products we want to search
     * @param fat fat of the products we want to search
     * @param sodium sodium of the products we want to search
     * @param price price of the products we want to search
     * @return
     */
    @Override
    public List<MenuItem> searchProducts(String keyword, double rating, double calories, double protein, double fat, double sodium, double price) {
        assert keyword != null && rating>0 && calories>0 && protein>0 && fat>0 && sodium>0 && price>0;
        List<MenuItem> result = new ArrayList<>();
        result = menu.stream().filter(s->s.containGivenSubstring(keyword) && s.ratingFilter(rating) && s.caloriesFilter(calories) && s.priceFilter(protein) && s.fatFilter(fat) && s.sodiumFilter(sodium) && s.priceFilter(price)).collect(Collectors.toList());
        assert result!=null;
        return result;
    }

    /**
     * Register a new observer
     * @param o the new observer
     */
    @Override
   public void registerObserver(Observer o) {
        observers.add(o);
    }

    /**
     * Unregister an observer
     * @param o the observer to be unregistered
     */
    @Override
   public void unregisterObserver(Observer o) {
        observers.remove(observers.indexOf(o));

    }

    /**
     * Notify the observers about a new order that has been created
     * @param order the new order created
     * @param list order's list of products
     */
    @Override
    public void notifyObservers(Order order,ArrayList<MenuItem> list) {
            for (Observer o : observers) {
                o.update(order, list);
            }
    }

    /**
     * Method to find if a certain user exist
     * @param name Name of the user we want to find
     * @param password Password of the user we want to find
     * @return
     * @throws IllegalArgumentException
     */
    public User findUser(String name, String password) throws IllegalArgumentException{
        for(User user : users){
            if(user.getUsername().equals(name) && user.getPassword().equals(password)){
                return user;
            }
        }
        throw new IllegalArgumentException("Invalid users");
    }

    /**
     * Getter for the menu list
     * @return
     */
    public List<MenuItem> getMenu() {
        return menu;
    }

    /**
     * Getter for the hashMap of orders
     * @return
     */
    public HashMap<Order, ArrayList<MenuItem>> getHashMap() {
        return hashMap;
    }

}
