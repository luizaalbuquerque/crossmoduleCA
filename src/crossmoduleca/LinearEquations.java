package crossmoduleca;

import javax.swing.*;

public class LinearEquations {

    public static void main(String args[]) {

//        declaring variables 
        int x, k, row1_2, column1_2, row2nd1_2, column2nd1_2;
        String answer = "", answer2nd = "", answer3rd = "";
        String option;
//        swing
        option = JOptionPane.showInputDialog("Calculate Matrices:\n (Choose on option by number) \n"
                + "1 - Multiplying \n"
                + "2 - Dividing \n"
                + "3 - Adding \n"
                + "4- Substracting \n"
                + "5 - Exit");
//        switch for the options
        switch (Integer.parseInt(option)) {
            
//          multiplication 
            case 1:
//
//                row2nd1_2 = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the number of rows for the Matrices 1 and 2?"));
//                column2nd1_2 = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the number of columns for the Matrices 1 and 2?"));
//
//                int[][] matrix1B = new int[row2nd1_2][column2nd1_2];
//                int[][] matrix2B = new int[row2nd1_2][column2nd1_2];
//                int[][] multiplication = new int[row2nd1_2][column2nd1_2];
//
//                for (x = 0; x < row2nd1_2; x++) {
//                    for (k = 0; k < column2nd1_2; k++) {
//                        matrix1B[x][k] = Integer.parseInt(JOptionPane.showInputDialog(null, "Type a value for the Matrix 1"));
//                        answer = answer + matrix1B[x][k] + "-";
//                    }
//                }
//
//                for (x = 0; x < row2nd1_2; x++) {
//                    for (k = 0; k < column2nd1_2; k++) {
//                        matrix2B[x][k] = Integer.parseInt(JOptionPane.showInputDialog(null, "Type a value for the Matrix 2"));
//                        answer2nd = answer2nd + matrix2B[x][k] + "-";
//                    }
//                }
//
//                for (x = 0; x < row2nd1_2; x++) {
//                    for (k = 0; k < column2nd1_2; k++) {
//                        multiplication[x][k] = matrix1B[x][k] - matrix1B[x][k];
//                        answer3rd = answer3rd + multiplication[x][k] + "-";
//                    }
//                }
//
//                break;

//                dividing 
            case 2:    

                
//                adding
            case 3:
                row1_2 = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the number of rows for the Matrices 1 and 2?"));
                column1_2 = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the number of columns for the Matrices 1 and 2?"));

                int[][] matrix_1 = new int[row1_2][column1_2];
                int[][] matrix_2 = new int[row1_2][column1_2];
                int[][] adding = new int[row1_2][column1_2];

                for (x = 0; x < row1_2; x++) {
                    for (k = 0; k < column1_2; k++) {
                        matrix_1[x][k] = Integer.parseInt(JOptionPane.showInputDialog(null, "Type a value for the Matrix 1"));
                        answer = answer + matrix_1[x][k] + "-";
                    }
                }

                for (x = 0; x < row1_2; x++) {
                    for (k = 0; k < column1_2; k++) {
                        matrix_2[x][k] = Integer.parseInt(JOptionPane.showInputDialog(null, "Type a value for the Matrix 2"));
                        answer2nd = answer2nd + matrix_2[x][k] + "-";
                    }
                }

                for (x = 0; x < row1_2; x++) {
                    for (k = 0; k < column1_2; k++) {
                        adding[x][k] = matrix_1[x][k] + matrix_2[x][k];
                        answer3rd = answer3rd + adding[x][k] + "-";
                    }
                }

                break;

//                subtracting 
            case 4:

                row2nd1_2 = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the number of rows for the Matrices 1 and 2?"));
                column2nd1_2 = Integer.parseInt(JOptionPane.showInputDialog(null, "What is the number of columns for the Matrices 1 and 2?"));

                int[][] matrix1_2 = new int[row2nd1_2][column2nd1_2];
                int[][] matrix2_2 = new int[row2nd1_2][column2nd1_2];
                int[][] substraction = new int[row2nd1_2][column2nd1_2];

                for (x = 0; x < row2nd1_2; x++) {
                    for (k = 0; k < column2nd1_2; k++) {
                        matrix1_2[x][k] = Integer.parseInt(JOptionPane.showInputDialog(null, "Type a value for the Matrix 1"));
                        answer = answer + matrix1_2[x][k] + "-";
                    }
                }

                for (x = 0; x < row2nd1_2; x++) {
                    for (k = 0; k < column2nd1_2; k++) {
                        matrix2_2[x][k] = Integer.parseInt(JOptionPane.showInputDialog(null, "Type a value for the Matrix 2"));
                        answer2nd = answer2nd + matrix2_2[x][k] + "-";
                    }
                }

                for (x = 0; x < row2nd1_2; x++) {
                    for (k = 0; k < column2nd1_2; k++) {
                        substraction[x][k] = matrix1_2[x][k] - matrix2_2[x][k];
                        answer3rd = answer3rd + substraction[x][k] + "-";
                    }
                }

                break;

//                exit the program 
            case 5:
            return;
        }

        JOptionPane.showMessageDialog(null, "The Final Matrix is: \n" + answer + "\n" + answer2nd + "\n" + answer3rd);
    }
}
