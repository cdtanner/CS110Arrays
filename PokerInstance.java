/*CS 110 Sample Program
 * Arrays of objects
 * determine poker hands*/

import java.util.Scanner;
import java.util.Arrays;

public class PokerInstance
{
  private Card [] hand;
  
  public PokerInstance()
  {
      hand = new Card [5];
  }
  
  public static void main (String [] agrs)
  {
    
    PokerInstance playHand = new PokerInstance();
    
    //generate a hand of 5 random cards
    for (int i =0;i<playHand.hand.length;i++)
      playHand.hand[i] = new Card();
    
    /*hand[0] = new Card(Card.Suits.diamonds,4);
    hand[1] = new Card(Card.Suits.clubs,2);
    hand[2] = new Card(Card.Suits.clubs,1);
    hand[3] = new Card(Card.Suits.hearts,2);
    hand[4] = new Card(Card.Suits.spades,2);*/
    
    //display the hand
    System.out.println("the hand dealt is: ");
    for (int i=0;i<playHand.hand.length;i++)
      System.out.println(playHand.hand[i]);
    if (playHand.royalFlush()) System.out.print ("ABsolute WInner, royal flush!!!");
        else if (playHand.straightFlush()) System.out.print ("Almost always a Winner, straight flush!!!");
                 else if (playHand.straight()) System.out.print ("Usually a WInner, striaght!!!");  
                          else if (playHand.flush()) System.out.print("Great hand a flush!!!!");
                              else if (playHand.fullHouse ()) System.out.print("Great hand  full house");
                                  else if (playHand.fourKind()) System.out.print("Great hand, four of a kind");
                                    else if (playHand.threeKind()) System.out.print("Good hand three of a kind");
                                       else if (playHand.twoKind()) System.out.print("two of a kind");
                                           else System.out.print ("Trade them all in");
    System.out.println();                    
    System.out.print ("thanks for playing");
  }
  
  public boolean royalFlush ()
  {
    boolean rf = false;
    int [] faces = new int [5];
    
    if (this.flush())
    {
      for (int i =0; i < 5; i++)
        faces[i] = hand[i].face();
      
      Arrays.sort(faces);
      if (faces[0] == 1 && faces[1] == 10 && faces[2] ==11 && faces[3] == 12 && faces[4] == 13) rf= true;
    }
    
    return rf;
  }
  
  public boolean straight ()
  {   boolean st = true;
      
      int [] faces = new int[5];
      
      for (int i =0; i < 5; i++)
        faces[i] = hand[i].face();
      
      Arrays.sort(faces);
      for (int i=0; st && i<4;i++)
        if (faces[i+1]-faces[i] != 1) st = false;
      
      return st;
  }
  
  public boolean straightFlush ()
  {
    return (this.flush() && this.straight());
  }
            
  public boolean flush ()
  {  boolean isFlush = true;
     Card firstOne = new Card(hand[0].suit(), hand[0].face());
     
     for (int i = 1; isFlush && i<hand.length;i++)
       if (!firstOne.sameSuit(hand[i])) isFlush=false;
     
     return isFlush;
  }
  
  public boolean fullHouse ()
  {
    return (this.threeKind() && this.twoKind());
  }
  
  public boolean fourKind()
  {
    int count =0;
    
    for (int i=0; count != 3 && i<hand.length;i++)
    { count =0;
      for (int j=0;j<hand.length;j++)
        if (hand[i].sameFace(hand[j]) && i!=j) count++;
    }
    
    return (count==3);
  }
  
  public boolean threeKind()
  {
    int count =0;
    
    for (int i=0; count !=2 && i<hand.length;i++)
    { count =0;
      for (int j=0;j<hand.length;j++)
        if (hand[i].sameFace(hand[j]) && i!=j) count++;
    }
    
    return (count==2);
  }
  
  public boolean twoKind()
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
  