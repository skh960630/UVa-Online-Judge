package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;

class UVa10855_RotatedSquare {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		PrintWriter pw = new PrintWriter(System.out);
		
		while((input = br.readLine()) != null) {
			String[] split = input.split(" ");
			int N = Integer.parseInt(split[0]);
			int n = Integer.parseInt(split[1]);
			
			if(N == 0 && n == 0) {
				break;
			}
			
			String[] top = new String[N];
			String[][] bot = new String[4][n]; // 0,90,180,270
			char[][][] bottom = new char[4][n][n];
			
			for(int i = 0; i < N; i++) {
				top[i] = br.readLine();
			}
			
			for(int x = 0; x < n; x++) {
				input = br.readLine();
				
				for(int y = 0; y < n; y++) {
					char value = input.charAt(y);
					bottom[0][x][y] = value;
					bottom[1][y][n-x-1] = value;
					bottom[2][n-x-1][n-y-1] = value;
					bottom[3][n-y-1][x] = value;
				}
			}
			
			for(int j = 0; j < 4; j++) {				
				for(int k = 0; k < n; k++) {
					String temp = "";
					
					for(int l = 0; l < n; l++) {
						temp += bottom[j][k][l];
					}

					bot[j][k] = temp;
				} 
			}
			
			int limit = N-n+1;
			
			for(int a = 0; a < 4; a++) {
				int result = 0;
				
				for(int b = 0; b < limit; b++) {
					for(int c = 0; c < limit; c++) {
						if(bot[a][0].equals(top[b].substring(c, c+n))) {
							boolean appearance = true;
							
							for(int d = 1; d < n; d++) {
								if(!bot[a][d].equals(top[b+d].substring(c, c+n))) {
									appearance = false;
									break;
								}
							}
							
							if(appearance) {
								result++;
							}
						}
					}
				}
				
				pw.print(result);
				if(a < 3) {
					pw.print(" ");
				}
			}
			pw.println();
		}
		
		pw.flush();
		pw.close();
	}

}
