package crossmoduleca;

/**
 *
 * @author Luiza Cavalcanti
 */
public class usersdata {

    static String username;
    static String fullname;
    static String usertype;
    static String pswd;
    static String gender;
    static boolean active;
    static int phone;

    /**
     * @return username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * @param username to set
     */
    public static void setUsername(String username) {
        usersdata.username = username;
    }

    /**
     * @return fullname
     */
    public static String getFullname() {
        return fullname;
    }

    /**
     * @param fullname to set
     */
    public static void setFullname(String fullname) {
        usersdata.fullname = fullname;
    }

    /**
     * @return usertype
     */
    public static String getUsertype() {
        return usersdata.usertype;
    }

    /**
     * @param usertype to set
     */
    public static void setUsertype(String usertype) {
        usersdata.usertype = usertype;
    }

    /**
     * @return password
     */
    public static String getPswd() {
        return usersdata.pswd;
    }

    /**
     * @param pswd to set
     */
    public static void setPswd(String pswd) {
        usersdata.pswd = pswd;
    }

    /**
     * @return the gender
     */
    public static String getGender() {
        return usersdata.gender;
    }

    /**
     * @param gender to set
     */
    public static void setGender(String gender) {
        usersdata.gender = gender;
    }

    /**
     * @return the active
     */
    public static boolean isActive() {
        return usersdata.active;
    }

    /**
     * @param active to set
     */
    public static void setActive(boolean active) {
        usersdata.active = active;
    }

    /**
     * @return the phone
     */
    public static int getphone() {
        return usersdata.phone;
    }

    /**
     * @param set phone
     */
    public static void setPhone(int phone) {
        usersdata.phone = phone;
    }

}
