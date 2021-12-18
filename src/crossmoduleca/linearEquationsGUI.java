/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossmoduleca;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author luizaalbuquerque
 *
 * GITHUB REPOSITORY: https://github.com/luizaalbuquerque/crossmoduleCA.git
 *
 *
 * referencing code: GeeksforGeeks.org
 * referencing code: sanfoundry.com/
 * 
 */
public class linearEquationsGUI extends javax.swing.JFrame {

    /**
     * Creates new form linearEquationsGUI
     */
// database connection 
    Connection conn = new MySQLConection().dbconn();
    ResultSet rs = null;
    ResultSet allUsers = null;
    Statement stmt = null;
    static int GlobalID;

//creating variables 
    double[][] finalNumberMatrix;
    String resultFinalToStore = "";

    public linearEquationsGUI() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        variablesText = new javax.swing.JTextField();
        okButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        editbutton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        resultLabel = new javax.swing.JLabel();
        inverseLabel = new javax.swing.JLabel();
        finalResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Solve Equations:");

        variablesText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                variablesTextActionPerformed(evt);
            }
        });

        okButton.setText("ok");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Enter number of variables and click 'ok':");

        editbutton.setText("Edit my Profile");
        editbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbuttonActionPerformed(evt);
            }
        });

        jLabel4.setText("User type: REGULAR ");

        jLabel3.setText("Result:");

        jLabel5.setText("Inverse: ");

        jLabel6.setText("Representation:");

        resultLabel.setText("Representation Label");

        inverseLabel.setText("Inverse Label");

        finalResult.setText("Result Label");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(editbutton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(67, 67, 67)
                                .addComponent(inverseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(finalResult, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 210, Short.MAX_VALUE)
                                .addComponent(jLabel12))
                            .addComponent(variablesText))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(okButton)
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel6)
                        .addGap(129, 129, 129)
                        .addComponent(jLabel5)
                        .addGap(194, 194, 194)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editbutton)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(variablesText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okButton))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel12)
                        .addGap(183, 183, 183))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inverseLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(resultLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(finalResult, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(142, 142, 142))))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void variablesTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_variablesTextActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_variablesTextActionPerformed

    private void editbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbuttonActionPerformed
        // TODO add your handling code here:
