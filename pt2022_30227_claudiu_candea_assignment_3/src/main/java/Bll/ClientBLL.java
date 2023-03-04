package Bll;

import Bll.Validators.AgeValidator;
import Bll.Validators.Validator;
import DAO.ClientDAO;
import Model.Client;
import Bll.Validators.EmailValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for operation with Clients
 */

public class ClientBLL {
    private List<Validator<Client>> validators;
    private ClientDAO clientDAO;

    /**
     * ClinetBLL constructor
     */
    public ClientBLL() {
        validators = new ArrayList<Validator<Client>>();
        validators.add(new EmailValidator());
        validators.add(new AgeValidator());
        clientDAO=new ClientDAO();
    }

    /**
     * Method for find a client by id
     * @param id search id
     * @return Client
     */
    public Client findClientById(int id) {
        Client client = clientDAO.findById(id);
        if (client == null) {
            throw new NoSuchElementException("The student with id =" + id + " was not found!");
        }
        return client;
    }

    /**
     * Method for find all clients
     * @return List
     */
    public List<Client> findAllClient(){
        List<Client> list = clientDAO.findAll();
        return list;
    }

    /**
     * Method for validate and insert a client
     * @param client inserted client
     * @return int
     */
    public int insertClient(Client client) {
        for (Validator<Client> v : validators) {
            v.validate(client);
        }
        return clientDAO.insert(client);
    }

    /**
     * Method for validate and update a client
     * @param client  client
     * @return int
     */
    public int updateClient(Client client){
            for (Validator<Client> v : validators) {

                v.validate(client);
            }
        return clientDAO.update(client);
    }

    /**
     * Method for delete a client
     * @param id delete id
     * @return int
     */
    public int deleteClient(int id){

        int deletedId= clientDAO.delete(id);
        return deletedId;
    }
}
