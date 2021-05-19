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

public class enroll_course extends JFrame implements ActionListener,ItemListener {


    Connection con;
    JComboBox roll1, dep1, courses;
    JButton submit;
    JLabel roll, dep, course_id, cia1, cia2, cia3, endsem;
    JTextField tfcia2, tfcia3, tfendsem, tfcia1, tfsalary, tffid, tfcid, tfcname, tfsid, tfphone, tfcr, tffname, tfgender, tfcity;
    JButton addfbtn;
    JRadioButton radiobtn;

    enroll_course() {
        con = dbconnection.dbconnect();

        setBounds(700, 100, 390, 660);
        setLayout(null);

       dep = new JLabel("Department");
        dep.setBounds(80, 40, 150, 25);
        dep.setFont(new Font("Arial", Font.BOLD, 22));
        add(dep);

        dep1 = new JComboBox();
        dep1.setBounds(80, 70, 200, 30);
        dep1.setFont(new Font("Arial", Font.BOLD, 15));
        dep1.addItemListener(this);
        add(dep1);

        roll = new JLabel("Roll no.");
        roll.setBounds(80, 115, 150, 30);
        roll.setFont(new Font("Arial", Font.BOLD, 22));

        add(roll);


        roll1 = new JComboBox();
        roll1.setBounds(80, 145, 200, 30);
        roll1.setFont(new Font("Arial", Font.BOLD, 15));
       // dep1.addItemListener(new depcb());
       roll1.addItemListener(this);
        add(roll1);


        course_id = new JLabel("Course Id");
        course_id.setBounds(80, 190, 150, 30);
        course_id.setFont(new Font("Arial", Font.BOLD, 22));

        add(course_id);


        courses = new JComboBox();
        courses.setBounds(80, 220, 200, 30);
        courses.setFont(new Font("Arial", Font.BOLD, 15));
        courses.addItemListener(this);
        add(courses);


        cia1 = new JLabel("Cia 1");
        cia1.setBounds(80, 265, 150, 25);
        cia1.setFont(new Font("Arial", Font.BOLD, 22));
        add(cia1);


        tfcia1 = new JTextField();
        tfcia1.setBounds(80, 295, 200, 25);
        tfcia1.setFont(new Font("Arial", Font.BOLD, 15));
        add(tfcia1);


        cia2 = new JLabel("Cia 2");
        cia2.setBounds(80, 340, 150, 25);
        cia2.setFont(new Font("Arial", Font.BOLD, 22));
        add(cia2);

        tfcia2 = new JTextField();
        tfcia2.setBounds(80, 370, 200, 30);
        tfcia2.setFont(new Font("Arial", Font.BOLD, 15));
        add(tfcia2);

        cia3 = new JLabel("Cia 3");
        cia3.setBounds(80, 415, 150, 25);
        cia3.setFont(new Font("Arial", Font.BOLD, 22));
        add(cia3);

        tfcia3 = new JTextField();
        tfcia3.setBounds(80, 445, 200, 30);
        tfcia3.setFont(new Font("Arial", Font.BOLD, 15));
        add(tfcia3);


        endsem = new JLabel("Endsem");
        endsem.setBounds(80, 490, 150, 25);
        endsem.setFont(new Font("Arial", Font.BOLD, 22));
        add(endsem);


        tfendsem = new JTextField();
        tfendsem.setBounds(80, 520, 200, 30);
        tfendsem.setFont(new Font("Arial", Font.BOLD, 15));
        add(tfendsem);


        addfbtn = new JButton("SUBMIT");
        addfbtn.setBounds(130, 570, 110, 40);
        addfbtn.addActionListener(this);
        add(addfbtn);
        setVisible(true);


        try {
            PreparedStatement pst = con.prepareStatement("select dep_id from department");
            ResultSet result = pst.executeQuery();
            while (result.next()) {

                String dep = result.getString("dep_id");
                dep1.addItem(dep);
            }


        } catch (SQLException sq) {
            System.out.println("Failed " + sq.getMessage());
        }


    }





public void itemStateChanged(java.awt.event.ItemEvent e) {
    Object s = e.getSource();
    if (s == dep1) {

        try {
            String query2 = ("select roll from student where dep_id=?");
            PreparedStatement pst = con.prepareStatement(query2);
            pst.setString(1,dep1.getSelectedItem().toString());

            ResultSet result = pst.executeQuery();
            roll1.removeAllItems();
            while (result.next()) {
                roll1.addItem(result.getString("roll"));

            }

        } catch (SQLException sq) {
            System.out.println("FAILED" + sq.getMessage());
        }


    }
    if(s==dep1){
        try {
            String query0 = ("select course_id  from courses2 where dep_id=?");
           // String query2 = ("select course_id from courses where dep_id='" + roll1.getSelectedItem() + "'");
            PreparedStatement pst = con.prepareStatement(query0);
pst.setString(1,dep1.getSelectedItem().toString());
            ResultSet result = pst.executeQuery();
            courses.removeAllItems();
            while (result.next()) {
                courses.addItem(result.getString("course_id"));

            }

        } catch (SQLException sq) {
            System.out.println("FAILED" + sq.getMessage());
        }

    }

}




                //  SELECT course_id FROM courses where dep_id IN(select dep_id from student where roll=? and dep_id=);










public void actionPerformed(ActionEvent e){



       /* String cid  = tfcid.getText();
String cname =  tfcname.getText();
        String semester_id = tfsid.getText();
        String faculty = tftid.getText();
        String credits = tfcr.getText()
        */
        Object s = e.getSource();

        if(s==addfbtn){
            System.out.println(roll1.getSelectedItem().toString());
            System.out.println(dep1.getSelectedItem().toString());
            System.out.println(courses.getSelectedItem().toString());
            System.out.println(tfcia1.getText());
            System.out.println(tfcia2.getText());
            System.out.println(tfcia3.getText());
            System.out.println(tfendsem.getText());

            try{
                String query = ("insert into course_details(roll,course_id,cia1,midsem,cia3,endsem) values(?,?,?,?,?,?)");
                PreparedStatement pst = con.prepareStatement(query);


                pst.setString(1,roll1.getSelectedItem().toString());
                pst.setString(2, courses.getSelectedItem().toString());
                pst.setString(3,tfcia1.getText());
                pst.setString(4,tfcia2.getText());
                pst.setString(5,tfcia3.getText());
                pst.setString(6,tfendsem.getText());


                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Marks Added Successfully");

            }catch (SQLException sq){
                JOptionPane.showMessageDialog(null,"Data Inertion Failed"+sq.getMessage());
            }




        }

    }




    public static void main (String[]args){

        new enroll_course();
    }

}

