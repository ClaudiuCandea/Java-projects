package Bll.Validators;

import Model.Product;

/**
 * Class for validating the quantity of product
 */

public class QuantityValidator implements Validator<Product> {

    /**
     * Method for validating the quantity of product
     * @param product Product to be validate
     */
    public void validate(Product product) {
        if(product.getQuantity()<0){
            throw new IllegalArgumentException(" Product quantity will be negativ after this operation!!");
        }
    }
}
