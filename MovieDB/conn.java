package MovieDB;

import java.sql.*;  

public class conn{
    Connection c;
    Statement s;
    public conn(){  
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","kunalpodder1");   
            s =c.createStatement();  
            
           
        }catch(Exception e){ 
            System.out.println(e);
        }  
    }  
}  
