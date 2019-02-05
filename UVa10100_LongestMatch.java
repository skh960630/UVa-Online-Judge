import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class UVa10100_LongestMatch {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		int test = 1;
		PrintWriter pw = new PrintWriter(System.out);
		
		while((input = br.readLine()) != null)
		{
			String str1 = "";
			String str2 = "";
			
			boolean check = false;
			
			for(int x = 0; x < input.length(); x++)
			{
				if(Character.isLetterOrDigit(input.charAt(x)))
				{
					str1 += input.charAt(x);
					check = true;
				}
				else
				{
					if(check)
					{
						str1 += ' ';
						check = false;
					}
				}
			}
			
			input = br.readLine();
			check = false;
			
			for(int y = 0; y < input.length(); y++)
			{
				if(Character.isLetterOrDigit(input.charAt(y)))
				{
					str2 += input.charAt(y);
					check = true;
				}
				else
				{
					if(check)
					{
						str2 += ' ';
						check = false;
					}
				}
			}
			
			if(str1.isEmpty() || str2.isEmpty())
			{
				pw.printf("%2d. Blank!\n",test);
			}
			else
			{
				StringTokenizer st1 = new StringTokenizer(str1);
				StringTokenizer st2 = new StringTokenizer(str2);
				
				String[] arr1 = new String[st1.countTokens()];
				String[] arr2 = new String[st2.countTokens()];
				
				int i = 0;
				
				while(st1.hasMoreTokens())
				{
					arr1[i] = st1.nextToken();
					i++;
				}
				
				i = 0;
				
				while(st2.hasMoreTokens())
				{
					arr2[i] = st2.nextToken();
					i++;
				}
				
				int[][] res = new int[arr1.length+1][arr2.length+1];
				
				for(int y = 0; y < arr1.length; y++)
				{
					for(int k = 0; k < arr2.length; k++)
					{
						if(arr1[y].equals(arr2[k]))
						{
							res[y+1][k+1] = res[y][k]+1;
						}
						else
						{
							res[y+1][k+1] = Math.max(res[y+1][k], res[y][k+1]);
						}
					}
				}
				
				System.out.printf("%2d. Length of longest match: %d\n",test,
						res[arr1.length][arr2.length]);
			}
			
			++test;
		}
		
		pw.flush();
	}

}
