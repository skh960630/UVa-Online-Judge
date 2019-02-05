import java.util.Scanner;
import java.io.PrintWriter;

class UVa10205_StackEmUp {
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		PrintWriter pw = new PrintWriter(System.out);
		int t = sc.nextInt();
		String input = null;
		
		for(int i = 0; i < t; i++)
		{
			int n = sc.nextInt();
			int[][] shuffles = new int[n+1][53];
			
			String[] cards = new String[53];
			
			cards[1] = "2";
			cards[2] = "3";
			cards[3] = "4";
			cards[4] = "5";
			cards[5] = "6";
			cards[6] = "7";
			cards[7] = "8";
			cards[8] = "9";
			cards[9] = "10";
			cards[10] = "Jack";
			cards[11] = "Queen";
			cards[12] = "King";
			cards[13] = "Ace";
			
			for(int a = 1; a <= 13; a++)
			{
				cards[a] += " of Clubs";
			}
			
			cards[14] = "2";
			cards[15] = "3";
			cards[16] = "4";
			cards[17] = "5";
			cards[18] = "6";
			cards[19] = "7";
			cards[20] = "8";
			cards[21] = "9";
			cards[22] = "10";
			cards[23] = "Jack";
			cards[24] = "Queen";
			cards[25] = "King";
			cards[26] = "Ace";
			
			for(int b = 14; b <= 26; b++)
			{
				cards[b] += " of Diamonds";
			}
			
			cards[27] = "2";
			cards[28] = "3";
			cards[29] = "4";
			cards[30] = "5";
			cards[31] = "6";
			cards[32] = "7";
			cards[33] = "8";
			cards[34] = "9";
			cards[35] = "10";
			cards[36] = "Jack";
			cards[37] = "Queen";
			cards[38] = "King";
			cards[39] = "Ace";
			
			for(int c = 27; c <= 39; c++)
			{
				cards[c] += " of Hearts";
			}
			
			cards[40] = "2";
			cards[41] = "3";
			cards[42] = "4";
			cards[43] = "5";
			cards[44] = "6";
			cards[45] = "7";
			cards[46] = "8";
			cards[47] = "9";
			cards[48] = "10";
			cards[49] = "Jack";
			cards[50] = "Queen";
			cards[51] = "King";
			cards[52] = "Ace";
			
			for(int d = 40; d <= 52; d++)
			{
				cards[d] += " of Spades";
			}
			
			for(int j = 1; j <= n; j++)
			{
				for(int k = 1; k <= 52; k++)
				{
					shuffles[j][k] = sc.nextInt();
				}
			}
			
			int[] sort = new int[53];
			
			for(int k = 1; k <= 52; k++)
			{
				sort[k] = k;
			}
			
			sc.nextLine();
			
			while(sc.hasNextLine() && !(input = sc.nextLine()).isEmpty())
			{
				int z = Integer.parseInt(input);
				
				int[] temp = new int[53];
				
				for(int x = 1; x <= 52; x++)
				{
					temp[x] = sort[shuffles[z][x]];
				}
				
				sort = temp;
			}
			
			for(int y = 1; y <= 52; y++)
				pw.println(cards[sort[y]]);
			
			if(i != t-1)
			{
				pw.println();
			}
		}
		
		pw.flush();
		pw.close();
	}

}