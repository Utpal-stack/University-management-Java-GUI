package databases;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class view_teachers extends JFrame {
Connection con;

DefaultTableModel model = new DefaultTableModel();
JTable teachers_table,t;
JScrollPane js;

view_teachers(){
    con =  dbconnection.dbconnect();
    setBounds(0,0,1540,820);

    t = new JTable(model);
    t.setRowHeight(25);
    t.setEnabled(false);
    t.setFont(new Font("Arial",Font.PLAIN,18));
    t.getTableHeader().setBackground(Color.BLACK);
    t.getTableHeader().setForeground(Color.WHITE);
    t.getTableHeader().setFont(new Font("Arial",Font.BOLD,20));

    t.setPreferredScrollableViewportSize(new Dimension(900,300));
    t.setFillsViewportHeight(true);
    ////COLUMNS
    model.addColumn("Department");
    model.addColumn("Id");
    model.addColumn("Name");
    model.addColumn("Gender");
    model.addColumn("Phone");
    model.addColumn("City");
    model.addColumn("Salary");
    model.addColumn("Age");
    //SETTING COLUMN WIDTH (NOT IMPORTANT)
    t.getColumn("Department").setPreferredWidth(10);
    t.getColumn("Id").setPreferredWidth(10);
    t.getColumn("Name").setPreferredWidth(30);
    t.getColumn("Gender").setPreferredWidth(30);
    t.getColumn("Phone").setPreferredWidth(30);
    t.getColumn("City").setPreferredWidth(30);
    t.getColumn("Salary").setPreferredWidth(30);
    t.getColumn("Age").setPreferredWidth(30);
    //////////////////////////////////////////////////////
    JScrollPane js = new JScrollPane(t);
    add(js);
    this.validate();

    try{
        String querry = ("select * from faculty_dep");
        PreparedStatement pst = con.prepareStatement(querry);
        ResultSet result = pst.executeQuery();
        while(result.next()) {
            String dep = result.getString("dep_name");
            String id = result.getString("faculty_id");
            String name = result.getString("faculty_name");
            String gender = result.getString("gender");
            String fphone = result.getString("fphone");
            String city = result.getString("city");
            String salary = result.getString("salary");
            String age = result.getString("age");

            model.addRow(new Object[]{ dep,id, name, gender, fphone, city, salary, age});
        }
    }catch (SQLException sq){
        JOptionPane.showMessageDialog(null,"SORRY"+sq.getMessage());
    }
    setVisible(true);
}
public static  void main(String[] args){

    new view_teachers();
}

}
