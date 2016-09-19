import java.util.Scanner;

public class StartGame {
	static GameOfLife g = new GameOfLife();
	static void decision()
	{
		while(true){
			System.out.println("Show next generation? Y/N");
			Scanner scan=new Scanner(System.in);
			char dcs = scan.nextLine().charAt(0);
			if(dcs == 'y'){
				g.nextGeneration();
			}
			else if(dcs == 'Y'){
				g.nextGeneration();
			}
			else break;
		}
	}
	
	public static void main (String args[])
	{
		System.out.println("Enter (x,y) co-ordinates : ");
		g.input();
		System.out.println("Display :");
		g.displayGrid();
		decision();
	}	
}