package practice;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringNoRep {
	 public int lengthOfLongestSubstring(String s) {
	        Map<Character, Integer> charMap = new HashMap<>();
	        int begin = 0;
	        int longest = 0;
	        for(int i=0; i<s.length(); i++){
	            if(charMap.containsKey(s.charAt(i))) {
	            	begin = Math.max(begin,charMap.get(s.charAt(i))+1);
	            }
	            charMap.put(s.charAt(i), i);
	            longest = Math.max(longest, i-begin+1);
	            
	        }
	        return longest;
	    }
	 
	 public static void main(String[] args) {
		 LongestSubStringNoRep obj = new LongestSubStringNoRep();
		 
		System.out.println(obj.lengthOfLongestSubstring("aabaab!bb"));
		System.out.println(obj.lengthOfLongestSubstring("pwwkew"));
		System.out.println(obj.lengthOfLongestSubstring("bbbbbb"));
		System.out.println(obj.lengthOfLongestSubstring(""));
		System.out.println(obj.lengthOfLongestSubstring("dvdf"));
		System.out.println(obj.lengthOfLongestSubstring("dvkvdvkefskdeicndjfancadjfitencaeir"));
	}
	 
}

