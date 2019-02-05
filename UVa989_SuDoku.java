import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class UVa989_SuDoku {
	
	static int grid[][];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		PrintWriter pw = new PrintWriter(System.out);
		
		while((input = br.readLine()) != null)
		{
			int n = (int)Math.pow(Integer.parseInt(input), 2);
			grid = new int[n][n];
			
			for(int i = 0; i < n; i++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < n; j++)
				{
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			boolean solved = solve(0, 0, n);
			
			if(solved)
			{
				for(int x = 0; x < n; x++)
				{
					for(int y = 0; y < n; y++)
					{
						pw.print(grid[x][y]);
						
						if(y != n-1)
						{
							pw.print(" ");
						}
					}
					
					pw.println();
				}
			}
			else
			{
				pw.println("NO SOLUTION");
			}
			
			if((input = br.readLine()) == null)
			{
				break;
			}
			
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
	
	static boolean solve(int i, int j, int n)
	{
		if(j == n)
		{
			++i;
			j = 0;
		}
		
		if(i == n)
		{
			return true;
		}
		
		if(grid[i][j] != 0)
		{
			return solve(i, j+1, n);
		}
		
		for(int k = 1; k <= 9; k++)
		{
			if(valid(i, j, n, k))
			{
				grid[i][j] = k;
				
				if(solve(i, j+1, n))
				{
					return true;
				}
				else
				{
					grid[i][j] = 0;
				}
			}
		}
		
		return false;
	}
	
	static boolean valid(int i, int j, int n, int value)
	{
		for(int x = 0; x < n; x++)
		{
			if(grid[i][x] == value)
			{
				return false;
			}
			
			if(grid[x][j] == value)
			{
				return false;
			}
		}
		
		int each = (int)Math.sqrt(n);
		
		int row = each*(i/each);
		int col = each*(j/each);
		int rowLimit = row+each;
		int colLimit = col+each;
		
		for(int a = row; a < rowLimit; a++)
		{
			for(int b = col; b < colLimit; b++)
			{
				if(grid[a][b] == value)
				{
					return false;
				}
			}
		}
		
		return true;
	}

}
