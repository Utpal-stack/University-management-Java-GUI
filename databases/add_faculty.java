package databases;

        import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.sql.Connection;
        import java.sql.PreparedStatement;
        import java.sql.SQLException;

public class add_faculty extends  JFrame implements ActionListener{
    Connection con;
    JButton submit;
    JLabel salary,fphone,gender,course_id,course_name,sem_id,faculty_id,credits,Faculty_id,faculty_name,city;
    JTextField tfsalary,tffid,tfcid,tfcname,tfsid,tfphone,tfcr,tffname,tfgender,tfcity;
    JButton addfbtn;
    JRadioButton radiobtn;
    add_faculty(){
        con = dbconnection.dbconnect();

        setBounds(700,100,390,600);
        setLayout(null);


        Faculty_id = new JLabel("Faculty Id");
        Faculty_id.setBounds(80,40,150,25);
        Faculty_id.setFont(new Font("Arial",Font.BOLD,22));
        add(Faculty_id);

        tffid = new JTextField();
        tffid.setBounds(80,70,200,30);
        tffid.setFont(new Font("Arial",Font.BOLD,15));
        add(tffid);

        faculty_name = new JLabel("Name");
        faculty_name.setBounds(80,115,150,30);
        faculty_name.setFont(new Font("Arial",Font.BOLD,22));
        add(faculty_name);


        tffname = new JTextField();
        tffname.setBounds(80,145,200,30);
        tffname.setFont(new Font("Arial",Font.BOLD,15));
        add(tffname);


        gender = new JLabel("Gender");
        gender.setBounds(80,190,150,30);
        gender.setFont(new Font("Arial",Font.BOLD,22));
        add(gender);


        radiobtn = new JRadioButton();
        radiobtn.setBounds(80,220,20,30);
        radiobtn.setText("MALE");
        add(radiobtn);
        // tfgender = new JTextField();
        //tfgender.setBounds(80,220,200,30);
        //tfgender.setFont(new Font("Arial",Font.BOLD,15));
        //add(tfgender);




        fphone = new JLabel("Phone no.");
        fphone.setBounds(80,265,150,25);
        fphone.setFont(new Font("Arial",Font.BOLD,22));
        add(fphone);



        tfphone = new JTextField();
        tfphone.setBounds(80,295,200,25);
        tfphone.setFont(new Font("Arial",Font.BOLD,15));
        add(tfphone);


        city = new JLabel("City");
        city.setBounds(80,340,150,25);
        city.setFont(new Font("Arial",Font.BOLD,22));
        add(city);

        tfcity = new JTextField();
        tfcity.setBounds(80,370,200,30);
        tfcity.setFont(new Font("Arial",Font.BOLD,15));
        add(tfcity);

        salary = new JLabel("Salary");
        salary.setBounds(80,415,150,25);
        salary.setFont(new Font("Arial",Font.BOLD,22));
        add(salary);

        tfsalary = new JTextField();
        tfsalary.setBounds(80,445,200,30);
        tfsalary.setFont(new Font("Arial",Font.BOLD,15));
        add(tfsalary);



        addfbtn = new JButton("Add Faculty");
        addfbtn.setBounds(130,500,110,35);
        addfbtn.addActionListener(this);
        add(addfbtn);
        setVisible(true);



    }


    public void actionPerformed(ActionEvent e){



       /* String cid  = tfcid.getText();
String cname =  tfcname.getText();
        String semester_id = tfsid.getText();
        String faculty = tftid.getText();
        String credits = tfcr.getText()
        */
        Object s = e.getSource();

        if(s==addfbtn){
            try{
                String query = ("insert into faculty(faculty_id,faculty_name,gender,fphone,city,salary) values(?,?,?,?,?,?)");
                PreparedStatement pst = con.prepareStatement(query);


                pst.setString(1,tffid.getText());
                pst.setString(2, tffname.getText());
                pst.setString(3,radiobtn.getText());
                pst.setString(4,tfphone.getText());
                pst.setString(5,tfcity.getText());
                pst.setString(6,tfsalary.getText());
                System.out.println(radiobtn.getText());

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Faculty Added Successfully");

            }catch (SQLException sq){
                JOptionPane.showMessageDialog(null,"Data Inertion Failed"+sq.getMessage());
            }




        }

    }

    public static void main (String[]args){

        new add_faculty();
    }

}
