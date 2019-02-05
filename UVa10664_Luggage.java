import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class UVa10664_Luggage {

	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < t; i++)
		{
			String[] split = br.readLine().split(" ");
			ArrayList<Integer> temp = new ArrayList<>();
			
			int total = 0;
			
			for(int j = 0; j < split.length; j++)
			{
				temp.add(Integer.parseInt(split[j]));
				total += Integer.parseInt(split[j]);
			}
			
			if(total%2 != 0)
				System.out.println("NO");
			else
			{
				total /= 2;
				
				Collections.sort(temp);
				int sum = 0;
				
				boolean done = false;
				boolean check = false;
				ArrayList<int[]> list = new ArrayList<>();
				
				for(int x = temp.size()-2; x >= 0; x--)
				{
					ArrayList<Integer> test = new ArrayList<>();
					test.addAll(temp);
					test.set(test.size()-1, -1);
					sum = temp.get(temp.size()-1);
					
					for(int y = x; y >= 0; y--)
					{
						if(sum+test.get(y) <= total)
						{
							sum += test.get(y);
							test.set(y, -1);
						}
					}
					
					if(sum == total)
					{
						check = true;
						int[] input = new int[test.size()];
						int ip = 0;
						
						for(int a = 0; a < test.size(); a++)
						{
							if(test.get(a) != -1)
							{
								input[ip] = test.get(a);
								++ip;
							}
						}
						
						list.add(input);
					}
				}
				
				if(check)
				{
					for(int b = 0; b < list.size(); b++)
					{
						int other = 0;
						int[] test = list.get(b);
						
						for(int y = 0; y < test.length; y++)
							other += test[y];
						
						if(other == total)
						{
							done = true;
							break;
						}
					}
				}
				
				if(done)
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}
}
