package numberguess;
import java.util.Scanner;

public class NumberGuessRunner 
{
    
    
    public static void main(String[] args) 
    {
       boolean twoPlayers;
       
        NumberGuess y = new NumberGuess();
        Scanner in = new Scanner (System.in);
        String level;
       
        System.out.println("Do you want a 1 or 2 player game (please type the # of players)");
        String input = in.next();
        System.out.println("---------------------------------------------------------------------------------------------");
        
         if (input.equals("1") || input.equals("one")) 
         {
            System.out.println("Would you like to play on easy (type 1) or hard (type 2)?");
            level = in.next();
            if (level.equals("1") || level.equalsIgnoreCase("one")) 
            {
                twoPlayers = false;  
                y.calcGuess(twoPlayers);
                
            }
            
            else
            {
                y.multiLevel();
            }
            
        } 
        
        else if (input.equals("2") || input.equals("two"))  
        {
            twoPlayers = true;
            y.calcGuess(twoPlayers);
        }
    
        else  
        {
            twoPlayers = false;
            y.calcGuess(twoPlayers);
        }
                   
   }

}
