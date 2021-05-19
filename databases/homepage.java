package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class homepage extends JFrame implements ActionListener {
   JTextField tf,tfr; JPanel detail_card, marks_card ,p3,panelmenu,jp,header;
   JLabel lusername,lemail;
   String email1,name,roll,addresss,sem_id,sem_id1;
Connection con;
JButton b11,b1,b2,b3,b4,b5,logout,calc;
JComboBox box;



    public void home(String semail){
con = dbconnection.dbconnect();

    setBounds(150,30,1300,800);
    setTitle("Student Home");
    setLayout(null);

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
ImageIcon background_image = new ImageIcon("campus.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(1500,800,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel background = new JLabel("",background_image,JLabel.CENTER);


        ImageIcon  card_image = new ImageIcon("detail5.jpg");
        Image card1 = card_image.getImage();
        Image tmp_card = card1.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        card_image = new ImageIcon(tmp_card);
        JLabel background2 = new JLabel("",card_image,JLabel.CENTER);
        background2.setBounds(0,0,250,200);








        ImageIcon  card_image2 = new ImageIcon("marks3.jpg");
        Image card2 = card_image2.getImage();
        Image tmp_card2 = card2.getScaledInstance(250,200,Image.SCALE_SMOOTH);
        card_image2 = new ImageIcon(tmp_card2);
        JLabel background3 = new JLabel("",card_image2,JLabel.CENTER);
        background3.setBounds(0,0,250,200);




        ImageIcon  card_image3 = new ImageIcon("shedule.png");
        Image card3 = card_image3.getImage();
        Image tmp_card3 = card3.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        card_image3 = new ImageIcon(tmp_card3);
        JLabel background4 = new JLabel("",card_image3,JLabel.CENTER);
        background4.setBounds(0,0,250,200);






    background.setBounds(0,0,1300,800);

    getContentPane().add(background);
        panelmenu = new JPanel();
        panelmenu.setBounds(50,100,1200,600);
        panelmenu.setBackground(Color.yellow);
        panelmenu.setLayout(null);
        panelmenu.setBackground(new Color(0,0,10,75));
        background.add(panelmenu);

        detail_card = new JPanel();
        detail_card.setLayout(null);
        detail_card.setBounds(100,150,250,250);
        panelmenu.add(detail_card);
        detail_card.add(background2);
      //  background2.setLayout(null);



        b1 = new JButton("My Details");
        b1.setBounds(50,205,150,40);
        b1.addActionListener(this);
        detail_card.add(b1);
////////////////////////////////////////
        marks_card = new JPanel();
        marks_card.setBounds(480,150,250,250);
        marks_card.setLayout(null);
        panelmenu.add(marks_card);
        b2= new JButton("My Marks");
        b2.setBounds(50,205,150,40);
        b2.addActionListener(this);
        marks_card.add(background3);
        marks_card.add(b2);



        p3 = new JPanel();
        p3.setBounds(850,150,250,250);
        p3.setLayout(null);
        panelmenu.add(p3);
        b4= new JButton("Time Table");
        b4.setBounds(50,205,150,40);
        b4.addActionListener(this);
        p3.add(background4);
        p3.add(b4);


      /*  b2 = new JButton("MARKS");
        b2.setBounds(80,140,100,50);
         b2.addActionListener(this);
        panelmenu.add(b2);*/

        b3 = new JButton("MARKS");
        b3.setBounds(120,205,100,60);
        b3.addActionListener(this);
        panelmenu.add(b3);

        header= new JPanel();
        header.setBounds(0,0,1300,30);
        header.setBackground(Color.BLACK);


        calc = new JButton("Calculator");
        calc.setBounds(1030,6,100,20);
        calc.setFont(new Font("Arial",Font.BOLD,12));
        calc.addActionListener(this);
        calc.setForeground(Color.blue);


        logout =  new JButton("logout");
        logout.setBounds(1180,6,70,20);
        logout.setFont(new Font("Arial",Font.BOLD,12));
        logout.setForeground(Color.blue);
        logout.addActionListener(this);
        header.add(calc);
        header.add(logout);


    header.setVisible(true);
    header.setLayout(null);
    background.add(header);


    lemail = new JLabel("Welcome to Home ! @"+semail);
    lemail.setBounds(10,3,500,20);
    lemail.setFont(new Font("Arial",Font.BOLD,18));
    lemail.setForeground(Color.WHITE);
    header.add(lemail);

        setVisible(true);

try {

    String querry = ("Select * from student where email=?");
    PreparedStatement pst = con.prepareStatement(querry);
    pst.setString(1,semail);
    ResultSet result = pst.executeQuery();
    System.out.println("Querry Succesful");
if(result.next()){
    email1 = result.getString("email");
 addresss = result.getString("address");
roll = result.getString("roll");
    name  = result.getString("name");

}
else{
    System.out.println("CorrectQuery");
}

}catch(SQLException e){
    System.out.println("Failed Query"+e.getMessage());
}

    } public void actionPerformed(ActionEvent es){
        Object source = es.getSource();

        if(source == b1){
            s_details obj = new s_details();
            obj.sdetails(roll);
            System.out.println(roll);
        }
       else if(source == b2){
            System.out.println("BUTTON CLICKET FROM HOME"+roll);
            choose_result obj5 = new choose_result();
            obj5.check_result(roll);
       }
       else if(source==calc){

new calculator();


        }


       else if (source==logout){
           dispose();
           loginform obj1 = new loginform();
           obj1.signin();

        }




      /*  else if(source==b3){
            System.out.println("Sorry");
        }*/



        System.out.println("ROLL FROM HOMEPAGE"+roll);
        System.out.println("sem from home"+sem_id1);
    }
    public static  void main(String [] args){

        homepage obj = new homepage();
        obj.home("");
    }
}





/*TRY JCOMBOBOX PART STARTED HERE;
        try {
            String query1 = ("select * from combobox where roll=? group by sem_id");
            PreparedStatement pst = con.prepareStatement(query1);
            pst.setString(1, roll);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {

                String semester = rs.getString("semester");
                String roll = rs.getString("roll");
                sem_id1 = rs.getString("sem_id");
                box.addItem(sem_id1);
            }
        }
        catch (SQLException sq) {
            System.out.println("FAILED" + sq.getMessage());
        }
////JCOMBOBOX PART ENDS HERE;*/



    /*  //JCOMBOX ACTION PERFOEMD;
        else if (source == b11){
            System.out.println(box.getSelectedItem());
            tfr.setText(String.valueOf(box.getSelectedItem()));
            sem_id1 = String.valueOf(box.getSelectedItem());
student_examination obj = new student_examination();
obj.marks_details(roll,sem_id1); }
        ////////END*/