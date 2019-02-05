import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

class UVa400_Unixls {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			int n = Integer.parseInt(input);
			int max = 0;
			
			String[] list = new String[n];
			
			for(int i = 0; i < n; i++)
			{
				String temp = br.readLine();
				list[i] = temp;
				if(temp.length() > max)
					max = temp.length();
			}
			
			Arrays.sort(list);
			int temp = 60/max;
			
			while((((temp - 1) * (max+2)) + max) > 60)
				--temp;
			
			System.out.println("------------------------------------------------------------");
			
			int length = 0;
			
			while(n%temp != 0)
				++n;
			
			length = n/temp;
			
			for(int j = 0; j < length; j++)
			{
				int k = j;
				String result = "";
				while(k < list.length)
				{
					result += list[k];
					int test = (max+2) - list[k].length();
					int testTwo = test - 2;
					
					k += length;
					
					if(k < list.length)
					{
						for(int x = 0; x < test; x++)
							result += " ";
					}
					else
					{
						for(int a = 0; a < testTwo; a++)
							result += " ";
					}
				}
				
				System.out.println(result);
			}
		}
	}

}