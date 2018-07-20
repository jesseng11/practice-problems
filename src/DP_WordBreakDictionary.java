import java.util.*;

public class DP_WordBreakDictionary {
	public static void main(String[] args) {
		Set<String> dict = new HashSet<String>();
		dict.add("icecream");
		dict.add("ice");
		dict.add("cream");
		dict.add("i");
		dict.add("like");
		String sent = "ilikeicecream";
		
		System.out.println(wordBreakDP(sent, dict));
	}
	
	public static boolean wordBreakRec(String str, Set<String> dict) {
		return wordBreakRec(str, dict, 0);
	}
	
	//O(n^2)
	public static boolean wordBreakRec(String str, Set<String> dict, int startIndex) {
		if(startIndex == str.length())
			return true;
		
		for(String word: dict) {
			int len = word.length();
			int endIndex = startIndex + len;
			
			if(endIndex > str.length())
				continue;
			
			if(str.substring(startIndex, endIndex).equals(word)) {
				if(wordBreakRec(str, dict, endIndex))
					return true;
			}
		}
		
		return false;
	}
	
	//O(s*d) where s is string length and d is dict size
	public static boolean wordBreakDP(String str, Set<String> dict) {
		boolean[] t = new boolean[str.length()+1];
		t[0] = true;
		
		for(int i = 0; i < str.length(); i++) {
			if(!t[i])
				continue;
			
			for(String word: dict) {
				int len = word.length();
				int endIndex = i + len;
				
				if(endIndex > str.length())
					continue;
				
				if(str.substring(i, endIndex).equals(word))
					t[endIndex] = true;
			}
		}

//		for(int i = 0; i < t.length; i++) {
//			System.out.println(t[i]);
//		}
		
		return t[str.length()];
	}
}
