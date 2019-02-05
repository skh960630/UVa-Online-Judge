import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class UVa119_GreedyGiftGivers {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		PrintWriter pw = new PrintWriter(System.out);
		int count = 0;
		
		while((input = br.readLine()) != null)
		{
			if(count == 0)
				++count;
			else
				pw.println();
			
			int n = Integer.parseInt(input);
			int[] records = new int[n];
			ArrayList<String> names = new ArrayList<>();
			String[] split = br.readLine().split(" ");
			
			for(int i = 0; i < n; i++)
				names.add(split[i]);
			
			for(int j = 0; j < n; j++)
			{
				split = br.readLine().split(" ");
				int money = Integer.parseInt(split[1]);
				
				if(money != 0)
				{
					int num = Integer.parseInt(split[2]);
					
					if(num != 0)
					{
						int divided = money/num;
						
						records[names.indexOf(split[0])] -= divided*num;
						
						for(int k = 3; k < num+3; k++)
							records[names.indexOf(split[k])] += divided;
					}
				}
			}
			
			for(int k = 0; k < n; k++)
				pw.println(names.get(k) +" " +records[k]);
			
		}
		
		pw.flush();
		pw.close();
	}

}
