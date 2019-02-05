import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa10116_RobotMotion {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			String[] split = input.split(" ");
			int[] nums = new int[split.length];
			
			for(int x = 0; x < split.length; x++)
				nums[x] = Integer.parseInt(split[x]);
			
			if(nums[0] == 0)
				return;
			
			char[][] list = new char[nums[0]][nums[1]];
			int[][] passed = new int[nums[0]][nums[1]];
			
			for(int i = 0; i < nums[0]; i++)
			{
				input = br.readLine();
				
				for(int j = 0; j < nums[1]; j++)
				{
					list[i][j] = input.charAt(j);
					passed[i][j] = -1;
				}
			}
			
			boolean done = false;
			boolean exit = false;
			int row = 0;
			int col = nums[2]-1;
			int count = 0;
			
			while(!done)
			{
				if(row >= nums[0] || col >= nums[1] || row < 0 || col < 0)
				{
					done = true;
					exit = true;
				}
				else if(passed[row][col] != -1)
					done= true;
				else
				{
					char temp = list[row][col];
					passed[row][col] = count;
					++count;
					
					if(temp == 'N')
						--row;
					else if(temp == 'S')
						++row;
					else if(temp == 'E')
						++col;
					else
						--col;
				}
			}
			
			if(exit)
				System.out.println(count +" step(s) to exit");
			else
			{	
				int loop = count - passed[row][col];
			
				System.out.println(passed[row][col] +" step(s) before a loop of " 
						+loop +" step(s)");
			}
		}
	}

}
