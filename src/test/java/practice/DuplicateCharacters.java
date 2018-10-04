package practice;

import java.util.HashMap;
import java.util.Set;

public class DuplicateCharacters {
	
	public static void duplicateChar(String inputString)
	{
		//Create a Hashmap with Character and Integer
		HashMap<Character, Integer> charCountMap=new HashMap<Character, Integer>();
		
		char[] strArray = inputString.toCharArray();
		
		for(char c: strArray)
		{
			
			if(charCountMap.containsKey(c))
			{
				//charCountMap.put(c, charCountMap.get(c)+1);
				charCountMap.put(c,charCountMap.get(c)+1);
			}
			else
			{
				charCountMap.put(c, 1);
			}
			
			Set<Character> charInString = charCountMap.keySet(); 
			for(Character ch: charInString)
			{
				
				if(charCountMap.get(ch)>1)
				{
					System.out.println(ch +" : "+ charCountMap.get(ch));
				}
				
			}
			
			
		}
		
		
	}
	
	public static void main(String[] args)
    {
		duplicateChar("JavaJ2EE");
 
		duplicateChar("Fresh Fish");
 
		duplicateChar("Better Butter");
    }

}
