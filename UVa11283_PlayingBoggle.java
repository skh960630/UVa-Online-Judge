import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class UVa11283_PlayingBoggle {
	static char[][] grid;
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= t; i++)
		{
			br.readLine();
			grid = new char[4][4];
			
			for(int j = 0; j < 4; j++)
			{
				String input = br.readLine();
				
				for(int k = 0; k < 4; k++)
				{
					grid[j][k] = input.charAt(k);
				}
			}
			
			int score = 0;
			String input = br.readLine().trim();
			
			if(!input.isEmpty())
			{
				int n = Integer.parseInt(input);
				
				for(int k = 0; k < n; k++)
				{
					String word = br.readLine().trim();
					boolean solved = false;
					
					for(int a = 0; a < 4; a++)
					{
						for(int b = 0; b < 4; b++)
						{
							if(grid[a][b] == word.charAt(0))
							{
								ArrayList<Integer> tempX = new ArrayList<>();
								ArrayList<Integer> tempY = new ArrayList<>();
								tempX.add(a);
								tempY.add(b);
								
								if(solve(word, 1, a, b, tempX, tempY))
								{
									solved = true;
									break;
								}
							}
						}
					}
					
					if(solved)
					{
						if(word.length() <= 4)
						{
							score += 1;
						}
						else if(word.length() == 5)
						{
							score += 2;
						}
						else if(word.length() == 6)
						{
							score += 3;
						}
						else if(word.length() == 7)
						{
							score += 5;
						}
						else
						{
							score += 11;
						}
					}
				}
				
			}
			
			System.out.println("Score for Boggle game #" +i +": " +score);
		}
		
		pw.flush();
		pw.close();
	}
	
	static boolean solve(String s, int n, int x, int y, 
			ArrayList<Integer> usedX, ArrayList<Integer> usedY)
	{
		if(n == s.length())
		{
			return true;
		}
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 4; j++)
			{
				if(grid[i][j] == s.charAt(n))
				{
					boolean availability = true;
					
					for(int k = 0; k < usedX.size(); k++)
					{
						if(usedX.get(k) == i && usedY.get(k) == j)
						{
							availability = false;
							break;
						}
					}
					
					if(availability)
					{
						if(i-1 == x && j-1 == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
						else if(i-1 == x && j == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
						else if(i-1 == x && j+1 == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
						else if(i == x && j-1 == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
						else if(i == x && j+1 == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
						else if(i+1 == x && j-1 == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
						else if(i+1 == x && j == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
						else if(i+1 == x && j+1 == y)
						{
							ArrayList<Integer> tempX = new ArrayList<>();
							ArrayList<Integer> tempY = new ArrayList<>();
							tempX.addAll(usedX);
							tempY.addAll(usedY);
							tempX.add(i);
							tempY.add(j);
							
							if(solve(s, n+1, i, j, tempX, tempY))
							{
								return true;
							}
						}
					}
				}
			}
		}
		
		return false;
	}

}
