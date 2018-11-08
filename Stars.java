/**
 * @(#)Stars.java
 * @CS 110 Sample Program
 * @11-23-08
 * @demonstrates 2 dimensional arrays
 * @Determines if data representing lights in sky shows star locations
 */

import java.util.Scanner;
import java.io.*;

public class Stars 
{    
    static final int MAXSIZE = 8;
    
    public static void main (String[] args) throws FileNotFoundException
    {     
     Scanner inFile = new Scanner(new FileReader("stars.dat"));
     int[][] stars = new int[6][8];
     int i,j;
     int total;
     
     for (i = 0; i < 6; i++)
     {
      for ( j = 0; j < 8; j++)
      {
       stars[i][j] = inFile.nextInt();
      } 
     }
     
     System.out.println("The data is: ");
     printMatrix(stars, 6, 8);
     System.out.println();
     System.out.println();
     System.out.println("The stars are: ");
     System.out.println("  - - - - - - - -");
     for (i = 0; i < 6; i++)
     {
      System.out.print(":");
      for (j = 0; j < 8; j++)
      {
       if (i - 1 >= 0 && i + 1 < 6 && j - 1 >= 0 && j + 1 < 8)
       {
        if (((stars[i][j] + stars[i-1][j] +
         stars[i][j-1] + stars[i+1][j] +
         stars[i][j+1])/5.0) > 6.0)
          System.out.print(" *");
        else
         System.out.print("  ");
       }
      }
      System.out.println();
     }
    }
    
    public static void printMatrix (int[][] matrix, int numRows, int numCols)
    {
     int i, j;

     for (i = 0; i < numRows; i++)
     {
       System.out.println();
       for (j = 0;j < numCols; j++)
       {
         System.out.printf("%5d",matrix[i][j]);
       }
     }
    }
}