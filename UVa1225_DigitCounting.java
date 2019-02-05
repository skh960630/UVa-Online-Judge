package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa1225_DigitCounting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		PrintWriter pw = new PrintWriter(System.out);
		
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(br.readLine());
			int[] results = new int[10];
			
			for(int j = 1; j <= num; j++) {
				int temp = j;
				while(temp != 0) {
					int digit = temp%10;
					results[digit] += 1;
					temp = temp/10;
				}
			}
			
			for(int r = 0; r < results.length; r++) {
				pw.print(results[r]);
				if(r != results.length-1) {
					pw.print(" ");
				}
			}
			
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}
}
