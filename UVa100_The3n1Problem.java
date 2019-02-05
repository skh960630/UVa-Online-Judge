package UVa;

import java.util.Scanner;

class UVa100_The3n1Problem {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int x = i;
			int y = j;
			
			if(i > j) {
				x = j;
				y = i;
			}
			
			int result = 0;
			
			for(int a = x; a <= y; a++) {
				int l = 1;
				int temp = a;
				
				while(temp > 1) {
					if(temp%2 == 0) {
						temp /= 2;
					}else {
						temp = temp * 3 + 1;
					}
					l++;
				}
				
				result = Math.max(result, l);
			}
			
			System.out.println(i + " " + j + " " + result);
		}
	}

}
