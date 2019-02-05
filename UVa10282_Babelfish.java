import java.util.Scanner;
import java.util.HashMap;

class UVa10282_Babelfish {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		String input = null;
		HashMap<String, String> dict = new HashMap<String, String>();
		
		while(sc.hasNextLine())
		{
			input = sc.nextLine();
			
			if(!input.isEmpty())
			{
				String[] split = input.split(" ");
				dict.put(split[1], split[0]);
			}
			else
				break;
		}
		
		while(sc.hasNextLine())
		{
			String test = sc.nextLine();
			StringBuilder ans = new StringBuilder();
			
			if(!test.isEmpty())
			{
				if(dict.containsKey(test))
					ans.append(dict.get(test) +"\n");
				else
					System.out.println("eh");
			}
			else
				break;
			
			System.out.print(ans.toString());
		}
	}
}
