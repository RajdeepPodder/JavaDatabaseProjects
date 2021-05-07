package MovieDB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class options extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
  
    options(){
        setTitle("Movie Data Base");
        
        l1 = new JLabel("Admin Controls");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(280,40,450,40);
        add(l1);
                
        b1 = new JButton("Insert Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("Delete Data");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("UPDate Data");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        setLayout(null);
        
        b4 = new JButton("Search Data");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        setLayout(null);
        
        b5 = new JButton("Log OUT");
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        setLayout(null);
        
        b6 = new JButton("Display All User Account");
        b6.setBackground(Color.BLACK);
        b6.setForeground(Color.WHITE);
        setLayout(null);
        
        b7 = new JButton("Delete USER Account");
        b7.setBackground(Color.BLACK);
        b7.setForeground(Color.WHITE);
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBounds(300,100,200,50);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setBounds(300,150,200,50);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 18));
        b3.setBounds(300,200,200,50);
        add(b3);
        
        b4.setFont(new Font("Arial", Font.BOLD, 18));
        b4.setBounds(300,250,200,50);
        add(b4);
        
        b5.setFont(new Font("Arial", Font.BOLD, 18));
        b5.setBounds(300,300,200,50);
        add(b5);
        
        b6.setFont(new Font("Arial", Font.BOLD, 18));
        b6.setBounds(250,350,300,50);
        add(b6);
        
        b7.setFont(new Font("Arial", Font.BOLD, 18));
        b7.setBounds(250,400,300,50);
        add(b7);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,500);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                    setVisible(false);
                    new DataBaseInfo().setVisible(true);
                }
            else if(ae.getSource()==b2){
                setVisible(false);
                new DeleteInfo().setVisible(true);
            }
            else if(ae.getSource()==b3){
                setVisible(false);
                new UpDateInfo().setVisible(true);
            }
            else if(ae.getSource()==b4){
                setVisible(false);
                new MovieDataBase().setVisible(true);
            }
            else if(ae.getSource()==b5){
                setVisible(false);
                new Admin_login().setVisible(true);
            }
            else if(ae.getSource()==b6){
                setVisible(false);
                new DisplayAllUserAccount();
            }
            else if(ae.getSource()==b7){
                setVisible(false);
                new DeleteUserAccount().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new options().setVisible(true);
    }
}

