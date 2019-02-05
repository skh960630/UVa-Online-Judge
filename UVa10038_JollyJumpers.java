package UVa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.IOException;

class UVa10038_JollyJumpers {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null) {
			String[] split = input.split(" ");
			int n = Integer.parseInt(split[0]);
			int[] nums = new int[n-1];
			boolean result = true;
			
			for(int j = 2; j < split.length; j++) {
				int test = Integer.parseInt(split[j]) - Integer.parseInt(split[j-1]);
				
				if(test < 0) {
					test *= -1;
				}
				nums[j-2] = test;
			}
			
			Arrays.sort(nums);
			
			for(int i = nums.length-1; i >= 0; i--) {
				n--;
				
				if(nums[i] != n) {
					result = false;
					break;
				}
			}
			
			if(result) {
				System.out.println("Jolly");
			}else {
				System.out.println("Not jolly");
			}
			
			
		}
	}

}
