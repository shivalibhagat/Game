
public class StartGame {
	public static void main (String args[])
	{
	GameOfLife g=new GameOfLife();
	System.out.println("Enter : ");
	g.input();
	g.fillGrid();
	g.displayGrid();
	g.nextGeneration();
	System.out.println("Display :");
	g.displayGrid();
		
		
	}

}
