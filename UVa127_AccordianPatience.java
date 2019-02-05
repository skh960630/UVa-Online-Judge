import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.ArrayList;

class UVa127_AccordianPatience {
	
	public static void main(String[] args) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		
		while((input = br.readLine()) != null)
		{
			if(input.equals("#"))
				return;
			
			LinkedList<String> list = new LinkedList<>();
			LinkedList<Card> cards = new LinkedList<>();
			
			Collections.addAll(list, input.split(" "));
			
			input = br.readLine();
			
			Collections.addAll(list, input.split(" "));
			
			for(String s : list)
			{
				Card temp = new Card(s);
				cards.add(temp);
			}
			
			acc results = new acc();
			
			for(int i = 0; i < 52; i++)
				results.add(cards.get(i));
			
			System.out.println(results.toString());
		}
	}
	
	static class acc
	{
		private Card first;
		private Card last;
		
		public void add(Card c)
		{
			if(first == null)
			{
				first = c;
				last = c;
			}
			else
			{
				makeLast(c);
				placeCard(c);
			}
		}
		
		private void makeLast(Card c)
		{
			last.right = c;
			c.left = last;
			last = c;
		}
		
		private void placeCard(Card c)
		{
			if(c == null)
				return;
			
			if(prevThree(c))
			{
				if(c.under == null)
				{
					if(last == c)
						last = last.left;
					
					join(c);
				}
				else
				{
					if(last == c)
						last = last.under;
					
					underAvail(c);
				}
				
				threeLeft(c);
				
				placeCard(c);
				return;
			}
			else if(prevOne(c))
			{
				if(c.under == null)
					join(c);
				else
				{
					if(last == c)
						last = c.under;
					
					underAvail(c);
				}
				
				oneLeft(c);
				placeCard(c);
				
				return;
			}
			
			placeCard(c.right);
		}
		
		private void underAvail(Card c)
		{
			if(c.left != null)
				c.left.right = c.under;
			
			if(c.right != null)
				c.right.left = c.under;
			
			c.under.left = c.left;
			c.under.right = c.right;
		}
		
		private void oneLeft(Card c)
		{
			c.under = c.left;
			
			if(c.under == first)
				first = c;
			
			c.left = c.under.left;
			c.right = c.under.right;
			
			if(c.left != null)
				c.left.right = c;
			
			if(c.right != null)
				c.right.left = c;
		}
		
		private void threeLeft(Card c)
		{
			c.under = c.left.left.left;
			
			if(c.under == first)
				first = c;
			
			c.left = c.under.left;
			c.right = c.under.right;
			
			if(c.left != null)
				c.left.right = c;
			
			if(c.right != null)
				c.right.left = c;
		}
		
		private void join(Card c)
		{
			if(c.left != null)
				c.left.right = c.right;
			
			if(c.right != null)
				c.right.left = c.left;
		}
		
		private boolean prevThree(Card c)
		{
			if(c.left != null && c.left.left != null && c.left.left.left != null
					&& c.same(c.left.left.left))
				return true;
			else
				return false;
		}
		
		private boolean prevOne(Card c)
		{
			if(c.left != null && c.same(c.left))
				return true;
			else
				return false;
		}
		
		public String toString()
		{
			Card temp = first;
			ArrayList<Integer> count = new ArrayList<>();
			
			while(temp != null)
			{
				count.add(toCount(temp));
				temp = temp.right;
			}
			
			StringBuilder sb = new StringBuilder();
			
			if(count.size() == 1)
				sb.append(count.size() +" pile remaining:");
			else
				sb.append(count.size() +" piles remaining:");
			
			for(int i = 0; i < count.size(); i++)
				sb.append(" " +count.get(i));
			
			return sb.toString();
		}
		
		private int toCount(Card c)
		{
			int count = 1;
			Card temp = c;
			
			while(temp.under != null)
			{
				++count;
				temp = temp.under;
			}
			
			return count;
		}
	}
	
	static class Card
	{
		public Card left, right, under;
		private int value;
		private int suite;
		
		public Card(String s)
		{
			switch(s.charAt(0))
			{
			case '2': case '3': case '4': case'5': case'6': case'7': case'8': case'9':
				value = Integer.parseInt(s.charAt(0) +"");
				break;
				
			case 'T':
				value = 10;
				break;
				
			case 'J':
				value = 11;
				break;
				
			case 'Q':
				value = 12;
				break;
				
			case 'K':
				value = 13;
				break;
				
			case 'A':
				value = 1;
				break;
			}
			
			switch(s.charAt(1))
			{
			case 'S':
				suite = 1;
				break;
				
			case 'H':
				suite = 2;
				break;
				
			case 'C':
				suite = 3;
				break;
				
			case 'D':
				suite = 4;
				break;
			}
		}
		
		public boolean same(Card c)
		{
			if(value == c.value || suite == c.suite)
				return true;
			else
				return false;
		}
	}
}
