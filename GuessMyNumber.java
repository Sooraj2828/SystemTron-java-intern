import java.util.*;

public class GuessMyNumber {
  public static void main(String[] args) {
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    System.out.println("DO YOU WANT TO PLAY GAME? (Y/N)");
    String ch = sc.nextLine().toLowerCase();
    boolean flag = true;
    int count = 0;

    while (flag) {
      int randNo = rand.nextInt(20);
      while (true) {
        if (ch.equals("y")) {
          System.out.println("Guess a number:");
          int Guess = sc.nextInt();
          count++;

          if (Guess == randNo) {
            System.out.println("CORRECT GUESS! 👍");
            System.out.println("You took " + count + " chances to guess.");
            break;
          } else if (Guess > randNo) {
            System.out.println("Your guess is too high!");
          } else {
            System.out.println("Your guess is too low!");
          }
        } else {
          System.out.println("You missed a chance!!!!!!!");
          System.exit(0);
        }
      }
      System.out.println("Want to play another game? 🤩 (Y/N)");
      String ch1 = sc.next().toLowerCase();

      if (ch1.equals("y")) {
        count = 0;
        flag = true;
      } else {
    	  System.out.println("Thank you for playing");
          break;  
      }
    }
  }
}