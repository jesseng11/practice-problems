import java.io.*;
import java.util.*;

public class LinkedList_FindKthToLastElement {
  public static void main(String[] args) {
    LinkedListNode n = new LinkedListNode(1);
    n.appendToTail(2);
    n.appendToTail(3);
    n.appendToTail(4);
    n.appendToTail(5);
    n.appendToTail(6);
    
    System.out.println(findKthToLastElementInList(n, 4));
    
    System.out.println(runnerSolution(n, 4));
  }
  
  //O(n)
  public static int findKthToLastElementInList(LinkedListNode n, int k) {
    LinkedListNode temp = n;
    int length = 0;
    
    while(temp != null) {
      temp = temp.next;
      length++;
    }
    
    int index = length - k;
    int counter = 0;
    
    while(counter != index) {
      n = n.next;
      counter++;
    }
    
    return n.data;
  }
  
  public static int runnerSolution(LinkedListNode n, int k) {
    LinkedListNode runner = n;
    int counter = 0;
    
    while(counter < k && runner != null) {
      runner = runner.next;
      counter++;
    }
    
    while(runner != null) {
      runner = runner.next; 
      n = n.next;
    }
    
    return n.data;
    
//     LinkedListNode p1 = n;
//     LinkedListNode p2 = n;
    
//     for(int i = 0; i < k; i++) {
//       p1 = p1.next; 
//     }
    
//     while(p1 != null) {
//       p1 = p1.next;
//       p2 = p2.next;
//     }
    
//     return p2.data;
  }
}