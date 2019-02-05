import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UVa11777_AutomateTheGrades {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int count = 0;
		
		for(int i = 0; i < test; i++)
		{
			++count;
			
			String[] split = br.readLine().split(" ");
			
			int[] classTests = new int[3];
			classTests[0] = Integer.parseInt(split[4]);
			classTests[1] = Integer.parseInt(split[5]);
			classTests[2] = Integer.parseInt(split[6]);
			
			int min = 20;
			int save = 0;
			
			for(int k = 0; k < 3; k++)
			{
				if(min > classTests[k])
				{
					min = classTests[k];
					save = k;
				}
			}
			
			int ave = 0;
			
			for(int l = 0; l < 3; l++)
				if(l != save)
					ave += classTests[l];
			
			ave /= 2;
			
			int total = Integer.parseInt(split[0]) + Integer.parseInt(split[1]) 
			+ Integer.parseInt(split[2]) + Integer.parseInt(split[3]) + ave;
			
			char grade = ' ';
			
			if(total >= 90)
				grade = 'A';
			else if(total >= 80)
				grade = 'B';
			else if(total >= 70)		
				grade = 'C';
			else if(total >= 60)
				grade = 'D';
			else
				grade = 'F';
			
			
			System.out.println("Case " +count +": " +grade);
		}
	}

}
