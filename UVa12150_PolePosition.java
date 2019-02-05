import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa12150_PolePosition {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			int n = Integer.parseInt(input);
			
			if(n == 0)
				break;
			
			int[] rank = new int[n+1];
			boolean check = false;
			
			for(int i = 1; i <= n; i++)
			{
				String[] split = br.readLine().split(" ");
				int car = Integer.parseInt(split[0]);
				int pos = Integer.parseInt(split[1]);
				
				int r = i+pos;
				
				if(r > 0 && r <= n && rank[r] == 0)
					rank[r] = car;
				else
					check = true;
			}
			
			if(check)
				pw.println(-1);
			else
			{
				for(int j = 1; j <= n; j++)
				{
					pw.print(rank[j]);
					
					if(j != n)
						pw.print(" ");
				}
				
				pw.println();
			}
				
		}
		
		pw.flush();
		pw.close();
	}
}
