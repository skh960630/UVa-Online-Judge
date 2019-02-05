import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa11933_SplittingNumbers {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		PrintWriter pw = new PrintWriter(System.out);
		
		while((input = br.readLine()) != null)
		{
			int n = Integer.parseInt(input);
			
			if(n == 0)
				break;
			
			String binaryN = "";
			
			while(n > 0)
			{
				binaryN = (n%2)+binaryN;
				n /= 2;
			}
			
			String a = "";
			String b = "";
			boolean check = false;
			int count = 0;
				
			for(int i = 0; i < binaryN.length(); i++)
			{
				if(binaryN.charAt(i) == '0')
				{
					a = a+0;
					b = b+0;
				}
				else
				{
					++count;
					
					if(check)
					{
						a = a+0;
						b = b+1;
						check = false;
					}
					else
					{
						a = a+1;
						b = b+0;
						check = true;
					}
				}
			}
			
			int resultA = 0;
			int resultB = 0;
			
			for(int j = 0; j < binaryN.length(); j++)
			{
				int temp = binaryN.length()-1-j;
				
				if(a.charAt(temp) == '1')
					resultA += Math.pow(2, j);
				
				if(b.charAt(temp) == '1')
					resultB += Math.pow(2, j);
			}
			
			if(count%2 == 0)
			{
				int temp = resultA;
				resultA = resultB;
				resultB = temp;
			}
			
			pw.println(resultA +" " +resultB);
		}
		
		pw.flush();
		pw.close();
	}

}
