import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

class UVa11466_LargestPrimeDivisor {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			long n = Long.parseLong(input);
			
			if(n == 0)
				return;
			
			if(n < 0)
				n *= -1;
			
			BigInteger bi = BigInteger.valueOf(n);
			
			if(bi.isProbablePrime(10))
				System.out.println(-1);
			else
			{
				long max = 0;
				long temp = n;
				
				while(n%2 == 0)
					n /= 2;
				
				for(long i = 3; i*i <= n; i += 2)
				{
					if(n%i == 0)
					{
						while(n%i == 0)
							n /= i;
						
						max = Math.max(i, n);
					}
				}
				
				if(max*max == temp)
					max = 1;
				
				max = Math.max(max, n);
				
				if(max > 2)
					System.out.println(max);
				else
					System.out.println(-1);
			}
		}
	}
}
