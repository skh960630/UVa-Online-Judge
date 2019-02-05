package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class UVa591_BoxOfBricks {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int n = 0;
		int set = 1;
		
		while((n = Integer.parseInt(br.readLine())) != 0) {
			int[] bricks = new int[n];
			String[] input = br.readLine().split(" ");
			int total = 0;
			
			for(int i = 0; i < n; i++) {
				bricks[i] = Integer.parseInt(input[i]);
				total += bricks[i];
			}
			
			total /= n;
			int result = 0;
			
			for(int j = 0; j < n; j++) {
				if(total > bricks[j]) {
					result += total-bricks[j];
				}else if(total < bricks[j]) {
					result += bricks[j]-total;
				}
			}
			
			result /= 2;	
			
			pw.println("Set #" + set);
			pw.println("The minimum number of moves is " + result + ".");
			pw.println();
			
			set++;
		}
		
		pw.flush();
		pw.close();
	}

}
