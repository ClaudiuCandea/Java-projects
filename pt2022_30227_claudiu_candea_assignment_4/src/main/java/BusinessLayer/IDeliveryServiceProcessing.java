package BusinessLayer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public interface IDeliveryServiceProcessing {
    /**
     *
     */
    void importProduct();

    /**
     * @pre product != null
     *
     */
    void addProduct(BaseProduct product);

    /**
     * @pre productName != null
     * @param productName
     */
    void deleteProduct(String productName);

    /**
     * @pre title!= null && price>0
     * @param title
     * @param price
     */
    void modifyProduct(String title, double price);

    /**
     * title != null && list!=null
     * @param list
     * @param title
     */
    void createCompositeProduct(List<BaseProduct> list,String title);

    /**
     * @pre startHour>0 && startHour<24 && endHour>0 && endHour<24
     * @post @nochange
     * @param startHour
     * @param endHour
     */
    void generateReport1(int startHour,int endHour);

    /**
     * @pre totalPriceMin>0 && nrOrdersMin>0
     * @post @nochange
     * @param totalPriceMin
     * @param nrOrdersMin
     */
    void generateReport3(double totalPriceMin, int nrOrdersMin);

    /**
     * @pre numberOfOrders>0
     * @post @nochange
     * @param numberOfOrders
     */
    void generateReport2(int numberOfOrders);

    /**
     * @pre date!=null && numberOfOrders>0
     * @param date
     * @param numberOfOrders
     */
    void generateReport4(Date date, int numberOfOrders);

    /**
     * username!=null && password!=null
     * @param username
     * @param password
     */
    void registerClient(String username,String password);

    /**
     * @pre list!=null && username!=null
     * @param list
     * @param username
     */
    void createOrder(ArrayList<MenuItem> list, String username);

    /**
     * @pre keyword != null && rating>0 && calories>0 && protein>0 && fat>0 && sodium>0 && price>0
     * @post @result != null
     * @param keyword
     * @param rating
     * @param calories
     * @param protein
     * @param fat
     * @param sodium
     * @param price
     * @return
     */
    List<MenuItem> searchProducts(String keyword, double rating, double calories, double protein, double fat, double sodium, double price);

}
