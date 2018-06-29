import java.io.*;
import java.util.*;


//If the stack gets too high, it might topple, like a stack of plates. Start a new stack when the previous stack exceeds some threshold. Implement a data structure SetOfStacks that mimics this. SetOfStacks should be composed of several stacks and should create a new stack once the prev one exceeds capacity.
public class Stack_SetOfStacks {
  public static void main(String[] args) {
    SetOfStacks set = new SetOfStacks(2);
    
    set.push(1);
    set.push(2);
    System.out.println(set.pop());
    System.out.println(set.stacks.get(0).peek());
    set.push(3);
    set.push(4);
    set.push(5);
    set.push(6);
    set.push(7);
    System.out.println(set.pop());
    System.out.println(set.stacks.get(1).peek());
    System.out.println(set.stacks.get(2).peek());
  }
}

class SetOfStacks {
  public ArrayList<Stack<Integer>> stacks = new ArrayList<Stack<Integer>>(); 
  public int maxSize;
  
  public SetOfStacks(int size) {
    maxSize = size;
  }
  
  public void push(int value) {
    Stack<Integer> last = getLastStack();
    
    if(last != null && last.size() != maxSize) {
      last.push(value);
    }
    
    else {
      Stack<Integer> newStack = new Stack<Integer>();
      newStack.push(value);
      stacks.add(newStack);
    }
  }
  
  public Integer pop() {    
    Stack<Integer> last = getLastStack();
    
    if(last == null)
      return -1;
    
    int value = last.pop();
    
    if(last.isEmpty()) {
      stacks.remove(stacks.size() - 1);
    }
    
    return value;
  }
  
  public Stack<Integer> getLastStack(){
    if(stacks.size() == 0)
      return null;
    
    return stacks.get(stacks.size() - 1);
  }
  
  public boolean isEmpty(){
    Stack<Integer> last = getLastStack();
    return last == null || last.isEmpty();
  }
}