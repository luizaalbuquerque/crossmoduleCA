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
 * GITHUB REPOSITORY: https://github.com/luizaalbuquerque/crossmoduleCA.git
 */
public class SingUp {
//    variables

    public String fullName;
    public String userName;
    public String gender;
    public String pswd;
    public String usertype;
    public String active;
    public String phone;

    public void NewAccountWith(String fullname, String username, String pswd, String usertype, String gender, String useractive, String phone) throws SQLException {
// setting variables 
        this.fullName = fullname;
        this.userName = username;
        this.gender = gender;
        this.pswd = pswd;
        this.usertype = usertype;
        this.phone = phone;
        this.active = useractive;

//        connecting with DB
        Connection conn;

//        storing query in a variable
        String query = "INSERT INTO USERS (id, fullname, username, pswd, usertype, gender, active, phone) "
                + "VALUES (NULL,'" + this.fullName + "','" + this.userName + "','" + this.pswd + "','" + this.usertype + "','" + this.gender + "','" + this.active + "','" + this.phone + "')";

//        DB connetion
        conn = new MySQLConection().dbconn();

        try {
            // create a connection
            Statement stmt = conn.createStatement();
            //execute the query and insert the data 
            stmt.executeUpdate(query);

        } catch (SQLException e) {
            System.out.println("error ");
//            e.printStackTrace();
        }
        conn.close();

    }

}
