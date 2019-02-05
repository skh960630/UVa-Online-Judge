import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

class Uva11369_Shopaholic {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] prices = new int[n];
			String[] inputs = br.readLine().split(" ");
			
			for(int j = 0; j < n; j++)
				prices[j] = Integer.parseInt(inputs[j]);
			
			Arrays.sort(prices);
			
			int total = 0;
			int count = n/3;
			
			if(n%3 == 0)
				for(int k = 0, l = 0; l < count; k += 3, l++)
					total += prices[k];
			else if(n%3 == 1)				
				for(int k = 1, l = 0; l < count; k += 3, l++)
					total += prices[k];
			else
				for(int k = 2, l = 0; l < count; k += 3, l++)
					total += prices[k];
			
			System.out.println(total);
		}
	}
	
}
