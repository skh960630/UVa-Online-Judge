import java.util.Scanner;

class UVa12279_EmoogleBalance {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int c = 0;
		
		while(sc.hasNextLine())
		{
			++c;
			int n = sc.nextInt();
			
			if(n == 0)
				return;
			
			int x = 0;
			int y = 0;
			
			for(int i = 0; i < n; i++)
			{
				int test = sc.nextInt();
				
				if(test > 0)
					++x;
				else
					++y;
			}
			
			int result = x-y;
			
			System.out.println("Case " +c +": " +result);
		}
	}

}
