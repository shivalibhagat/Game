public class Cell
{
	public static char aliveChar = 'x';
	public static char deadChar = 'o';
	public Boolean alive;
	public Cell(Boolean state)
	{
		this.alive = state;
	}
}