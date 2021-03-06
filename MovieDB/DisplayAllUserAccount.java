package MovieDB;



import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class DisplayAllUserAccount extends JFrame implements ActionListener {

 

    JFrame frame1;

    JLabel l0, l1, l2;

    JComboBox c1;

    JButton b1;

    Connection con;

    ResultSet rs, rs1;

    Statement st, st1;

    PreparedStatement pst;

    String ids;

    static JTable table;

    String[] columnNames = {"User ID","Password","Name","Country","Email ID"};

    String from;

 

    DisplayAllUserAccount() {

 

        l0 = new JLabel("Fatching user Information");

        l0.setForeground(Color.red);

        l0.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("Select Name");

        b1 = new JButton("submit");

 

        l0.setBounds(100, 50, 350, 40);

        l1.setBounds(45, 110, 100, 20);

        b1.setBounds(150, 150, 150, 20);

        b1.addActionListener(this);

 

        setTitle("Fetching User Info From DataBase");

        setLayout(null);

        setVisible(true);

        setSize(500, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.CYAN);

        add(l0);

        add(l1);;

        add(b1);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kunalpodder1");
            st = con.createStatement();

            rs = st.executeQuery("select user_id from login");

            Vector v = new Vector();

            while (rs.next()) {

                ids = rs.getString(1);

                v.add(ids);

            }

            c1 = new JComboBox(v);

            c1.setBounds(150, 110, 150, 20);

 

            add(c1);

            st.close();

            rs.close();

        } catch (Exception e) {

        }

    }

 

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {

            showTableData1();

        }

 

    }

 

    public void showTableData1() {

 

        frame1 = new JFrame("Database Search Result");

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new BorderLayout());

        //TableModel tm = new TableModel();

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columnNames);

        //DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

        table = new JTable(model);

        table = new JTable();

        table.setModel(model);

        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);

        table.setFillsViewportHeight(true);

        JScrollPane scroll = new JScrollPane(table);

        scroll.setHorizontalScrollBarPolicy(

                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        scroll.setVerticalScrollBarPolicy(

                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        from = (String) c1.getSelectedItem();

        //String textvalue = textbox.getText();

        String user_id = "";
        String password = "";
        String fname = "";
        String country = "";
        String email_id = "";

 

        try {

            pst = con.prepareStatement("select * from login where user_id ='" + from + "'");

            ResultSet rs = pst.executeQuery();

            int i= 0;
            if (rs.next()) {

                user_id = rs.getString("user_id");

                password = rs.getString("password");

                fname = rs.getString("fname");

                country = rs.getString("country");
                
                email_id = rs.getString("email_id");
                


                model.addRow(new Object[]{user_id, password, fname, country,email_id});

                i++;

            }

            if (i < 1) {

                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

            }

            if (i == 1) {

                System.out.println(i + " Record Found");

            } else {

                System.out.println(i + " Records Found");

            }

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }

        frame1.add(scroll);

        frame1.setVisible(true);

        frame1.setSize(400, 300);

    }

 

    public static void main(String args[]) {

        new DisplayAllUserAccount();

    }

}






/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayAllUserAccount {
    public DisplayAllUserAccount() {
        try{
            conn c1 = new conn();
            String q="Select * from login";
            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next()){ 
                do{
                System.out.println(rs.getString(1)+"||"+rs.getString(2)+"||"+rs.getString(3)+"||"+rs.getString(4)+"||"+rs.getString(5));
                System.out.println();
                
                
                }while(rs.next());
            }
            else{
                System.out.println("Record Not Found...");
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}*/