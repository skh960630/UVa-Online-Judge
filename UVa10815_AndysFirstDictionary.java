import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

class UVa10815_AndysFirstDictionary {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		ArrayList<String> result = new ArrayList<String>();
		
		while((input = br.readLine()) != null)
		{			
			String s = "";
			
			for(int i = 0; i < input.length(); i++)
			{
				if(Character.isAlphabetic(input.charAt(i)))
					s += input.charAt(i);
				else if(s.length() > 0)
				{
					s = s.toLowerCase();
					
					if(!result.contains(s))
						result.add(s);
					
					s = "";
				}
			}
			
			if(s.length() > 0)
			{
				s = s.toLowerCase();
				if(!	result.contains(s))
					result.add(s);
			}
		}
		
		Collections.sort(result);
		
		for(int j = 0; j < result.size(); j++)
			System.out.println(result.get(j));
	}
}
