import java.io.*;
import java.util.*;

public class LinkedList_RemoveDuplicates {
  public static void main(String[] args) {
    LinkedListNode node = new LinkedListNode(1);
    node.appendToTail(2);
    node.appendToTail(2);
    node.appendToTail(3);
    node.appendToTail(4);
    node.appendToTail(4);

    removeDups2(node);
    
    while(node != null) {
      System.out.println(node.data);
      node = node.next;
    }
  }
  
  //O(n)
  static void removeDups(LinkedListNode n) {
    if(n == null)
      return;
    
    HashSet<Integer> set = new HashSet<Integer>();
    LinkedListNode prev = null;
    
    while(n != null) {
      if(set.contains(n.data)){
        prev.next = n.next;
      }
      else {
        set.add(n.data); 
        prev = n;
      }
      
      n = n.next;
    }
    
    return;
  }
  
  //space O(1)
  //time O(n^2)
  static void removeDups2(LinkedListNode n) {
    LinkedListNode runner = null;
    
    while(n != null) {
      runner = n.next;
      
      while(runner != null) {
        if(runner.data == n.data) {
           n.next = runner.next;
        }
        
        runner = runner.next;
      }
      
      n = n.next;
    }
    
    return;
  }
}