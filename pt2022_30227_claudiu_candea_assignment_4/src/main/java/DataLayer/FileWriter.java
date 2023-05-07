package DataLayer;

import BusinessLayer.MenuItem;
import BusinessLayer.Order;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileWriter implements Serializable{


    public void creatPDF(Order order, ArrayList<MenuItem> list){
        OutputStream file = null;
        try {
            file = new FileOutputStream(new File("Bill number "+order.getOrderID()+".pdf"));
            Document document = new Document();
            PdfWriter.getInstance(document,file);
            document.open();
            document.add(new Paragraph(order.toString()));
            double totalPrice=0;
            for(MenuItem item : list){
                document.add(new Paragraph(item.toString()));
                totalPrice+=item.computePrice();
            }
            document.add(new Paragraph(("Total price="+totalPrice)));
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
    public void createReportFile(List<Order> list ,String  fileName){
        OutputStream file = null;
        try {
            file = new FileOutputStream(new File(fileName));
            Document document = new Document();
            PdfWriter.getInstance(document,file);
            document.open();
            for(Order order : list){
                document.add(new Paragraph(order.toString()));
            }
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
    public void createReportFileWithProduct(List<MenuItem> list ,String  fileName){
        OutputStream file = null;
        try {
            file = new FileOutputStream(new File(fileName));
            Document document = new Document();
            PdfWriter.getInstance(document,file);
            document.open();
            for(MenuItem menuItem : list){
                document.add(new Paragraph(menuItem.toString()));
            }
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
