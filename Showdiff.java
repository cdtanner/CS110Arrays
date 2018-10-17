/**
 * @(#)Showdiff.java
 * @CS 110 Sample Program
 * @10-17-18
 * @Demonstrates the use of arrays
 */

import java.util.Scanner;

public class Showdiff 
{
 public static void main (String[] args) 
 {
  final int MAXITEMS = 10;
  Scanner sc = new Scanner(System.in);
  float[] x = new float[MAXITEMS];
  float average;
  int sum = 0;
  int i;
  
  System.out.println("Please enter " + MAXITEMS + " integers");
  for (i = 0; i < MAXITEMS; i ++)
  {
   x[i] = sc.nextInt();
  }  
  for (i = 0; i < MAXITEMS; i ++)
  {
   sum += x[i];
  }
  average = (float) sum / MAXITEMS;
  System.out.println();
  System.out.println("The average is " + average);
  System.out.println();
  System.out.println("Table of differences between the value"
   + " and the average");
  System.out.println("ENTRY   VALUE  DIFFERENCE");
   
  for (i = 0; i < MAXITEMS; i ++)
  {
   System.out.print("  " + i + "      " + x[i] + "   " 
    + (float)(x[i]-average));
   System.out.println();
  }
  sc.close();
 }
}