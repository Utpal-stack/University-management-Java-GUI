package databases;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

public class student_examination extends JFrame {
    Connection con;int i=0,j=0;int count;
    DefaultTableModel tmodel;
    String querry, name1, roll1,dep_name1, address,pname,sem,yrs,totaly,percentage1,division,sem_id;
   DecimalFormat df = new DecimalFormat("#.##");
    double percentage,p3;
    JTable table;
    JPanel tpanel,p2;
    JLabel lname,lroll,lsem,lyear,ldepartment,ldivision,lstatus,ltotal;
    public void marks_details(String roll,String sem_id1) {
        con = dbconnection.dbconnect();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setBounds(50, 50, 1300, 800);
        setVisible(true);
        setLayout(null);

        tpanel = new JPanel();
        tpanel.setBounds(50,300,1150,450);
        tpanel.setBackground(Color.cyan);
        tpanel.setBackground(new Color(0,0,90,75));
        add(tpanel);

        try {
            String countquery = ("select courses.sem_id as sem_id,SUM(CIA1+MIDSEM+CIA3+ENDSEM) as total,batches.semester as semester,batches.year as year,count(course_details.roll) as count,student.name as name,student.roll as roll,department.dep_name as dep_name" +
                    " from course_details " +
                    "INNER JOIN student ON course_details.roll=student.roll " +
                    "INNER JOIN department ON department.dep_id=student.dep_id INNER JOIN courses ON course_details.course_id=courses.course_id " +
                    "INNER JOIN batches ON batches.sem_id=courses.sem_id where course_details.roll=? and courses.sem_id=?");
            PreparedStatement pst = con.prepareStatement(countquery);
            pst.setString(1,roll);
            pst.setString(2,sem_id1);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                count = rs.getInt("count");
                roll1 =  rs.getString("roll");
                name1 =  rs.getString("name");
                dep_name1 =  rs.getString("dep_name");
               sem =  rs.getString("semester");
                yrs =  rs.getString("year");
               totaly =  rs.getString("total");
                System.out.println(totaly);
                int a = Integer.valueOf(totaly);
                double calculation = a*1;
double divide = calculation/700;
 percentage = divide * 100;
percentage1 = df.format(percentage);
p3 = Double.valueOf(percentage1);
                System.out.println("a"+a);
               System.out.println("Calc"+calculation);
             //   String b = String.valueOf(calculation);
              System.out.println("b"+divide);
             //   percentage1 = b;
             //   System.out.println("Percentage"+percentage1);
            }

        }catch (SQLException et){
            System.out.println("FAIL"+et.getMessage());
        }

        lname = new JLabel("Student Name : "+name1);
        lname.setBounds(50,100,300,30);
        lname.setFont(new Font("Arial",Font.BOLD,18));
        add(lname);

        ldepartment = new JLabel("Department     : "+dep_name1);
        ldepartment.setBounds(50,200,600,30);
        ldepartment.setFont(new Font("Arial",Font.BOLD,18));
        add(ldepartment);

        lroll = new JLabel("Register No    : "+roll1);
        lroll.setBounds(50,150,300,30);
        lroll.setFont(new Font("Arial",Font.BOLD,18));
        add(lroll);

        lsem = new JLabel("Semester : "+sem);
        lsem.setBounds(600,100,400,30);
        lsem.setFont(new Font("Arial",Font.BOLD,18));
        add(lsem);

        lyear = new JLabel("Year : "+yrs);
        lyear.setBounds(600,150,400,30);
        lyear.setFont(new Font("Arial",Font.BOLD,18));
        add(lyear);

        lstatus = new JLabel();
        lstatus.setBounds(60,650,400,30);
        lstatus.setFont(new Font("Arial",Font.BOLD,18));
        if(p3>=40){
            lstatus.setText("Status : "+"Passed");
        }
        else if (p3<40){
            lstatus.setText("Status : "+"Failed");
        }

        add(lstatus);


        ldivision = new JLabel();
        ldivision.setBounds(400,650,400,30);
        ldivision.setFont(new Font("Arial",Font.BOLD,18));
        if(p3<60 && p3>=40){
            ldivision.setText("Division : "+"Second Class");
        }
        else if (p3>=60){
            ldivision.setText("Division : "+"First Class");
        }
        add(ldivision);




        ltotal = new JLabel("Total Marks : "+totaly);
        ltotal.setBounds(900,650,400,30);
        ltotal.setFont(new Font("Arial",Font.BOLD,18));
        add(ltotal);




        String data[][] = new String[count][11];

        String column[] = {"Subject Code","Subject","CIA1","MIDSEM","CIA3","ENDSEM","Total"};
        try {
            querry = ("select * from course_enrolled where roll=? and sem_id=?");

            PreparedStatement pst = con.prepareStatement(querry);
            pst.setString(1, roll);
            pst.setString(2, sem_id1);
            ResultSet result = pst.executeQuery();
            while (result.next()) {


                data[i][j++] = result.getString("course_id");
                data[i][j++] = result.getString("course_name");
                data[i][j++] = result.getString("CIA1");
                data[i][j++] = result.getString("MIDSEM");
                data[i][j++] = result.getString("CIA3");
                data[i][j++] = result.getString("ENDSEM");
                data[i][j++] = result.getString("total_marks");

                j=0;
                i++;
            }
if(result.next()){
     pname = result.getString("roll");


}
        }


        catch (SQLException es)
        {
            System.out.println("Failed" + es.getMessage());
        }


        table = new JTable(data, column);
table.getTableHeader().setFont(new Font("Segoe",Font.BOLD,14));
table.getTableHeader().setOpaque(false);
table.getTableHeader().setBackground(Color.BLACK);
table.getTableHeader().setForeground(Color.WHITE);
table.setRowHeight(40);
table.setRowMargin(2);
table.setEnabled(false);
table.setFocusable(true);
table.getColumn("Subject").setPreferredWidth(150);
        table.getColumn("CIA1").setPreferredWidth(20);
        table.getColumn("ENDSEM").setPreferredWidth(20);
        table.getColumn("CIA3").setPreferredWidth(20);
        table.getColumn("MIDSEM").setPreferredWidth(20);
table.setFont(new Font("Arial",Font.PLAIN,18));

        JScrollPane js = new JScrollPane(table);

        table.setPreferredScrollableViewportSize(new Dimension(1150,300));
        table.setFillsViewportHeight(true);

        tpanel.add(js);







    }
    public static void main(String [] args) {


        student_examination obj = new student_examination();
        obj.marks_details("","");
    }


}