//opening a new tab when clicking on the button 'Edit my Profile' 
        JFrame edit = new edit();
        edit.setVisible(true);
    }//GEN-LAST:event_editbuttonActionPerformed

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        try {
            // TODO add your handling code here:

//   Storing the variables that are going to the the constants
            char[] variablesType = {'x', 'y', 'z', 'w'};

// getting the number of constantes from the user and storing in an int
            int equationsNumber = parseInt(variablesText.getText());

// user-friendly message to inform the user that the variable was added to the program
            JOptionPane.showMessageDialog(null, "Number of variable was add as " + equationsNumber + ". \n Now add the values for coefficients.");

//creating a to dimentional Array
            double[][] matrix = new double[equationsNumber][equationsNumber];
            double[][] constants = new double[equationsNumber][1];

//loop to display the user's input in an organized way
            for (int i = 0; i < equationsNumber; i++) {
                for (int j = 0; j < equationsNumber; j++) {
                    matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Enter the coefficientes for the variables of equation 1 \n the format will be: \n" + " ax + by + cz + ew... = d \n obs.: if the number is negative, add '-' before it "));
                }
                constants[i][0] = Integer.parseInt(JOptionPane.showInputDialog("Enter the coefficientes for the variables of equation 2 \n the format will be: \n" + " ax + by + cz + ew... = d \n obs.: if the number is negative, add '-' before it "));
            }

            finalNumberMatrix = matrix;

            String results = "<html><body>";
//loop to display the user's input in an organized way (showing the Matrix representation)
            for (int i = 0; i < equationsNumber; i++) {
                for (int j = 0; j < equationsNumber; j++) {

                    results += " " + matrix[i][j];
                }

                results += "   " + variablesType[i];
                results += ("  =  " + constants[i][0]);

                results += "<br>";

            }

            resultLabel.setText("" + results);

            String inverse = "<html><body>";
//inverse of the matrix[][]
            double inverted_matrix[][] = invert(matrix);

            for (int i = 0; i < equationsNumber; ++i) {
                for (int j = 0; j < equationsNumber; ++j) {
                    inverse += "" + inverted_matrix[i][j] + "  ";
                    inverse += (inverted_matrix[i][j] + "  ");
                }
                inverse += "<br>";
            }
            inverseLabel.setText("" + inverse);

//Multiplication of matrix inverse and constants
            double result[][] = new double[equationsNumber][1];
            for (int i = 0; i < equationsNumber; i++) {
                for (int j = 0; j < 1; j++) {
                    for (int k = 0; k < equationsNumber; k++) {
                        result[i][j] = result[i][j] + inverted_matrix[i][k] * constants[k][j];
                    }
                }
            }
            String resultFinal = "<html><body>";
//final product, the final matrix result 

            for (int i = 0; i < equationsNumber; i++) {
                resultFinal += (result[i][0] + " ");
                resultFinalToStore += (result[i][0]);

            }
            finalResult.setText("" + resultFinal);

            String query = "INSERT INTO linearEquations (id, variables ,result) "
                    + "VALUES (" + CrossmoduleGUI.GlobalID + ",'" + Arrays.deepToString(finalNumberMatrix) + "','" + resultFinalToStore + "')";

//         user-friendly message to inform the user that the data was added in the database
            JOptionPane.showMessageDialog(null, "Data inserted on the database, press 'ok' and see result ");

//            connection to the database
            stmt = conn.createStatement();
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            Logger.getLogger(linearEquationsGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static double[][] invert(double[][] lenght) {
        int number = lenght.length;
//        creating a two dimentional array
        double x[][] = new double[number][number];
        double b[][] = new double[number][number];
        int index[] = new int[number];
        for (int i = 0; i < number; ++i) {
            b[i][i] = 1;
        }

// Transform the matrix into an upper triangle
        gaussian(lenght, index);

// Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < number - 1; ++i) {
            for (int j = i + 1; j < number; ++j) {
                for (int k = 0; k < number; ++k) {
                    b[index[j]][k]
                            -= lenght[index[j]][i] * b[index[i]][k];
                }
            }
        }

        // Perform backward substitutions
        for (int i = 0; i < number; ++i) {
            x[number - 1][i] = b[index[number - 1]][i] / lenght[index[number - 1]][number - 1];
            for (int j = number - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < number; ++k) {
                    x[j][i] -= lenght[index[j]][k] * x[k][i];
                }
                x[j][i] /= lenght[index[j]][j];
            }
        }
        return x;
    }

// Method to carry out the partial-pivoting Gaussian
// elimination.  Here index[] stores pivoting order.
    public static void gaussian(double a[][], int index[]) {
        int n = index.length;
        double c[] = new double[n];

        // Initialize the index
        for (int i = 0; i < n; ++i) {
            index[i] = i;
        }

        // Find the rescaling factors, one from each row
        for (int i = 0; i < n; ++i) {
            double c1 = 0;
            for (int j = 0; j < n; ++j) {
                double c0 = Math.abs(a[i][j]);
                if (c0 > c1) {
                    c1 = c0;
                }
            }
            c[i] = c1;
        }

        // Search the pivoting element from each column
        int k = 0;
        for (int j = 0; j < n - 1; ++j) {
            double pi1 = 0;
            for (int i = j; i < n; ++i) {
                double pi0 = Math.abs(a[index[i]][j]);
                pi0 /= c[index[i]];
                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            // Interchange rows according to the pivoting order
            int itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;
            for (int i = j + 1; i < n; ++i) {
                double pj = a[index[i]][j] / a[index[j]][j];

                // Record pivoting ratios below the diagonal
                a[index[i]][j] = pj;

                // Modify other elements accordingly
                for (int l = j + 1; l < n; ++l) {
                    a[index[i]][l] -= pj * a[index[j]][l];
                }
            }
        }


    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(linearEquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(linearEquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(linearEquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(linearEquationsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new linearEquationsGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton editbutton;
    private javax.swing.JLabel finalResult;
    private javax.swing.JLabel inverseLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JTextField variablesText;
    // End of variables declaration//GEN-END:variables
}
