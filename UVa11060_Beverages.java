import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

class UVa11060_Beverages {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		String input = null;
		int count = 0;
		
		while((input = br.readLine()) != null)
		{
			++count;
			int n = Integer.parseInt(input);
			String[] names = new String[n];
			HashMap<String, Integer> nameList = new HashMap<>();
			
			for(int i = 0; i < n; i++)
			{	
				names[i] = br.readLine();
				nameList.put(names[i], i);
			}
			
			int m = Integer.parseInt(br.readLine());
			int[] back = new int[n];
			boolean[][] saves = new boolean[n][n];
			
			for(int j = 0; j < m; j++)
			{
				StringTokenizer st = new StringTokenizer(br.readLine());
				String front = st.nextToken();
				String last = st.nextToken();
				
				if(!saves[nameList.get(front)][nameList.get(last)])
				{
					saves[nameList.get(front)][nameList.get(last)] = true;
					back[nameList.get(last)]++;
				}
			}
			
			PriorityQueue<Integer> results = new PriorityQueue<>();
			
			for(int k = 0; k < n; k++)
				if(back[k] == 0)
					results.add(k);
			
			System.out.print("Case #" +count +": Dilbert should drink beverages in this "
					+ "order:");
			
			while(!results.isEmpty())
			{
				int temp = results.poll();
				System.out.print(" " +names[temp]);
				
				for(int x = 0; x < n; x++)
				{
					if(saves[temp][x])
					{
						if(--back[x] == 0)
						{
							results.add(x);
						}
					}
				}
			}
			
			System.out.println(".");
			System.out.println();
			br.readLine();
		}
		
		pw.flush();
		pw.close();
	}

}
