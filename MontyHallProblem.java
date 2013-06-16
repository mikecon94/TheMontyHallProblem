import java.util.Scanner;
import java.util.Random;

public class MontyHallProblem
{
  public static double totalGames = 0;
  public static double totalGamesWon = 0;
  public static double switches = 0;
  public static double switchWins = 0;
  public static double percentage = 0;
  public static double switchPercentage = 0;
  public static double noneSwitchPercentage = 0;
  
  public static void main(String[] args)
  {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    String[] doors = new String[3];
    int showDoor;
    int chosenDoor;
    int count = 0;
    while(true) //If using a file change to while(count< number inputs)
    {
      count++;
      System.out.printf("Total Games:                         %1$.0f\n", totalGames);
      System.out.printf("Number of Wins:                      %1$.0f\n", totalGamesWon);
      System.out.printf("Number of times Switched             %1$.0f\n", switches);
      System.out.printf("Number of wins after switching       %1$.0f\n", switchWins);
      System.out.printf("Number of times not switched         %1$.0f\n", (totalGames - switches));
      System.out.printf("Number of time won without switching %1$.0f\n", (totalGamesWon - switchWins));
      System.out.printf("Percentage of wins                   %1$.2f%%\n", percentage);
      System.out.printf("Percentage of wins after switching   %1$.2f%%\n", switchPercentage);
      System.out.printf("Percentage without switching         %1$.2f%%\n", noneSwitchPercentage);
      System.out.println();
      showDoor = 5;
      chosenDoor = 5;
      printDoors(doors, chosenDoor, showDoor);
      createDoors(rand, doors);
      System.out.print("Choose a door (1, 2 or 3): ");
      chosenDoor = input.nextInt() - 1;
      printDoors(doors, chosenDoor, showDoor);
      System.out.println("The host reveals one of the losing doors...");
      System.out.println();
      boolean badShow = true;
      while(badShow)
      {
        showDoor = rand.nextInt(3);
        if(doors[showDoor] == "Win")
        {
          badShow = true;
        }
        else
        {
          badShow = showDoor == chosenDoor ? true : false;
        }
      }
      printDoors(doors, chosenDoor, showDoor);
      System.out.print("Switch choice? (y/n) ");
      input.nextLine();
      String change = input.nextLine().toLowerCase();
      if("y".equals(change))
      {
        switches++;
        chosenDoor = (chosenDoor != 0 && showDoor != 0) ? 0 : (chosenDoor != 1 && showDoor != 1) ? 1 : 2;        
      }
      printDoors(doors, chosenDoor, showDoor);
      printOpenDoors(doors, chosenDoor);
      System.out.println("Win".equals(doors[chosenDoor]) ? "You Win" : "You Lose");
      System.out.println();
      if("Win".equals(doors[chosenDoor]))
      {
        totalGamesWon++;
        switchWins += "y".equals(change) ? 1 : 0;
      }
      totalGames++;
      calculatePercentages(change);
    }
    System.out.printf("Total Games:                         %1$.0f\n", totalGames);
    System.out.printf("Number of Wins:                      %1$.0f\n", totalGamesWon);
    System.out.printf("Number of times Switched             %1$.0f\n", switches);
    System.out.printf("Number of wins after switching       %1$.0f\n", switchWins);
    System.out.printf("Number of times not switched         %1$.0f\n", (totalGames - switches));
    System.out.printf("Number of time won without switching %1$.0f\n", (totalGamesWon - switchWins));
    System.out.printf("Percentage of wins                   %1$.2f%%\n", percentage);
    System.out.printf("Percentage of wins after switching   %1$.2f%%\n", switchPercentage);
    System.out.printf("Percentage without switching         %1$.2f%%\n", noneSwitchPercentage);
  } //main
  
  public static void calculatePercentages(String change)
  {
    percentage = (totalGamesWon / totalGames) * 100;
    switchPercentage = (switchWins / switches) * 100;
    noneSwitchPercentage = ((totalGamesWon - switchWins) / (totalGames - switches)) * 100;
  }
  
  public static void printOpenDoors(String[] doors, int chosenDoor)
  {
    System.out.println("1 - " + doors[0] + (chosenDoor == 0 ? " - Chosen" : ""));
    System.out.println("2 - " + doors[1] + (chosenDoor == 1 ? " - Chosen" : ""));
    System.out.println("3 - " + doors[2] + (chosenDoor == 2 ? " - Chosen" : ""));
    System.out.println();
  }
  
  public static void printDoors(String[] doors, int chosenDoor, int showDoor)
  {
    System.out.println();
    System.out.println("1 - " + (chosenDoor == 0 ? "Chosen " : showDoor == 0 ? doors[showDoor] : "Closed "));
    System.out.println("2 - " + (chosenDoor == 1 ? "Chosen " : showDoor == 1 ? doors[showDoor] : "Closed "));
    System.out.println("3 - " + (chosenDoor == 2 ? "Chosen " : showDoor == 2 ? doors[showDoor] : "Closed "));
    System.out.println();
  }
  
  public static void createDoors(Random rand, String[] doors)
  {
    int winner = rand.nextInt(3) + 1;
    switch(winner)
    {
      case 1: doors[0] = "Win";
              doors[1] = "Lose";
              doors[2] = "Lose";
              break;
      case 2: doors[0] = "Lose";
              doors[1] = "Win";
              doors[2] = "Lose";
              break;
      case 3: doors[0] = "Lose";
              doors[1] = "Lose";
              doors[2] = "Win";
              break;
    }
  }
  
} //class