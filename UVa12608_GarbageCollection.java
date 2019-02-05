import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class UVa12608_GarbageCollection {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++)
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int garbage = 0;
			int count = 0;
			int save = 0;
			
			for(int j = 0; j < n; j++)
			{
				st = new StringTokenizer(br.readLine());
				int distance = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				count += distance-save;
				int temp = garbage+weight;
				
				if(temp > w)
				{
					count += distance*2;
					garbage = weight;
				}
				else
					garbage = temp;
				
				if(garbage == w)
				{
					if( j != n-1)
					{
						count += distance*2;
						garbage = 0;
					}	
				}
				
				save = distance;
			}
			
			count += save;
			
			pw.println(count);
		}
		
		pw.flush();
		pw.close();
	}

}
