package crossmoduleca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Luiza Cavalcanti 
 */
public class Login {

    public static String pswdinput;

    public static void loginCheck(String username, String pswd) throws SQLException {

        pswdinput = pswd;

        Connection conn;
        PreparedStatement pstm = null;

        String query = "SELECT * FROM users WHERE username = '" + username + "'";

        conn = new MySQLConection().dbconn();
        ResultSet rs = null;
        ResultSet rscheck = null;

        try {
            pstm = conn.prepareStatement(query);
            rscheck = pstm.executeQuery(query);
            pstm = conn.prepareStatement(query);
            rs = pstm.executeQuery(query);

            if (rscheck.next() == true) { // checking username
         

                while (rs.next()) {
                    
                    pswd = rs.getString("pswd");
                    
                    if (!pswd.equals(pswdinput)) { // checking password
                        System.out.println("wrog password try again");
                        CrossmoduleCA.login();

                    } else {
                        pswd = rs.getString("pswd");
                        
                        System.out.println("\nID " + "\t" + "NAME" + "\t\t\t" + "USERNAME" + "\t" + "ACTIVE" + "\t" + "TYPE");
                        System.out.println("================================================================");
                        System.out.println(rs.getString("id") + "\t" + rs.getString("fullname")
                                + "\t\t" + rs.getString("username") + "\t\t" + rs.getString("active") + "\t" + rs.getString("usertype") + "\n");
                    
                        // Close the result set, statement and the connection
                        rs.close();
                        rscheck.close();
                        pstm.close();
                        conn.close();
                    }
                }

 

            } else {

                System.out.println("User not founded. Try again! Or type 0 to finish");
                CrossmoduleCA.login();
            }

        } catch (SQLException e) {

        }

    }

    static void login(String username, String pswd) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
