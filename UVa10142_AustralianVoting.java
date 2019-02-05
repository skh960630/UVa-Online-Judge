import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;

class UVa10142_AustralianVoting {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		br.readLine();
		
		for(int i = 0; i < input; i++)
		{
			int n = Integer.parseInt(br.readLine());
			String[] names = new String[n];		
			ArrayList<ArrayList<Integer>> list = new ArrayList<>();
			String votes = null;
			
			for(int j = 0; j < n; j++)
				names[j] = br.readLine();
			
			while((votes = br.readLine()) != null && !votes.isEmpty())
			{
				String[] split = votes.split(" ");
				ArrayList<Integer> temp = new ArrayList<>();
				
				for(int k = 0; k < n; k++)
					temp.add(Integer.parseInt(split[k]));
				
				list.add(temp);
			}
			
			int half = list.size()/2;
			int maxPerson = -1;
			ArrayList<Integer> removed = new ArrayList<>();
			
			while(maxPerson == -1)
			{
				int[] candidates = new int[n];
				
				for(int x = 0; x < list.size(); x++)
					++candidates[list.get(x).get(0)-1];
				
				int max = Integer.MIN_VALUE;
				int min = Integer.MAX_VALUE;
				int save = 0;
				
				for(int y = 0; y < n; y++)
				{
					if(max < candidates[y])
					{
						max = candidates[y];
						save = y;
					}
					
					if(min > candidates[y])
						if(!removed.contains(y))
							min = candidates[y];
				}
				
				if(max > half)
				{
					maxPerson = save;
					break;
				}
				
				if(max == min)
					break;
				
				for(int z = 0; z < n; z++)
				{
					if(candidates[z] == min)
					{
						removed.add(z);
						
						for(int rem = 0; rem < list.size(); rem++)
							list.get(rem).remove((Object)(z+1));
					}
				}
			}
			
			if(maxPerson == -1)
			{
				for(int res = 0; res < n; res++)
					if(!removed.contains(res))
						System.out.println(names[res]);
			}
			else
				System.out.println(names[maxPerson]);
			
			if(i != input-1)
				System.out.println();
		}
	}

}
