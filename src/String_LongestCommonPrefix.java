
public class String_LongestCommonPrefix {
	public static void main(String[] args) {
		String[] arr = {"leets", "leedcode", "leet", "leeds"};
		System.out.println(betterLongestCommonPrefix(arr));
	}
	
	//O(S), where S is the sum of all characters in all strings.
	//Horizontal scanning
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		
		String prefix = strs[0];
		
		for(int i = 1; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if(prefix.isEmpty())
					return "";
			}
		}
		
		return prefix;
	}
	
	//find shortest str first
	public static String betterLongestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)
			return "";
		
		if(strs.length == 1)
			return strs[0];
		
		int minLen = Integer.MAX_VALUE;
		
		for(String str: strs) {
			if(minLen > str.length()) {
				minLen = str.length();
			}
		}
		
		for(int i = 0; i < minLen; i++) {
			for(int j = 0; j < strs.length - 1; j++) {
				String s1 = strs[j];
				String s2 = strs[j+1];
				System.out.println(s1 + ", " + s2);
				System.out.println(s1.charAt(i) + ": " + s2.charAt(i));
				if(s1.charAt(i) != s2.charAt(i)) {
					return s1.substring(0, i);
				}
			}
		}
		
		return strs[0].substring(0, minLen);
	}
	
	//Divide and Conquer
	public String longestCommonPrefixDC(String[] strs) {
	    if (strs == null || strs.length == 0) return "";    
	        return longestCommonPrefix(strs, 0 , strs.length - 1);
	}

	private String longestCommonPrefix(String[] strs, int l, int r) {
	    if (l == r) {
	        return strs[l];
	    }
	    else {
	        int mid = (l + r)/2;
	        String lcpLeft =   longestCommonPrefix(strs, l , mid);
	        String lcpRight =  longestCommonPrefix(strs, mid + 1,r);
	        return commonPrefix(lcpLeft, lcpRight);
	   }
	}

	String commonPrefix(String left,String right) {
	    int min = Math.min(left.length(), right.length());       
	    for (int i = 0; i < min; i++) {
	        if ( left.charAt(i) != right.charAt(i) )
	            return left.substring(0, i);
	    }
	    return left.substring(0, min);
	}
}
