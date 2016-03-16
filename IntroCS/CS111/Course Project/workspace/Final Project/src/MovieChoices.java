import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class MovieChoices {



	public MovieChoices()
	{
		
	}
	
	public void chooseGenre() throws IOException{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number for the genre you desire from the list above: ");
		int choice = scan.nextInt();
		MovieList movieList = new MovieList();
		
		if (choice ==1){
			movieList.Action();
		}
			
		
		else if (choice == 2){
			movieList.Classic();
			}
		
		else if (choice ==3){
			movieList.Comedy();
		}
		else if (choice == 4){
			movieList.Drama();
		}
		else if (choice == 5){
			movieList.Historical();
		}
		else if (choice == 6){
			movieList.Horror();
			
		}
		else if (choice == 7){
			movieList.Mystery();
		}
		else if (choice == 8){
			movieList.Romance();
		}
		else if (choice == 9){
			movieList.Romcom();
		}
		else if (choice == 10){
			movieList.Scifi();
		}
		else {
			System.out.println("Invalid input.");
		}
			
	}
	
	public void chooseRandom() throws IOException{
		Random rand = new Random();
		MovieList movieList = new MovieList();
		int num = rand.nextInt(10);
		if (num==0){
			System.out.println("Your random genre is: Action");
			movieList.Action();
		}
		else if (num ==1){
			System.out.println("Your random genre is: Classic");
			movieList.Classic();
		}
		else if (num ==2){
			System.out.println("Your random genre is: Comedy");
			movieList.Comedy();
		}
		else if(num == 3){
			System.out.println("Your random genre is: Drama");
			movieList.Drama();
		}
		else if(num == 4){
			System.out.println("Your random genre is: Historical");
			movieList.Historical();
		}
		else if(num ==5){
			System.out.println("Your random genre is: Horror");
			movieList.Horror();
		}
		else if(num == 6){
			System.out.println("Your random genre is: Mystery");
			movieList.Mystery();
		}
		else if(num == 7){
			System.out.println("Your random genre is: Romance");
			movieList.Romance();
		}
		else if(num ==8){
			System.out.println("Your random genre is: Romantic Comedy");
			movieList.Romcom();
		}
		else {
			System.out.println("Your random genre is: Science Fiction");
			movieList.Scifi();
		}
	}
	
}