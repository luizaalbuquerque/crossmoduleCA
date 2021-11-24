/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossmoduleca;

import java.sql.*;

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
     public String usertype;

    public void NewAccountWith(String fullname, String username, String pswd, String usertype, String gender) throws SQLException {
        
        this.FullName = fullname;
        this.UserName = username;
        this.Gender = gender;
        this.pswd = pswd;
        this.usertype = usertype;
//        variables
       
        Connection conn;
        PreparedStatement pstm = null;

        String query = "INSERT INTO USERS (id, fullname, username, pswd, usertype, gender, active) VALUES (NULL,'" +  this.FullName + "','" +  this.UserName + "','" +  this.pswd + "','" + this.usertype + "','" + this.Gender + "',1)";

        conn = new MySQLConection().dbconn();
        
        
       try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
       }catch(Exception e){
           System.out.println("error");
       }
       
       conn.close();
       

//rs.close();
//stmt.close();
//
        
        
        
        
        System.out.println("Sign up:" + query );
        
    }
    

}
