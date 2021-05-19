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

public class choose_payment extends JFrame implements ActionListener, ItemListener {
    JTextField tfr;
     String email1,sem_id,sem_id1,roll2;
    Connection con;
    JButton b11;
    JComboBox box,cdep,croll;

    public void choose_payment1() {
        con = dbconnection.dbconnect();
        setBounds(560, 200, 400, 400);
        setLayout(null);
        JLabel l = new JLabel("Choose Department");
        l.setBounds(100,70,200,20);
        l.setFont(new Font("Arial",Font.BOLD,17));
        add(l);


        JLabel l1 = new JLabel("Choose Roll");
        l1.setBounds(100,150,200,20);
        l1.setFont(new Font("Arial",Font.BOLD,17));
        add(l1);

        JLabel l3 = new JLabel("Choose Semester");
        l3.setBounds(100,230,200,20);
        l3.setFont(new Font("Arial",Font.BOLD,17));
        add(l3);



        cdep= new JComboBox();
        cdep.setLocation(100, 100);
        cdep.setSize(150, 30);
        cdep.setFont(new Font("Arial",Font.BOLD,14));
        cdep.addItemListener(this);
        add(cdep);



        croll= new JComboBox();
        croll.setLocation(100, 180);
        croll.setSize(150, 30);
        croll.setFont(new Font("Arial",Font.BOLD,14));
        croll.addItemListener(this);
        add(croll);

        box = new JComboBox();
        box.setLocation(100, 250);
        box.setSize(150, 30);
        box.setFont(new Font("Arial",Font.BOLD,14));
        add(box);

       // tfr = new JTextField();
       // tfr.setBounds(100, 170, 150, 30);
        // add(tfr);

        b11 = new JButton("Pay");
        b11.setBounds(100, 300, 130, 30);
        b11.addActionListener(this);
        add(b11);

        setVisible(true);

        try{
            String query1 = ("select dep_id from department");
            PreparedStatement pst = con.prepareStatement(query1);
            ResultSet result = pst.executeQuery();
            cdep.removeAllItems();
        while(result.next()){

            String dep_id = result.getString("dep_id");
            cdep.addItem(dep_id);

        }
        }catch (SQLException sq){
            JOptionPane.showMessageDialog(null,"Eroor Fetching"+sq.getMessage());
        }


     /*   try {
            String query1 = ("select * from combobox where roll=? group by sem_id");
            PreparedStatement pst = con.prepareStatement(query1);
         //   pst.setString(1, roll);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String semester = rs.getString("semester");
                roll2 = rs.getString("roll");
                sem_id1 = rs.getString("sem_id");
                box.addItem(sem_id1);
            }
        } catch (SQLException sq) {
            System.out.println("FAILED" + sq.getMessage());
        }*/

        //System.out.println("I am from result"+roll);




    }


    public void itemStateChanged(ItemEvent e) {
        Object source = e.getSource();

        if (source == cdep) {
            try {
                String query2 = ("select roll from student where dep_id = ?");
                PreparedStatement pst = con.prepareStatement(query2);
                pst.setString(1, cdep.getSelectedItem().toString());
                ResultSet result = pst.executeQuery();
                while (result.next()) {
                    String roll = result.getString("roll");
                    croll.addItem(roll);

                }
            } catch (SQLException sq) {
                JOptionPane.showMessageDialog(null, sq.getMessage());
            }
        } else if (source == croll) {
            try {
                String query1 = ("select * from combobox where roll=? group by sem_id");
                PreparedStatement pst = con.prepareStatement(query1);
                pst.setString(1, croll.getSelectedItem().toString());
                ResultSet rs = pst.executeQuery();
box.removeAllItems();
                while (rs.next()) {

                    String semester = rs.getString("semester");

                    sem_id1 = rs.getString("sem_id");
                    box.addItem(sem_id1);


                }
            } catch (SQLException sq) {
                JOptionPane.showMessageDialog(null,sq.getMessage());
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        String dep = cdep.getSelectedItem().toString();
        String roll_id = croll.getSelectedItem().toString();
        String sem = box.getSelectedItem().toString();

        if(source==b11) {

          new payment(dep,roll_id,sem);


        }

    }

public  static  void  main(String [] args){

 choose_payment obj = new choose_payment();
obj.choose_payment1();
            }
}


