import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Example {
	
	/*
	 * "gurugram" g - (g,2) u - (u,2) r - (r,2) a - (a,1) m - (m,1)
	 */
	
	public static void main(String[] args) {
		String input = args[0];
		
		//validate if it is not empty
		
		//get it to array 
		
		
		//hashset
		Set<Character> charSet = new HashSet<Character>();
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		char[] data = input.toCharArray();
		for(int count = 0; count < data.length; count++) {
			if(charMap.containsKey(data[count])) {
				charMap.put(data[count], charMap.get(data[count])+1);
			}else {
				charMap.put(data[count],1);
			}
		}
		System.out.println(charMap);
		
		
	}

}
