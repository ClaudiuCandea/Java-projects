package DAO;

import Model.Orders;
import Model.Product;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * Class for creat insert queries for the Orders table
 */

public class OrderDAO extends AbstractDAO<Orders>{
    public OrderDAO(){
        super();
    }

    /**
     * Create insert query for Orders table
     * @return String
     */
    public String createInsertQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO orders (productName,clientName,quantity) VALUES(?,?,?)");
        return sb.toString();
    }

    /**
     * Set values for insert statement in Orders table
     * @param statement
     * @param order
     */
    public void setInsertValues(PreparedStatement statement, Orders order){
        try {
            statement.setString(1,order.getProductName());
            statement.setString(2,order.getClientName());
            statement.setInt(3,order.getQuantity());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
