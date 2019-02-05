import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa11264_CoinCollector {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int t = Integer.parseInt(input);
		
		for(int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			long[] list = new long[n];
			String values = br.readLine();
			String[] split = values.split(" ");
			
			for(int j = 0; j < n; j++)
				list[j] = Long.parseLong(split[j]);			
			
			int count = 1;
			long max = list[0];
			
			for(int k = 1; k < n-1; k++)
			{
				if(max + list[k] < list[k+1])
				{
					max += list[k];
					++count;
				}
			}
			
			++count;
			
			System.out.println(count);
		}
	}
}
