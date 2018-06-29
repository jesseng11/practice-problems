import java.util.*;

public class Stack_ReturnBalancedParenthesesStr {
	public static String fixParenthesis(String paren) {
	    if(paren == null) 
	    	return null;
	    
	    char[] str = paren.toCharArray();
	    Stack<Integer> stack = new Stack<Integer>();
	
	    for(int i =0; i < str.length; i++) {
	        if(str[i] == '(') 
	        	stack.push(i);
	        
	        else if(str[i] == ')') {
	            if(stack.isEmpty()) 
	            	str[i] = ' ';
	            else 
	            	stack.pop();
	        }
	    }
	
	    while(!stack.isEmpty()) {
	        str[stack.pop()] = ' ';
	    }
	
	    return String.valueOf(str).trim();
	}
	
	public static void main(String[] args) {
		String str = "(((";
		String str2 = "(()()))";
		String str3 = "((()(())";
		    
		System.out.println(fixParenthesis(str));
		System.out.println(fixParenthesis(str2));
		System.out.println(fixParenthesis(str3));
	}
}