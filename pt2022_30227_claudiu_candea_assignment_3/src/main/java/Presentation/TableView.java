package Presentation;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
/**
 * UI Class for display in a JTable the result of find operations
 */

public class TableView<T> extends JFrame {
    private JTable table;
    private JScrollPane scrollPane;

    /**
     * Return table
     * @return JTable
     */
    public JTable getTable() {
        return table;
    }

    public  TableView(List<T> list){
        this.table=this.createTable(list);
        this.setSize(600,600);
        this.scrollPane = new JScrollPane(this.table);
        this.add(scrollPane);
        this.setVisible(true);

    }

    /**
     * Create a table from a list of genetic objects
     * @param list list of objects that will be displayed in the table
     * @return JTable
     */
    public JTable createTable(List<T> list){
        ArrayList<String> columnNames = new ArrayList<String>();
        int numberOfFields = 0;
        for (Field field : list.get(0).getClass().getDeclaredFields()) {
            field.setAccessible(true);
            columnNames.add(field.getName());
            numberOfFields++;
        }
        Object[][]  data = new Object[list.size()][numberOfFields];
        for(int i=0;i<list.size();i++){
            int j=0;
            for(Field field : list.get(i).getClass().getDeclaredFields()){
                try {
                    field.setAccessible(true);
                    data[i][j]=field.get(list.get(i));
                    j++;
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        DefaultTableModel tmodel = new DefaultTableModel(data,columnNames.toArray());
        JTable table = new JTable(tmodel);
        table.getTableHeader();
        System.out.println(table.getTableHeader());
        return table;
    }
}
