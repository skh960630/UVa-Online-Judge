import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

class UVa514_Rails {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			int n = Integer.parseInt(input);
			
			if(n == 0)
				return;
			
			String[] test = null;
			
			while(Integer.parseInt((test = br.readLine().split(" "))[0]) != 0)
			{
				Deque<Integer> station = new ArrayDeque<>();
				Deque<Integer> storage = new ArrayDeque<>();
				boolean done = false;
				
				station = new ArrayDeque<>();
				for(int i = 0; i < n; i++)
					station.push(Integer.parseInt(test[i]));
				
				int j = 1;
				
				while(j <= n && !done)
				{
					if(storage.contains(j))
						break;
					
					while(!station.isEmpty())
					{
						if(station.peek() == j)
						{
							station.pop();
							break;
						}
						else
							storage.add(station.pop());
					}
					
					if(station.isEmpty())
					{
						station = storage;
						storage = new ArrayDeque<>();
					}
					
					++j;
				}
				
				if(station.isEmpty())
					System.out.println("Yes");
				else
					System.out.println("No");
			}
			
			System.out.println();
		}
	}
}
