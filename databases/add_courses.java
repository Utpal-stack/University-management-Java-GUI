package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class add_courses extends JFrame implements ActionListener {
    Connection con;
    JButton submit;
    JLabel course_id,course_name,sem_id,faculty_id,credits;
    JTextField tfcid,tfcname,tfsid,tftid,tfcr;
    JButton addcbtn;
    add_courses(){
        con = dbconnection.dbconnect();

        setBounds(700,100,390,550);
        setLayout(null);


course_id = new JLabel("Course Id");
course_id.setBounds(80,40,150,25);
course_id.setFont(new Font("Arial",Font.BOLD,22));
add(course_id);

tfcid = new JTextField();
tfcid.setBounds(80,70,200,30);
tfcid.setFont(new Font("Arial",Font.BOLD,15));
add(tfcid);

course_name = new JLabel("Course name");
        course_name.setBounds(80,115,150,30);
        course_name.setFont(new Font("Arial",Font.BOLD,22));
        add(course_name);


        tfcname = new JTextField();
        tfcname.setBounds(80,145,200,30);
        tfcname.setFont(new Font("Arial",Font.BOLD,15));
        add(tfcname);


            sem_id = new JLabel("Sem Id");
        sem_id.setBounds(80,190,150,30);
        sem_id.setFont(new Font("Arial",Font.BOLD,22));
        add(sem_id);

        tfsid = new JTextField();
        tfsid.setBounds(80,220,200,30);
        tfsid.setFont(new Font("Arial",Font.BOLD,15));
        add(tfsid);




        faculty_id = new JLabel("Course Id");
        faculty_id.setBounds(80,265,150,25);
        faculty_id.setFont(new Font("Arial",Font.BOLD,22));
        add(faculty_id);



        tftid = new JTextField();
        tftid.setBounds(80,295,200,25);
        tftid.setFont(new Font("Arial",Font.BOLD,15));
        add(tftid);


        credits = new JLabel("Credits");
        credits.setBounds(80,340,150,25);
        credits.setFont(new Font("Arial",Font.BOLD,22));
        add(credits);

        tfcr = new JTextField();
        tfcr.setBounds(80,370,200,30);
        tfcr.setFont(new Font("Arial",Font.BOLD,15));
        add(tfcr);

        addcbtn = new JButton("Add Courses");
        addcbtn.setBounds(130,430,110,35);
        addcbtn.addActionListener(this);
        add(addcbtn);
        setVisible(true);



    }


    public void actionPerformed(ActionEvent e){



       /* String cid  = tfcid.getText();
String cname =  tfcname.getText();
        String semester_id = tfsid.getText();
        String faculty = tftid.getText();
        String credits = tfcr.getText()
        */
        Object s = e.getSource();

        if(s==addcbtn){
            try{
                String query = ("insert into courses(course_id,course_name,sem_id,faculty_id,credits) values(?,?,?,?,?)");
                PreparedStatement pst = con.prepareStatement(query);


                pst.setString(1,tfcid.getText());
                pst.setString(2, tfcname.getText());
                pst.setString(3,tfsid.getText());
                pst.setString(4,tftid.getText());
                pst.setString(5,tfcr.getText());
                System.out.println(tfsid.getClass());

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Course Added Successfully");

            }catch (SQLException sq){
                JOptionPane.showMessageDialog(null,"Data Inertion Failed"+sq.getMessage());
            }




        }

    }

    public static void main (String[]args){

        new add_courses();
    }

}
