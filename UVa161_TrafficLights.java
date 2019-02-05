import java.util.Scanner;
import java.util.ArrayList;

class UVa161_TrafficLights {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext())
		{
			int n = sc.nextInt();
			
			if(n == 0)
				return;
			
			ArrayList<Integer> list = new ArrayList<>();
			list.add(n);
			int min = n;
			
			while((n = sc.nextInt()) != 0)
			{
				list.add(n);
				
				if(n < min)
					min = n;
			}
			
			int time = min;
			
			while(time <= 18000)
			{
				boolean done = true;
				
				for(int i = 0; i < list.size(); i++)
				{
					int temp = time/list.get(i);
					
					if(temp%2 != 0)
					{
						done = false;
						break;
					}
					
					if(time%list.get(i) >= list.get(i)-5)
					{
						done = false;
						break;
					}
				}
				
				if(done)
					break;
				
				++time;
			}
			
			if(time > 18000)
				System.out.println("Signals fail to synchronise in 5 hours");
			else
			{
				int hour = time/3600;
				time -= 3600*hour;
				int minute = time/60;
				time -= 60*minute;
				int sec = time;
				
				System.out.printf("%02d:%02d:%02d\n", hour, minute, sec);
			}
		}
	}
}
