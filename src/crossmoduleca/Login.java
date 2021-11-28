package crossmoduleca;

import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author Luiza Cavalcanti
 */
public class Login {

//    variables
    public static String pswdinput;
    public static String username;

    public static void loginCheck(String username, String pswd) throws SQLException {

        pswdinput = pswd;
        Connection conn;
//        PreparedStatement pstm = null;

//        checking username and password
        String query = "SELECT * FROM USERS WHERE username = '" + username + "' AND pswd = '" + pswd + "'";

//        variables 
        conn = new MySQLConection().dbconn();
        ResultSet rs = null;
        ResultSet allUsers = null;
        Statement stmt = null;

        try {

            // create a connection
            stmt = conn.createStatement();

            //execute the query 
            rs = stmt.executeQuery(query);

//            checking boolean ResultSet, if it is true, do the folling: 
            if (rs.next()) {

//                assigning variables full name and id 
                String fullname = rs.getString("fullname");
                String myID = rs.getString("id");

//                testing
                System.out.println("Welcome " + fullname);
                System.out.println("\n");

//                checking if the user type is admin 
                String userType = rs.getString("usertype");
                if (userType.equals("admin")) {

//                   select all table 
                    allUsers = stmt.executeQuery("SELECT * FROM USERS");

//          show all table in the DataBase, using the while loop to print all rows
                    System.out.println("\nID " + "|" + "\t" + "|" + "FULL NAME" + "|" + "\t\t" + "|" + "USERNAME" + "|" + "\t\t" + "|" + "GENDER" + "|" + " \t\t" + "|" + "PASSWORD" + "|" + "\t" + "|" + "ACTIVE" + "|" + "\t" + "|" + "TYPE");

                    while (allUsers.next()) {
                        String id = allUsers.getString("id");
                        String userFullName = allUsers.getString("fullname");
                        String showusername = allUsers.getString("username");
                        String pwd = allUsers.getString("pswd");
                        String usertype = allUsers.getString("usertype");
                        String gender = allUsers.getString("gender");
                        String active = allUsers.getString("active");
                        System.out.println("----------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(id + "|" + "\t" + "|" + userFullName + "|" + "\t\t" + "|" + showusername + "|" + "\t\t" + "|" + gender + "|" + " \t\t\t" + "|" + pwd + "|" + "\t" + "|" + active + "|" + "\t\t" + "|" + usertype + "\n");

                    }

//                   still in case the user is admin, output two options, edit your own profile or delete an user
                    System.out.println("Choose one option: " + "\n" + "1 - Edit your profile" + " \n" + "2 - Delete an user");
//                    using scanner to store the user choice 
                    Scanner access = new Scanner(System.in);
                    String option = access.next();
//                    checking the choice
                    if (option.equals("1")) {
                        System.out.println("Do you want to edit your profile?");
//checking the user choice 
                        if (access.next().equals("yes")) {
//option to change the profile 
                            Scanner scannerUser = new Scanner(System.in); //use scanner to save the user input

                            System.out.print("Username: "); //check username

                            String user = scannerUser.next().toLowerCase(); //store username

                            System.out.print("Password: "); //check password

                            String pwd = scannerUser.next().toLowerCase(); //store password

                            System.out.print("Gender: "); //check gender

                            String gender = scannerUser.next().toLowerCase(); //store gender
                            System.out.print("Usertype: "); //check usertype

                            String usertype = scannerUser.next().toLowerCase();//store user type

                            System.out.print("Fullname: "); //check fullname

                            String userfullname = scannerUser.next().toLowerCase(); //store full name 
// query to update the profile on the DataBase
                            String q = "UPDATE USERS SET fullname = '" + userfullname + "', pswd = '" + pwd + "', gender = '" + gender + "', username = '" + user + "', usertype = '" + usertype + "' where id = " + myID;
                            stmt.executeUpdate(q);

                        }
//in case the use choose to delete a user
                    } else if (option.equals("2")) {
                        System.out.println("You chose to delete a user");
                        System.out.println("Now, choose an user by his ID:");

//              query to delete user onn te DataBase by the id                
                        String q = "DELETE FROM USERS where id = " + access.next();
                        stmt.executeUpdate(q);

                    }

                    allUsers.close();

                }

//                if the user don't exist, it will create a new user
            } else {

//                    System.out.println("User not founded. Try again! Or type 0 to finish");
                System.out.println("The user don't exits, to create a new account, fill in the following: ");

                Scanner scannerUser = new Scanner(System.in); //using scanner to store the user input 

                System.out.print("Username: "); //check username

                String user = scannerUser.next().toLowerCase(); // store username

                System.out.print("Password: "); //check password

                String pwd = scannerUser.next().toLowerCase(); //store password

                System.out.print("Gender: "); //check gender

                String gender = scannerUser.next().toLowerCase(); //store gender
                System.out.print("Usertype: "); //check usertype

                String usertype = scannerUser.next().toLowerCase(); //store user type

                System.out.print("Fullname: "); //check fullname

                String fullname = scannerUser.next().toLowerCase(); //store full name

//                    creting the signup 
                SingUp signup = new SingUp();
                signup.NewAccountWith(fullname, user, pwd, usertype, gender);

            }
//creating the erro message for the try-catch
        } catch (SQLException e) {
            System.out.println("Error");
//            test purpose
//            e.printStackTrace();
        }
//        closing the statement 
        stmt.close();

//            closig the result set and the connection 
        rs.close();
        conn.close();
    }
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
//        
