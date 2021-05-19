package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JPanel;

class add_department extends  JFrame implements ActionListener{

    Connection conn;
    PreparedStatement pst = null;
    ResultSet rs = null;

    Container c;
    JLabel label1, label2 , heading;
    JTextField t1, t2;
    JPasswordField  t3;
    JButton submit;

    add_department(){

        //  conn = login.connection();

        setTitle("department");
        setSize(400,400);
        setLocation(150,150);
        setLocationRelativeTo(null);
        // setDefaultCloseOperation(EXIT_ON_CLOSE);

        c= getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        heading = new JLabel("ADD DEPARTMENT");
        heading.setBounds(20,20,350,70);
        heading.setFont(new Font("Cooper Black",Font.BOLD,33));
        heading.setForeground(Color.BLUE);
        c.add(heading);

        label1 = new JLabel("Department name :");
        label1.setBounds(45,125,200,20);
        label1.setFont(new Font("Arial", Font.BOLD, 17));
        c.add(label1);

        t1 = new JTextField();
        t1.setBounds(200,125,150,28);
        c.add(t1);

        label2 = new JLabel("Department id       :");
        label2.setBounds(45,175,200,25);
        label2.setFont(new Font("Arial", Font.BOLD, 17));
        c.add(label2);

        t2 = new JTextField();
        t2.setBounds(200,175,150,28);
        c.add(t2);



        submit = new JButton("SUBMIT");
        submit.setBounds(150, 250, 100,30);
        submit.setForeground(Color.blue);
        submit.addActionListener(this);
        c.add(submit);

        setVisible(true);
    }
  /*  @Override
    public abstract Dimension getMaximumSize();
    return abstract getCustomDimensions();

    @Override
    public abstract Dimension getMinimumSize();
    return abstract getCustomDimensions();

    @Override
    public abstract Dimension getPreferredSize();
    return abstract getCustomDimensions();*/

    @Override
    public void actionPerformed(ActionEvent e) {

       if(e.getSource()== submit){
          String  name = t1.getText();
           String  id = t2.getText();


          Connection conn = null;

         try{
              Class.forName("com.mysql.cj.jdbc.Driver");
              conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","ppks*8167");

               PreparedStatement pst = conn.prepareStatement("insert into department values(?,?)");
               pst.setString(1,id);
               pst.setString(2,name);


               pst.executeUpdate();
               JOptionPane.showMessageDialog(null,"Department Addeds !!");

               System.out.println("Connected");

           }catch (Exception ex){

               JOptionPane.showMessageDialog(null,ex);
           }
       }
    }
    public static void main(String[] args) {
        new add_department();
    }
}