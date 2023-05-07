package PresentationLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;

import java.util.ArrayList;
import java.util.HashMap;

public interface Observer {

    public void update(Order order,ArrayList<MenuItem> list);
}
