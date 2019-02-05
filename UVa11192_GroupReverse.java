package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa11192_GroupReverse {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		PrintWriter pw = new PrintWriter(System.out);
		
		while(!(input = br.readLine()).equals("0")) {
			String[] split = input.split(" ");
			int g = Integer.parseInt(split[0]);
			String line = split[1];
			int length = split[1].length()/g;			
			String result = "";
			
			for(int i = 0; i < line.length(); i+=length) {
				result += reverseString(line.substring(i, i+length));
			}
			
			pw.println(result);
		}
		
		pw.flush();
		pw.close();
	}
	
	static String reverseString(String line) {
		String reversed = "";
		
		for(int i = line.length()-1; i >= 0; i--) {
			reversed += line.charAt(i);
		}
		
		return reversed;
	}

}
