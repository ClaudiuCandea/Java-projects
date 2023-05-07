package DataLayer;

import BusinessLayer.DeliveryService;
import BusinessLayer.User;

import java.io.*;

public class Serializator {

    public void serialization(DeliveryService deliveryService) {
        try {
            FileOutputStream file = new FileOutputStream("file.ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(deliveryService);
            out.close();
            file.close();
        }catch(FileNotFoundException e){
            System.out.println("File could not open");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public DeliveryService deserialization(){
        DeliveryService deliveryService;
        try{
            FileInputStream file = new FileInputStream("file.ser");
            ObjectInputStream in = new ObjectInputStream(file);
            deliveryService = (DeliveryService)in.readObject();
            return deliveryService;
        }catch(Exception e){
            deliveryService = new DeliveryService();
            User admin = new User("admin","admin","Admin");
            User employee = new User("Gelu","gelu","Employee");
            User client = new User("Clau","123","Client");
            deliveryService.addUser(admin);
            deliveryService.addUser(employee);
            deliveryService.addUser(client);
            return deliveryService;
        }
    }

}
