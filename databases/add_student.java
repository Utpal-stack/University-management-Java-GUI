package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.Color;

public class add_student extends JFrame implements ActionListener{
    JComboBox dep,gender;
    JPanel jp;
    JLabel lage,lgender,ldob,lcity,lphone,lrpassword,ldep,lname,lreg,laddress,login,lemail,lpassword;
    JButton btn_submit,btnl;
    JTextField tfname = new JTextField();
    JTextField tfref = new JTextField();
    JTextField tfaddress = new JTextField();
    JTextField tfemail = new JTextField();
    JTextField tfdep = new JTextField();
    JTextField tfcity= new JTextField();
    JTextField tfrpassword= new JTextField();
    JPasswordField tfpassword = new JPasswordField();
JTextField tfage,tfgender,tfphone,dob,age;
    Connection con;
   public void add_student1(){

        con = dbconnection.dbconnect();
        setBounds(150,30,1300,800);

       ImageIcon background_image = new ImageIcon("framebg.jpg");

     Image img = background_image.getImage();
       Image temp_img = img.getScaledInstance(1500,800,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);



       JLabel background = new JLabel("",background_image,JLabel.CENTER);
       background.setBounds(0,0,1300,800);
        background.setLayout(null);
        add(background);


        jp = new JPanel();
        jp.setBounds(200,100,800,600);
        jp.setBackground(new Color(0,0,0,120));
        jp.setLayout(null);

        background.add(jp);


        lname = new JLabel("Username ");
        lname.setBounds(40,90,160,23);
        lname.setFont(new Font("TimesnewRoman",Font.BOLD,25));
        lname.setForeground(Color.WHITE);
        jp.add(lname);

        tfname.setBounds(40,120,300,30);
        tfname.setFont(new Font("Arial",Font.BOLD,18));

        jp.add(tfname);


        lreg = new JLabel("Reg no ");
        lreg.setBounds(440,90,160,23);
        lreg.setFont(new Font("Arial",Font.BOLD,25));
        lreg.setForeground(Color.WHITE);
        jp.add(lreg);

        tfref.setBounds(440,120,200,30);
        tfref.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfref);

        lcity = new JLabel("City");
lcity.setBounds(440,170,200,30);
lcity.setFont(new Font("Arial",Font.BOLD,25));
lcity.setForeground(Color.WHITE);
jp.add(lcity);

tfcity  = new JTextField();
tfcity.setBounds(440,200,200,30);
tfcity.setFont(new Font("Arial",Font.BOLD,18));
jp.add(tfcity);



     // //  laddress = new JLabel("Address    :");
      //  laddress.setBounds(10,210,160,23);
     //   laddress.setFont(new Font("Arial",Font.BOLD,25));
     //   laddress.setForeground(Color.WHITE);
     //   jp.add(laddress);
      //  tfaddress.setBounds(147,210,340,30);
      //  tfaddress.setFont(new Font("Arial",Font.BOLD,18));

      ///  jp.add(tfaddress);



        lemail = new JLabel("Email Id  ");
        lemail.setBounds(40,170,170,23);
        lemail.setFont(new Font("Arial",Font.BOLD,25));
        lemail.setForeground(Color.WHITE);
        jp.add(lemail);

        tfemail.setBounds(40,200,300,30);
        tfemail.setFont(new Font("Arial",Font.BOLD,18));

        jp.add(tfemail);


        lpassword = new JLabel("Password ");
        lpassword.setBounds(40,240,160,23);
        lpassword.setFont(new Font("Arial",Font.BOLD,25));
        lpassword.setForeground(Color.WHITE);
        jp.add(lpassword);

