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
    public int age;
    public int phone;
    
    public void NewAccountWith(String fullname, String username, String pswd, String usertype, String gender, int phone, int age) throws SQLException {

        this.FullName = fullname;
        this.UserName = username;
        this.Gender = gender;
        this.pswd = pswd;
        this.usertype = usertype;
        this.phone = phone;
        this.age = age;
//        variables

        Connection conn;
        PreparedStatement pstm = null;

        String query = "INSERT INTO USERS (id, fullname, username, pswd, usertype, gender, active, age, phone) VALUES (NULL,'" + this.FullName + "','" + this.UserName + "','" + this.pswd + "','" + this.usertype + "','" + this.Gender + "','" + 1 + this.phone + "','" + this.age + "' )";

        conn = new MySQLConection().dbconn();

        try {
            // create a connection
            Statement stmt = conn.createStatement();
            //execute the query 
            stmt.executeUpdate(query);
            //insert the data 
              //stmt.executeUpdate(query);
        } catch (SQLException e) {
            System.out.println("error");
        }

        conn.close();

// create a Statement from the connection
      //  Statement statement = conn.createStatement();

// insert the data
     //   statement.executeUpdate("INSERT INTO Customers " + "VALUES (1001, 'Simpson', 'Mr.', 'Springfield', 2001)");

//rs.close();
//stmt.close();
//
        System.out.println("Sign up:" + query);

    }

}
