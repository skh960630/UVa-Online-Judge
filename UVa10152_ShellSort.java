import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;

class UVa10152_ShellSort {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < test; i++)
		{
			int n = Integer.parseInt(br.readLine());
			ArrayList<String> names = new ArrayList<String>();
			ArrayList<String> desired = new ArrayList<String>();
			ArrayList<String> results = new ArrayList<String>();
			
			for(int j = 0; j < n; j++)
				names.add(br.readLine());
			
			for(int k = 0; k < n; k++)
				desired.add(br.readLine());
			
			for(int x = n-1; x > 0; x--)
			{
				int curr = names.indexOf(desired.get(x));
				int next = names.indexOf(desired.get(x-1));
				
				if(next > curr)
				{
					results.add(names.get(next));
					String temp = names.get(next);
					names.remove(next);
					names.add(0,temp);
				}
			}
			
			for(String s : results)
				System.out.println(s);
			
			System.out.println();
		}
	}

}