        tfpassword.setBounds(40,270,300,30);
        tfpassword.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfpassword);




        lrpassword = new JLabel("Repeat Password ");
        lrpassword.setBounds(40,310,300,23);
        lrpassword.setFont(new Font("Arial",Font.BOLD,25));
        lrpassword.setForeground(Color.WHITE);
        jp.add(lrpassword);

        tfrpassword.setBounds(40,340,300,30);
        tfrpassword.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfrpassword);


        lphone = new JLabel("Phone no.");
        lphone.setBounds(40,380,150,23);
        lphone.setFont(new Font("Arial",Font.BOLD,25));
        lphone.setForeground(Color.WHITE);
        jp.add(lphone);

        tfphone = new JTextField();
        tfphone.setBounds(40,410,340,30);
        tfphone.setFont(new Font("Arial",Font.BOLD,18));
        jp.add(tfphone);



lgender = new JLabel("Gender");
lgender.setBounds(440,240,200,25);
lgender.setFont(new Font("Arial",Font.BOLD,25));
lgender.setForeground(Color.WHITE);
jp.add(lgender);
gender = new JComboBox();
gender.setBounds(440,270,200,30);gender.setFont(new Font("Arial",Font.BOLD,18));
       gender.addItem("MALE");
       gender.addItem("FEMALE");

        jp.add(gender);
        String genders = String.valueOf(gender.getSelectedItem());
        System.out.println(genders);



ldep = new JLabel("Department");
ldep.setBounds(440,310,200,30);
ldep.setForeground(Color.WHITE);
ldep.setFont(new Font("Arial",Font.BOLD,25));
jp.add(ldep);

dep = new JComboBox();
dep.setBounds(440,340,200,30);
dep.setFont(new Font("Arial",Font.BOLD,18));

try{
    String query = ("select dep_id from department");
    PreparedStatement pst = con.prepareStatement(query);
    ResultSet result = pst.executeQuery();
    while(result.next()){
        String depid = result.getString("dep_id");
        dep.addItem(depid);
    }
}catch (SQLException e){
    System.out.println("Failed to get department"+e.getMessage());
}

jp.add(dep);



ldob = new JLabel("Date Of Birth");
ldob.setBounds(440,380,200,30);
        ldob.setForeground(Color.WHITE);
        ldob.setFont(new Font("Arial",Font.BOLD,25));
        jp.add(ldob);

dob = new JTextField();
dob.setBounds(440,408,200,30);
jp.add(dob);





        login= new JLabel("Alredy a member ? Click here ");
        login.setBounds(300,560,500,20);
        login.setFont(new Font("Arial",Font.BOLD,15));
        login.setForeground(Color.WHITE);
        jp.add(login);




        btn_submit = new JButton("Signup");
        btn_submit.setBounds(350,500,150,30);
        btn_submit.setFont(new Font("Arial",Font.BOLD,22));
        jp.add(btn_submit);


        btnl = new JButton("Login");
        btnl.setBounds(550,560,100,20);
        btnl.setFont(new Font("Arial",Font.BOLD,18));
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
        String address1 = "ABC";
        String email1 = tfemail.getText();
        String password1 = tfpassword.getText();
        String repeatpass = tfrpassword.getText();
        String city = tfcity.getText();
        String phone = tfphone.getText();
  //     Date dop = Date.valueOf(dob.getText());
        String  genders  =  String.valueOf(gender.getSelectedItem());
        String deps = String.valueOf(dep.getSelectedItem());

        Object source = e.getSource();
        if(source==btn_submit) {

            try {
                PreparedStatement pst = con.prepareStatement("insert into student(name,roll,address,email,password,repeat_password,phone_no,gender,dep_id,city) values(?,?,?,?,?,?,?,?,?,?)");
                pst.setString(1,name1);
                pst.setString(2,reg1);
                pst.setString(3,address1);
                pst.setString(4,email1);
                pst.setString(5,password1);



                pst.setString(6,repeatpass);
                pst.setString(7,phone);
                pst.setString(8,genders);
                pst.setString(9,deps);
                pst.setString(10,city);
               // pst.setDate(11,dop);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"DATA INSERTED");
                tfname.setText("");
                tfref.setText("");
                tfaddress.setText("");
            }catch(SQLException et){
                System.out.println("Failed"+et.getMessage());
            }

        }
        else if(source==btnl){
            System.out.println("Login form");
            dispose();
            loginform obj = new loginform();
            obj.signin();
        }
    }
}


