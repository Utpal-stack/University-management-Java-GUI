package databases;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.plaf.basic.BasicBorders;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.border.Border;
public class registration extends JFrame implements ActionListener{
    JPanel jp;
    JLabel header,lname,lreg,laddress,login,lemail,lpassword;
    JButton btn_submit,btnl;
    JTextField tfname = new JTextField();
    JTextField tfref = new JTextField();
    JTextField tfaddress = new JTextField();
    JTextField tfemail = new JTextField();
    JPasswordField tfpassword = new JPasswordField();
    Connection con;

    registration(){

        con = dbconnection.dbconnect();
        setBounds(150,30,1300,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon background_image = new ImageIcon("framebg.jpg");

        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1500,800,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);

        JLabel background = new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,1300,800);
        background.setLayout(null);
        add(background);

        jp = new JPanel();
jp.setBounds(400,100,500,600);
jp.setBackground(new Color(0,0,0,120));
jp.setLayout(null);

background.add(jp);
header = new JLabel("Sign Up");
header.setBounds(180,50,200,40);
header.setFont(new Font("Arial",Font.BOLD,40));
header.setForeground(Color.WHITE);
jp.add(header);
lname = new JLabel("Username :");
lname.setBounds(10,150,160,23);
lname.setFont(new Font("TimesnewRoman",Font.BOLD,25));
lname.setForeground(Color.WHITE);
jp.add(lname);

        tfname.setBounds(147,150,340,30);
        tfname.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfname);


        lreg = new JLabel("Reg no      :");
        lreg.setBounds(10,210,160,23);
        lreg.setFont(new Font("Arial",Font.BOLD,25));
        lreg.setForeground(Color.WHITE);
        jp.add(lreg);

        tfref.setBounds(147,210,340,30);
        tfref.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfref);

        laddress = new JLabel("Address    :");
        laddress.setBounds(10,270,160,23);
        laddress.setFont(new Font("Arial",Font.BOLD,25));

        laddress.setForeground(Color.WHITE);
        jp.add(laddress);
        tfaddress.setBounds(147,270,340,30);
        tfaddress.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfaddress);

        lemail = new JLabel("Email Id    :");
        lemail.setBounds(10,330,160,23);
        lemail.setFont(new Font("Arial",Font.BOLD,25));
        lemail.setForeground(Color.WHITE);
        jp.add(lemail);

        tfemail.setBounds(147,330,340,30);
        tfemail.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfemail);

        lpassword = new JLabel("Password :");
        lpassword.setBounds(10,390,160,23);
        lpassword.setFont(new Font("Arial",Font.BOLD,25));
        lpassword.setForeground(Color.WHITE);
        jp.add(lpassword);

        tfpassword.setBounds(147,390,340,30);
        tfpassword.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfpassword);

login= new JLabel("Alredy a member ? Click here ");
login.setBounds(65,560,500,20);
login.setFont(new Font("Arial",Font.BOLD,15));
login.setForeground(Color.WHITE);
jp.add(login);

        btn_submit = new JButton("Signup");
        btn_submit.setBounds(170,450,150,30);
        btn_submit.setFont(new Font("Arial",Font.BOLD,22));
//btn_submit.setBorder(new RoundedBorder(15));
        jp.add(btn_submit);

        btnl = new JButton("Login");
        btnl.setBounds(300,560,100,20);
        btnl.setFont(new Font("Arial",Font.BOLD,18));
     //   btnl.setBorder(new RoundedBorder(20));
        btnl.setBackground(Color.green);
        jp.add(btnl);

        setLayout(null);
        setVisible(true);
        btn_submit.addActionListener(this);
        btnl.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){

    String name1 = tfname.getText();
    String reg1 = tfref.getText();
    String address1 = tfaddress.getText();
    String email1 = tfemail.getText();
    String password1 = tfpassword.getText();

    Object source = e.getSource();
if(source==btn_submit) {

    try {
        PreparedStatement pst = con.prepareStatement("insert into student(name,roll,address,email,password) values(?,?,?,?,?)");
        pst.setString(1,name1);
        pst.setString(2,reg1);
        pst.setString(3,address1);
        pst.setString(4,email1);
        pst.setString(5,password1);
        pst.executeUpdate();
        JOptionPane.showMessageDialog(null,"DATA INSERTED");
        tfname.setText("");
        tfref.setText("");
        tfaddress.setText("");
    }catch(SQLException et){
        System.out.println("Failed");
    }

}
else if(source==btnl){
    System.out.println("Login form");
    dispose();
    loginform obj = new loginform();
    obj.signin();
}
    }
    public static void main(String [] args){
        new registration();
    }






}


