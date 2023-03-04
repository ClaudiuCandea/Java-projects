package Model;
/**
 *Class that represent the data for a order stored in the Orders table
 */

public class Orders {

    private int id;
    private String productName;
    private String clientName;
    private int quantity;

    /**
     * Constuctor with parameter
     * @param id id value
     * @param quantity quantity value
     * @param productName productName value
     * @param clientName clientName value
     */
    public Orders(int id, int quantity, String productName, String clientName){
        this.id=id;
        this.quantity=quantity;
        this.productName=productName;
        this.clientName=clientName;
    }

    /**
     * Constructor without parameter
     */
    public Orders(){

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
     * Return product name value
     * @return String
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set product name value
     * @param productName set value
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Return client name value
     * @return String
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * Set client name value
     * @param clientName set value
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
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
}
