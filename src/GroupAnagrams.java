import java.util.*;

public class GroupAnagrams {  
	public static void main(String[] args) {
		String[] anagrams = {"cab", "top", "pot", "cba", "abc"};
		
//		for(List<String> groups: groupAnagramsOkay(anagrams)) {
//			System.out.println(groups);
//		}
		
		for(List<String> groups: groupAnagrams(anagrams)) {
			System.out.println(groups);
		}
	}
	
	//time: O(nklogk) where n is length of strs and k is max length of string in str
	//space: O(nk)
	public static List<List<String>> groupAnagramsOkay(String[] strs) {
		if(strs.length == 0)
			return new ArrayList();
		
		Map<String, List> results = new HashMap<String, List>();
		
		for(String s: strs) {
			char[] charArr = s.toCharArray();
			
			Arrays.sort(charArr);
			
			String key = String.valueOf(charArr);
			
			if(!results.containsKey(key)) {
				results.put(key, new ArrayList());
			}
			
			results.get(key).add(s);
		}
		
		return new ArrayList(results.values());
	}
	
	//O(nk) for both space and time
	public static List<List<String>> groupAnagrams(String[] strs) {
		if(strs.length == 0)
			return new ArrayList();
		
		Map<String, List> results = new HashMap<String, List>();
		
		int[] count = new int[26];
		
		for(String s: strs) {
			Arrays.fill(count, 0);
			
			for(char c: s.toCharArray())
				count[c - 'a']++;
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < 26; i++) {
				sb.append('#');
				sb.append(count[i]);
			}
			
			String key = sb.toString();
			
			if(!results.containsKey(key))
				results.put(key, new ArrayList());
			
			results.get(key).add(s);
		}
		
		return new ArrayList(results.values());
	}
}
