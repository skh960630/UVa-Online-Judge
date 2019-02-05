package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

class UVa10252_CommonPermutation {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String top = null;
		PrintWriter pw = new PrintWriter(System.out);
		
		while((top = br.readLine()) != null) {
			String bottom = br.readLine();
			
			ArrayList<Character> permutation = new ArrayList<>();
			ArrayList<Character> results = new ArrayList<>();
			
			for(int i = 0; i < top.length(); i++) {
				permutation.add(top.charAt(i));
			}
			
			for(int j = 0; j < bottom.length(); j++) {
				char temp = bottom.charAt(j);
				
				if(permutation.contains(temp)) {
					results.add(temp);
					permutation.remove(permutation.indexOf(temp));
				}
			}
			
			Collections.sort(results);
			
			for(int k = 0; k < results.size(); k++) {
				pw.print(results.get(k));
			}
			
			pw.println();
		}
		
		pw.flush();
		pw.close();
		
	}

}
