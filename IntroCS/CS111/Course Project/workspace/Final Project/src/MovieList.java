import java.io.IOException;
import java.util.Scanner;
public class MovieList {

	
	public MovieList()
	{}
	
	MovieGenre movieGenre = new MovieGenre();
	Scanner scan = new Scanner(System.in);
	
	
	public void Action() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Action movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Action movie " +movieGenre.Action() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Action movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Action();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Action movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Action();
				count++;
			}
		}
	}
	
	public void Classic() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Classic movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Action movie " +movieGenre.Classic() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Classic movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Classic();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Classic movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Classic();
				count++;
			}
		}
	}
	
	
	public void Comedy() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Comedy movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Comedy movie " +movieGenre.Comedy() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Comedy movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Comedy();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Comedy movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Comedy();
				count++;
			}
	}
	}
	
	public void Drama() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Drama movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Action movie " +movieGenre.Drama() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Drama movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Drama();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Drama movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Drama();
				count++;
			}
	}
	}
	
	public void Historical() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Historical movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Historical movie " +movieGenre.Historic() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Historical movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Historic();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Historical movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Historic();
				count++;
			}
	}
	}
	
	public void Horror() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Horror movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Horror movie " +movieGenre.Horror() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Horror movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Horror();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Horror movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Horror();
				count++;
			}
	}
	}
	
	public void Mystery() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Mystery movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Mystery movie " +movieGenre.Mystery() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Mystery movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Mystery();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Mystery movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Mystery();
				count++;
			}
		}
	}
	
	public void Romance() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Romance movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Romance movie " +movieGenre.Romance() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Romance movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.Romance();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Romance movies: ");
			int count = 0;
			while (count <100){
				movieGenre.Romance();
				count++;
			}
	}
	}
	
	public void Romcom() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of RomCom movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the RomCom movie " +movieGenre.RomCom() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 RomCom movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.RomCom();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of RomCom movies: ");
			int count = 0;
			while (count <100){
				movieGenre.RomCom();
				count++;
			}
	}
	}
	
	public void Scifi() throws IOException{
		System.out.println("Do you want: \n1. Single random movie selection \n2. A list of 10 movies \n3. Or the whole list of Sci-Fi movies? ");
		System.out.println("Enter the number of your choice: ");
		int what = scan.nextInt();
		if (what == 1){
			System.out.println("Movie Majic has choosen the Sci-Fi movie " +movieGenre.SciFi() +" for you.");
		}
		else if (what == 2){
			System.out.println("Movie Majic has choosen these 10 Sci-Fi movies for you: ");
			for (int count = 0; count<10; count++){
				movieGenre.SciFi();
			}
		}
		else if (what == 3){
			System.out.println("Here is Movie Majic's entire list of Sci-Fi movies: ");
			int count = 0;
			while (count <100){
				movieGenre.SciFi();
				count++;
			}
	}
	}
	
	
}
