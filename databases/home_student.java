package databases;

import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

class home_student extends JFrame implements ActionListener {
    JButton b1,b2,b3,b4,b5,b6;
    JLabel l0,l1,l2,l3,l4,l5,l6,lemail,background;
    JTextField tf,tf1,tf2;
    JPanel p1,p2,p3,header,footer,body,spanel,cpanel,fpanel;
    JComboBox box;
    Connection con;
    public void student_home(){
        //con = dbconnection.dbconnect();
        ImageIcon background_image = new ImageIcon("utapls.jpg");
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(250,200,Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);

        ImageIcon background_image1 = new ImageIcon("utapalv.jpg");
        Image img1 = background_image1.getImage();
        Image temp_img1 = img1.getScaledInstance(250,200,Image.SCALE_SMOOTH);
        background_image1 = new ImageIcon(temp_img1);

        ImageIcon background_image2 = new ImageIcon("question.jpg");
        Image img2 = background_image2.getImage();
        Image temp_img2 = img2.getScaledInstance(250,200,Image.SCALE_SMOOTH);
        background_image2 = new ImageIcon(temp_img2);

        JLabel background = new JLabel("",background_image,JLabel.LEFT);
        JLabel background2 = new JLabel("",background_image1,JLabel.CENTER);
        JLabel background3 = new JLabel("",background_image2,JLabel.CENTER);
        setLayout(null);

        setBounds(280,105,1050,650);
        header = new JPanel();
        header.setBounds(0,0,1050,40);
        header.setBackground(Color.BLACK);
        header.setLayout(null);
        add(header);

        lemail = new JLabel("Welcome Admin");
        lemail.setBounds(10,10,500,25);
        lemail.setFont(new Font("Cooper Black",Font.BOLD,18));
        lemail.setForeground(Color.WHITE);
        header.add(lemail);


        l1 = new JLabel(" ------------------------------- STUDENT -----------------------------");
        l1.setBounds(20,75,1300,50);
        l1.setFont(new Font("Cooper Black",Font.BOLD,40));
        add(l1);

////////////////////////////////////////////////////////////
        spanel = new JPanel();
        spanel.setLayout(new CardLayout(0,0));
        spanel.setBounds(50,200,250,270);
        //  spanel.setBackground(new Color(0,0,10,100));
        spanel.setBackground(Color.lightGray);
        add(spanel);
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
        cpanel.setBounds(400,200,250,270);
        cpanel.setBackground(Color.lightGray);
        cpanel.setLayout(new CardLayout());
        add(cpanel);

        cpanel.add(background2);
        l2 = new JLabel("View Student");
        l2.setBounds(60,0,200,30);
        l2.setFont(new Font("Arial",Font.BOLD,20));
        background2.add(l2);
        b2 = new JButton("View Student");
        b2.setBounds(60,230,140,30);
        b2.setBackground(Color.green);
        b2.setFont(new Font("Arial",Font.BOLD,16));
        b2.setForeground(Color.black);
        b2.addActionListener(this);
        background2.add(b2);

/////////////////////////////////////////////////////////////
        fpanel = new JPanel();
        fpanel.setBounds(750,200,250,270);
        fpanel.setLayout(new CardLayout());
        fpanel.setBackground(Color.lightGray);
        add(fpanel);
        ////////
        fpanel.add(background3);
        l3 = new JLabel("View Marks");
        l3.setBounds(60,0,200,30);
        l3.setFont(new Font("Arial",Font.BOLD,20));
        background3.add(l3);
        b3 = new JButton("View Marks");
        b3.setBounds(60,230,140,30);
        b3.setBackground(Color.green);
        b3.setFont(new Font("Arial",Font.BOLD,16));
        b3.setForeground(Color.black);
        b3.addActionListener(this);
        background3.add(b3);

        setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        Object source = e.getSource();
        if(source==b1) {

              add_student obj =new add_student();
            obj.add_student1();

        }

        else if (source==b2){
            new view_student_combobox();
        }
        else if (source==b3){
       new admin_all_student_marks();

        }
    }
    public static void main(String[] args) {
        home_student obj  = new home_student();
        obj.student_home();
    }
}