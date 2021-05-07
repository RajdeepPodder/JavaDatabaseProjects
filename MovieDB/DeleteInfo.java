package MovieDB;




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.*;

public class DeleteInfo extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField tf1;
    JButton b1,b2,b3;
    DeleteInfo(){
        setTitle("Create An Account");
        
        l1 = new JLabel("Enter the ID to Delete the ROW");
        l1.setFont(new Font("Osward", Font.BOLD, 30));
        l1.setBounds(70,40,500,40);
        add(l1);
        
        l2 = new JLabel("MOVIE ID:");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        l2.setBounds(200,120,230,30);
        add(l2);
        
        tf1 = new JTextField(15);
        tf1.setBounds(200,160,230,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);
        
        
        b1 = new JButton("Delete");
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
        b1.setBounds(180,300,80,30);
        add(b1);
        
        b2.setFont(new Font("Arial", Font.BOLD, 12));
        b2.setBounds(280,300,80,30);
        add(b2);
        
        b3.setFont(new Font("Arial", Font.BOLD, 12));
        b3.setBounds(380,300,80,30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.CYAN);
        
        setSize(600,450);
        setLocation(500,120);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try{        
            if(ae.getSource()==b1){
                conn c1 = new conn();
                String mov_id  = tf1.getText();
                String q1 = "delete from Movie where mov_id = '"+mov_id+"'";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "The data has been successfully deleted");
            }
            if(ae.getSource()==b2){
                tf1.setText("");
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
        new DeleteInfo().setVisible(true);
    }
    
}

 
