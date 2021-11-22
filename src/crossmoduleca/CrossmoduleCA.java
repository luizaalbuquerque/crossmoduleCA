package crossmoduleca;

import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author Luiza Cavalcanti
 */
public class CrossmoduleCA {

    private static String username;
    private static String pswd;

    /**
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * @param aUsername the username to set
     */
    public static void setUsername(String aUsername) {
        username = aUsername;
    }

    /**
     * @return the pswd
     */
    public static String getPswd() {
        return pswd;
    }

    /**
     * @param aPswd the pswd to set
     */
    public static void setPswd(String aPswd) {
        pswd = aPswd;
    }

    public static void main(String[] args) throws SQLException {

        System.out.println("##################################################");
        System.out.println("############     LOGIN SYSTEM   ##################");
        System.out.println("##################################################\n");
        System.out.println("PLEASE ENTER YOUR USERNAME AND PSWD OR type 0 to exit!\n");

        start();

    }

    public static void start() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Username: ");
        setUsername(scanner.next().toLowerCase());

        if ("0".equals(username)) {
            System.exit(0);
        }

        System.out.print("Password: ");
        setPswd(scanner.next());

        Login.login(username, pswd);

    }

    static void login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
