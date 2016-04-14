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
          Connection con= DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:libertadpre","ge","ge");
          return con;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    
        return null;
    }
     
        
      
}
