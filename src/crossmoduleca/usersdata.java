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
    static int age;

    /**
     * @return the username
     */
    public static String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public static void setUsername(String username) {
        usersdata.username = username;
    }

    /**
     * @return the fullname
     */
    public static String getFullname() {
        return fullname;
    }

    /**
     * @param fullname the fullname to set
     */
    public static void setFullname(String fullname) {
         usersdata.fullname = fullname;
    }

    /**
     * @return the usertype
     */
    public static String getUsertype() {
        return usersdata.usertype;
    }

    /**
     * @param usertype the usertype to set
     */
    public static void setUsertype(String usertype) {
         usersdata.usertype = usertype;
    }

    /**
     * @return the pswd
     */
    public static String  getPswd() {
        return usersdata.pswd;
    }

    /**
     * @param pswd the pswd to set
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
     * @param gender the gender to set
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
     * @param active the active to set
     */
    public static void setActive(boolean active) {
        usersdata.active = active;
    }

    /**
     * @return the phone
     */
    public static int  getphone() {
        return usersdata.phone;
    }

    /**
     * @param pswd the phone to set
     */
    public static void setPhone(int phone) {
        usersdata.phone = phone;
    }
    
    
    /**
     * @return the age
     */
    public static int getAge() {
        return usersdata.age;
    }

    /**
     * @param pswd the age to set
     */
    public static void setAge(int age) {
        usersdata.age = age;
    }

}
