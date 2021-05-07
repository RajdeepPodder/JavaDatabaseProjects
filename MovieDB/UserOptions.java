package MovieDB;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class UserOptions extends JFrame implements ActionListener{
    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
  
    UserOptions(){
        setTitle("Movie Data Base");
        
        l1 = new JLabel("User Options");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(280,40,450,40);
        add(l1);
                
        b1 = new JButton("Search Data");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        
        b3 = new JButton("Log OUT");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        setLayout(null);
        
        
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        b1.setBounds(300,100,200,50);
        add(b1);
        
        
        b3.setFont(new Font("Arial", Font.BOLD, 18));
        b3.setBounds(300,200,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(800,500);
        setLocation(550,200);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                    setVisible(false);
                    new MovieDataBase().setVisible(true);
                }
            else if(ae.getSource()==b3){
                setVisible(false);
                new LogIn().setVisible(true);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        new UserOptions().setVisible(true);
    }
}

