import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa10161_AntOnChess {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			long num = Long.parseLong(input);
			
			if(num == 0)
				return;
			
			boolean checkOdd = false;
			long first = (long)Math.round(Math.sqrt(num));
			long temp = (long)(num - (first*first));
			double test = Math.sqrt(num);
			
			if(test > first)
			{	
				if((first+1)%2 != 0)
					checkOdd = true;
			}
			else
				if((first%2) != 0)
					checkOdd = true;
			
			long x = 0;
			long y = 0;
			
			if(checkOdd)
			{
				if(temp > 0)
				{
					x = first+1;
					y = temp;
				}
				else
				{
					x = -1*temp + 1;
					y = first;
				}
			}
			else
			{
				if(temp > 0)
				{
					x = temp;
					y = first + 1;
				}
				else
				{
					x = first;
					y = -1*temp + 1;
				}
			}
			
			System.out.println(x +" " +y);
		}
	}

}
