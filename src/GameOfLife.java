/*
 * GameOfLife.java contains:
 * input() - takes in coordinates and create a 20x20 grid all cells initially 0
 * 			 call the generateGrid(), 
 * 			 passing x and y coordinates
 * generateGrid() - receive coordinates and change dead (0) status to alive (1),
 * 					call display()
 * display() - just show the grid and status of all cells
 * nextStep() - ask user to input either n(next gen) or e(exit), case insensitive
 * 				call nextGeneration()
 * nextGeneration() - check status of 8 neighbors of intended cell
 * 
 * 
 * Game Rules:
 * 	1. live cell with 2 or 3 live neighbors remain alive
 * 	2. live cell with <2 or >3 live neighbors die
 * 	3. dead cell with 3 live neighbors become alive
 * 
 */


import java.util.Scanner;

public class GameOfLife {
int input[][];
int grid[][];
int size=20;
int noOfInput;
int neighbour[];
GameOfLife()
{
	grid=new int[size][size];
	for(int i=0;i<size;i++)
	{
		for(int j=0;j<size;j++)
		{
			grid[i][j]=0;
		}
	}
}

void input()
{
	Scanner scan=new Scanner(System.in);
	 noOfInput=0;
	
	 input=new int[10][10];
	 int x,y;
	 x=scan.nextInt();
	 y=scan.nextInt();
	 while((x!=-1)&& (y!= -1)){		 
		 input[noOfInput][0]=x;
		 input[noOfInput][1]=y;
		 x=scan.nextInt();
		 y=scan.nextInt();
		 noOfInput++;
	 }
	 /*
	 do{
	 x=scan.nextInt();
	 y=scan.nextInt();
	 if(x!=-1 && y!=-1)
	 {
	 input[noOfInput][0]=x;
	 input[noOfInput][1]=y;
	 noOfInput++;
	 }
		}while((x!=-1)&& (y!= -1));
	//noOfInput--;
	 */
	 //fill grid
	 fillGrid(noOfInput);
	
}
//ask user if next gen or stop
public void nextStep(){
	Scanner stdin = new Scanner(System.in);
	
	System.out.println("N=Next Generation E=Exit: ");
	String text = stdin.nextLine();
	char txt = text.charAt(0);
	switch(txt){
	case 'N':
		nextGeneration();
		break;
	case 'n':
		nextGeneration();
		break;
	case 'E':
		System.exit(0);
	case 'e':
		System.exit(0);;
	default:
		nextStep();
	}
}

void fillGrid(int n)
{
	for(int x=0;x<n;x++)
	{
			grid[input[x][0]][input[x][1]]=1;	
			
	}
	
}

void nextGeneration()
{
	
	
	for(int x=0;x<noOfInput;x++)
	{
	  
      checkNeighbour(x,input[x][0],input[x][1]);
	}
	for(int x=0;x<noOfInput;x++)
	{
	 checkNeighbour(x,input[x][0]-1,input[x][1]);
	}
     //checkNeighbour(x,input[x][0],input[x][1]-1);
    //checkNeighbour(x,input[x][0]+1,input[x][1]);
    //checkNeighbour(x,input[x][0],input[x][1]+1);
    //checkNeighbour(x,input[x][0]+1,input[x][1]+1);
    //checkNeighbour(x,input[x][0]-1,input[x][1]-1);
	for(int x=0;x<noOfInput;x++)
	{
		
	
	//checkExistance(neighbour[x],input[x][0]-1,input[x][1]);
   // checkExistance(neighbour[x],input[x][0],input[x][1]-1);
    //checkExistance(neighbour[x],input[x][0]+1,input[x][1]);
    //checkExistance(neighbour[x],input[x][0],input[x][1]+1);
    //checkExistance(neighbour[x],input[x][0]+1,input[x][1]+1);
    //checkExistance(neighbour[x],input[x][0]-1,input[x][1]-1);
	
	}
	
}


void checkNeighbour(int position,int x,int y)
{
	neighbour=new int[noOfInput];
	
	if(x!=(size-1))
	{
		if(grid[x+1][y]==1)
			{
			neighbour[position]++;	
			}
	}
	if(y!=(size-1))
	{
	
		if(grid[x][y+1]==1)
			{
			neighbour[position]++;	
			}
	}
	
	if(x!=0)
	{
		if(grid[x-1][y]==1)
			{
			neighbour[position]++;		
			}
	}
	if(y!=0)
	{
	
		if(grid[x][y-1]==1)
			{
			neighbour[position]++;	
			}
	}
	
	if(x!=(size-1) && y!=(size-1))
	{
		if(grid[x+1][y+1]==1)
		{
			neighbour[position]++;	
		}
	}

	if(x!=0 && y!=0)
	{
		if(grid[x-1][y-1]==1)
		{
			neighbour[position]++;	
		}
	}
	
	System.out.println("neighbour :" + neighbour[position]);
	checkExistance(neighbour[x],input[x][0],input[x][1]);
	
}

void checkExistance(int neighbour,int x,int y)
{
	if((neighbour==0||neighbour==1||neighbour>3))
	{
		
		grid[x][y]=0;
		
		
	}
	else if (neighbour==3)
	{
		grid[x][y]=1;
		
		
	}
	
	
}


void displayGrid()
{
	for(int i=0;i<size;i++)
	{
		for(int j=0;j<size;j++)
		{
			System.out.print(grid[i][j] + " ");
			
		}
		System.out.println();
		
	}
}


}
