package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

class UVa443_HumbleNumbers {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		ArrayList<Long> humbles = new ArrayList<>();
		humbles.add(1L);
		int count = 0;
		
		while(humbles.size() < 5842) {
			long factor1 = humbles.get(count) * 2;
			long factor2 = humbles.get(count) * 3;
			long factor3 = humbles.get(count) * 5;
			long factor4 = humbles.get(count) * 7;
			
			if(factor1 <= 2000000000 && !humbles.contains(factor1))
				humbles.add(factor1);
			if(factor2 <= 2000000000 && !humbles.contains(factor2))
				humbles.add(factor2);
			if(factor3 <= 2000000000 && !humbles.contains(factor3))
				humbles.add(factor3);
			if(factor4 <= 2000000000 && !humbles.contains(factor4))
				humbles.add(factor4);
			count++;
		}
		
		Collections.sort(humbles);
		
		int n = 0;
		
		while((n = Integer.parseInt(br.readLine())) != 0) {
			long result = humbles.get(n-1);
			int tenth = (n/10)%10;
			int oneth = n%10;
			String suffix = "th";
			
			if(tenth != 1) {
				if(oneth == 1) {
					suffix = "st";
				}else if(oneth == 2) {
					suffix = "nd";
				}else if(oneth == 3) {
					suffix = "rd";
				}
			}
			
			pw.println("The " + n + suffix + " humble number is " + result + ".");
		}
		
		pw.flush();
		pw.close();
	}
	
}
