/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parquelibertad;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Oracle
 */
public class dbConnection {
    public static Connection conectDB(){
        try{
        
          Class.forName("oracle.jdbc.OracleDriver");
          Connection con= DriverManager.getConnection("jdbc:oracle:thin:@10.0.2.15:1521:PLibertad","ge","libertad2016");
          return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    
        return null;
    }
     
        
      
}
