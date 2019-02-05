import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.io.IOException;

class UVa10033_Interpreter {
	static DecimalFormat df = new DecimalFormat("000");
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.readLine();
		
		for(int i = 0; i < n; i++)
		{
			String[] list = new String[1000];
			Arrays.fill(list, "000");
			String input = null;
			int j = 0;
			
			while(true)
			{
				input = br.readLine();
				if(input != null && !input.isEmpty())
				{
					list[j] = input;
					++j;
				}
				else
					break;
			}
			
			int[] regs = new int[10];
			int location = 0;
			int count = 0;
			
			while(location < 1000)
			{
				String inst = list[location];
				int head = Integer.parseInt(inst.substring(0,1));
				int d = Integer.parseInt(inst.substring(1,2));
				int s = Integer.parseInt(inst.substring(2));
				
				switch(head)
				{
				case 1:
					location = 1000;
					++location;
					break;
					
				case 2:
					regs[d] = s;
					++location;
					break;
					
				case 3:
					regs[d] = (regs[d] + s)%1000;
					++location;
					break;
					
				case 4:
					regs[d] = (regs[d] * s)%1000;
					++location;
					break;
					
				case 5:
					regs[d] = regs[s];
					++location;
					break;
					
				case 6:
					regs[d] = (regs[d] + regs[s])%1000;
					++location;
					break;
					
				case 7:
					regs[d] = (regs[d] * regs[s])%1000;
					++location;
					break;
					
				case 8:
					regs[d] = Integer.parseInt(list[regs[s]]);
					++location;
					break;
					
				case 9:
					list[regs[s]] = df.format(regs[d]);
					++location;
					break;
					
				case 0:
					if(regs[s] != 0)
						location = regs[d];
					else
						++location;
					break;
				}
				++count;
			}
			
			System.out.println(count);
			
			if(i < n-1)
				System.out.println();
		}
		
	}

}
