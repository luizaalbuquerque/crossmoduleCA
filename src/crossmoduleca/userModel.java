package crossmoduleca;

/**
 *
 * @author Luiza Cavalcanti
 */
public class userModel {

   int id;
    String username;
    String fullname;
    String usertype;
    String pswd;
    String gender;
    boolean active;
    String phone;
//    static String variables;
//    static String result;

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return fullname
     */
    public String getFullname() {
        return fullname;
    }

    /**
     * @param fullname to set
     */
    public  void setFullname(String fullname) {
        this.fullname = fullname;
    }

    /**
     * @return usertype
     */
    public  String getUsertype() {
        return this.usertype;
    }

    /**
     * @param usertype to set
     */
    public  void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    /**
     * @return password
     */
    public String getPswd() {
        return this.pswd;
    }

    /**
     * @param pswd to set
     */
    public  void setPswd(String pswd) {
        this.pswd = pswd;
    }

    /**
     * @return the gender
     */
    public  String getGender() {
        return this.gender;
    }

    /**
     * @param gender to set
     */
    public  void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the active
     */
    public  boolean isActive() {
        return this.active;
    }

    /**
     * @param active to set
     */
    public  void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the phone
     */
    public  String getphone() {
        return this.phone;
    }

    /**
     * @param set phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
