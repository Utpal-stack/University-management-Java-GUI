package databases;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class calculator extends JFrame implements ActionListener{

    Container c;
    JTextField t1;
    JButton add, sub, mul, division, b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, beq, bc;

    double firstnum, secondnum, result;
    String operation , answer;

    calculator(){
        setTitle("Christ Calculator");
        setSize(300,300);
        setLocation(100,100);
        setLocationRelativeTo(null);


        c = getContentPane();
        c.setLayout(null);

        t1 = new JTextField();
        t1.setBounds(35,20,235,40);
        c.add(t1);

        b0 = new JButton("0");
        b1 = new JButton("1");
        b2 = new JButton("2");
        b3 = new JButton("3");
        b4 = new JButton("4");
        b5 = new JButton("5");
        b6 = new JButton("6");
        b7 = new JButton("7");
        b8 = new JButton("8");
        b9 = new JButton("9");
        beq = new JButton("=");
        bc = new JButton("C");

        b9.setBounds(155,70,55,35);
        b8.setBounds(95,70,55,35);
        b7.setBounds(35,70,55,35);

        b6.setBounds(155,110,55,35);
        b5.setBounds(95,110,55,35);
        b4.setBounds(35,110,55,35);

        b3.setBounds(155,150,55,35);
        b2.setBounds(95,150,55,35);
        b1.setBounds(35,150,55,35);

        beq.setBounds(155,190,55,35);
        b0.setBounds(95,190,55,35);
        bc.setBounds(35,190,55,35);

        c.add(b9);
        c.add(b8);
        c.add(b7);
        c.add(b6);
        c.add(b5);
        c.add(b4);
        c.add(b3);
        c.add(b2);
        c.add(b1);
        c.add(b0);
        c.add(beq);
        c.add(bc);

        b1.setBackground(Color.GREEN);
        b2.setBackground(Color.GREEN);
        b3.setBackground(Color.GREEN);
        b4.setBackground(Color.GREEN);
        b5.setBackground(Color.GREEN);
        b6.setBackground(Color.GREEN);
        b7.setBackground(Color.GREEN);
        b8.setBackground(Color.GREEN);
        b9.setBackground(Color.GREEN);
        b0.setBackground(Color.GREEN);
        bc.setBackground(Color.CYAN);
        beq.setBackground(Color.CYAN);

        b9.addActionListener(this);
        b8.addActionListener(this);
        b7.addActionListener(this);
        b6.addActionListener(this);
        b5.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);
        b2.addActionListener(this);
        b1.addActionListener(this);
        b0.addActionListener(this);
        beq.addActionListener(this);
        bc.addActionListener(this);

        add = new JButton("+");
        add.setBounds(220,70,50,35);
        c.add(add);

        sub = new JButton("-");
        sub.setBounds(220,110,50,35);
        c.add(sub);

        mul = new JButton("X");
        mul.setBounds(220,150,50,35);
        c.add(mul);

        division = new JButton("/");
        division.setBounds(220,190,50,35);
        c.add(division);

        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        division.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == b7) {
                String Enternumber = t1.getText() + b7.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b8) {
                String Enternumber = t1.getText() + b8.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b9) {
                String Enternumber = t1.getText() + b9.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b6) {
                String Enternumber = t1.getText() + b6.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b5) {
                String Enternumber = t1.getText() + b5.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b4) {
                String Enternumber = t1.getText() + b4.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b3) {
                String Enternumber = t1.getText() + b3.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b2) {
                String Enternumber = t1.getText() + b2.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b1) {
                String Enternumber = t1.getText() + b1.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == b0) {
                String Enternumber = t1.getText() + b0.getText();
                t1.setText(Enternumber);
            }
            if (e.getSource() == bc) {
                t1.setText(null);
            }
            if (e.getSource() == add) {
                firstnum = Double.parseDouble(t1.getText());
                t1.setText("");
                operation = "+";
            }
            if (e.getSource() == sub) {

                firstnum = Double.parseDouble(t1.getText());
                t1.setText("");
                operation = "-";
            }
            if (e.getSource() == mul) {
                firstnum = Double.parseDouble(t1.getText());
                t1.setText("");
                operation = "X";
            }
            if (e.getSource() == division) {
                firstnum = Double.parseDouble(t1.getText());
                t1.setText("");
                operation = "/";
            }
            if (e.getSource() == beq) {

                secondnum = Double.parseDouble(t1.getText());
                if (operation == "+") {
                    result = firstnum + secondnum;
                    answer = String.format("%.1f", result);
                    t1.setText(answer);
                }
                if (operation == "-") {
                    result = firstnum - secondnum;
                    answer = String.format("%.1f", result);
                    t1.setText(answer);
                }
                if (operation == "X") {
                    result = firstnum * secondnum;
                    answer = String.format("%.1f", result);
                    t1.setText(answer);
                }
                if (operation == "/") {
                    result = firstnum / secondnum;
                    answer = String.format("%.2f", result);
                    t1.setText(answer);
                }
            }
        }
        catch (NumberFormatException e1){
            t1.setText("Invalid Input");
        }
        catch (ArithmeticException e2){
            t1.setText("Error");
        }
    }
}
class cal {
    public static void main(String[] args) {
        calculator frame = new calculator();
    }
}