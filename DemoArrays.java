import java.util.Scanner;

public class DemoArrays
{
  static Scanner sc = new Scanner (System.in);
  
  public static void main (String [] args)
  {
    Scanner sc = new Scanner (System.in);
    int [] a; 
    int [] b;
    int [] c;
    
    int numElementsA, numElementsB;
    
    numElementsA = getNumElements ("first");
    numElementsB = getNumElements("second");
    
    a = new int[numElementsA];
    b = new int[numElementsB];
    
    loadElements ("first", a);
    loadElements ("second", b);
    
    if (equalArrays(a,b))
      System.out.println ("the arrays are equal");
    else 
      System.out.println ("the arrays are not equal");

    c = createCopy (a);

    System.out.println ("the contents of the Copied Array are:");
    displayContents(c,c.length);
    
    c = sumArrays (a,b);
    
    System.out.println ("the contents of the Summed Arrays are:");
    displayContents (c, c.length); 
    
    sc.close();
  }
    
   public static int getNumElements (String type)
   {
     int numEles;
     
     System.out.print ("enter the number of elements in the " + type + " array");
     numEles= sc.nextInt();
     return numEles;
   }
   
   public static void loadElements (String type, int [] a)
   {
     int i;
     
     System.out.println ("Enter the " + a.length + " elements of the " + type + " array");
     for (i=0; i < a.length; i++)
     {
       System.out.print ("Enter the value: ");
       a [i]= sc.nextInt();
     }
     
   }
   
   public static boolean equalArrays( int [] a, int [] b)
   {
     int i;
     boolean equal = true;
     if (a.length != b.length) equal = false;
     
     for (i=0; equal && i < a.length; i++)
       if (a[i]!= b[i]) equal = false;
     
     return equal;
   }
   
   public static int [] createCopy (int [] a)
   {
     int [] copy = new int [a.length];
     
     for (int i =0; i < a.length; i++)
       copy [i] = a [i];
     
     return copy;
   }
   
   public static int [] sumArrays (int []a, int []b)
   {
     int len = (a.length < b.length)?a.length: b.length;
     int [] sum = new int [len];
     
     for (int i = 0; i < len ; i++)
      sum [i] = a[i] + b[i];
     
     return sum;
   }
   
   public static void displayContents(int [] a, int numEles)
   {
     System.out.println ("Element          Value");
     for (int i = 0; i < numEles; i++)
      System.out.println (i + "\t\t" + a[i]);
     
   }
}

       