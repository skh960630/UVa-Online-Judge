import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa1223_Editor {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++)
		{
			String input = br.readLine();
			int[][] results = new int[input.length()+1][input.length()+1];
			int max = 0;
			
			for(int j = 1; j <= input.length(); j++)
			{
				for(int k = j+1; k <= input.length(); k++)
				{
					if(input.charAt(j-1) == input.charAt(k-1))
					{
						results[j][k] = results[j-1][k-1]+1;
						
						if(max < results[j][k])
						{
							max = results[j][k];
						}
					}
					else
					{
						results[j][k] = 0;
					}
				}
			}
			
			pw.println(max);
		}
		
		pw.flush();
		pw.close();
	}

}
