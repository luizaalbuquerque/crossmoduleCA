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
    
     public String FullName;
     public String UserName;
     public String Gender;
     public String pswd;

    public void NewAccountWith(String fullname, String username, String pswd, String gender) {
        
        this.FullName = fullname;
        this.UserName = username;
        this.Gender = pswd;
        this.pswd = gender;
                
//        variables
       
        Connection conn;
        PreparedStatement pstm = null;

        String query = "INSERT INTO 'users' VALUES ('" +  this.FullName + "','" +  this.UserName + "','" +  this.pswd + "',' admin, " + this.Gender + "',1)";

        conn = new MySQLConection().dbconn();
        
        System.out.println("Sign up:" + query );
        
    }
    

}
