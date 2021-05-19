package databases;

import com.sun.net.httpserver.Authenticator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

    public class payment extends JFrame implements ActionListener {
    Connection con;

    JLabel id,sems,deps,roll,sem_id ,dep_id,ammount,ammounts;
    JButton confirm;
  //  select payment.roll,sems_id,dep_id,ammount from payment INNER JOIN student
   // ON payment.roll=student.roll where dep_id="CS" ;
    payment(String dep,String roll_id,String sem){
    con =dbconnection.dbconnect();

    setBounds(600,180,400,500);
    setLayout(null);
    setTitle("Payment Gateway");
    setVisible(true);



    roll = new JLabel("Roll no      ");
    roll.setBounds(20,100,150,40);
    roll.setFont(new Font("Arial",Font.BOLD,25));
    add(roll);


    id = new JLabel();
    id.setBounds(190,100,150,40);
    id.setFont(new Font("Arial",Font.BOLD,25));
    id.setText(roll_id);
    add(id);


    dep_id = new JLabel("Department  " );
    dep_id.setBounds(20,150,180,40);
    dep_id.setFont(new Font("Arial",Font.BOLD,25));
    add(dep_id);



    deps = new JLabel();
    deps.setBounds(190,150,150,40);
    deps.setFont(new Font("Arial",Font.BOLD,25));
    deps.setText(dep);
    add(deps);


    sem_id = new JLabel("Semester  ");
    sem_id.setBounds(20,200,150,40);
    sem_id.setFont(new Font("Arial",Font.BOLD,25));
    add(sem_id);


    sems = new JLabel();
    sems.setBounds(190,200,150,40);
    sems.setFont(new Font("Arial",Font.BOLD,25));
    sems.setText(sem);
    add(sems);



    ammount= new JLabel("Ammount  ");
    ammount.setBounds(20,250,150,40);
    ammount.setFont(new Font("Arial",Font.BOLD,25));
    add(ammount);


    ammounts = new JLabel();
    ammounts.setText("200196");
    ammounts.setBounds(190,250,150,40);
    ammounts.setFont(new Font("Arial",Font.BOLD,25));
    add(ammounts);

    confirm = new JButton("Confirm");
    confirm.setBounds(140,350,100,40);
    confirm.setForeground(Color.BLACK);
    confirm.setFont(new Font("Arial",Font.BOLD,15));
    confirm.setBackground(Color.GREEN);
    confirm.addActionListener(this);
    add(confirm);



}
public static void main(String [] args){
new payment("","","");

}

public void actionPerformed(ActionEvent e){
    try{
        String query = ("insert into payment(roll,sems_id,ammount) values(?,?,?)");
        PreparedStatement pst = con .prepareStatement(query);
        pst.setString(1,id.getText());
        pst.setString(2,sems.getText());
        pst.setString(3,ammounts.getText());

         pst.executeUpdate();
         JOptionPane.showMessageDialog(null, "Paymetn Successful");

    }catch (SQLException sq){
        JOptionPane.showMessageDialog(null,sq.getMessage());
    }

    }
}
