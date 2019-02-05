import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Vector;

class UVa489_HangmanJudge {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			int n = Integer.parseInt(input);
			int strokes = 0;
			
			if(n == -1)
				return;
			
			String answer = br.readLine();
			String tried = br.readLine();
			Vector<Character> ansWords = new Vector<Character>();
			Vector<Character> wrong = new Vector<Character>();
			boolean check = true;
			int last = 0;
			
			char[] ans = new char[answer.length()];
			char[] tr = new char[tried.length()];
			
			for(int j = 0; j < ans.length; j++)
			{
				ans[j] = answer.charAt(j);
				ansWords.add(ans[j]);
			}
			
			for(int k = 0; k < tr.length; k++)
				tr[k] = tried.charAt(k);
			
			for(int x = 0; x < tr.length; x++)
			{
				if(ansWords.contains(tr[x]))
				{
					for(int y = 0; y < ans.length; y++)
						if(ans[y] == tr[x])
							ans[y] = '0';
					
					if(!wrong.contains(tr[x]))
					{
						wrong.add(tr[x]);
						if(strokes < 7)
							last = ans.length - 1;
						else
							last = ans.length;
					}
				}
				else if(!wrong.contains(tr[x]))
				{
					wrong.add(tr[x]);
					++strokes;
				}
			}
			
			for(int x = 0; x < ans.length; x++)
			{
				if(ans[x] != '0')
					check = false;
			}
			
			System.out.println("Round "+n);
			
			if(check && last < ans.length)
				System.out.println("You win.");
			else if(strokes >= 7)
				System.out.println("You lose.");
			else
				System.out.println("You chickened out.");
		}
	}
	
}
