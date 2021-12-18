package crossmoduleca;

import java.sql.SQLException;
import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

// GITHUB REPOSITORY: https://github.com/luizaalbuquerque/crossmoduleCA.git 
public class LinearEquations {

    public static void main(String[] args) throws SQLException {

//           Connection conn;
// 
//String query = "SELECT * FROM USERS WHERE username = '" ;
//        
//          conn = new MySQLConection().dbconn();
//        ResultSet rs = null;
//        ResultSet allUsers = null;
//        Statement stmt = null;
//        
//   
//            // create a connection
//            stmt = conn.createStatement();
//
//            //execute the query 
//            rs = stmt.executeQuery(query);
//
//                           allUsers = stmt.executeQuery("SELECT * FROM USERS"); 
//            


        char[] var = {'x', 'y', 'z', 'w'};
       // String option =
  JOptionPane.showInputDialog("Enter the number of variables in the equations: "); //columns

        int number = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the coefficients of each variable for each equations \n ")); //rows
       
        JOptionPane.showInputDialog( "In the following format: \n" + " ax + by + cz + ... = d "); //columns
//
//        int number1 = Integer.parseInt(JOptionPane.showInputDialog(null,
//                "In the following format: \n"
//                + " ax + by + cz + ... = d "));
      
        double[][] matrix = new double[number][number];
        double[][] constants = new double[number][1];

        //input
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog(null));
            }
            constants[i][0] = Integer.parseInt(JOptionPane.showInputDialog(null));
        }
        //Matrix representation
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.print("  " + var[i]);
            System.out.print("  =  " + constants[i][0]);
            System.out.println();
        }
        //inverse of matrix mat[][]
        double inverted_matrix[][] = invert(matrix);
        System.out.println("The inverse is: ");
        for (int i = 0; i < number; ++i) {
            for (int j = 0; j < number; ++j) {
                System.out.print(inverted_matrix[i][j] + "  ");
            }
            System.out.println();
        }
        //Multiplication of mat inverse and constants
        double result[][] = new double[number][1];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < 1; j++) {
                for (int k = 0; k < number; k++) {
                    result[i][j] = result[i][j] + inverted_matrix[i][k] * constants[k][j];
                }
            }
        }
        System.out.println("The product is:");
        for (int i = 0; i < number; i++) {
            System.out.println(result[i][0] + " ");
        }
//        userinput.close();

    }

    public static double[][] invert(double a[][]) {
        int n = a.length;
        double x[][] = new double[n][n];
        double b[][] = new double[n][n];
        int index[] = new int[n];
        for (int i = 0; i < n; ++i) {
            b[i][i] = 1;
        }

        // Transform the matrix into an upper triangle
        gaussian(a, index);

        // Update the matrix b[i][j] with the ratios stored
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                for (int k = 0; k < n; ++k) {
                    b[index[j]][k]
                            -= a[index[j]][i] * b[index[i]][k];
                }
            }
        }

        // Perform backward substitutions
        for (int i = 0; i < n; ++i) {
            x[n - 1][i] = b[index[n - 1]][i] / a[index[n - 1]][n - 1];
            for (int j = n - 2; j >= 0; --j) {
                x[j][i] = b[index[j]][i];
                for (int k = j + 1; k < n; ++k) {
                    x[j][i] -= a[index[j]][k] * x[k][i];
                }
                x[j][i] /= a[index[j]][j];
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
    }
}
