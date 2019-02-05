import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UVa10281_AverageSpeed {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		double displacement = 0.0;
		double[] prevTime = new double[3];
		double speed = 0;
		boolean start = true;
		
		while((input = br.readLine()) != null)
		{
			String[] split = input.split(" ");
			String[] dis = split[0].split(":");
			
			double hour = Double.parseDouble(dis[0]);
			double min = Double.parseDouble(dis[1]);
			double sec = Double.parseDouble(dis[2]);
			
			if(split.length == 1)
			{
				displacement += ((hour - prevTime[0]) * speed) + 
						((min - prevTime[1]) *(speed/60)) + ((sec - prevTime[2]) * (speed/3600));
				
				System.out.printf(split[0] +" %.2f km\n", displacement);
			}
			else
			{
				if(!start)
				{
					displacement += ((hour - prevTime[0]) * speed) + 
							((min - prevTime[1]) *(speed/60)) + 
							((sec - prevTime[2]) * (speed/3600));
					speed = Double.parseDouble(split[1]);
				}
				else
				{
					speed = Double.parseDouble(split[1]);
					start = false;
				}
			}
			
			prevTime[0] = hour;
			prevTime[1] = min;
			prevTime[2] = sec;
		}
	}

}
