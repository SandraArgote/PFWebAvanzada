/**
 * @author Sandra Paulina Argote Romo
 */

package modelo;

import java.sql.Connection;
import java.sql.DriverManager;

public class JavaDB {
    
    public static Connection getConnection(){  
        Connection con = null; 
        String url = "jdbc:mysql://localhost:3306/proyectopwa?zeroDateTimeBehavior=convertToNull";
        String user = "root";
        String pass = "";
                
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            con = DriverManager.getConnection(url, user, pass);  
        }catch(Exception e){
            System.out.println(e);
        }  
        return con;  
    } 
}