package DAO;

import Bll.ProductBLL;
import Model.Client;
import Model.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Class for creat insert and update queries for the Product table
 */

public class ProductDAO extends AbstractDAO<Product> {

    public ProductDAO(){
        super();
    }

    /**
     * Create insert query for Product table
     * @return String
     */
    public String createInsertQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO product (name,quantity,price) VALUES(?,?,?)");
        return sb.toString();
    }
    /**
     * Create update query for Product table
     * @return String
     */
    public String createUpdateQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE product SET name=?, quantity=?, price=? WHERE id=?");
        return sb.toString();
    }

    /**
     * Set values for insert statement in Product table
     * @param statement insert statement
     * @param product product to insert
     */
    public void setInsertValues(PreparedStatement statement, Product product){
        try {
            statement.setString(1,product.getName());
            statement.setInt(2,product.getQuantity());
            statement.setInt(3,product.getPrice());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set values for update statement in Product table
     * @param statement update statement
     * @param product updated product
     */
    public void setUpdateValues(PreparedStatement statement, Product product){
        try {
            statement.setString(1,product.getName());
            statement.setInt(2,product.getQuantity());
            statement.setInt(3,product.getPrice());
            statement.setInt(4,product.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
