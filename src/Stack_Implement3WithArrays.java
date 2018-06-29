import java.io.*;
import java.util.*;

//Use single array to implement 3 stacks
public class Stack_Implement3WithArrays {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
  }
}

class FixedMultiStack {
  public int numStacks = 3;
  public int sizeCapacity;
  public int[] size;
  public int[] values;
  
  public FixedMultiStack(int stackSize) {
    sizeCapacity = stackSize;
    size = new int[numStacks];
    values = new int[stackSize * numStacks];
  }
  
  public void push(int stackNum, int n) {
    if(isFull(stackNum))
      return;
      //throw new FullStackException();
    
    int index = topIndex(stackNum);
    values[index] = n;
    size[stackNum]++;
  }
  
  public int pop(int stackNum) {
    if(isEmpty(stackNum))
      return -1;
      //throw new EmptyStackException();
    
    int index = topIndex(stackNum);
    int value = values[index];
    values[index] = 0;
    size[stackNum]--;
    return value;
  }
  
  public int peek(int stackNum) {
    if(isEmpty(stackNum))
      return -1;
      //throw new EmptyStackException();
    
    return values[topIndex(stackNum)];
  }
  
  public boolean isEmpty(int stackNum) {
    if(size[stackNum] == 0)
      return true;
    
    return false;
  }
  
  public boolean isFull(int stackNum) {
    if(size[stackNum] == sizeCapacity)
      return true;
    
    return false;
  }
  
  private int topIndex(int stackNum) {
    int offset = (stackNum - 1) * sizeCapacity;
    int stackSize = size[stackNum];
    return offset + stackSize + 1;
  }
}
