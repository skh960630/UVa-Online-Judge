import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa575_SkewBinary {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			double n = Double.parseDouble(input);
			
			if(n == 0.0)
				return;
			
			long result = 0;
			int inputLeng = input.length();
			
			if(inputLeng > 9)
			{
				int div = inputLeng/9;
				int length = div + 1;
				int[] list = new int[length];
				
				for(int i = 0, j = 0; j < div; i+=9, j++)
					list[j] = Integer.parseInt(input.substring(i, i+9));
				
				String temp = input.substring(9 * div);
				list[div] = Integer.parseInt(temp);
				
				for(int x = 0, k = inputLeng; x < list.length-1; x++,k-=9)
				{
					result +=skBinary(list[x], k-8);
				}
				
				if(list[div] != 0)
					result += skBinary(list[div],1);
			}
			else
			{
				result = skBinary(n, 1);
			}
			
			System.out.println(result);
		}
	}
	
	static long skBinary(double num, int power)
	{
		if(num == 0)
			return 0;
		
		double digit = num%10;
		num = num/10 - (digit * 0.1);
		
		return (long)((digit * (Math.pow(2, power) - 1)) + skBinary(num, ++power));
	}
}
