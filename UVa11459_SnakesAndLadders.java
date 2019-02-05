import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

class UVa11459_SnakesAndLadders {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < input; i++)
		{
			String[] split = br.readLine().split(" ");
			int numPlayers = Integer.parseInt(split[0]);
			int[] players = new int[numPlayers];
			HashMap<Integer, Integer> list = new HashMap<>();
			
			for(int p = 0; p < players.length; p++)
				players[p] = 0;
			
			int num = Integer.parseInt(split[1]);
			int rolls = Integer.parseInt(split[2]);
			
			for(int j = 0; j < num; j++)
			{
				split = br.readLine().split(" ");
				list.put(Integer.parseInt(split[0]) - 1, Integer.parseInt(split[1]) - 1);
			}
			
			boolean over = false;
			
			for(int k = 0; k < rolls; k++)
			{
				int next = Integer.parseInt(br.readLine());
				if(!over)
				{
					players[k%numPlayers] += next;
					if(list.containsKey(players[k%numPlayers]))
						players[k%numPlayers] = list.get(players[k%numPlayers]);
					if(players[k%numPlayers] >= 99)
						over = true;
				}
			}
			
			for(int l = 0; l < players.length; l++)
			{	
				if(players[l] > 99)
					players[l] = 99;
				System.out.println("Position of player "+(l+1) +" is " +(players[l]+1) +".");
			}
		}
	}

}
