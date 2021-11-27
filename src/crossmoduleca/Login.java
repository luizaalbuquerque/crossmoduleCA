package crossmoduleca;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Luiza Cavalcanti
 */
public class Login {

    public static String pswdinput;
    public static String username;

    public static void loginCheck(String username, String pswd) throws SQLException {

        pswdinput = pswd;
//        username =usern;

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

            if (rscheck.next()) { // checking username

                while (rs.next()) {

                    pswd = rs.getString("pswd");

                    if (!pswd.equals(pswdinput)) { // checking password
                        System.out.println("wrong password, try again");

                    } else {
                        pswd = rs.getString("pswd"); // show the id of the name loged 

                        System.out.println("\nID " + "\t" + "FULL NAME" + "\t\t\t" + "USERNAME" + "\t" + "ACTIVE" + "\t" + "TYPE");
                        System.out.println("============================================================================");
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
//error output for user 
                System.out.println("User not founded. Try again! Or type 0 to finish");

                System.out.println("would you like to create a new account? ");

                Scanner scannerUser = new Scanner(System.in);

                System.out.print("Username: "); //check username

                String user = scannerUser.next().toLowerCase();

                System.out.print("Password: "); //check username

                String pwd = scannerUser.next().toLowerCase();

                System.out.print("Gender: "); //check username

                String gender = scannerUser.next().toLowerCase();
                System.out.print("Usertype: "); //check username

                String usertype = scannerUser.next().toLowerCase();

                System.out.print("Fullname: "); //check username

                String fullname = scannerUser.next().toLowerCase();

                SingUp signup = new SingUp();
                signup.NewAccountWith(fullname, user, pwd, usertype, gender);

                //scannerUsername.next().toLowerCase();
                // CrossmoduleCA.login();
            }
        } catch (SQLException e) {
            System.out.print("Not supported yet.");
        }

    }

//    static void login(String username, String pswd) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
