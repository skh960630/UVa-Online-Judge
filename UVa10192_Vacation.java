import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa10192_Vacation {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		int n = 0;
		
		while((input = br.readLine()) != null)
		{
			if(input.equals("#"))
					return;
			
			++n;
			String other = br.readLine();
			
			System.out.println("Case #" +n +": you can visit at most " 
			+getMax(input, other) +" cities.");
			
		}
	}
	
	static int getMax(String first, String second)
	{
		int[][] temp = new int[first.length()+1][second.length()+1];
		
		for(int i = 0 ; i <= first.length(); i++)
			temp[i][0] = 0;
		
		for(int j = 0; j <= second.length(); j++)
			temp[0][j] = 0;
		
		for(int k = 1; k <= first.length(); k++)
		{
			for(int l = 1; l <= second.length(); l++)
			{
				if(first.charAt(k-1) == second.charAt(l-1))
					temp[k][l] = 1 + temp[k-1][l-1];
				else
					temp[k][l] = Math.max(temp[k-1][l], temp[k][l-1]);
			}
		}
		
		return temp[first.length()][second.length()];
	}

}
