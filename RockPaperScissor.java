import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {

	public static void main(String[] args) {
		Random rand = new Random();
		Scanner sc= new Scanner(System.in);
		System.out.println("ROCK, PAPER AND SCISSOR GAME\n0.Rock \n1.Paper \n2.Scissor");	
		Boolean game = true;
		while(game) {
			int r = rand.nextInt(2);
			String comp = varassign(r);
			while(true) {
				System.out.println("---------------------------");
				System.out.println("Computer has made its choice ");
				System.out.println("Enter your choice :");
				int p = sc.nextInt();
				String Player = varassign(p);
				if(comp == Player) {
					System.out.println("Game draw");
				}
				else if((comp == "rock" && Player == "scissor" )||(comp == "paper" && Player == "rock")||(comp == "scissor" && Player == "paper"))  {
					System.out.println("The computer choice :"+comp);
					System.out.println("Your choice :"+Player);
					System.out.println("computer won the game");
				}
				else {
					System.out.println("The computer choice :"+comp);
					System.out.println("Your choice :"+Player);
					System.out.println("Player won the game");
				}
				System.out.println("\nWant to play game ?(Y/N)");
				char c=sc.next().charAt(0);
				if(c == 'y' || c == 'y') {
					game=true;
					break;
				}
				else {
					game = false;
					break;
				}
			}
		}

	}

	static String varassign(int r) {
		String var="";
		switch(r){
		case 0:var="rock";
		break;
		case 1:var="paper";
		break;
		case 2:var="scissor";
		break;
		}
		return var;
	}
}



