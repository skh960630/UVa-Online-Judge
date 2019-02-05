package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa12356_ArmyBuddies {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		PrintWriter pw = new PrintWriter(System.out);
		
		while((input = br.readLine()) != null) {
			String[] split = input.split(" ");
			int s = Integer.parseInt(split[0]);
			int b = Integer.parseInt(split[1]);
			
			if(s == 0 && b == 0) {
				break;
			}
			
			int[] left = new int[s+2];
			int[] right = new int[s+2];
			
			for(int x = 1; x <= s; x++) {
				left[x] = x-1;
				right[x] = x+1;
			}
			
			right[s] = 0;
			
			for(int i = 0; i < b; i++) {
				split = br.readLine().split(" ");
				int l = Integer.parseInt(split[0]);
				int r = Integer.parseInt(split[1]);
				
				if(left[l] == 0) {
					pw.print("* ");
				}else {
					pw.print(left[l] + " ");
				}
				
				if(right[r] == 0) {
					pw.println("*");
				}else {
					pw.println(right[r]);
				}
				
				left[right[r]] = left[l];
				right[left[l]] = right[r];
			}
			
			pw.println("-");
		}
		
		pw.flush();
		pw.close();
	}

}
