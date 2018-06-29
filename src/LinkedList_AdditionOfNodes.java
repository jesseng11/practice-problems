import java.io.*;
import java.util.*;

public class LinkedList_AdditionOfNodes {
  public static void main(String[] args) {
    //617
    LinkedListNode l1 = new LinkedListNode(7);
    l1.appendToTail(1);
    l1.appendToTail(6);
    
    //295
    LinkedListNode l2 = new LinkedListNode(5);
    l2.appendToTail(9);
    l2.appendToTail(2);
    
    //912
    LinkedListNode result = addLists(l1, l2, 0);
    while(result != null) {
      System.out.println(result.data);
      result = result.next;
    }
  }
  
  public static LinkedListNode addLists(LinkedListNode l1, LinkedListNode l2, int carry) {
    if(l1 == null && l2 == null && carry == 0)
      return null;
    
    LinkedListNode result = new LinkedListNode();
    int value = carry;
    
    if(l1 != null)
      value += l1.data;
    if(l2 != null)
      value += l2.data;
    
    result.data = value % 10; //rightmost digit
    
    if(l1 != null || l2 != null) {
      LinkedListNode more = addLists(
        l1 == null ? null : l1.next,
        l2 == null ? null : l2.next,
        value >= 10 ? 1 : 0);
      
      result.next = more;
    }
    
    return result;
  }
}