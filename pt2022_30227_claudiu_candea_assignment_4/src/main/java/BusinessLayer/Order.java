package BusinessLayer;

import com.itextpdf.text.Paragraph;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Order implements Serializable {
    private int orderID;
    private String username;
    private Date orderDate;

    public Order(int orderID, String username, Date OrderDate){
        this.username = username;
        this.orderID = orderID;
        orderDate = OrderDate;
    }

    public int hashCode(){
        int hash = 7 ;
        hash = 31*hash + orderID;
        hash = 31*hash + username.hashCode();
        hash = 31*hash + orderDate.hashCode();
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderID == order.orderID && username == order.username && Objects.equals(orderDate, order.orderDate);
    }

    public boolean compareHour(int starHour, int endHour){
        if(orderDate.getHours()>=starHour && orderDate.getHours()<endHour){
            return true;
        }
        else return false;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getUsername() {
        return username;
    }
    public double computeTotalPrice(ArrayList<MenuItem> list){
        double totalPrice=0;
        for(MenuItem item : list){
            totalPrice+=item.computePrice();
        }
        return totalPrice;
    }
    public boolean compareDate(Date date){
        if(date.getYear()==orderDate.getYear() && date.getMonth()==orderDate.getMonth() && date.getDay()==orderDate.getDay()){
            return true;
        }
        else{
            return false;
        }
    }


    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "orderID=" + orderID +
                ", username='" + username + '\'' +
                ", orderDate=" + orderDate;
    }
}
