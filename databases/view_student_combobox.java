package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;
import java.util.regex.Pattern;

public class view_student_combobox extends JFrame implements ItemListener, ActionListener {
    Connection con;
    JLabel ldep, lroll;
    JComboBox cdep, croll;
    JButton search;
    String rollno,roll,name,phone,gender,city,address,dep_name;

    view_student_combobox() {

        setResizable(false);
    double x =  getToolkit().getScreenResolution();



        System.out.println(x);
        con = dbconnection.dbconnect();
        setBounds(100,200, 400, 400);
        setLayout(null);

        ldep = new JLabel("Department");
        ldep.setBounds(100, 50, 150, 30);
        ldep.setFont(new Font("Arial", Font.BOLD, 20));
        add(ldep);

        cdep = new JComboBox();
        cdep.setBounds(100, 100, 150, 30);
        cdep.setFont(new Font("Arial", Font.BOLD, 20));
        cdep.addItemListener(this);
        add(cdep);


        lroll = new JLabel("Roll");
        lroll.setBounds(100, 150, 150, 30);
        lroll.setFont(new Font("Arial", Font.BOLD, 20));
        add(lroll);

        croll = new JComboBox();
        croll.setBounds(100, 200, 150, 30);
        croll.setFont(new Font("Arial", Font.BOLD, 20));
        add(croll);

        search = new JButton("Search");
        search.setBounds(100, 260, 150, 30);
        search.setFont(new Font("Arial", Font.BOLD, 20));
        search.addActionListener(this);
        add(search);

        setVisible(true);

        try {
            String query = ("select dep_id from department");
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                String deps = result.getString("dep_id");
                System.out.println(deps);
                cdep.addItem(deps);
            }

        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "SORRY CHRISTITE : " + sq.getMessage());
        }


    }

    public static void main(String[] args) {
        System.out.println("HELLO");
        new view_student_combobox();
    }

    public void itemStateChanged(ItemEvent e) {
        try {
            String query2 = ("select roll from student where dep_id=?");
            PreparedStatement pst = con.prepareStatement(query2);
            pst.setString(1, cdep.getSelectedItem().toString());
            ResultSet result = pst.executeQuery();
            croll.removeAllItems();
            while (result.next()) {
                rollno = result.getString("roll");

                croll.addItem(rollno);
            }
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, "SORRY" + sq.getMessage());
        }

    }

    public void actionPerformed(ActionEvent e) {
        try {
            String query3 = ("select department.dep_name as dep_name,student.name as sname,roll,address,city,phone_no,gender,age,student.dep_id as dep_id,email " +
                    "from student INNER JOIN department ON student.dep_id=student.dep_id where roll=?");
            PreparedStatement pst = con.prepareStatement(query3);
            pst.setString(1, croll.getSelectedItem().toString());
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                 dep_name = result.getString("dep_name");
                 name = result.getString("sname");
                roll = result.getString("roll");
                 address = result.getString("address");
                city = result.getString("city");
                phone = result.getString("phone_no");
                 gender = result.getString("gender");
                String age = result.getString("age");
                String dep_id = result.getString("dep_id");
                String email = result.getString("email");
            }
        new view_students(dep_name, name,city,phone,address,gender,roll);
        } catch (SQLException sq) {
            JOptionPane.showMessageDialog(null, sq.getMessage());
        }
    }
}
