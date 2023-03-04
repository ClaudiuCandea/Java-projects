package DAO;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Class for insert, delete, find and update the tables in the database.
 * This class use reflection to implements the operations with the database
 */

import Connection.ConnectionFactory;


public class AbstractDAO<T> {
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    /**
     * Create a select query
     * @param id search id
     * @return
     */
    private String createSelectQuery(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT");
        sb.append(" * ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE id" + "=?");
        return sb.toString();
    }

    /**
     * Createa a find all query
     * @return
     */
    private String createFindAllQuery(){
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT * ");
        sb.append("FROM ");
        sb.append(type.getSimpleName());
        return sb.toString();
    }

    /**
     * Create a delete query
     * @param field name of the Table
     * @return String
     */
    private String createDeleteQuery(String field){
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * This method will be overwrited in ClientDAO, ProductDAO, OrderDAO
     * @return String
     */
    public  String createInsertQuery(){
        return null;
    }
    /**
     * This method will be overwrited in ClientDAO, ProductDAO, OrderDAO
     * @return String
     */
    public  String createUpdateQuery(){
        return null;
    }
    /**
     * This method will be overwrited in ClientDAO, ProductDAO, OrderDAO
     */
    public void setInsertValues(PreparedStatement statement, T t){

    }
    /**
     * This method will be overwrited in ClientDAO, ProductDAO, OrderDAO
     */
    public void setUpdateValues(PreparedStatement statement, T t){

    }

    /**
     * Method that work with the database and execut a find all query
     * @return List<T>
     */
    public List<T> findAll() {
        // TODO:
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createFindAllQuery();
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            System.out.println(statement.toString());
            resultSet = statement.executeQuery();
            List<T> list = createObjects(resultSet);
            return list;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findAll " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Method that work with the database and execute a find by id query
     * @param id search id
     * @return T
     */
    public T findById(int id) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery(id);
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            System.out.println(statement);
            resultSet = statement.executeQuery();
            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * Method that use reflection to create java object from a resultSet
     * @param resultSet ResultSet
     * @return List<T>
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T) ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     *Method that work with the database and execute an insert query
     * @param t inserted object
     * @return int
     */
    public int insert(T t) {
        // TODO:
        Connection dbConnection = ConnectionFactory.getConnection();
        int insertedId=-1;
        PreparedStatement insertStatement = null;
        ResultSet rs = null;
        try {
            insertStatement = dbConnection.prepareStatement(createInsertQuery(), Statement.RETURN_GENERATED_KEYS);
            setInsertValues(insertStatement,t);
            System.out.println(insertStatement.toString());
            insertStatement.executeUpdate();
            rs = insertStatement.getGeneratedKeys();
            if(rs.next()){
                insertedId = rs.getInt(1);
            }
            return insertedId;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, "AbstractDAO:insert " + e.getMessage());
        }finally {
            ConnectionFactory.close(insertStatement);
            ConnectionFactory.close(dbConnection);
            ConnectionFactory.close(rs);
        }
        return -1;
    }

    /**
     * Method that work with the database and execute an update query
     * @param t updated object
     * @return int
     */
    public int update(T t) {
        Connection dbConnection = ConnectionFactory.getConnection();

        PreparedStatement updateStatement = null;
        ResultSet rs = null;
        int updatedID=-1;
        try{
            updateStatement = dbConnection.prepareStatement(createUpdateQuery(), Statement.RETURN_GENERATED_KEYS);
            setUpdateValues(updateStatement,t);
            updateStatement.executeUpdate();
            rs = updateStatement.getGeneratedKeys();
            if(rs.next()) {
                updatedID = rs.getInt(1);
            }

        }catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(updateStatement);
            ConnectionFactory.close(dbConnection);
        }
        return -1;
    }

    /**
     * Method that work with the database and execute a delete query
     * @param id deleted id
     * @return int
     */
    public int delete(int id){

        Connection connection = null;
        PreparedStatement deleteStatement = null;
        ResultSet resultSet = null;
        int deletedId=-1;
        String query = createDeleteQuery("id");
        try {
            connection = ConnectionFactory.getConnection();
            deleteStatement = connection.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            deleteStatement.setInt(1, id);
             deleteStatement.executeUpdate();

            resultSet =deleteStatement.getGeneratedKeys();
            return deletedId;
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(deleteStatement);
            ConnectionFactory.close(connection);
        }
        return -1;
    }
}
