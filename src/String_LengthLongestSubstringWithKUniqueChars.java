import java.util.*;

public class String_LengthLongestSubstringWithKUniqueChars {
	public static void main(String[] args) {
		String str1 = "";
		String str2 = "abcadcacacaca";
		
		System.out.println(lengthLongestSubstring(str2, 3));
	}
	
	public static int lengthLongestSubstring(String str, int k) {
		if(str == null || str.length() == 0 || k == 0)
			return 0;
		
		if(k > str.length())
			return str.length();
		
		int max = k;
		int start = 0;
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			
			if(map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
			
			if(map.size() > k) {
				max = Math.max(max, i-start);
				
				while(map.size() > k) {
					char front = str.charAt(start);
					
					if(map.get(front) > 1)
						map.put(front, map.get(front)-1);
					else
						map.remove(front);
					
					start++;
				}
			}
		}
		
		max = Math.max(max, str.length()-start);
		return max;
	}
}
