package UVa;

import java.util.Scanner;

class UVa11878_HomeworkChecker {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String input = null;
		int count = 0;
		int n = 0;
		
		while(sc.hasNext() || n < 100) {
			n++;
			input = sc.nextLine();
			String[] split = input.split("=");
			
			if(!split[1].equals("?")) {
				int answer = Integer.parseInt(split[1]);
				int front = 0;
				int back = 0;
				char symbol = '+';
				
				for(int i = 0; i < split[0].length(); i++) {
					if(split[0].charAt(i) == '+') {
						front = Integer.parseInt(split[0].substring(0, i));
						back = Integer.parseInt(split[0].substring(i+1));
					}else if(split[0].charAt(i) == '-') {
						symbol = '-';
						front = Integer.parseInt(split[0].substring(0, i));
						back = Integer.parseInt(split[0].substring(i+1));
					}
				}
				
				if(symbol == '+') {
					if(front + back == answer) {
						count++;
					}
				}else {
					if(front - back == answer) {
						count++;
					}
				}
				
			}
			
		}
		
		System.out.println(count);
	}

}
