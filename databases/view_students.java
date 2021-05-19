package databases;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class view_students extends JFrame {
    Connection con;
    DefaultTableModel tmodel;
   // String querry, name, roll1, address,dep_name,gender,city,phone;
    JTable table;
    JPanel tpanel;
    JLabel lname,laddress,lroll,ldepname,lphone,lgender,lcity;
   view_students(String roll,String dep_name,String city,String phone,String address, String gender,String name) {
        con = dbconnection.dbconnect();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(50, 50, 1300, 800);
        setLayout(null);

        tpanel = new JPanel();
        tpanel.setBounds(400,200,700,400);
        tpanel.setLayout(null);
        TitledBorder title;
        title = BorderFactory.createTitledBorder("Student Details");
        title.setTitleFont(new Font("Arial",Font.BOLD,20));
        tpanel.setBorder(title);


        tpanel.setBackground(Color.cyan);
        tpanel.setBackground(new Color(0,0,90,75));
        add(tpanel);
//
//        try{
//            String query2 = ("select department.dep_name as dep_name,student.name,roll,address,city,phone_no,gender,age,student.dep_id as dep_id,email " +
//                    "from student INNER JOIN department ON student.dep_id=student.dep_id where roll=?");
//            PreparedStatement pst = con.prepareStatement(query2);
//            pst.setString(1,roll);
//            ResultSet result = pst.executeQuery();
//            if(result.next()){
//                name = result.getString("name");
//                roll1 = result.getString("roll");
//                dep_name = result.getString("dep_name");
//                gender = result.getString("gender");
//                phone = result.getString("phone_no");
//                city = result.getString("city");
//                address = result.getString("address");
//
//
//
//
//
//            }
//
//
//
//        }catch (SQLException s1){
//            System.out.println("FAILED"+s1.getMessage());
//        }
//


        lname = new JLabel("Student Name  -  "+name);
        lname.setBounds(20,50,400,25);
        lname.setFont(new Font("Arial",Font.BOLD,22));
        tpanel.add(lname);


        lroll = new JLabel("Register No.  -  "+roll);
        lroll.setBounds(20,100,400,25);
        lroll.setFont(new Font("Arial",Font.BOLD,22));
        tpanel.add(lroll);
        ldepname = new JLabel("Department  - "+dep_name);
        ldepname.setBounds(20,150,400,25);
        ldepname.setFont(new Font("Arial",Font.BOLD,22));
        tpanel.add(ldepname);

        lgender = new JLabel("Gender  -  "+gender);
        lgender.setBounds(20,200,400,25);
        lgender.setFont(new Font("Arial",Font.BOLD,22));
        tpanel.add(lgender);

        lphone = new JLabel("Phone no   -  "+phone);
        lphone.setBounds(20,250,400,25);
        lphone.setFont(new Font("Arial",Font.BOLD,22));
        tpanel.add(lphone);

        lcity = new JLabel("City  - "+city);
        lcity.setBounds(20,300,400,25);
        lcity.setFont(new Font("Arial",Font.BOLD,22));
        tpanel.add(lcity);

        laddress = new JLabel("Address  -  "+address);
        laddress.setBounds(20,350,400,25);
        laddress.setFont(new Font("Arial",Font.BOLD,22));
        tpanel.add(laddress);
        setVisible(true);

    }
    public static void main(String [] args) {


       new view_students("","","","","","","");
    }


}
