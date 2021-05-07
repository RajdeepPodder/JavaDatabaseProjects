package MovieDB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class Signup extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6;
    JTextField tf1,tf2,tf3,tf4;
    JPasswordField pf2;
    JButton b1,b2,b3;
    Signup(){
        setTitle("Create An Account");
        
        l1 = new JLabel("Enter The Detailed Information");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(200,40,500,40);
        add(l1);
        
        l2 = new JLabel("USER ID:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(300,120,230,30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        l3 = new JLabel("PASSWORD:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(300,190,230,30);
        add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);
        
        l4 = new JLabel("FULL NAME:");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(300,270,230,30);
        add(l4);
        
        tf2 = new JTextField(15);
        tf2.setBounds(300,300,230,30);
        tf2.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf2);
        
        l5 = new JLabel("Country:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(300,340,230,30);
        add(l5);
        
        tf3 = new JTextField(15);
        tf3.setBounds(300,380,230,30);
        tf3.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf3);

        l6 = new JLabel("Email ID:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(300,420,230,30);
        add(l6);
        
        tf4 = new JTextField(15);
        tf4.setBounds(300,450,230,30);
        tf4.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf4);
        
        b1 = new JButton("Save");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(350,500,80,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 12));
        b2.setBounds(450,500,80,30);
        add(b2);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.BLUE);
        
        setSize(800,750);
        setLocation(500,120);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String user_id  = tf1.getText();
                String password  = pf2.getText();
                String fname  = tf2.getText();
                String country  = tf3.getText();
                String email_id  = tf4.getText();
                String q1 = "insert into login values('"+user_id+"','"+password+"','"+fname+"','"+country+"','"+email_id+"')";
                c1.s.executeUpdate(q1);
                
                new LogIn().setVisible(true);
                setVisible(false);
            }
            if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
            }
            }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new Signup().setVisible(true);
    }
    
}