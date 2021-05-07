package MovieDB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class UpDateInfo extends JFrame implements ActionListener{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6;
    JButton b1,b2,b3;
    UpDateInfo(){
        setTitle("Create An Account");
        
        l1 = new JLabel("Enter The Detailed Information");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(200,40,500,40);
        add(l1);
        
        l2 = new JLabel("MOVIE ID:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(300,120,230,30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        l3 = new JLabel("MOVIE TITLE:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(300,190,230,30);
        add(l3);
        
        tf2 = new JTextField(15);
        tf2.setFont(new Font("Arial", Font.BOLD, 14));
        tf2.setBounds(300,220,230,30);
        add(tf2);
        
        l4 = new JLabel("YEAR:");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(300,270,230,30);
        add(l4);
        
        tf3 = new JTextField(15);
        tf3.setBounds(300,300,230,30);
        tf3.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf3);
        
        l5 = new JLabel("LANGUAGE:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(300,340,230,30);
        add(l5);
        
        tf4 = new JTextField(15);
        tf4.setBounds(300,380,230,30);
        tf4.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf4);

        l6 = new JLabel("COUNTRY:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(300,420,230,30);
        add(l6);
        
        tf5 = new JTextField(15);
        tf5.setBounds(300,450,230,30);
        tf5.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf5);
        
        l7 = new JLabel("DURATION:");
        l7.setFont(new Font("Raleway", Font.BOLD, 28));
        l7.setBounds(300,500,230,30);
        add(l7);
        
        tf6 = new JTextField(15);
        tf6.setBounds(300,530,230,30);
        tf6.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf6);
        
        b1 = new JButton("UPDATE");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("BACK");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(250,600,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 12));
        b2.setBounds(400,600,80,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 12));
        b3.setBounds(500,600,80,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,750);
        setLocation(500,120);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String mov_id  = tf1.getText();
                String mov_title = tf2.getText();
                String mov_year = tf3.getText();
                String mov_lang  = tf4.getText();
                String mov_country  = tf5.getText();
                String mov_duration = tf6.getText();
                String q1 = "Update Movie set mov_title = '"+mov_title+"',mov_year = '"+mov_year+"',mov_lang = '"+mov_lang+"',mov_country = '"+mov_country+"',mov_duration = '"+mov_duration+"' where mov_id = '"+mov_id+"'";
                c1.s.executeUpdate(q1);  
                JOptionPane.showMessageDialog(null, "The data has been successfully updated");
            }
            if(ae.getSource()==b2){
                tf1.setText("");
                tf2.setText("");
                tf2.setText("");
                tf3.setText("");
                tf4.setText("");
                tf5.setText("");
                tf6.setText("");
            }
            if(ae.getSource()==b3){
                new options().setVisible(true);
                setVisible(false);
            }
            }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new UpDateInfo().setVisible(true);
    }
    
}