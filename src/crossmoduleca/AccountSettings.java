/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossmoduleca;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * @author Luiza Cavalcanti
 */
public class AccountSettings {

    public static void FirstAccess(String username, String pswd) {

//        variables
        Connection conn;
        PreparedStatement pstm = null;

        String query = "SELECT * FROM users WHERE username = '" + username + "'";

    }

}
