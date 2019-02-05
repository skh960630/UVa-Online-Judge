import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa12482_ShortStoryCompetition {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			String[] split = input.split(" ");
			int n = Integer.parseInt(split[0]); // number of words
			int l = Integer.parseInt(split[1]); // max nums of lines per page
			int c = Integer.parseInt(split[2]); // max chars per line
			
			split = br.readLine().split(" ");
			int total = 0;
			int line = 1;
			int page = 1;
			
			for(int i = 0; i < n; i++)
			{
				int temp = total+split[i].length();
				
				if(temp > c)
				{
					++line;
					total = split[i].length()+1;
				}
				else
					total = temp+1;
				
				if(line > l)
				{
					line = 1;
					++page;
				}
			}
			
			pw.println(page);
		}
		
		pw.flush();
		pw.close();
	}

}
