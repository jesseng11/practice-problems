import java.io.*;
import java.util.*;

//How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop, and min should all operate in O(1) time.
public class Stack_WithMin {
  public static void main(String[] args) {
    StackWithMin s = new StackWithMin();
    s.push(10);
    System.out.println(s.min());
    s.push(20);
    System.out.println(s.min());
    s.push(1);
    System.out.println(s.min());
    s.pop();
    s.push(30);
    System.out.println(s.min());
    s.push(5);
    System.out.println(s.min());
  }
}

@SuppressWarnings("serial")
class StackWithMin extends Stack<Integer> {
  public Stack<Integer> minStack;
  
  public StackWithMin() {
    minStack = new Stack<Integer>(); 
  }
  
  public void push(int value) {
    if(value <= min()) {
      minStack.push(value);
    }
    super.push(value);
  }
  
  public Integer pop(){
    int value = super.pop();
    if(value == min()) {
      minStack.pop(); 
    }
    return value;
  }
  
  public Integer min() {
    if(minStack.isEmpty())
      return Integer.MAX_VALUE;
    else
      return minStack.peek();
  }
}