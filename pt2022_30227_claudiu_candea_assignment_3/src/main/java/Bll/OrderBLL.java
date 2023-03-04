package Bll;

import Bll.Validators.QuantityOrderValidator;
import Bll.Validators.Validator;
import DAO.OrderDAO;
import Model.Client;
import Model.Orders;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Class for operation with orders
 */

public class OrderBLL {

    private List<Validator<Orders>> validators;
    private OrderDAO orderDAO;

    /**
     * Constructor without parameters
     */
    public OrderBLL() {
        validators = new ArrayList<Validator<Orders>>();
        validators.add(new QuantityOrderValidator());

        orderDAO=new OrderDAO();
    }

    /**
     * Method for find all orders
     * @return List<Orders>
     */
    public List<Orders> findAllOrder(){
        List<Orders> list = orderDAO.findAll();
        return list;
    }

    /**
     * Method for validate and inset an order
     * @param order inserted order
     * @return int
     */
    public int insertOrder(Orders order) {
        for (Validator<Orders> v : validators) {
            v.validate(order);
        }
        return orderDAO.insert(order);
    }

    /**
     * Method for create a PDF file as a bill
     * @param order order that need a bill
     * @param totalPrice totalPrice of the order
     */
    public void creatPDF(Orders order, int totalPrice){
        for (Validator<Orders> v : validators) {
            v.validate(order);
        }
        OutputStream file = null;
        try {
            file = new FileOutputStream(new File("Bill number "+order.getId()+".pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document,file);
            document.open();
            document.add(new Paragraph("Order number "+order.getId()));
            document.add(new Paragraph("Client name "+ order.getClientName()));
            document.add(new Paragraph("Product name "+ order.getProductName()));
            document.add(new Paragraph("Quantity "+order.getQuantity()));
            document.add(new Paragraph("Total price "+ totalPrice));
            document.addCreationDate();
            document.close();
            file.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
