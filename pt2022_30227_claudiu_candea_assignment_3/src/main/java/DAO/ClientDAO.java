package DAO;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import Connection.ConnectionFactory;
import Model.Client;

import java.util.logging.Logger;

/**
 * Class for creat insert and update queries for the Client table
 */

public class ClientDAO extends AbstractDAO<Client> {

    public ClientDAO(){
        super();
    }

    /**
     * Create query for insert in Client table
     * @return String
     */
    public String createInsertQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO client (name,email,age) VALUES(?,?,?)");
        return sb.toString();
    }

    /**
     * Create query for update in Client table
     * @return String
     */
    public String createUpdateQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE client SET name=?, email=?, age=? WHERE id=?");
        return sb.toString();
    }

    /**
     * Set the values for the insert statement in Client table
     * @param statement insert statement
     * @param client client to insert
     */
    public void setInsertValues(PreparedStatement statement,Client client){
        try {
            statement.setString(1,client.getName());
            statement.setString(2,client.getEmail());
            statement.setInt(3,client.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the values for the update state in Client table
     * @param statement update statement
     * @param client client to update
     */
    public void setUpdateValues(PreparedStatement statement, Client client){
        try {
            statement.setString(1,client.getName());
            statement.setString(2,client.getEmail());
            statement.setInt(3,client.getAge());
            statement.setInt(4,client.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
