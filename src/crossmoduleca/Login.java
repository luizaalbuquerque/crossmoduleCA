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
    public static String userAdmin;

    public static void loginCheck(String username, String pswd) throws SQLException {

        pswdinput = pswd;
        Connection conn;

//        checking username and password
        String query = "SELECT * FROM USERS WHERE username = '" + username + "' AND pswd = '" + pswd + "'";

//connecting DB
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
            if (!rs.next()) {
                
                
                

                        System.out.println("The user don't exits, to create a new account, fill in the following: ");

                        Scanner scannerUser = new Scanner(System.in); //using scanner to store the user input 

                        System.out.print("Username: "); //check username

                        String user = scannerUser.nextLine().toLowerCase(); // store username

                        System.out.print("Password: "); //check password

                        String pwd = scannerUser.nextLine().toLowerCase(); //store password

                        System.out.print("(use a single letter) Gender: "); //check gender

                        String gender = scannerUser.nextLine().toLowerCase(); //store gender

                        System.out.print("(admin or regular) Usertype:"); //check usertype

                        String usertype = scannerUser.nextLine().toLowerCase(); //store user type

                        System.out.print("Fullname: "); //check fullname

                        String userfullname = scannerUser.nextLine().toLowerCase(); //store full name

                        System.out.print("use 1 for active and 0 for unactive: "); //check activity

                        String useractive = scannerUser.nextLine().toLowerCase(); //store activity

                        System.out.print("Phone: "); //check phone

                        String phone = scannerUser.nextLine().toLowerCase(); //store phone

//                    creting the signup 
                        SingUp signup = new SingUp();
                        signup.NewAccountWith(userfullname, user, pwd, usertype, gender, useractive, phone);

                    }
            else{
                

//                assigning variables fullname and id 
                String fullname = rs.getString("fullname");
                String myID = rs.getString("id");

//                if the user exists and is a regular user will output "welcome + user name
                System.out.println("Welcome, " + fullname);
                System.out.println("\n");

//                checking if the user type is admin 
                String userType = rs.getString("usertype");
                Login.userAdmin = userType;
                if (Login.userAdmin.equals("admin")) {

//                   select all table 
                    allUsers = stmt.executeQuery("SELECT * FROM USERS");

//          show all table in the DataBase, using the while loop to print all rows
                    System.out.println("\nID " + "|" + "\t" + "|" + "FULL NAME" + "|" + "\t\t" + "|" + "USERNAME" + "|" + "\t\t" + "|" + "GENDER" + "|" + " \t\t" + "|" + "PASSWORD" + "|" + "\t" + "|" + "ACTIVE" + "|" + "\t" + "|" + "TYPE" + "|" + "\t\t" + "|" +"PHONE" + "|" );

                    while (allUsers.next()) {
                        String id = allUsers.getString("id");
                        String userFullName = allUsers.getString("fullname");
                        String showusername = allUsers.getString("username");
                        String pwd = allUsers.getString("pswd");
                        String usertype = allUsers.getString("usertype");
                        String gender = allUsers.getString("gender");
                        String useractive = allUsers.getString("active");
                        String phone = allUsers.getString("phone");
                        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------");
                        System.out.println(id + "|" + "\t" + "|" + userFullName + "|" + "\t\t" + "|" + showusername + "|" + "\t\t" + "|" + gender + "|" + " \t\t\t" + "|" + pwd + "|" + "\t" + "|" + useractive + "|" + "\t\t" + "|" + usertype +  "|" +"\t" + "|" + phone + "|"+"\n\n" );

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

                            String user = scannerUser.nextLine().toLowerCase(); //store username

                            System.out.print("Password: "); //check password

                            String pwd = scannerUser.nextLine().toLowerCase(); //store password

                            System.out.print("(use a single letter) Gender: "); //check gender

                            String gender = scannerUser.nextLine().toLowerCase(); //store gender
                            System.out.print("(admin or regular) Usertype: "); //check usertype

                            String usertype = scannerUser.nextLine().toLowerCase();//store user type

                            System.out.print("Fullname: "); //check fullname

                            String userfullname = scannerUser.nextLine().toLowerCase(); //store full name 

                            System.out.print("active: use 1 for active and 0 for unactive: "); //check activity

                            String useractive = scannerUser.nextLine().toLowerCase(); //store activity

                            System.out.print("Phone: "); //check phone

                            String phone = scannerUser.nextLine().toLowerCase(); //store phone

// query to update the profile on the DataBase
                            String q = "UPDATE USERS SET fullname = '" + userfullname + "', pswd = '" + pwd + "', gender = '" + gender + "', username = '" + user + "', usertype = '" + usertype + "', active = '" + useractive + "', phone = '" + phone + "' where id = " + myID;
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
            }
        } catch (SQLException e) {
            System.out.println("Error");
//            test purpose
            e.printStackTrace();
        }
//        closing the statement 
        stmt.close();

//            closig the result set and the connection 
        rs.close();
        conn.close();
    }
}
