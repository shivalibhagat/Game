import java.util.ArrayList;
import java.util.Scanner;

public class GameOfLife
{
	int size=20;
	static ArrayList<Cell> cells = new ArrayList<Cell>();

	GameOfLife()
	{
		for (int i = 0; i < size * size; i++) 
			cells.add(new Cell(false));
	}

	void input()
	{
		 Scanner scan=new Scanner(System.in);	
		 int x,y;
		 do{
			 x=scan.nextInt();
			 y=scan.nextInt();
			 if((x!=-1)&& (y!= -1))
				 stateChange(x,y);
		 }while((x!=-1)&& (y!= -1));
	}

	void stateChange(int x, int y)
	{
		if (x < size && y < size)
		{
			cells.get(size * y + x).alive = true;
		}
	}

	void displayGrid()
	{
		for (int i = 0; i <= size; i++)
			System.out.println();
		for (int y = 0; y < size; y++)
		{
			for (int x = 0; x < size; x++)
			{
				if (cells.get(size * y + x).alive == true)
					System.out.print(Cell.aliveChar);
				else System.out.print(Cell.deadChar);
			}
			System.out.println();
		}
	}
	
	void nextGeneration()
	{
		ArrayList<Cell> newCells = new ArrayList<Cell>();
		for (Cell cell : cells)
		{
			int index = cells.indexOf(cell);
			int liveNeighbors = 0;
			
			//left
			if (index - 1 > -1 && cells.get(index - 1).alive == true)
				liveNeighbors++;
			//top left
			if (index + size - 1 < cells.size() && cells.get(index + size - 1).alive == true)
				liveNeighbors++;
			//up
			if (index - size > -1 && cells.get(index - size).alive == true)
				liveNeighbors++;
			//top right
			if (index + size + 1 < cells.size() && cells.get(index + size + 1).alive == true)
				liveNeighbors++;
			//right
			if (index + 1 < cells.size() && cells.get(index + 1).alive == true)
				liveNeighbors++;
			//bottom right
			if (index - size + 1 > -1 && cells.get(index - size + 1).alive == true)
				liveNeighbors++;
			//down
			if (index + size < cells.size() && cells.get(index + size).alive == true)
				liveNeighbors++;
			//bottom left
			if (index - size - 1 > -1 && cells.get(index - size - 1).alive == true)
				liveNeighbors++;
			
			if (cell.alive)
			{
				if (liveNeighbors < 2)
					newCells.add(new Cell(false));
				else if (liveNeighbors == 2 || liveNeighbors == 3)
					newCells.add(new Cell(true));
				else if (liveNeighbors > 3)
					newCells.add(new Cell(false));
			}
			else if (liveNeighbors == 3)
					newCells.add(new Cell(true));
			else newCells.add(new Cell(false));		
		}
		cells = newCells;
		displayGrid();
	}
}