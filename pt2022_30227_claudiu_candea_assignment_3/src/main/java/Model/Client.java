package Model;

/**
 *Class that represent the data for a client stored in the Client table
 */

public class Client {

    private int id;
    private String name;
    private String email;
    private int age;

    /**
     * Constructor with parameters
     * @param id id value
     * @param age age value
     * @param name name value
     * @param mail mail value
     */
    public Client(int id, int age, String name, String mail){
        this.id=id;
        this.age=age;
        this.name=name;
        this.email=mail;
    }

    /**
     * Constructor without parameters
     */
    public Client(){

    }

    /**
     * Return the id value
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Set the id value
     * @param id set value
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Return the name value
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set name value
     * @param name set value
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Return email value
     * @return String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set email value
     * @param mail set value
     */
    public void setEmail(String mail) {
        this.email = mail;
    }

    /**
     * Return age value
     * @return int
     */
    public int getAge() {
        return age;
    }

    /**
     * Set age value
     * @param age set value
     */
    public void setAge(int age) {
        this.age = age;
    }

}
