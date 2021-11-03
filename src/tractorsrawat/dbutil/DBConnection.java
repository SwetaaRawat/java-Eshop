/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tractorsrawat.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Shweta
 */
public class DBConnection {
    public static Connection conn;
    static 
    {
        try{
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","rawattractors","rawattractors");
            JOptionPane.showMessageDialog(null,"Connection open sucessfully!","Success",JOptionPane.INFORMATION_MESSAGE);    
        }
        catch(ClassNotFoundException ex){
           JOptionPane.showMessageDialog(null,"Error in loading the driver","Driver Error!",JOptionPane.ERROR_MESSAGE); 
           ex.printStackTrace();
           System.exit(1);
        } 
         catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error in opening connection","DB  Error!",JOptionPane.ERROR_MESSAGE); 
           ex.printStackTrace();
           System.exit(1);
        } 
    }
    public static Connection getConnection(){
       return conn; 
    }
    
    public static void closeConnection(){
        try{
            conn.close();
             JOptionPane.showMessageDialog(null,"Connection closed sucessfully!","Success",JOptionPane.INFORMATION_MESSAGE);    
        }
         catch(SQLException ex){
           JOptionPane.showMessageDialog(null,"Error in closing connection","DB  Error!",JOptionPane.ERROR_MESSAGE); 
           ex.printStackTrace();
           
        } 
        
    }
    
}
