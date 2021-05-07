package MovieDB;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class User_Account  {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,aid,aid1,aid2,aid3,aid4;
    String user_id,password,fname, country,email_id;

    User_Account(String user_id){
        try{
            conn con = new conn();
            String str = "select * from login where user_id = '"+user_id+"'";
            ResultSet rs= con.s.executeQuery(str);

            while(rs.next()){
                password = rs.getString("password");
                fname = rs.getString("fname");
                country = rs.getString("country");
                email_id = rs.getString("email_id");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        f=new JFrame("Print Data");
        f.setVisible(true);
        f.setSize(595,642);
        f.setLocation(450,200);
        f.setBackground(Color.black);
        f.setLayout(null);
        
        l1 = new JLabel("WELCOME TO THE MOVIES");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(100,40,450,40);
        f.add(l1);
        
        l2 = new JLabel("USER ID:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(125,150,375,30);
        f.add(l2);
        
        aid = new JLabel(user_id);
        aid.setBounds(250,150,300,30);
        aid.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid);
        
        l3 = new JLabel("PASSWORD:");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));
        l3.setBounds(125,200,375,30);
        f.add(l3);
        
        aid1 = new JLabel(password);
        aid1.setBounds(300,200,300,30);
        aid1.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid1);
        
        l4 = new JLabel("Name:");
        l4.setFont(new Font("Raleway", Font.BOLD, 28));
        l4.setBounds(125,250,375,30);
        f.add(l4);
        
        aid2 = new JLabel(fname);
        aid2.setBounds(250,250,300,30);
        aid2.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid2);
        
        l5 = new JLabel("Country:");
        l5.setFont(new Font("Raleway", Font.BOLD, 28));
        l5.setBounds(125,300,375,30);
        f.add(l5);
        
        aid3 = new JLabel(country);
        aid3.setBounds(250,300,300,30);
        aid3.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid3);
        
        l6 = new JLabel("Email ID:");
        l6.setFont(new Font("Raleway", Font.BOLD, 28));
        l6.setBounds(125,350,375,30);
        f.add(l6);
        
        aid4 = new JLabel(email_id);
        aid4.setBounds(250,350,300,30);
        aid4.setFont(new Font("serif",Font.BOLD,20));
        f.add(aid4);
    }
    public static void main(String[] args){
        new User_Account("Print Data");
    }
}