package crossmoduleca;

import java.sql.*;
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

        //String query = "SELECT * FROM users WHERE username = '" + username + "'";
        String query = "SELECT * FROM USERS WHERE username = '" + username + "' AND pswd = '" + pswd + "'";
        // String adminQuery = "SELECT * FROM USERS WHERE USERTYPE = ADMIN;

        conn = new MySQLConection().dbconn();
        ResultSet rs = null;
        ResultSet allUsers = null;
        Statement stmt = null;

        try {
            // create a connection
            stmt = conn.createStatement();
            //execute the query 
            rs = stmt.executeQuery(query);
//

            if (rs.next()) {

                String fullname = rs.getString("fullname");
                String myID =  rs.getString("id");
                
                System.out.println("Welcome " + fullname);
                System.out.println("\n");

                String userType = rs.getString("usertype");
                if (userType.equals("admin")) {

                    allUsers = stmt.executeQuery("SELECT * FROM USERS");

                    while (allUsers.next()) {
                        String id = allUsers.getString("id");
                        String userFullName = allUsers.getString("fullname");
                        System.out.println(id + " - " + userFullName);

                    }
                    System.out.println("Choose one option: 1 - Edit your profile or 2 for delete user");
                    Scanner scanner = new Scanner(System.in);
                    String option = scanner.next();
                    if (option.equals("1")) {
                        System.out.println("I want edit my profile");
                       
                        if (scanner.next().equals("yes")) {
                            //codigo
                             Scanner scannerUser = new Scanner(System.in);

                System.out.print("Username: "); //check username

                String user = scannerUser.next().toLowerCase();

                System.out.print("Password: "); //check password

                String pwd = scannerUser.next().toLowerCase();

                System.out.print("Gender: "); //check gender

                String gender = scannerUser.next().toLowerCase();
                System.out.print("Usertype: "); //check usertype

                String usertype = scannerUser.next().toLowerCase();

                System.out.print("Fullname: "); //check fullname

                String userfullname = scannerUser.next().toLowerCase();
                
                 String q = "UPDATE USERS SET fullname = '" + userfullname + "', pswd = '" + pwd + "', gender = '" + gender + "', username = '" + user + "', usertype = '" + usertype + "' where id = " + myID;
                 stmt.executeUpdate(q);
                            
                            
                            
                        }else{
                           //
                        }
                        
                        
                        
                        
                        
                        
                    } else if (option.equals("2")) {
                        System.out.println("I wanna delete user");
                        System.out.println("Choose an user by ID:");
                        
                        String q = "DELETE FROM USERS where id = " + scanner.next();
                        stmt.executeUpdate(q);
                       
                    }

                    allUsers.close();

                }

            } else {

                System.out.println("User not founded. Try again! Or type 0 to finish");

                System.out.println("would you like to create a new account? ");

                Scanner scannerUser = new Scanner(System.in);

                System.out.print("Username: "); //check username

                String user = scannerUser.next().toLowerCase();

                System.out.print("Password: "); //check password

                String pwd = scannerUser.next().toLowerCase();

                System.out.print("Gender: "); //check gender

                String gender = scannerUser.next().toLowerCase();
                System.out.print("Usertype: "); //check usertype

                String usertype = scannerUser.next().toLowerCase();

                System.out.print("Fullname: "); //check fullname

                String fullname = scannerUser.next().toLowerCase();

                SingUp signup = new SingUp();
                signup.NewAccountWith(fullname, user, pwd, usertype, gender);

//         
            }

        } catch (SQLException e) {
            System.out.println("error");
            e.printStackTrace();
        }
        stmt.close();

        rs.close();
        conn.close();
    }

//
//                    pswd = rs.getString("pswd");
//
//                    if (!pswd.equals(pswdinput)) { // checking password
//                        System.out.println("wrong password, try again");
//
//                    } else {
//                        pswd = rs.getString("pswd"); // show the id of the name loged 
//
//                        System.out.println("\nID " + "\t" + "FULL NAME" + "\t\t\t" + "USERNAME" + "\t" + "ACTIVE" + "\t" + "TYPE");
//                        System.out.println("============================================================================");
//                        System.out.println(rs.getString("id") + "\t" + rs.getString("fullname")
//                                + "\t\t" + rs.getString("username") + "\t\t" + rs.getString("active") + "\t" + rs.getString("usertype") + "\n");
//
//                        // Close the result set, statement and the connection
//                        rs.close();
//        } catch (SQLException e) {
//            System.out.print("Not supported yet.");
//        }
//    }
//    static void login(String username, String pswd) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
