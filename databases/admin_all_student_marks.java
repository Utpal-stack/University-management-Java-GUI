package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.ConnectException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class admin_all_student_marks extends JFrame implements ActionListener, ItemListener {
    Connection con;
    JLabel lroll,ldep,lsem;
    JComboBox croll, cdep, csem;

    admin_all_student_marks(){
        con = dbconnection.dbconnect();
        setBounds(600,200,400,450);
        setTitle("View MArks");
        setLayout(null);
        ldep = new JLabel("Department");
        ldep.setBounds(120,50,150,30);
        ldep.setFont(new Font("Arial",Font.BOLD,22));
        add(ldep);

        cdep = new JComboBox();
        cdep.setBounds(120,80,150,30);
        cdep.addItemListener(this);
        add(cdep);
/////////////////////////////////////////////////////////////////////////


        lsem = new JLabel("Semester");
        lsem.setBounds(125,150,150,30);
        lsem.setFont(new Font("Arial",Font.BOLD,22));
        add(lsem);


        csem= new JComboBox();
        csem.setBounds(120,180,150,30);
        csem.addItemListener(this);
        add(csem);

        lroll = new JLabel("Roll");
        lroll.setBounds(125,250,150,30);
        lroll.setFont(new Font("Arial",Font.BOLD,22));
        add(lroll);

        croll= new JComboBox();
        croll.setBounds(120,280,150,30);

        add(croll);

        JButton search = new JButton("Search");
        search.setBounds(120,350,150,40);
        search.addActionListener(this);
        search.setFont(new Font("Arial",Font.BOLD,22));
        add(search);

        setVisible(true);
try{
    String query1 = ("Select dep_id from department");
    PreparedStatement pst = con.prepareStatement(query1);
    ResultSet result = pst.executeQuery();
while(result.next()){
   String dep_id = result.getString("dep_id");
   cdep.addItem(dep_id);
    }
}catch (SQLException sq){
    JOptionPane.showMessageDialog(null,"SORRY PRIYAM"+sq.getMessage());

}


try{

    String query = ("select sem_id from batches");
    PreparedStatement pst = con.prepareStatement(query);
    ResultSet result2 = pst.executeQuery();
    while(result2.next()){
        String sem_id = result2.getString("sem_id");
        csem.addItem(sem_id);
    }

}catch(SQLException sq){
    System.out.println(sq.getMessage());

}

    }




    public void itemStateChanged(ItemEvent e){
        Object source = e.getSource();
        if (source == csem) {
            try {
                String query2 = ("select roll from student where dep_id=? and roll IN(select roll from combobox where sem_id=?);");
                PreparedStatement pst = con.prepareStatement(query2);
                pst.setString(1,cdep.getSelectedItem().toString());
                pst.setString(2,csem.getSelectedItem().toString());

                ResultSet result2 = pst.executeQuery();
                croll.removeAllItems();
                while (result2.next()) {

                    String roll = result2.getString("roll");

                    croll.addItem(roll);
                    validate();

                }



            } catch (SQLException sq) {
                JOptionPane.showMessageDialog(null, "hello " + sq.getMessage());
            }
        }
    }

public void actionPerformed(ActionEvent e){

        String  roll = croll.getSelectedItem().toString();
        String sem_id1 = csem.getSelectedItem().toString();
    System.out.println("Roll : "+roll+"SEm"+sem_id1);
    student_examination obj  = new student_examination();
    obj.marks_details(roll,sem_id1);

}




    public static void main(String[] args){
        new admin_all_student_marks();




    }



}
