package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class adminlogin extends JFrame implements ActionListener {
Connection con;
JLabel l1,l2,l3,background,lemail,lpassword,lsignup;
JPanel p1,p2,p3;
JTextField tf,tf1,tf2,tfemail;
JPasswordField tfpassword;
JButton btn_login,btn_signup;
public void admin(){
    con = dbconnection.dbconnect();
    setBounds(50,25,1300,800);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ImageIcon background_image = new ImageIcon("framebg.jpg");
Image img = background_image.getImage();
Image temp_img = img.getScaledInstance(1500,800,Image.SCALE_SMOOTH);
background_image = new ImageIcon(temp_img);

    JLabel background = new JLabel("",background_image,JLabel.CENTER);
    background.setBounds(0,0,1300,800);
    background.setLayout(null);
    add(background);

    JPanel p1 = new JPanel();
    p1.setBounds(400,200,500,400);
    p1.setBackground(new Color(0,0,20,150));

    background.add(p1);
    JLabel l1 = new JLabel("Admin Login");
    l1.setBounds(150,10,300,40);
    l1.setForeground(Color.WHITE);
    l1.setFont(new Font("Arial",Font.BOLD,30));
    p1.add(l1);

    lemail = new JLabel("Email Id    :");
    lemail.setBounds(10, 100, 160, 23);
    lemail.setFont(new Font("TimesnewRoman", Font.BOLD, 25));
    lemail.setForeground(Color.WHITE);
    p1.add(lemail);

    tfemail = new JTextField();
    tfemail.setBounds(148, 100, 310, 30);
    tfemail.setFont(new Font("TimesnewRoman", Font.BOLD, 18));
    p1.add(tfemail);

    lpassword = new JLabel("Password :");
    lpassword.setBounds(10, 200, 160, 23);
    lpassword.setFont(new Font("Arial", Font.BOLD, 25));
    lpassword.setForeground(Color.WHITE);
    p1.add(lpassword);

    tfpassword = new JPasswordField();
    tfpassword.setBounds(148, 200, 310, 30);
    tfpassword.setFont(new Font("Arial", Font.BOLD, 30));
    p1.add(tfpassword);

    btn_login = new JButton("Login");
    btn_login.setBounds(180, 270, 120, 40);
    btn_login.setFont(new Font("Arial", Font.BOLD, 22));
    btn_login.setBackground(Color.LIGHT_GRAY);

    p1.add(btn_login);

    lsignup = new JLabel("Dont have a account ? Create Account");
    lsignup.setBounds(40, 350, 290, 20);
    lsignup.setFont(new Font("Arial", Font.BOLD, 15));
    lsignup.setForeground(Color.WHITE);
    p1.add(lsignup);

    btn_signup = new JButton("Signup");
    btn_signup.setBounds(330, 350, 100, 20);
    btn_signup.setFont(new Font("Arial", Font.BOLD, 15));
    btn_signup.setBackground(Color.green);
    p1.add(btn_signup);

    p1.setLayout(null);
    setLayout(null);
    setVisible(true);

    btn_login.addActionListener(this);
}
    public void actionPerformed(ActionEvent e){
    Object source = e.getSource();
    if(source==btn_login){
            String email = tfemail.getText();
            String password = tfpassword.getText();
            try{
                String querry1 = ("Select email,password from student where email=? and password=?");
                PreparedStatement pst = con.prepareStatement(querry1);
                pst.setString(1,email);
                pst.setString(2,password);
                ResultSet result = pst.executeQuery();
                if(result.next()){
                    String emails = result.getString("email");
mainhome obj = new mainhome();
obj.amainhome(emails);
                    System.out.println("Logged in");
                }
            }catch(SQLException sql){
                System.out.println("FAILED TO CONbECT"+sql.getMessage());
            }
        }
    }
public static void main(String[]args)
{
    adminlogin obj  = new adminlogin();
    obj.admin();

    }
}
