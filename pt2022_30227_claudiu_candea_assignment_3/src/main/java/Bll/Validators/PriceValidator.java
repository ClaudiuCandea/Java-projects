package Bll.Validators;

import Model.Product;
/**
 * Class for validating the price of a product
 */

public class PriceValidator implements Validator<Product> {
    /**
     * Method for validating the price of a product
     * @param product Product to be validate
     */
    public void validate(Product product) {
        if(product.getPrice()<0){
            throw new IllegalArgumentException("Price is negative!!");
        }
    }
}
