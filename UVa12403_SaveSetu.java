package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class UVa12403_SaveSetu {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		int n = Integer.parseInt(br.readLine());
		int report = 0;
		
		for(int i = 0; i < n; i++) {
			String[] split = br.readLine().split(" ");
			String command = split[0];
			
			if(command.equals("donate")) {
				report += Integer.parseInt(split[1]);
			}else {
				pw.println(report);
			}
		}
		
		pw.flush();
		pw.close();
	}
}
