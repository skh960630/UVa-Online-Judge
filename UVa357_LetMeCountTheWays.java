import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

class UVa357_LetMeCountTheWays {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		long[] counts = new long[30001];
		Arrays.fill(counts, 1);
		
		for(int i = 5; i <= 30000; i++)
			counts[i] += counts[i - 5];
		
		for(int j = 10; j <= 30000; j++)
			counts[j] += counts[j - 10];
		
		for(int k = 25; k <= 30000; k++)
			counts[k] += counts[k - 25];
		
		for(int l = 50; l <= 30000; l++)
			counts[l] += counts[l - 50];
		
		while((input = br.readLine()) != null)
		{
			int num = Integer.parseInt(input);
			
			if(num < 5)
				System.out.println("There is only 1 way to produce " +num +" cents change.");
			else
				System.out.println("There are " +counts[num] +" ways to produce " +num 
						+" cents change.");
		}
	}
}
