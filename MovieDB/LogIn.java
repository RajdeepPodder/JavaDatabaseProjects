package MovieDB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class LogIn extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField tf1;
    JPasswordField pf2;
    JButton b1,b2,b3,b4;
  
    LogIn(){
        setTitle("Movie Data Base");
        
        l1 = new JLabel("WELCOME TO THE MOVIES");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(200,40,450,40);
        add(l1);
        
        l2 = new JLabel("USER ID:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(300,150,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        l3 = new JLabel("PASSWORD:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,220,375,30);
        add(l3);
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(300,220,230,30);
        add(pf2);
                
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("View Account");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 14));
        b1.setBounds(300,300,100,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(430,300,100,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(250,350,150,30);
        add(b3);
        
        b4.setFont(new Font("Arial", Font.BOLD, 14));
        b4.setBounds(430,350,150,30);
        add(b4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String user_id  = tf1.getText();
                String password  = pf2.getText();
                
                String q  = "select * from login where user_id  = '"+user_id+"' and password = '"+password+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    new UserOptions().setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect USER_ID or Password");
                }
            }else if(ae.getSource()==b2){
                tf1.setText("");
                pf2.setText("");
            }else if(ae.getSource()==b3){
                setVisible(false);
                new Signup().setVisible(true);
            }
            else if(ae.getSource()==b4){
                conn c1 = new conn();
                String user_id  = tf1.getText();
                String password  = pf2.getText();
                
                String q  = "select * from login where user_id  = '"+user_id+"' and password = '"+password+"'";

                ResultSet rs = c1.s.executeQuery(q);
                if(rs.next()){
                    setVisible(false);
                    User_Account a = new User_Account(tf1.getText());
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect USER_ID or Password");
                }
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new LogIn().setVisible(true);
    }

    
}

