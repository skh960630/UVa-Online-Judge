package UVa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class UVa12577_HajjeAkbar {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		
		String input = br.readLine();
		int i = 1;
		
		while(!input.contentEquals("*")) {
			if(input.contentEquals("Hajj")) {
				pw.println("Case " + i + ": Hajj-e-Akbar");
			}else {
				pw.println("Case " + i + ": Hajj-e-Asghar");
			}
			
			i++;
			
			input = br.readLine();
		}
		
		pw.flush();
		pw.close();
	}
}
