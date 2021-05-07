package MovieDB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UI1 extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3;
  
    UI1(){
        setTitle("Movie Data Base");
        
        l1 = new JLabel("WELCOME TO THE MOVIES");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(200,40,450,40);
        add(l1);
                
        b1 = new JButton("LOG IN AS USER");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("LOG IN AS ADMIN");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBounds(300,150,200,50);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 18));
        b2.setBounds(300,250,200,50);
        add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,480);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                    setVisible(false);
                    new LogIn().setVisible(true);
                }
            else if(ae.getSource()==b2){
                setVisible(false);
                new Admin_login().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new UI1().setVisible(true);
    }

    
}

