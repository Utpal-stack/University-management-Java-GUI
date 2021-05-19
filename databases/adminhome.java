package databases;

import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

public class adminhome extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6;
    JLabel l0,l1,l2,l3,l4,l5,l6,lemail,background;
    JTextField tf,tf1,tf2;
    JPanel p1,p2,p3,header,footer,body,spanel,cpanel,fpanel,dpanel;
    JComboBox box;
 Connection con;
public void home(String emails){
con = dbconnection.dbconnect();
    ImageIcon bg = new ImageIcon("student3.jpg");
    Image img = bg.getImage();
    Image temp_img = img.getScaledInstance(1500,820,Image.SCALE_SMOOTH);
    bg = new ImageIcon(temp_img);
    JLabel backgrounds = new JLabel("",bg,JLabel.CENTER);

    ImageIcon card_image1 = new ImageIcon("add_student2.png");
    Image img1 = card_image1.getImage();
    Image temp_img1 = img1.getScaledInstance(250,170,Image.SCALE_SMOOTH);
    card_image1 = new ImageIcon(temp_img1);
    JLabel background = new JLabel("",card_image1,JLabel.CENTER);



    ImageIcon card_image2 = new ImageIcon("add_faculty2.png");
    Image img2 = card_image2.getImage();
    Image temp_img2 = img2.getScaledInstance(250,170,Image.SCALE_SMOOTH);
    card_image2 = new ImageIcon(temp_img2);
    JLabel background3 = new JLabel("",card_image2,JLabel.CENTER);


    ImageIcon card_image3 = new ImageIcon("add_courses.png");
    Image img3 = card_image3.getImage();
    Image temp_img3 = img3.getScaledInstance(250,170,Image.SCALE_SMOOTH);
    card_image3= new ImageIcon(temp_img3);
    JLabel background2 = new JLabel("",card_image3,JLabel.CENTER);



    ImageIcon card_image4 = new ImageIcon("add_marks.png");
    Image img4 = card_image4.getImage();
    Image temp_img4 = img4.getScaledInstance(250,170,Image.SCALE_SMOOTH);
    card_image4 = new ImageIcon(temp_img4);
    JLabel background4 = new JLabel("",card_image4,JLabel.CENTER);


    ImageIcon card_image5 = new ImageIcon("departmetn.jpg");
    Image img5 = card_image5.getImage();
    Image temp_img5 = img5.getScaledInstance(250,170,Image.SCALE_SMOOTH);
    card_image5 = new ImageIcon(temp_img5);
    JLabel background5 = new JLabel("",card_image5,JLabel.CENTER);


    ImageIcon card_image6 = new ImageIcon("framebg.jpg");
    Image img6 = card_image6.getImage();
    Image temp_img6 = img6.getScaledInstance(250,170,Image.SCALE_SMOOTH);
    card_image6 = new ImageIcon(temp_img6);
    JLabel background6 = new JLabel("",card_image4,JLabel.CENTER);




    setLayout(null);



    setBounds(30,15,1500,820);
    header = new JPanel();
    header.setBounds(0,0,1500,40);
    header.setBackground(Color.BLACK);
    header.setLayout(null);
    add(backgrounds);
    backgrounds.setBounds(0,0,1500,820);
    backgrounds.add(header);


    lemail = new JLabel("Welcome Admin ! @"+emails);
    lemail.setBounds(10,10,500,25);
    lemail.setFont(new Font("Arial",Font.BOLD,18));
    lemail.setForeground(Color.WHITE);
    header.add(lemail);



l1 = new JLabel("----------------------------------------DashBoard-----------------------------------");
l1.setBounds(200,75,1300,50);
l1.setFont(new Font("Arial",Font.BOLD,35));
backgrounds.add(l1);

////////////////////////////////////////////////////////////
    spanel = new JPanel();
    spanel.setLayout(new CardLayout(0,0));
    spanel.setBounds(200,170,250,270);
    spanel.setBackground(Color.lightGray);
    backgrounds.add(spanel);
    spanel.add(background);
    l0 = new JLabel("Add Student");
    l0.setBounds(60,0,200,30);
    l0.setFont(new Font("Arial",Font.BOLD,20));
    background.add(l0);
    b1 = new JButton("Add Student");
    b1.setBounds(60,230,140,30);
    b1.setBackground(Color.green);
    b1.setFont(new Font("Arial",Font.BOLD,16));
    b1.setForeground(Color.black);
    b1.addActionListener(this);
    background.add(b1);

  ///////////////////////////////////////////////////////
  cpanel = new JPanel();
    cpanel.setBounds(640,170,250,270);
    cpanel.setBackground(Color.lightGray);
    cpanel.setLayout(new CardLayout());
    backgrounds.add(cpanel);

    cpanel.add(background2);
    l2 = new JLabel("Add Courses");
    l2.setBounds(60,0,200,30);
    l2.setFont(new Font("Arial",Font.BOLD,20));
    background2.add(l2);
    b2 = new JButton("Add Courses");
    b2.setBounds(60,230,140,30);
    b2.setBackground(Color.green);
    b2.setFont(new Font("Arial",Font.BOLD,16));
    b2.setForeground(Color.black);
    b2.addActionListener(this);
    background2.add(b2);

/////////////////////////////////////////////////////////////
    fpanel = new JPanel();
    fpanel.setBounds(1050,170,250,270);
    fpanel.setLayout(new CardLayout());
    fpanel.setBackground(Color.lightGray);
    backgrounds.add(fpanel);
    ////////
    fpanel.add(background3);
    l3 = new JLabel("Add Faculty");
    l3.setBounds(60,0,200,30);
    l3.setFont(new Font("Arial",Font.BOLD,20));
    background3.add(l3);
    b3 = new JButton("Add Faculty");
    b3.setBounds(60,230,140,30);
    b3.setBackground(Color.green);
    b3.setFont(new Font("Arial",Font.BOLD,16));
    b3.setForeground(Color.black);
    b3.addActionListener(this);
    background3.add(b3);

////////////////////////////////////////
    p3 = new JPanel();
    p3.setBounds(450,485,250,270);
    p3.setLayout(new CardLayout());
    p3.setBackground(Color.lightGray);
    backgrounds.add(p3);
    ////////
    p3.add(background4);
    l4 = new JLabel("Add Marks");
    l4.setBounds(70,10,200,30);
    l4.setFont(new Font("Arial",Font.BOLD,20));
    background4.add(l4);
    b4 = new JButton("Add Marks");
    b4.setBounds(60,230,140,30);
    b4.setBackground(Color.green);
    b4.setFont(new Font("Arial",Font.BOLD,16));
    b4.setForeground(Color.black);
    b4.addActionListener(this);
    background4.add(b4);

////////////////////////////////////////////////////////
    dpanel = new JPanel();
    dpanel.setBounds(800,485,250,270);
    dpanel.setBackground(Color.lightGray);
    dpanel.setLayout(new CardLayout());
    backgrounds.add(dpanel);


    dpanel.add(background5);
    l5 = new JLabel("Add Department");
    l5.setBounds(50,10,200,30);
    l5.setFont(new Font("Arial",Font.BOLD,20));
    background5.add(l5);
    b5 = new JButton("Add Marks");
    b5.setBounds(60,230,140,30);
    b5.setBackground(Color.green);
    b5.setFont(new Font("Arial",Font.BOLD,16));
    b5.setForeground(Color.black);
    b5.addActionListener(this);
    background5.add(b5);
    //////////////////////

   /* spanel = new JPanel();
    spanel.setBounds(1150,485,250,250);
    spanel.setBackground(Color.cyan);
    spanel.setLayout(null);
    add(spanel);*/
/////////////////////////////////////////////////////////////

    setVisible(true);
}

public void actionPerformed(ActionEvent e){
    Object source = e.getSource();
    if(source==b1) {

   add_student obj =new add_student();
obj.add_student1();

        }

    else if (source==b2){
        new add_courses();
    }
    else if (source==b3){
        new add_faculty();
        new add_teacher();
    }
    else if(source==b4){


        new enroll_course();
    }

}
public static  void main(String [] args){
    adminhome obj = new adminhome();
    obj.home("");
}

}
