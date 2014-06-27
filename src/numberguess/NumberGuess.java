package numberguess;
import java.util.Random;
import java.util.Scanner;

public class NumberGuess 
{
    private int numberGuess = 0;
    private int randomNum;
    private boolean win = false;
    private int pturn = 0;
    private String name;
    private String p1name;
    private String p2name;
    private int triesLeft;
    private double levelPoints = 0;
    private double levelMultiplier = 0;
    private double playerPoints = 0;
    private double totalPoints = 0;
    
    Scanner x = new Scanner(System.in);
    Random rand = new Random();
    
    public NumberGuess()
    {
       randomNum = (rand.nextInt(19) +1);
    }
        
    public void calcGuess(boolean twoplayer) 
    {

        if (twoplayer == true) 
        {
            System.out.println("What is player 1's name?");
            p1name = x.next();
            System.out.println("---------------------------------------------------------------------------------------------");

            System.out.println("What is player 2's name?");
            p2name = x.next();
            System.out.println("---------------------------------------------------------------------------------------------");

            pturn = rand.nextInt(2) + 1;
            if (pturn == 1) 
            {
                name = p1name;
                System.out.println(name + ", you're up first to guess.");

            }
            
            else 
            {
                name = p2name;
                System.out.println(name + ", you're up first to guess.");
            }

        } 
       
        else 
        {
            System.out.println("What is your name?");
            p1name = x.next();
            System.out.println("---------------------------------------------------------------------------------------------");
            p2name = p1name;
            name = p1name;
            name = p2name;

        }

        while (win == false) 
        {
            System.out.println(name + ", please guess a number between 1 and 20");
            String response = x.next();
            int guess = Integer.parseInt(response);

            if (guess == randomNum) 
            {
                System.out.println(name + ", you have correctly guessed the number. The correct number was " + randomNum + ".");
                System.out.println("It took you " + (numberGuess+1) + " tries.");
                win = true;
                System.out.println("---------------------------------------------------------------------------------------------");
            } 
            else if (guess < randomNum) 
            {
                if (pturn == 1) 
                {
                    numberGuess++;
                    System.out.println(name + ", the number you have guessed is too low. Please try again.");
                    name = p2name;
                    pturn++;
                    System.out.println("---------------------------------------------------------------------------------------------");
                } 
                else 
                {
                    numberGuess++;
                    System.out.println(name + ", the number you have guessed is too low. Please try again.");
                    name = p1name;
                    pturn--;
                    System.out.println("---------------------------------------------------------------------------------------------");
                }

            } 
            else if (guess > randomNum) 
            {

                if (pturn == 1) 
                {
                    numberGuess++;
                    System.out.println(name + ", the number you have guessed is too high. Please try again.");
                    name = p2name;
                    pturn++;
                    System.out.println("---------------------------------------------------------------------------------------------");
                } 
                else
                {
                    numberGuess++;
                    System.out.println(name + ", the number you have guessed is too high. Please try again.");
                    name = p1name;
                    pturn--;
                    System.out.println("---------------------------------------------------------------------------------------------");
                }

            } 
            
            else 
            {
                if (pturn == 1) 
                {
                    numberGuess++;
                    System.out.println(name + ", the statement you have guessed is invalid. Please try again.");
                    name = p2name;
                    pturn++;
                    System.out.println("---------------------------------------------------------------------------------------------");
                } 
                else 
                {
                    numberGuess++;
                    System.out.println(name + ", the statement you have guessed is invalid. Please try again.");
                    name = p1name;
                    pturn--;
                    System.out.println("---------------------------------------------------------------------------------------------");
                }

            }

        }

    }

    public void multiLevel() 
    {
        System.out.println("---------------------------------------------------------------------------------------------");
        System.out.println("Welcome to the hard level.\n\nRules: "
                + "\nScoring is based on the number of levels you reach (100 points possible for the first level, 200 points possible for the second level, and so on)."
                + "\nYou must guess a number between 1 and 50 in a limited amount of tries to success to the next level."
                + "\nYou complete the game when you pass all 5 levels."
                + "");
        System.out.println("\nWhat is your name?");
        p1name = x.next();
        p2name = p1name;
        name = p1name;
        name = p2name;
        
        for (int i = 5; i < 30; i += 5) 
        {
            triesLeft = 30;
            levelPoints = 30-i;
            randomNum = (rand.nextInt(49) +1); 
            System.out.println("---------------------------------------------------------------------------------------------");
            System.out.println("Welcome to level " + (i / 5));
            System.out.println("\nYou have " + (triesLeft -= i) + " tries to complete this level.");

            while (win == false) 
            {
                System.out.println(name + ", please guess a number between 1 and 50");
                String response = x.next();
                int guess = Integer.parseInt(response);

                if (guess == randomNum) 
                {
                    System.out.println(name + ", you have correctly guessed the number. The correct number was " + randomNum + ".");
                    System.out.println("You had " + (triesLeft-1) + " tries left.");
                    win = true;
                    System.out.println("---------------------------------------------------------------------------------------------");
                    break;
                } 
                else if (guess < randomNum) 
                {
                    System.out.println(name + ", the number you have guessed is too low. Please try again. You have " + (triesLeft-1) + " tries left.");
                    name = p2name;
                    pturn++;
                    System.out.println("---------------------------------------------------------------------------------------------");
                    triesLeft--;
                } 
                else if (guess > randomNum) 
                {
                    System.out.println(name + ", the number you have guessed is too high. Please try again. You have " + (triesLeft-1) + " tries left.");
                    name = p2name;
                    System.out.println("---------------------------------------------------------------------------------------------");
                    triesLeft--;
                } 
                else 
                {
                    System.out.println(name + ", the statement you have guessed is invalid. Please try again. You have " + (triesLeft-1) + " tries left.");
                    name = p2name;
                    System.out.println("---------------------------------------------------------------------------------------------");
                    triesLeft--;
                }

                if (triesLeft <= 0 && win != true)
                {
                    System.out.println("You have used all your tries. You receive " + (int)playerPoints + " points.");
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                }
            }
                levelMultiplier = (100*(i/5));
                totalPoints = ((triesLeft-1)/levelPoints) * levelMultiplier; 
                playerPoints+=totalPoints;
                System.out.println("You now have " + (int)playerPoints + " points."); 
                win = false;
                levelPoints = 0;
        }
    }
}
