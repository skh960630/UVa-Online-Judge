import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class UVa11078_OpenCreditSystem {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < input; i++)
		{
			int n = Integer.parseInt(br.readLine());
			int[] values = new int[n];
			
			for(int j = 0; j < n; j++)
				values[j] = Integer.parseInt(br.readLine());
			
			int max = values[0];
			int maximumValue = max - values[1];
			
			for(int k = 2; k < n; k++)
			{
				if((max - values[k]) > maximumValue)
					maximumValue = max - values[k];

				if(max < values[k])
					max = values[k];
			}
			
			System.out.println(maximumValue);
		}
	}
}
