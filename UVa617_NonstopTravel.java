import java.util.Scanner;
import java.io.PrintWriter;
import java.util.ArrayList;

class UVa617_NonstopTravel {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int count = 0;
		
		while(sc.hasNext())
		{
			++count;
			int n = sc.nextInt();
			sc.nextLine();
			
			if(n == -1)
				break;
			
			if(n == 0)
				pw.println("Case " +count +": 30-60");
			else
			{
				double[] distance = new double[n];
				int[] green = new int[n];
				int[] yellow = new int[n];
				int[] red = new int[n];
				
				for(int i = 0; i < n; i++)
				{
					distance[i] = sc.nextDouble();
					green[i] = sc.nextInt();
					yellow[i] = sc.nextInt();
					red[i] = sc.nextInt();
					sc.nextLine();
				}
				
				ArrayList<Integer> results = new ArrayList<>();
				
				for(int add = 30; add <= 60; add++)
					results.add(add);
				
				for(int j = 0; j < n; j++)
				{	
					for(int k = 30; k <= 60; k++)
					{
						double speed = (double)(k)/3600;
						
						double temp = distance[j]/speed;
						int possible = green[j]+yellow[j];
						
						if(temp > possible)
						{
							double total = green[j]+yellow[j]+red[j];
							if((temp%total) > possible)
							{
								if(results.contains(k))
									results.remove((Object)k);
							}
						}
					}
				}
				
				if(results.isEmpty())
					pw.println("Case " +count +": No acceptable speeds.");
				else
				{
					ArrayList<Integer> starts = new ArrayList<>();
					ArrayList<Integer> ends = new ArrayList<>();
					boolean check = false;
					boolean continued = false;
					
					for(int x = 30; x < 60; x++)
					{
						if(results.contains(x))
						{
							if(!continued)
							{
								continued = true;
								check = true;
								starts.add(x);
							}
						}
						else
						{
							if(check)
							{
								check = false;
								continued = false;
								ends.add(x-1);
							}
						}
					}
					
					if(continued)
						ends.add(60);
					else
					{
						if(results.contains(60))
						{
							starts.add(60);
							ends.add(60);
						}
					}
					
					pw.print("Case " +count +": ");
					
					for(int y = 0; y < starts.size()-1; y++)
					{
						if(starts.get(y) == ends.get(y))
							pw.print(starts.get(y) +", ");
						else
							pw.print(starts.get(y) +"-" +ends.get(y) +", ");
					}
					
					if(starts.get(starts.size()-1) == ends.get(ends.size()-1))
						pw.println(starts.get(starts.size()-1));
					else
					{
						int temp = starts.get(starts.size()-1);
						int temp2 = ends.get(starts.size()-1);
						pw.println(temp +"-" +temp2);
					}
					
				}
			
			}
		}
		
		pw.flush();
		pw.close();
	}

}
