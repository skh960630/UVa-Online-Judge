import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa665_FalseCoin {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int m = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < m; i++)
		{
			br.readLine();
			
			String[] split = br.readLine().split(" ");
			int n = Integer.parseInt(split[0]);
			int k = Integer.parseInt(split[1]);
			
			String[] list = new String[k];
			char[] compared = new char[k];
			
			for(int j = 0; j < k; j++)
			{
				list[j] = br.readLine();
				compared[j] = br.readLine().charAt(0);
			}
			
			int[] coins = new int[n+1];
			
			boolean found = false;
			int result = 0;
			int x = 0;
			
			while(x < k && !found)
			{
				split = list[x].split(" ");
				int num = Integer.parseInt(split[0]);
				
				int count = 0;
				int save = 0;
				
				if(compared[x] == '=')
				{
					for(int y = 1; y <= num*2; y++)
						coins[Integer.parseInt(split[y])] = 1;
				}
				else
				{
					for(int y = 1; y <= num*2; y++)
					{
						int temp = Integer.parseInt(split[y]);
						
						if(coins[temp] == 0)
						{
							++count;
							save = temp;
						}
					}
					
				}
				
				if(count == 1)
				{
					result = save;
					found = true;
					break;
				}
				
				count = 0;
				save = 0;
				
				for(int res = 1; res <= n; res++)
				{
					if(coins[res] != 1)
					{
						++count;
						save = res;
					}
				}
				
				if(count == 1)
				{
					found = true;
					result = save;
					break;
				}
				
				++x;
			}
			
			pw.println(result);
			
			if(i != m-1)
				pw.println();
		}
		
		pw.flush();
		pw.close();
	}

}
