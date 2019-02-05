import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class UVa12100_PrinterQueue {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < input; i++)
		{
			
			String[] split = br.readLine().split(" ");
			String[] splitRange = br.readLine().split(" ");
			
			int n = Integer.parseInt(split[0]);
			int position = Integer.parseInt(split[1]);
			
			if(n == 1)
				System.out.println(1);
			else
			{
				ArrayList<Integer> list = new ArrayList<Integer>();
				
				for(int j = 0; j < n; j++)
					list.add(Integer.parseInt(splitRange[j]));
				
				boolean done = false;
				int count = 0;
				
				while(!done)
				{
					int temp = list.get(0);
					list.remove(0);
					boolean check = false;
					
					if(position == 0)
					{
						int k = 0;
						
						while(k < list.size() && !check)
						{
							if(list.get(k) > temp)
								check = true;
							
							++k;
						}
						
						if(!check)
						{
							++count;
							done = true;
						}
						else
						{
							list.add(temp);
							position = list.size() - 1;
						}
					}
					else
					{
						int l = 0;
						
						while(l < list.size() && !check)
						{	
							if(list.get(l) > temp)
								check = true;
							
							++l;
						}
						
						if(check)
							list.add(temp);
						else
							++count;
						
						--position;
					}
				}
				
				System.out.println(count);
			}
		}
	}
}
