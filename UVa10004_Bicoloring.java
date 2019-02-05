import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa10004_Bicoloring {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = 0;
		
		while((input = Integer.parseInt(br.readLine())) != 0)
		{
			int nodesN = input;
			int n = Integer.parseInt(br.readLine());
			
			String[] nodes = new String[nodesN];
			int[][] list = new int[nodesN][nodesN];
			boolean check = false;
			
			for(int i = 0; i < n; i++)
			{
				String split[] = br.readLine().split(" ");
				
				if(Integer.parseInt(split[0]) == Integer.parseInt(split[1]))
					check = true;
				
				list[Integer.parseInt(split[0])][Integer.parseInt(split[1])] = 1;
				list[Integer.parseInt(split[1])][Integer.parseInt(split[0])] = 1;
			}
			
			if(!check)
			{
				nodes[0] = "RED";
				
				for(int j = 0; j < nodesN; j++)
				{
					for(int k = 0; k < nodesN; k++)
					{
						if(list[j][k] == 1)
						{
							if(nodes[k] != null)
							{
								if(nodes[k].equals(nodes[j]))
								{	
									check = true;
									break;
								}
							}
							else
							{
								if(nodes[j] == "RED")
									nodes[k] = "BLUE";
								else
									nodes[k] = "RED";
							}
						}
					}
				}
			}
			
			if(check)
				System.out.println("NOT BICOLORABLE.");
			else
				System.out.println("BICOLORABLE.");
		}
	}

}
