import java.util.Scanner;
import java.util.Vector;

class UVa10591_HappyNumber {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		for(int i = 0; i < t; i++)
		{
			Vector<Long> list = new Vector<Long>();
			list.add((long) 1);
			long n = sc.nextLong();
			long temp = 0;	
			long div = n%10;
			long tempN = n;
			
			while(!list.contains(temp))
			{
				list.add(temp);
				div = tempN%10;
				temp = 0;
				
				while(tempN > 0)
				{
					temp += (div*div);
					tempN = tempN/10;
					div = tempN%10;	
				}
				
				tempN = temp;
			}
			
			int caseN = i+1;
			
			if(temp == 1)
				System.out.println("Case #" +caseN +": " +n +" is a Happy number.");
			else
				System.out.println("Case #" +caseN +": " +n +" is an Unhappy number.");
		}
	}

}
