import java.io.*;
import java.util.*;

//Write a program to sort a stack such that the smallest items are on the top. You can use an additional temporary stack, but you may not copy the elements into any other data structure (such as an array). The stack supports the following operations: push, pop, peek, and isEmpty.
public class Stack_SortElements {
  public static void main(String[] args) {
    Stack<Integer> s = new Stack<Integer>();
    s.push(5);
    s.push(10);
    s.push(7);
    s.push(12);
    s.push(8);
    s.push(3);
    s.push(1);
    
    sort(s);
    
    while(!s.isEmpty()) {
      System.out.println(s.pop()); 
    }
  }
  
  //time O(n^2)
  //space O(n)
  public static void sort(Stack<Integer> s) {
    Stack<Integer> t = new Stack<Integer>();
         
    while(!s.isEmpty()) {
      Integer temp = s.pop();

      while(!t.isEmpty() && t.peek() > temp) {
         s.push(t.pop());
      }

      t.push(temp);
    }
    
    while(!t.isEmpty()) {
      s.push(t.pop()); 
    }
  }
  
  //if we could use unlimited stacks, could use quicksort or mergesort
  //but that creates two additional stacks per level of recursion
}
