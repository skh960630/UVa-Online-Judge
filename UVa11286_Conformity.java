package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class UVa11286_Conformity {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int input = 0;
		
		while((input = Integer.parseInt(br.readLine())) != 0) {
			HashMap<String, Integer> combinations = new HashMap<>();
			ArrayList<String> courses = new ArrayList<>();
			int max = 1;
			int result = 0;
			
			for(int i = 0; i < input; i++) {
				String[] split = br.readLine().split(" ");
				int[] temp = new int[5];
				
				for(int j = 0; j < 5; j++) {
					temp[j] = Integer.parseInt(split[j]);
				}
				
				Arrays.sort(temp);
				String insert = "";
				
				for(int k = 0; k < 5; k++) {
					insert += temp[k];
				}
				
				if(combinations.containsKey(insert)) {
					int value = combinations.get(insert);
					combinations.replace(insert, value+1);
					value++;
					
					if(max < value) {
						max = value;
						result = value;
					}else if(max == value){
						result += value;
					}
					
				}else {
					combinations.put(insert, 1);
					courses.add(insert);
					
					if(max == 1) {
						result++;
					}
				}
			}
						
			pw.println(result);
		}
		
		pw.flush();
		pw.close();
	}

}
