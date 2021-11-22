package crossmoduleca;

import java.sql.SQLException;
import java.util.Scanner;
import crossmoduleca.usersdata;

/**
 *
 * @author Luiza Cavalcanti
 */
public class CrossmoduleCA {


    public static void main(String[] args) throws SQLException {
//
        System.out.println("##################################################");
        System.out.println("############     LOGIN SYSTEM   ##################");
        System.out.println("##################################################\n");
        System.out.println("PLEASE ENTER YOUR USERNAME AND PSWD OR type 0 to exit!\n");

        start();

    }


            
    public static void start() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        usersdata.setUsername(scanner.next().toLowerCase());
    

        System.out.print("Password: ");
       usersdata.setPswd(scanner.next());

       // Login.login(usersdata.getUsername(),usersdata.getPswd());
        
        Login.loginCheck(usersdata.getUsername(),usersdata.getPswd());

    }

    static void login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
