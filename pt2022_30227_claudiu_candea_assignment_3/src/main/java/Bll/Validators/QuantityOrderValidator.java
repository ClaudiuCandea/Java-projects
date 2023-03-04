package Bll.Validators;

import Model.Orders;

/**
 * Class for validating the quantity of an order
 */

public class QuantityOrderValidator implements Validator<Orders> {

    /**
     * Method for validating the quantity of an order
     * @param order Order to be validate
     */
    public void validate(Orders order) {
        if(order.getQuantity()<0){
            throw new IllegalArgumentException(" Order quantity is negativ!!");
        }
    }
}
