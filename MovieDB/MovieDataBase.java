package MovieDB;

import java.awt.*;

import java.awt.event.*;

import java.sql.*;

import java.util.Vector;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

 

public class MovieDataBase extends JFrame implements ActionListener {

 

    JFrame frame1;
    
    JLabel l0, l1, l2, l3;
    
    JTextField tf1;

    JComboBox c1,c2;

    JButton b1,b2;

    Connection con;

    ResultSet rs;

    Statement st;

    PreparedStatement pst1;

    String ids;

    static JTable table;

    String[] columnNames = {"Movie ID","Movie Title","Year", "Language", "Country","Duration"};

    String from, year;

 

    MovieDataBase() {

 

        l0 = new JLabel("Fatching Movie Information");

        l0.setForeground(Color.red);

        l0.setFont(new Font("Serif", Font.BOLD, 20));

        l1 = new JLabel("Select Movie Title");
        
        l2 = new JLabel("Select Year");

        b1 = new JButton("submit");

        b2 = new JButton("submit");
        
        l0.setBounds(100, 50, 350, 40);

        l1.setBounds(45, 110, 100, 20);

        l2.setBounds(75, 200, 100, 30);
        
        b1.setBounds(150, 150, 150, 20);
        
        b2.setBounds(150, 250, 150, 20);

        b1.addActionListener(this);

        b2.addActionListener(this); 

        tf1 = new JTextField(15);
        tf1.setBounds(150,200,100,30);
        tf1.setFont(new Font("Arial", Font.BOLD, 14));
        add(tf1);

        setTitle("Fetching Movie Info From DataBase");

        setLayout(null);

        setVisible(true);

        setSize(500, 500);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        getContentPane().setBackground(Color.CYAN);

        add(l0);

        add(l1);
        
        add(l2);

        add(b1);
        
        add(b2);

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kunalpodder1");
            st = con.createStatement();
            rs = st.executeQuery("select mov_title from Movie");
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

            showTableData();

        }
        if (ae.getSource() == b2) {

            years(tf1.getText());

        }
    }

     

    public void showTableData() {

 

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

        String mov_title = "";
        String mov_id = "";
        String mov_lang = "";
        String mov_year = "";
        String mov_country = "";
        String mov_duration = "";

 

        try {

            pst1 = con.prepareStatement("select * from Movie where mov_title='" + from + "'");

            ResultSet rs = pst1.executeQuery();

            int i = 0;

            if (rs.next()) {

                mov_title = rs.getString("mov_title");

                mov_lang = rs.getString("mov_lang");

                mov_id = rs.getString("mov_id");

                mov_year = rs.getString("mov_year");
                
                mov_country = rs.getString("mov_country");
                
                mov_duration = rs.getString("mov_duration");


                model.addRow(new Object[]{mov_id, mov_title, mov_year,mov_lang,mov_country,mov_duration});

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
      public void years(String year) {
        try{
            conn c1 = new conn();
            String q="Select * from Movie where mov_year  = '"+year+"'";
            ResultSet rs = c1.s.executeQuery(q);
            if(rs.next()){ 
                do{
                System.out.println(rs.getString(1)+"||"+rs.getString(2));
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
    public static void main(String args[]) {

        new MovieDataBase();

    }

}