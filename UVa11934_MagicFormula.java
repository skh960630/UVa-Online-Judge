import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UVa11934_MagicFormula {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			String[] split = input.split(" ");
			
			int a = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			int c = Integer.parseInt(split[2]);
			int d = Integer.parseInt(split[3]);
			int L = Integer.parseInt(split[4]);
			
			if(a == 0)
				if(b == 0)
					if(c == 0)
						if(d == 0)
							if(L == 0)
								return;
			
			double function = 0;
			int count = 0;
			
			for(int i = 0; i <= L; i++)
			{
				function = (a * (i*i)) + (b * i) + c;
				
				if(function%d == 0.0)
					count++;
			}
			
			System.out.println(count);
		}
	}

}
