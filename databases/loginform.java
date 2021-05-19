package databases;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginform extends JFrame implements ActionListener {
    JPanel jp;String save;
    JLabel header,lemail, lpassword, lsignup,username,address,roll;
    JButton btn_login, btn_signup;
    JTextField tfemail = new JTextField();
    JPasswordField tfpassword = new JPasswordField();
    Connection con;

    public void signin() {
        con = dbconnection.dbconnect();
roll = new JLabel("HELLO");

        setBounds(150, 30, 1300, 800);
        //getContentPane().setBackground(Color.darkGray);
        setLayout(null);
        setVisible(true);

        ImageIcon background_image = new ImageIcon("framebg.jpg");

        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1500,800,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);



        JLabel background = new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,1300,800);
        background.setLayout(null);
        add(background);

        jp = new JPanel();
        jp.setBounds(400, 100, 500, 600);
        jp.setBackground(new Color(00,00,10,80));
        jp.setVisible(true);
        jp.setLayout(null);
        background.add(jp);

        header = new JLabel("Student Login");
        header.setBounds(125,100,300,40);
        header.setFont(new Font("Arial",Font.BOLD,40));
        header.setForeground(Color.WHITE);
        jp.add(header);

        lemail = new JLabel("Email Id    :");
        lemail.setBounds(10, 200, 160, 23);
        lemail.setFont(new Font("TimesnewRoman", Font.BOLD, 25));
        lemail.setForeground(Color.WHITE);
        jp.add(lemail);

        tfemail.setBounds(148, 200, 310, 30);
        tfemail.setFont(new Font("TimesnewRoman", Font.BOLD, 17));
        jp.add(tfemail);



        lpassword = new JLabel("Password :");
        lpassword.setBounds(10, 300, 160, 23);
        lpassword.setFont(new Font("Arial", Font.BOLD, 25));
        lpassword.setForeground(Color.WHITE);
        jp.add(lpassword);

        tfpassword.setBounds(148, 300, 310, 30);
        tfpassword.setFont(new Font("Arial", Font.BOLD, 17));
        jp.add(tfpassword);

        btn_login = new JButton("Login");
        btn_login.setBounds(180, 370, 120, 40);
        btn_login.setFont(new Font("Arial", Font.BOLD, 22));
        btn_login.setBackground(Color.LIGHT_GRAY);

        jp.add(btn_login);

        lsignup = new JLabel("Dont have a account ? Create Account");
        lsignup.setBounds(40, 450, 290, 20);
        lsignup.setFont(new Font("Arial", Font.BOLD, 15));
        lsignup.setForeground(Color.WHITE);
        jp.add(lsignup);


        btn_signup = new JButton("Signup");
        btn_signup.setBounds(330, 450, 100, 20);
        btn_signup.setFont(new Font("Arial", Font.BOLD, 15));
        btn_signup.setBackground(Color.green);
        jp.add(btn_signup);

        btn_login.addActionListener(this);
        btn_signup.addActionListener(this);

    }



    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        String semail = tfemail.getText();
        char[] spass = tfpassword.getPassword();
        if (source == btn_login) {
            try {
                String query = ("select * from student where email=? and password=?");
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, semail);
                pst.setString(2, String.valueOf(spass));

                ResultSet result = pst.executeQuery();

                System.out.println("Querry Success Full");


                if (result.next()) {
                    String roll = result.getString("roll");
                    String email = result.getString("email");
                    String address2 = result.getString("address");
                    String names = result.getString("name");
                    String address = result.getString("address");
                    dispose();
                    homepage obj = new homepage();
                    obj.home(semail);
                 //  username = new JLabel("Welcome to Home Page @"+names+" !");
                  // username.setBounds(10,3,500,20);
                 //  username.setFont(new Font("Arial",Font.BOLD,18));
                  // username.setForeground(Color.WHITE);
                 // // obj.header.add(username);

                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login Credentials");
                }
            } catch (SQLException es) {
                System.out.println("Failed : " + es.getMessage());
            }

        } else if (source == btn_signup) {
            dispose();

            new registration();
        }
    }





}
