import java.util.*;

public class Stack_PostfixProcessor {
	public static int evaluatePostfix(String exp) {
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i = 0; i < exp.length(); i++) {
			char c = exp.charAt(i);
			
			if(c == ' ')
				continue;
			
			/*char's are actually of the same type / length as shorts. Now when you have a char that represents a ASCII/unicode digit (like '1'), and you subtract the smallest possible ASCII/unicode digit from it (e.g. '0'), then you'll be left with the digit's corresponding value (hence, 1)*/
			else if(Character.isDigit(c)) {
				int n = 0;
				
				while(Character.isDigit(c)) {
					n = n*10 + (int)(c - '0');
					i++;
					c = exp.charAt(i);
				}
				
				i--;
				stack.push(n);
			}
			
			else {
				int val1 = stack.pop();
				int val2 = stack.pop();
				
				switch(c) {
					case '+':
					stack.push(val2+val1);
					break;
					
					case '-':
					stack.push(val2-val1);
					break;
					
					case '/':
					stack.push(val2/val1);
					break;
					
					case '*':
					stack.push(val2*val1);
					break;
				}
			}
		}
		
		return stack.pop();
	}
	
    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println(evaluatePostfix(exp));
    }
}
