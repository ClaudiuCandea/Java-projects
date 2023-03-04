package Model;
/**
 *Class that represent the data for a product stored in the Product table
 */

public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;

    /**
     * Constructor with parameters
     * @param id id value
     * @param name name value
     * @param quantity quantity value
     * @param price price value
     */
    public Product(int id, String name, int quantity, int price){
        this.id=id;
        this.name=name;
        this.quantity=quantity;
        this.price=price;
    }

    /**
     * Constructor without parameters
     */
    public Product(){

    }

    /**
     * Return name value
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set name value
     * @param name set value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return quantity value
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set quantity value
     * @param quantity set value
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Return id value
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Set id value
     * @param id set value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return price value
     * @return int
     */
    public int getPrice() {
        return price;
    }

    /**
     * Set price value
     * @param price set value
     */
    public void setPrice(int price) {
        this.price = price;
    }
}
