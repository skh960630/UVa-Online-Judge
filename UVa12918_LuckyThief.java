import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa12918_LuckyThief {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++)
		{
			String[] split = br.readLine().split(" ");
			long n = Long.parseLong(split[0]);
			long m = Long.parseLong(split[1]);
			
			long result = (m-n)*n;
			result += n*(double)((double)(n-1)/2);
			
			System.out.println(result);
		}
	}

}
