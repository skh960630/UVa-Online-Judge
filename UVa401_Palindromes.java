import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Vector;

class UVa401_Palindromes {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			HashMap<Character, Character> list = new HashMap<>();
			Vector<Character> singleMirrored = new Vector<Character>();
			
			list.put('A', 'A');
			list.put('B', 'N');
			list.put('C', 'N');
			list.put('D', 'N');
			list.put('E', '3');
			list.put('F', 'N');
			list.put('G', 'N');
			list.put('H', 'H');
			list.put('I', 'I');
			list.put('J', 'L');
			list.put('K', 'N');
			list.put('L', 'J');
			list.put('M', 'M');
			list.put('N', 'N');
			list.put('O', 'O');
			list.put('P', 'N');
			list.put('Q', 'A');
			list.put('R', 'N');
			list.put('S', '2');
			list.put('T', 'T');
			list.put('U', 'U');
			list.put('V', 'V');
			list.put('W', 'W');
			list.put('X', 'X');
			list.put('Y', 'Y');
			list.put('Z', '5');
			list.put('1', '1');
			list.put('2', 'S');
			list.put('3', 'E');
			list.put('4', 'N');
			list.put('5', 'Z');
			list.put('6', 'N');
			list.put('7', 'A');
			list.put('8', '8');
			list.put('9', 'N');
			list.put('0', 'O');
			
			singleMirrored.add('A');
			singleMirrored.add('H');
			singleMirrored.add('I');
			singleMirrored.add('M');
			singleMirrored.add('O');
			singleMirrored.add('0');
			singleMirrored.add('T');
			singleMirrored.add('U');
			singleMirrored.add('V');
			singleMirrored.add('W');
			singleMirrored.add('X');
			singleMirrored.add('Y');
			singleMirrored.add('1');
			singleMirrored.add('8');
			
			boolean pal = true;
			boolean mir = true;
			int i = 0;
			//NOTAPAL INDROME
			if(input.length()%2 == 0)
			{
				int j = 0;
				
				String a = input.substring(0, input.length()/2);
				String b = palindrome(input.substring(input.length()/2), "");
				
				while(j < input.length()/2 && mir)
				{	
					if(!list.get(a.charAt(j)).equals(b.charAt(j)))
						mir = false;
					else
						++j;
				}		
			}
			else
			{
				int j = 0;
				
				if(!singleMirrored.contains(list.get(input.charAt(input.length()/2))))
					mir = false;
				
				String a = input.substring(0, input.length()/2);
				String b = palindrome(input.substring(input.length()/2), "");
				
				while(j < input.length()/2 && mir)
				{	
					if(!list.get(a.charAt(j)).equals(b.charAt(j)))
						mir = false;
					else
						++j;
				}
			}
			
			while(mir && i < input.length())
			{
				char c = input.charAt(i);
				
				if(list.get(c).equals('N'))
					mir = false;
				else
					++i;
			}
			
			if(!input.equals(palindrome(input, "")))
				pal = false;
			
			if(pal && mir)
				System.out.println(input +" -- is a mirrored palindrome.");
			else if(pal)
				System.out.println(input +" -- is a regular palindrome.");
			else if(mir)
				System.out.println(input +" -- is a mirrored string.");
			else
				System.out.println(input +" -- is not a palindrome.");
			
			System.out.println();
		}
	}
	
	static String palindrome(String s, String temp)
	{
		if(s.length() == 0)
			return temp;
		
		return palindrome(s.substring(0, s.length()-1), temp+s.charAt(s.length()-1));
	}
}
