import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa10624_SuperNumber {
static int[] result = new int[30];
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= t; i++)
		{
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			
			if(calculate(0, n, m))
			{
				System.out.print("Case " +i +": ");
				
				for(int j = 0; j < m; j++)
				{
					System.out.print(result[j]);
				}
				
				System.out.println();
			}
			else
			{
				System.out.println("Case " +i +": -1");
			}
			
		}
	}
	
	static boolean calculate(int num, int n, int m)
	{
		if(num == m)
		{
			return true;
		}
		
		for(int i = 0; i <= 9; i++)
		{
			result[num] = i;
			
			if(result[0] != 0)
			{
				if(num < n-1 || check(num+1))
				{
					if(calculate(num+1, n, m))
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	static boolean check(int num)
	{
		int temp = 0;
		
		for(int i = 0; i < num; i++)
		{
			temp = temp*10 + result[i];
			temp %= num;
		}
		
		if(temp == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}
