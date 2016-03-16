import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class MovieGenre {

<<<<<<< HEAD

	//constructor
	public MovieGenre()
	{

	}

=======
	
	//constructor
	public MovieGenre()
	{
		
	}
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	//methods to read in array lists for different movie classes
	public String Action() throws IOException
	{
		ArrayList<String> ActionArray = new ArrayList<String>();
		File actionList = new File("ArrayAction.txt");
		Scanner scan1 = new Scanner(actionList);
		while(scan1.hasNextLine() == true){
			String movie = scan1.nextLine();
			ActionArray.add(movie);
			//System.out.println("Adding action list ");
		}
		int size = ActionArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = ActionArray.get(randnum);
		System.out.println(movie);
		ActionArray.remove(randnum);
		return movie;
	}
<<<<<<< HEAD

=======
	
	
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String Classic() throws IOException
	{
		ArrayList<String> ClassicArray = new ArrayList<String>();
		File classicList = new File("ArrayClassic");
		Scanner scan2 = new Scanner(classicList);
		while(scan2.hasNextLine() == true ){
<<<<<<< HEAD
		String movie = scan2.nextLine();
		ClassicArray.add(movie);
=======
			System.out.println("Adding array classic");
			String movie = scan2.nextLine();
			ClassicArray.add(movie);
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
		}
		int size = ClassicArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = ClassicArray.get(randnum);
<<<<<<< HEAD
        System.out.println(movie);
		ClassicArray.remove(randnum);
		return movie;
	}

=======
		ClassicArray.remove(randnum);
		return movie;

	}
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String Drama() throws IOException
	{
		ArrayList<String> DramaArray = new ArrayList<String>();
		File dramaList = new File("ArrayDrama");
		Scanner scan3 = new Scanner(dramaList);
		while(scan3.hasNext() == true){
			String movie = scan3.nextLine();
			DramaArray.add(movie);}
		int size = DramaArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = DramaArray.get(randnum);
		System.out.println(movie);
		DramaArray.remove(randnum);
		return movie;

	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String Historic() throws IOException
	{
		ArrayList<String> HistoricArray = new ArrayList<String>();
		File historicList = new File("ArrayHistorical");
		Scanner scan4 = new Scanner(historicList);
		while(scan4.hasNext() == true){
			String movie = scan4.nextLine();
			HistoricArray.add(movie);}
		int size = HistoricArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = HistoricArray.get(randnum);
		System.out.println(movie);
		HistoricArray.remove(randnum);
		return movie;

	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String Horror() throws IOException
	{
		ArrayList<String> HorrorArray = new ArrayList<String>();
		File horrorList = new File("ArrayHorror");
		Scanner scan5 = new Scanner(horrorList);
		while(scan5.hasNext() == true){
			String movie = scan5.nextLine();
			HorrorArray.add(movie);}
		int size = HorrorArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = HorrorArray.get(randnum);
		System.out.println(movie);
		HorrorArray.remove(randnum);
		return movie;

	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String Mystery()throws IOException
	{
		ArrayList<String> MysteryArray = new ArrayList<String>();
		File mysteryList = new File("ArrayMystery");
		Scanner scan6 = new Scanner(mysteryList);
		while(scan6.hasNext() == true){
			String movie = scan6.nextLine();
			MysteryArray.add(movie);}
		int size = MysteryArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = MysteryArray.get(randnum);
		System.out.println(movie);
		MysteryArray.remove(randnum);
		return movie;
	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String Romance()throws IOException{
		ArrayList<String> RomanceArray = new ArrayList<String>();
		File romanceList = new File("ArrayRomance");
		Scanner scan7 = new Scanner(romanceList);
		while(scan7.hasNext() == true){
			String movie = scan7.nextLine();
			RomanceArray.add(movie);}
		int size = RomanceArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = RomanceArray.get(randnum);
		System.out.println(movie);
		RomanceArray.remove(randnum);
		return movie;
	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String RomCom()throws IOException{
		ArrayList<String> RomcomArray = new ArrayList<String>();
		File romcomList = new File("ArrayRomCom");
		Scanner scan8 = new Scanner(romcomList);
		while(scan8.hasNext() == true){
			String movie = scan8.nextLine();
			RomcomArray.add(movie);}
		int size = RomcomArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = RomcomArray.get(randnum);
		System.out.println(movie);
		RomcomArray.remove(randnum);
		return movie;
	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String SciFi()throws IOException{
		ArrayList<String> ScifiArray = new ArrayList<String>();
		File scifiList = new File("ArraySciFi");
		Scanner scan9 = new Scanner(scifiList);
		while(scan9.hasNext() == true){
			String movie = scan9.nextLine();
			ScifiArray.add(movie);}
		int size = ScifiArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = ScifiArray.get(randnum);
		System.out.println(movie);
		ScifiArray.remove(randnum);
		return movie;
	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
	public String Comedy()throws IOException{
		ArrayList<String> ComedyArray = new ArrayList<String>();
		File comedyList = new File("Comedy");
		Scanner scan10 = new Scanner(comedyList);
		while(scan10.hasNext() == true){
			String movie = scan10.nextLine();
			ComedyArray.add(movie);}
		int size = ComedyArray.size();
		Random rand = new Random();
		int randnum = rand.nextInt(size);
		String movie = ComedyArray.get(randnum);
		System.out.println(movie);
		ComedyArray.remove(randnum);
		return movie;
	}
<<<<<<< HEAD

=======
	
>>>>>>> ba64c769d38aa00f06f81fa527c792b4cac9e416
}
