import java.io.IOException;
import java.util.Scanner;


public class MainMovie {

	public static void main(String[] args) throws IOException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to Movie Magic!!!!");
		System.out.println("Here is a list of all the movie genres: (1)Action, (2)Classic, (3)Comedy, (4)Drama, (5)Historical, (6)Horror, (7)Mystery, (8)RomCom, (9)Romance, (10)SciFi.");
		System.out.println("You can choose from two options: ");
		System.out.println("1. I want to choose a genre!"); 
		System.out.println("2. Have Movie Majic choose a genre for me!\n");
		System.out.println("Please enter the number of the choice you select: ");
		int choice = scan.nextInt();
		
		MovieChoices movieChoices = new MovieChoices();
		if (choice == 1){
			movieChoices.chooseGenre();
		}
		else if (choice ==2){
			movieChoices.chooseRandom();
		}
		
		
		}
}
