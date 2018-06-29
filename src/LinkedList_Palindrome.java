import java.io.*;
import java.util.*;

public class LinkedList_Palindrome {
  public static void main(String[] args) {
    LinkedListNode node = new LinkedListNode(1);
    node.appendToTail(2);
    node.appendToTail(3);
    node.appendToTail(2);
    node.appendToTail(1);
    
    System.out.println(isPalindromeReverseCompare(node));
    System.out.println(isPalindromeIterative(node));
    
  }
  
  //SOLUTION 1
  public static boolean isPalindromeReverseCompare(LinkedListNode head) {
    LinkedListNode reversed = reverseAndClone(head);
    return isEqual(head, reversed);
  }
  
  // 1 2 3 null
  // 3 2 1 null
  public static LinkedListNode reverseAndClone(LinkedListNode node) {
    LinkedListNode head = null;
    
    while(node != null) {
      LinkedListNode n = new LinkedListNode(node.data);
      n.next = head;
      head = n;
      node = node.next;
    }
    
    return head;
  }
  
  public static boolean isEqual(LinkedListNode one, LinkedListNode two) {
    while(one != null && two != null) {
      if(one.data != two.data)
        return false;
      
      one = one.next;
      two = two.next;
    }
    
    return one == null && two == null;
  }
  
  //SOLUTION 2
  public static boolean isPalindromeIterative(LinkedListNode head) {
    LinkedListNode slow = head;
    LinkedListNode fast = head;
    
    Stack<Integer> stack = new Stack<Integer>();
    
    while(fast != null && fast.next != null) {
      stack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }
    
    //odd elements, skip over middle element
    if(fast != null) {
      slow = slow.next; 
    }
    
    while(slow != null) {
      int top = stack.pop().intValue();
      
      if(slow.data != top)
        return false;
      
      slow = slow.next;
    }
    
    return true;
  }
}