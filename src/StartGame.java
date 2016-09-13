/*
 * StartGame.java is the gui for our project
 * User enters the coordinates and the main program calls input()
 * That's all this class does
 * 
 */
public class StartGame {
	public static void main (String args[])
	{
	GameOfLife g=new GameOfLife();
	System.out.println("Enter : ");
	g.input();
	
	/*g.displayGrid();
	g.nextStep();
	System.out.println("Display :");
	g.displayGrid();
	*/	
		
	}

	
}
