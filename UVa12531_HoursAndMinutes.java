import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa12531_HoursAndMinutes {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		PrintWriter pw = new PrintWriter(System.out);
		
		while((input = br.readLine()) != null)
		{
			int n = Integer.parseInt(input);
			
			if(n%6 == 0)
				pw.println("Y");
			else
				pw.println("N");
		}
		
		pw.flush();
		pw.close();
	}

}
