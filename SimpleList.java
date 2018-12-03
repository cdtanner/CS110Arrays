import java.util.Scanner;
import java.util.ArrayList;

public class SimpleList
{
  
  private ArrayList<String> toDo;
  private Scanner sc;
  
  public static void menu()
  {
    System.out.println ("TO DO");
    System.out.println("Add an item to the list           1");
    System.out.println("Remove an item from the list      2");
    System.out.println("How many Item on the list:        3");
    System.out.println("Display the list                  4");
    System.out.println("Exit                              5");
  }
    
  public SimpleList ()
  {
    toDo = new ArrayList<String>();
    sc = new Scanner(System.in);
  }
  
  public static void main(String [] args)
  {
   SimpleList myList = new SimpleList();
   int choice;
   
   menu();
   choice = myList.sc.nextInt();
   //following statement is needed to remove the carriage return 
   //from the buffer when a stirng is read in after an integer or a double
   myList.sc.nextLine();
   while (choice !=5)
   {
     switch (choice)
     {
       case 1: myList.add();
               break;
       case 2: myList.remove();
               break;
       case 3: System.out.println("There are " + myList.toDo.size() + " items on the list");
               break;
       case 4: System.out.println(myList);
               break;
       default: choice =5;
     }
     menu();
     choice = myList.sc.nextInt();
     //following statement is needed to remove the carriage return 
     //from the buffer when a stirng is read in after an integer or a double
     myList.sc.nextLine();
   }
  }
  
  public void add()
  {
    String item;
    
    System.out.print ("enter the item to be added to the list: ");
    item = sc.nextLine();
    toDo.add(item);
  }
  
  public void remove()
  {
    String item;
    System.out.print ("enter the item to be removed from the list: ");
    item = sc.nextLine();
    if (toDo.contains(item))
      toDo.remove(item);
    else System.out.println("could not remove item does not exist");
  }
  
  public String toString()
  {
    String lst = "Your ToDo List";
    
    for (int i =0; i< toDo.size();i++)
      lst += "\n" + toDo.get(i);
    
    return lst;
  }
  
}
    
   
    
    