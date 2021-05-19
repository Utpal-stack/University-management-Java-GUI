package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.sql.Connection;

class mainhome extends  JFrame implements ActionListener {
Connection con;
String email2;
    Container c;
    JLabel l1, l2, l3, l4;
    JPanel panellogo, panelhead, panelheading, panelmenu, panelhome;
    JButton b1, b2, b3, b4, b5, b6, b7, b8;

   public void  amainhome(String emails) {
    setBackground(Color.blue);
    con  = dbconnection.dbconnect();
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Home");
        setLayout(null);
        setSize(1600, 830);
        setLocation(0, 0);
        c = getContentPane();
    c.setBackground(Color.BLUE);
        c.setLayout(null);

        panelhome = new JPanel();
        panelhome.setBounds(380, 190, 1500, 600);
        panelhome.setBackground(Color.white);
        panelhome.setBorder(BorderFactory.createBevelBorder(0));
        panelhome.setLayout(new BorderLayout());
        c.add(panelhome);
        l3 = new JLabel("");
        l3.setBounds(380, 190, 1100, 700);
        l3.setIcon(new ImageIcon("campus.jpeg"));
        panelhome.add(l3);

        panelhead = new JPanel();
        panelhead.setBounds(0, 0, 1700, 185);
        panelhead.setLayout(null);
        panelhead.setBackground(Color.lightGray);
        c.add(panelhead);


        panelheading = new JPanel();
        panelheading.setBounds(200, 20, 1200, 105);
        panelheading.setBackground(Color.ORANGE);
        panelheading.setBorder(BorderFactory.createBevelBorder(0));
        panelheading.setLayout(new BorderLayout());
        panelhead.add(panelheading);

        panellogo = new JPanel();
        panellogo.setBounds(25, 40, 80, 100);
        panellogo.setBackground(Color.gray);
        panellogo.setBorder(BorderFactory.createBevelBorder(0));
        panellogo.setLayout(new BorderLayout());
        panelhead.add(panellogo);

        l2 = new JLabel("");
        l2.setBounds(50, 30, 100, 120);
        l2.setIcon(new ImageIcon("christ.jpeg"));
        panellogo.add(l2);

        l1 = new JLabel("   UNIVERSITY MANAGEMENT");
        l1.setBounds(400, 30, 950, 130);
        l1.setFont(new Font("SWItal", Font.BOLD, 65));
        l1.setBackground(Color.black);
        panelheading.add(l1);

        b1 = new JButton(" Dashboard");
        b1.setBounds(80, 230, 200, 42);
        b1.setFont(new Font("Arial",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setIcon(new ImageIcon("speedometer.png"));
        c.add(b1);

        b2 = new JButton("Student");
        b2.setBounds(80, 302, 200, 42);
        b2.setIcon(new ImageIcon("computer.png"));
        b2.setFont(new Font("Arial",Font.BOLD,15));
        b2.addActionListener(this);
        c.add(b2);

        b3 = new JButton("Transaction");
        b3.setBounds(80, 372, 200, 42);
        b3.setFont(new Font("Arial",Font.BOLD,15));
        b3.setIcon(new ImageIcon("money-transfer.png"));
        b3.addActionListener(this);
        c.add(b3);

        b4 = new JButton("Teacher");
        b4.setBounds(80, 442, 200, 42);
       b4.setFont(new Font("Arial",Font.BOLD,15));
       b4.addActionListener(this);
        c.add(b4);

        b5 = new JButton("Admission Test");
        b5.setBounds(80, 512, 200, 42);
       b5.setFont(new Font("Arial",Font.BOLD,15));
       b5.addActionListener(this);
        c.add(b5);

        b6 = new JButton("Search");
        b6.setBounds(80, 572, 200, 42);
       b6.setFont(new Font("Arial",Font.BOLD,15));
        c.add(b6);

        b7 = new JButton("Analytical Statics");
        b7.setBounds(80, 642, 200, 42);
       b7.setFont(new Font("Arial",Font.BOLD,15));
        c.add(b7);

        b8 = new JButton("Log out / Sign out");
        b8.setBounds(80, 712, 200, 42);
       b8.setFont(new Font("Arial",Font.BOLD,15));
       b8.addActionListener(this);
        c.add(b8);

       System.out.println("Hell"+emails);
       email2 = emails;
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == b1) {
adminhome obj = new adminhome();
           obj.home(email2);
        }else if(source == b2){
           home_student obj = new home_student();
           obj.student_home();
        }else if(source== b4){
            new view_teachers();
        }
        else if(source == b3){
            choose_payment obj = new choose_payment();
            obj.choose_payment1();
        }


        else if (source== b5){
        new OnlineTest("");

        }
        else if(source == b8){
        dispose();
        adminlogin obj = new adminlogin();
        obj.admin();
        }
    }



       public static void main(String[]args){

           mainhome obj = new mainhome();
           obj.amainhome("");


        }



    }
