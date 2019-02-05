import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class UVa272_TEXQuotes {
	
	public static void main(String[] args) throws IOException{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String input = null;
		 boolean check = false;
		 
		 while((input = br.readLine()) != null)
		 {
			 for(int i = 0; i < input.length(); i++)
			 {
				 if(input.charAt(i) == '"')
				 {
					 if(!check)
					 {
						 check = true;
						 String temp;
						 if(i == 0)
							 temp = "``" + input.substring(i+1);
						 else
							 temp = input.substring(0, i) + "``" + input.substring(i+1);
						 input = temp;
					 }
					 else
					 {
						 check = false;
						 String temp = input.substring(0, i) + "''" + input.substring(i+1);
						 input = temp;
					 }
				 }
			 }
			 
			 System.out.println(input);
		 }
	}

}
