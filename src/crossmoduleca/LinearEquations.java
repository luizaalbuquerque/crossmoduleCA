/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crossmoduleca;

import java.util.Scanner;

/**
 *
 * @author luizaalbuquerque
 */
public class LinearEquations {

    public static void main (String arg[]){

       

        System.out.println("----- 3 variable linear euqation-----");

         Scanner userInput = new Scanner(System.in);
         
            char[] variable = {'x', 'y', 'z'};
            
            System.out.println("Enter the coefficient of 3 variables  \n in the format show: \n ax + by+ cz = d");
  
    int [][] matrix = new int [3] [3];
    int [][] constant = new int [3][1];
    
    for (int i=0; i<3; i++){
        for (int j =0; j<3; j++){
    matrix [i][j] = userInput.nextInt();
    
    
    
    
            
        }
        
        constant [i][0] =userInput.nextInt();
        
            }
     System.out.println(
            "Matrix representation of above linear equations is: ");
 
        // Outer loop for iterating rows
        for (int i = 0; i < 3; i++) {
 
            // Inner loop for iterating columns
            for (int j = 0; j < 3; j++) {
 
                System.out.print(" " + matrix[i][j]);
            }
 
            System.out.print("  " + variable[i]);
            System.out.print("  =  " + constant[i][0]);
            System.out.println();
        }
 
       
    
}
    
    
   
    
    }


