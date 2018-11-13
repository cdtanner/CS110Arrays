import java.util.Scanner;

public class FlashInstance
{
  public static Scanner sc=new Scanner(System.in);
  private Problem prob;
  private Wind testWindow = new Wind();
  private String [] messages = {"Great!", "Excellent!", "Good Job!", "Wonderful!", 
      "Fantastic!", "Cool!", "Marvelous!", "Terrific!", "Stupendous!", "Solid!"};

  public FlashInstance()
  {
    testWindow = new Wind();
   //Set color of various window components
   testWindow.setBackgroundColor(Wind.RED);
   testWindow.setPromptBackgroundColor(Wind.BLUE);
   testWindow.setPromptTextColor(Wind.YELLOW);
   testWindow.setMessageBackgroundColor(Wind.YELLOW);
   testWindow.setMessageTextColor(Wind.BLUE);
  } 
  public static void main(String [] agrs)
  {
   
    String play;
    String sanswer;
    int answer;
    boolean incorrect;
    int numProblems =0;
    int numCorrect =0;
    double percent =0;
   
    FlashInstance game = new FlashInstance();
    
    game.testWindow.setPrompt("Flash card problem? Y/N");
    play = game.testWindow.getInput();
    while (play.equals("Y") || play.equals("y"))
    {
      game.prob = new Problem();
      numProblems++;
      incorrect = true;
      for (int i=0; incorrect && i <3;i++)
      { game.testWindow.clearInput();
        game.testWindow.setMessage(" ");
        game.testWindow.setPrompt(game.prob.displayProblem());
        sanswer = game.testWindow.getInput();
        answer = Integer.parseInt(sanswer);
        if (answer == game.prob.correctAnswer())
        {game.testWindow.setMessage(game.messages[(int)(Math.random()*10)]);
          game.testWindow.wait(5);
          incorrect = false;
        }
        else if (i<2)
        {game.testWindow.setMessage("Sorry, incorrect, try again!");
        game.testWindow.wait(5);
        }
      }
      if (incorrect) 
      {game.testWindow.setMessage("Sorry the correct answer is: " + game.prob.correctAnswer());
        game.testWindow.wait(5);
      }
      else
        numCorrect++;
      game.testWindow.clearInput();
      game.testWindow.setMessage(" ");
      game.testWindow.setPrompt("Flash card problem? Y/N");
      play = game.testWindow.getInput();
    }
    if (numCorrect >0)
      percent = (double) numCorrect/ numProblems *100;
     game.testWindow.setPrompt(" ");
     game.testWindow.setMessage("You tried " + numProblems + " problems and got " + numCorrect + " correct = " + String.format("%.0f",percent) + "%");
     game.testWindow.wait(5);
        if (percent <=33) game.testWindow.setMessage("Play this game everyday");
     else if (percent <=66) game.testWindow.setMessage("Keep Practing");
     else game.testWindow.setMessage("Move to the next Grade level"); 
  }
}