/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossmoduleca;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Luiza Cavalcanti
 * 
 */
public class SingUp {
    
    public static void NewAccount () {
        
        String FullName;
        String UserName;
        String Gender;
        String pswd;
        
       
        Connection conn;
        PreparedStatement pstm = null;

        String query = "INSERT INTO `users` VALUES ('FullName','UserName','pswd','user','gender',1)";

        conn = new MySQLConection().dbconn();
}
    
}
