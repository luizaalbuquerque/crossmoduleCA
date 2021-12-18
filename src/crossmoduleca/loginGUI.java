/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossmoduleca;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import crossmoduleca.userModel;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luizaalbuquerque
 */
public class loginGUI extends javax.swing.JFrame {

//creating and assigning variables 
    userModel user;

    static public String userName;
    int access;

    /**
     * Creates new form loginGUI
     */
    public loginGUI() {

        initComponents();

//creating database connection      
        try {
            Connection conn = new MySQLConection().dbconn();
            ResultSet rs = null;
            ResultSet allUsers = null;
            Statement stmt = null;

//database connection and query execution 
            stmt = conn.createStatement();
            allUsers = stmt.executeQuery("SELECT * FROM USERS");

// creating a two dimentional ArrayList to store the user's data 
            ArrayList usersData = new ArrayList();
// returns attributte values for cells at row and columns 
            final Object[][] rowData = {};
            final Object[] columnNames = {"id", "fullname", "username", "pswd", "usertype", "gender", "active", "phone"};

            DefaultTableModel listTableModel;
            listTableModel = new DefaultTableModel(rowData, columnNames);

//loop to print all the rows, in this case all users from the table 
            while (allUsers.next()) {
                int id = allUsers.getInt("id");
                String userFullName = allUsers.getString("fullname");
                String showusername = allUsers.getString("username");
                String pwd = allUsers.getString("pswd");
                String usertype = allUsers.getString("usertype");
                String gender = allUsers.getString("gender");
                Boolean useractive = allUsers.getBoolean("active");
                String phone = allUsers.getString("phone");

                userModel userModel = new userModel();
                userModel.id = id;
                userModel.fullname = userFullName;
                userModel.username = showusername;
                userModel.pswd = pwd;
                userModel.usertype = usertype;
                userModel.gender = gender;
                userModel.active = useractive;
                userModel.phone = phone;

//add the information on the GUI table, selected by column 
                usersData.add(userModel);
                listTableModel.addRow(new Object[]{userModel.id, userModel.fullname, userModel.username, userModel.pswd, userModel.usertype, userModel.gender, userModel.active, userModel.phone});

            }
// setting the data in the table 
            usersTable.setModel(listTableModel);
            usersTable.setAutoResizeMode(JTable.ALLBITS);

//catch and error message 
        } catch (SQLException e) {
//test purpose
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        userIdRemove = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profileLabel.setText("Profile");

        jLabel2.setText("Users");

        usersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "FULLNAME", "USERNAME", "PASSWORD", "USERTYPE", "GENDER", "ACTIVE", "PHONE", "VARIABLE", "RESULT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setColumnSelectionAllowed(true);
        jScrollPane1.setViewportView(usersTable);
        usersTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        editButton.setText("Edit My Profile");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Delete Selected User");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        jLabel3.setText("Type an user ID");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 753, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(profileLabel)
                        .addGap(257, 257, 257)
                        .addComponent(editButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(userIdRemove)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profileLabel)
                    .addComponent(editButton))
                .addGap(18, 18, 18)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteButton)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIdRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
////redirects to edit after clicking the button 'edit' 
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed

        JFrame editAdm = new editAdm();
        editAdm.setVisible(true);

    }//GEN-LAST:event_editButtonActionPerformed
//deletes the user on the database after typing the ID and clicking on the button 'delete' 
    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed

     //connection
            Statement stmt = null;


        try {

//store the ID on the int 'id' 
            int id = parseInt(userIdRemove.getText());

//query to be executed in the database 
            String q = "DELETE FROM USERS where id = " + id;

//line to execute the query 
            stmt.executeUpdate(q);

// TODO add your handling code here:
//message for the user, informing that the user chosen was deleted             
            JOptionPane.showMessageDialog(null, "User which ID is: " + id + " was deleted from the database.");

        } catch (SQLException ex) {
            Logger.getLogger(loginGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
   
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public void main(String args[]) throws SQLException {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(loginGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel profileLabel;
    private javax.swing.JTextField userIdRemove;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
