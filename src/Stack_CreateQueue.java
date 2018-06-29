import java.io.*;
import java.util.*;

//Implement a MyQueue which implements a queue using two stacks
public class Stack_CreateQueue {
  public static void main(String[] args) {
    MyQueue queue = new MyQueue();
    
    queue.enqueue(1);
    queue.enqueue(2);
    System.out.println(queue.dequeue());
    queue.enqueue(3);
    queue.enqueue(4);
    System.out.println(queue.dequeue());
  }
}

class MyQueue{
  public Stack<Integer> lastOnTop;
  public Stack<Integer> firstOnTop;
  
  public MyQueue() {
    lastOnTop = new Stack<Integer>(); 
    firstOnTop = new Stack<Integer>(); 
  }
  
  public void enqueue(Integer value) {
    lastOnTop.push(value);
  }
  
  public Integer dequeue() {
    shiftStacks();
    return firstOnTop.pop();
  }
  
  public Integer peek() {
    shiftStacks();
    return firstOnTop.peek();    
  }
  
  private void shiftStacks() {
    if(firstOnTop.isEmpty()) {
      while(!lastOnTop.isEmpty()) {
        firstOnTop.push(lastOnTop.pop()); 
      }
    }
  }
}