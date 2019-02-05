import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;

class UVa10954_AddAll {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		
		while((n = Integer.parseInt(br.readLine())) != 0)
		{
			String[] split = br.readLine().split(" ");
			PriorityQueue<Integer> list = new PriorityQueue<>();
			
			for(int i = 0; i < n; i++)
				list.offer(Integer.parseInt(split[i]));
			
			int result = 0;
			
			while(list.size() != 1)
			{
				int temp = list.poll() + list.poll();
				result += temp;
				list.offer(temp);
			}
			
			System.out.println(result);
		}
	}

}
