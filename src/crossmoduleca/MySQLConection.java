package crossmoduleca;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Luiza Cavalcanti
 *
 */
public class MySQLConection {

    public static Connection dbconn() {

        String url = "jdbc:mysql://localhost:3306/db_crossmoduleCA";
        ///Users/luizaalbuquerque/NetBeansProjects/crossmoduleCA/db Exported";
        String user = "root";
        String dbpswd = "Iza051200*";
        Connection conn = null;

        try {

            conn = DriverManager.getConnection(url, user, dbpswd);

            return conn;
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, erro, "ERRO", JOptionPane.ERROR_MESSAGE);
        }
        return conn;

    }
}
