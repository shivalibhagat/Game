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
	
}
void fillGrid()
{
	for(int x=0;x<noOfInput;x++)
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
