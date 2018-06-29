import java.io.*;
import java.util.*;

public class Stack_IsBalancedParentheses {
  public static void main(String[] args) {
    String str = "()[{}]";
    String str2 = "(asdv)[{}]";
    String str3 = "(asdv)[{}}]";
    
    System.out.println(isValidParentheses(str));
    System.out.println(isValidParentheses(str2));
    System.out.println(isValidParentheses(str3));
  }
  
  public static boolean isValidParentheses(String str) {
    HashMap<Character, Character> map = new HashMap<Character, Character>();
    map.put('(', ')');
    map.put('[', ']');
    map.put('{', '}');
    
    Stack<Character> stack = new Stack<Character>();
    
    for(Character c: str.toCharArray()) {
      if(map.keySet().contains(c)) {
        stack.push(c); 
      }
      else if (map.values().contains(c)) {
        if(!stack.isEmpty() && map.get(stack.peek()) == c)
          stack.pop(); 
        else
          return false;
      }
    }
    
    return stack.isEmpty();
  }
}
