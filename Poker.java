/*CS 110 Sample Program
 * Arrays of objects
 * determine poker hands*/

import java.util.Arrays;

public class Poker
{
  public static void main (String [] agrs)
  {
    Card [] hand = new Card [5];
    
   /* //generate a hand of 5 random cards
    for (int i =0;i<hand.length;i++)
      hand[i] = new Card();
    */
    hand[0] = new Card(Card.Suits.diamonds,4);
    hand[1] = new Card(Card.Suits.clubs,2);
    hand[2] = new Card(Card.Suits.clubs,4);
    hand[3] = new Card(Card.Suits.hearts,2);
    hand[4] = new Card(Card.Suits.spades,2);
    
    //display the hand
    System.out.println("the hand dealt is: ");
    for (int i=0;i<hand.length;i++)
      System.out.println(hand[i]);
    if (royalFlush(hand)) System.out.print ("ABsolute WInner, royal flush!!!");
        else if (straightFlush(hand)) System.out.print ("Almost always a Winner, straight flush!!!");
                 else if (straight(hand)) System.out.print ("Usually a WInner, striaght!!!");  
                          else if (flush(hand)) System.out.print("Great hand a flush!!!!");
                              else if (fullHouse (hand)) System.out.print("Great hand  full house");
                                  else if (fourKind(hand)) System.out.print("Great hand, four of a kind");
                                    else if (threeKind(hand)) System.out.print("Good hand three of a kind");
                                       else if (twoKind(hand)) System.out.print("two of a kind");
                                           else System.out.print ("Trade them all in");
    System.out.println();                    
    System.out.print ("thanks for playing");
  }
  
  public static boolean royalFlush (Card [] hand)
  {
    boolean rf = false;
    int [] faces = new int [5];
    
    if (flush(hand))
    {
      for (int i =0; i < 5; i++)
        faces[i] = hand[i].getFace();
      
      Arrays.sort(faces);
      if (faces[0] == 1 && faces[1] == 10 && faces[2] ==11 && faces[3] == 12 && faces[4] == 13) rf= true;
    }
    
    return rf;
  }
  
  public static boolean straight (Card [] hand)
  {   boolean st = true;
      
      int [] faces = new int[5];
      
      for (int i =0; i < 5; i++)
        faces[i] = hand[i].getFace();
      
      Arrays.sort(faces);
      for (int i=0; st && i<4;i++)
        if (faces[i+1]-faces[i] != 1) st = false;
      
      return st;
  }
  
  public static boolean straightFlush (Card [] hand)
  {
    return (flush(hand) && straight(hand));
  }
            
  public static boolean flush (Card [] hand)
  {  boolean isFlush = true;
     Card firstOne = new Card(hand[0].getSuit(), hand[0].getFace());
     
     for (int i = 1; isFlush && i<hand.length;i++)
       if (!firstOne.sameSuit(hand[i])) isFlush=false;
     
     return isFlush;
  }
  
  public static boolean fullHouse (Card [] hand)
  {
    return (threeKind(hand) && twoKind(hand));
  }
  
  public static boolean fourKind(Card [] hand)
  {
    int count =0;
    
    for (int i=0; count != 3 && i<hand.length;i++)
    { count =0;
      for (int j=0;j<hand.length;j++)
        if (hand[i].sameFace(hand[j]) && i!=j) count++;
    }
    
    return (count==3);
  }
  
  public static boolean threeKind(Card [] hand)
  {
    int count =0;
    
    for (int i=0; count !=2 && i<hand.length;i++)
    { count =0;
      for (int j=0;j<hand.length;j++)
        if (hand[i].sameFace(hand[j]) && i!=j) count++;
    }
    
    return (count==2);
  }
  
  public static boolean twoKind(Card [] hand)
  {
    int count =0;
    
    for (int i=0; count != 1 && i<hand.length;i++)
    { count =0;
      for (int j=0;j<hand.length;j++)
        if (hand[i].sameFace(hand[j]) && i!=j) count++;
    }
    
    return (count==1);
  }
}
  