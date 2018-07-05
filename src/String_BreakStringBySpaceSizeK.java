import java.util.ArrayList;

/*
 * Given string of words separated by spaces and a number k, 
 * return the original string broken up into the lines such that no 
 * line has more than k characters and each line contains the maximum 
 * number of words that can fit
 * 
 * "foo bar baz" k=2 -> error
 * "foo bar baz" k=3 -> ["foo", "bar", "baz"]
 * "foo bar baz" k=6 -> ["foo", "bar", "baz"]
 * "foo bar baz" k=7 -> ["foo bar", "baz"]
 */
public class String_BreakStringBySpaceSizeK {
	public static void main(String[] args) {
		String str = "foo bar baz";
		int k = 6;
		
		ArrayList<String> result = breakString(str, k);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
	
	public static ArrayList<String> breakString(String str, int k) {
		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> words = new ArrayList<String>();
		StringBuilder sb = new StringBuilder();
		int beginningIndex = 0;
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ' || i == str.length()-1) {
				String word = str.substring(beginningIndex, i+1);
				beginningIndex = i+1;
				words.add(word.trim());
				
				if(word.trim().length() > k) {
					return null;
				}
			}
		}
		
		sb.append(words.get(0));
		
		for(int i = 1; i < words.size(); i++) {
			int count = sb.length() + words.get(i).length() + 1;
			
			if(count <= k) {
				sb.append(" ");
				sb.append(words.get(i));
			}
			
			else {
				result.add(sb.toString());
				sb = new StringBuilder();
				sb.append(words.get(i));
			}
		}
		
		result.add(sb.toString());
		
		return result;
	}
}
