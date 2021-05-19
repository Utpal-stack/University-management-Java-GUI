package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class choose_result extends JFrame implements ActionListener {

    JTextField tfr;
    public String email1,sem_id,sem_id1,roll2;
    Connection con;
    JButton b11;
    JComboBox box;

    public void check_result(String roll) {
        con = dbconnection.dbconnect();
        setBounds(560, 200, 400, 400);
        setLayout(null);
JLabel l = new JLabel("Choose Semester");
l.setBounds(80,70,150,20);
l.setFont(new Font("Arial",Font.BOLD,17));
add(l);
        box = new JComboBox();
        box.setLocation(100, 100);
        box.setSize(150, 30);
        box.setFont(new Font("Arial",Font.BOLD,14));

        add(box);

        tfr = new JTextField();
        tfr.setBounds(100, 170, 150, 30);
       // add(tfr);

        b11 = new JButton("PRESS ME");
        b11.setBounds(100, 230, 130, 30);
           b11.addActionListener(this);
        add(b11);

        setVisible(true);

        try {
            String query1 = ("select * from combobox where roll=? group by sem_id");
            PreparedStatement pst = con.prepareStatement(query1);
            pst.setString(1, roll);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String semester = rs.getString("semester");
                roll2 = rs.getString("roll");
                sem_id1 = rs.getString("sem_id");
                box.addItem(sem_id1);
            }
        } catch (SQLException sq) {
            System.out.println("FAILED" + sq.getMessage());
        }

        System.out.println("I am from result"+roll);




    }

    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();


        if(source==b11) {
            tfr.setText(String.valueOf(box.getSelectedItem()));
            sem_id1 = String.valueOf(box.getSelectedItem());
student_examination obj = new student_examination();
obj.marks_details(roll2,sem_id1);
           System.out.println("I am from RESult : "+roll2);
            System.out.println("I am from resultb"+sem_id1);

        }

    }


}

