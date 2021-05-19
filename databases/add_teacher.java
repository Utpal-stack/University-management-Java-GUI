package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


class add_teacher extends  JFrame implements ActionListener {

    Connection con;
    Container c;
    JPanel head;
    JTextField ID, name, Gender ,Phone, City, Salary, Age;
    JButton submit;

    add_teacher() {
        con = dbconnection.dbconnect();

        setTitle("Student_details");
        setSize(770, 650);
        setLocation(400, 130);
setResizable(false);
        //  setLayout(null);
        //   setDefaultCloseOperation(EXIT_ON_CLOSE);

        c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.pink);

        head = new JPanel();
        head.setBounds(90, 22,590, 75 );
        head.setLayout(null);
        head.setBackground(Color.CYAN);
        c.add(head);

        JLabel heading = new JLabel(" ADD TEACHER");
        heading.setBounds(20, 0, 570,70);
        heading.setFont(new Font("DigifaceWide", Font.BOLD, 67));
        heading.setBackground(Color.black);
        head.add(heading);

        //   id, nam, gender ,phone, city, salary, age
        JLabel id = new JLabel("Faculty ID    :");
        id.setBounds(230,130, 100,30);
        id.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(id);

        JLabel nam = new JLabel("Name            :");
        nam.setBounds(230,180, 100,30);
        nam.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(nam);

        JLabel gender = new JLabel("Gender    :");
        gender.setBounds(230,230, 100,30);
        gender.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(gender);

        JLabel phone = new JLabel("Phone         :");
        phone.setBounds(230,280, 100,30);
        phone.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(phone);

        JLabel city = new JLabel("City           :");
        city.setBounds(230,330, 100,30);
        city.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(city);

        JLabel salary = new JLabel("Salary        :");
        salary.setBounds(230,380, 100,30);
        salary.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(salary);

        JLabel age = new JLabel("Age          :");
        age.setBounds(230,430, 100,30);
        age.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(age);

        //    ID, name, gender ,phone, city, Salary, Age
        ID = new JTextField();
        ID.setBounds(330,130, 200,30);
        ID.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(ID);

        name = new JTextField();
        name.setBounds(330,180, 200,30);
        name.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(name);

        Gender = new JTextField();
        Gender.setBounds(330,230, 200,30);
        Gender.setFont(new Font("Arial", Font.BOLD, 15));

        c.add(Gender);

        Phone = new JTextField();
        Phone.setBounds(330,280, 200,30);
        Phone.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(Phone);

        City = new JTextField();
        City.setBounds(330,330, 200,30);
        City.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(City);

        Salary = new JTextField();
        Salary.setBounds(330,380, 200,30);
        Salary.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(Salary);

        Age = new JTextField();
        Age.setBounds(330,430, 200,30);
        Age.setFont(new Font("Arial", Font.BOLD, 15));
        c.add(Age);

        submit = new JButton("Submit");
        submit.setBounds(350, 500, 130,40);
        submit.addActionListener(this);
        c.add(submit);


        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//    ID, name, gender ,phone, city, Salary, Age
        if(e.getSource()== submit){
            String  IDText = ID.getText();
            String  nameText = name.getText();
            String  genderText = Gender.getText();
            String  phoneText = Phone.getText();
            String  cityText = City.getText();
            String  salaryText = Salary.getText();
        //    String  ageText = Age.getText();



            try{
               /* Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://localhost/student","root","");
*/
                PreparedStatement pst = con.prepareStatement("insert into faculty(faculty_id,faculty_name,gender,fphone,city,salary)values(?,?,?,?,?,?)");
                pst.setString(1,IDText);
                pst.setString(2,nameText);
                pst.setString(3,genderText);
                pst.setString(4,phoneText);
                pst.setString(5,cityText);
                pst.setString(6,salaryText);
              //  pst.setString(7,ageText);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"added successfully !!");

                System.out.println("added");

            }catch (Exception ex){

                JOptionPane.showMessageDialog(null,ex);
            }
        }
    }
    public static void main(String[] args) {
        new add_teacher();
    }
}