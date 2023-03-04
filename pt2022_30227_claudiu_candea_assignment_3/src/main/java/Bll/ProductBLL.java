package Bll;

import Bll.Validators.*;
import DAO.ClientDAO;
import DAO.ProductDAO;
import Model.Client;
import Model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for operation with products
 */

public class ProductBLL {

    private List<Validator<Product>> validators;
    private ProductDAO productDAO;

    /**
     * Constructor without parameters
     */
    public ProductBLL() {
        validators = new ArrayList<Validator<Product>>();
        validators.add(new PriceValidator());
        validators.add(new QuantityValidator());

        productDAO=new ProductDAO();
    }

    /**
     * Method for find a product by id
     * @param id search id
     * @return Product
     */
    public Product findProductById(int id) {
        Product product = productDAO.findById(id);
        if (product == null) {
            throw new NoSuchElementException("The product with id =" + id + " was not found!");
        }
        return product;
    }

    /**
     * Method for find all products
     * @return List<Product>
     */
    public List<Product> findAllProduct(){
        List<Product> list = productDAO.findAll();
        return list;
    }

    /**
     * Method for insert a product
     * @param product inserted product
     * @return int
     */
    public int insertProduct(Product product) {
        for (Validator<Product> v : validators) {
            v.validate(product);
        }
        return productDAO.insert(product);
    }

    /**
     * Method for update a product
     * @param product updated product
     * @return int
     */
    public int updateProduct(Product product){
        for(Validator<Product> v : validators){

            v.validate(product);
        }
        return productDAO.update(product);
    }

    /**
     * Method for delete a product
     * @param id
     * @return int
     */
    public int deleteProduct(int id){
        int deletedId = productDAO.delete(id);
        if(deletedId==0){
            throw new NoSuchElementException("The Product with id =" + id + " was not found!");
        }
        return deletedId;
    }
}
