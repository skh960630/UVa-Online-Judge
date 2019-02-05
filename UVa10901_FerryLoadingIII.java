package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

class UVa10901_FerryLoadingIII {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int c = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < c; i++) {
			String[] split = br.readLine().split(" ");
			
			int n = Integer.parseInt(split[0]);
			int t = Integer.parseInt(split[1]);
			int m = Integer.parseInt(split[2]);
			
			String[] side = new String[m];
			int[] time = new int[m];
			
			for(int j = 0; j < m; j++) {
				split = br.readLine().split(" ");
				time[j] = Integer.parseInt(split[0]);
				side[j] = split[1];
			}
			
			int num = 0;
			int currentTime = 0;
			int count = 0;
			String position = "left";
			LinkedList<Integer> leftWaitings = new LinkedList<>();
			LinkedList<Integer> rightWaitings = new LinkedList<>();
			int[] results = new int[m];
			
			while(count < m) {		
				while(num < m) {
					int temp = time[num]-currentTime;
					
					if(temp <= 0) {
						if(side[num].equals("left")) {
							leftWaitings.add(num);
						}else {
							rightWaitings.add(num);
						}
						num++;
					}else {
						break;
					}
				}
				
				if(leftWaitings.isEmpty() && rightWaitings.isEmpty()) {
					currentTime += time[num]-currentTime;
				}else {
					int loads = 0;
					
					if(position.equals("left")) {
						if(!leftWaitings.isEmpty()) {
							while(!leftWaitings.isEmpty() && loads < n) {
								int cargo = leftWaitings.poll();
								results[cargo] = currentTime + t;
								loads++;
							}
						}
						
						position = "right";
					}else {
						if(!rightWaitings.isEmpty()) {
							while(!rightWaitings.isEmpty() && loads < n) {
								int cargo = rightWaitings.poll();
								results[cargo] = currentTime + t;
								loads++;
							}
						}
						
						position = "left";
					}
					
					count += loads;
					currentTime += t;
				}
			}
			
			
			
			for(int r = 0; r < m; r++) {
				pw.println(results[r]);
			}
			
			
			if(i < c-1) {
				pw.println();
			}
		}
		
		pw.flush();
		pw.close();
	}

}
