import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.io.IOException;

class UVa10227_Forests {
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		br.readLine();
		
		for(int i = 0; i < test; i++)
		{
			String input = br.readLine();
			input.trim();
			String[] split = input.split(" ");
			int p = Integer.parseInt(split[0]);
			int t = Integer.parseInt(split[1]);
			
			int result = 0;
			
			if(p != 0 && t != 0)
			{
				HashMap<Integer, ArrayList<Integer>> list = new HashMap<>();
				
				while((input = br.readLine()) != null && !input.isEmpty())
				{
					input.trim();
					split = input.split(" ");
					int temp = Integer.parseInt(split[0]);
					ArrayList<Integer> line = new ArrayList<>();
					
					if(list.containsKey(temp))
					{
						line.addAll(list.get(temp));
						list.remove(temp);
					}
					
					if(!line.contains(Integer.parseInt(split[1])))
						line.add(Integer.parseInt(split[1]));
					
					Collections.sort(line);

					list.put(temp, line);
				}
				
				HashMap<Integer, ArrayList<Integer>> check = new HashMap<>();
				
				for(int j = 1; j <= p; j++)
				{
					if(!check.containsValue(list.get(j)))
					{
						++result;
						check.put(j, list.get(j));
					}
				}
			}
			else 
			{
				if(p != 0)
					result = 1;
				
				br.readLine();
			}
			
			System.out.println(result);
			
			if(i != test-1)
				System.out.println();
		}
	}
}
