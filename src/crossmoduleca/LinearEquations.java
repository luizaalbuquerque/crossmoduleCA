package crossmoduleca;

import java.sql.SQLException;
import java.util.Scanner;
import javax.swing.*;

public class LinearEquations {

   public static void main(String[] args) throws SQLException {
    
   }
   
public static void solveLinearEquations(double variable1, double variable2, double variable3, double variable4, double variable5, double variable6) {
 Scanner option = new Scanner(System.in);
//    int x = option.nextInt():
    
//       String calculate = JOptionPane.showInputDialog("calculate");
               
  if ( option.nextInt()==2) {
      variable1 = Integer.parseInt(JOptionPane.showInputDialog(null, "a"));
      variable2 = Integer.parseInt(JOptionPane.showInputDialog(null, "b"));
      variable3 = Integer.parseInt(JOptionPane.showInputDialog(null, "c"));
      variable4 = Integer.parseInt(JOptionPane.showInputDialog(null, "d"));
      variable5 = Integer.parseInt(JOptionPane.showInputDialog(null, "e"));
      variable6 = Integer.parseInt(JOptionPane.showInputDialog(null, "f"));
      
//     
      double det = ((variable1) * (variable4) - (variable2) * (variable3));
      double x = ((variable4) * (variable5) - (variable2) * (variable6)) / det;
      double y = ((variable1) * (variable6) - (variable3) * (variable5)) / det;
      System.out.print("x=" + x + " y=" + y);
 
  
  
      System.out.println(det);
  } else {
  }}
}