import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class UVa11629_BallotEvaluation {
	
	public static void	 main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		PrintWriter pw = new PrintWriter(System.out);
		
		int p = Integer.parseInt(split[0]);
		int g = Integer.parseInt(split[1]);
		
		ArrayList<String> parties = new ArrayList<>();
		double[] percentages = new double[p];
		
		for(int i = 0; i < p; i++)
		{
			split = br.readLine().split(" ");
			parties.add(split[0]);
			percentages[i] = Double.parseDouble(split[1]);
		}
		
		for(int j = 0; j < g; j++)
		{
			split = br.readLine().split(" ");
			double total = 0.0;
			
			for(int k = 0; k < split.length-1; k+=2)
				total += percentages[parties.indexOf(split[k])];
			
			String compare = split[split.length-2];
			int num = Integer.parseInt(split[split.length-1]);
			boolean answer = false;
			
			total *= 100;
			total = Math.round(total);
			total /= 100;
			
			if(compare.equals(">"))
			{
				if(total > num)
					answer = true;
			}
			else if(compare.equals("<"))
			{
				if(total < num)
					answer = true;
			}
			else if(compare.equals(">="))
			{
				if(total >= num)
					answer = true;
			}
			else if(compare.equals("<="))
			{
				if(total <= num)
					answer = true;
			}
			else
			{
				if(total == num)
					answer = true;
			}
			
			if(answer)
				pw.println("Guess #" +(j+1) +" was correct.");
			else
				pw.println("Guess #" +(j+1) +" was incorrect.");
		}
		
		pw.flush();
		pw.close();
	}
	
}