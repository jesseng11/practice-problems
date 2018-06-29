import java.io.*;
import java.util.*;

public class LinkedList_DeleteMiddleNode {
  public static void main(String[] args) {
    LinkedListNode n = new LinkedListNode(1);
    n.appendToTail(2);
    n.appendToTail(3);
    n.appendToTail(4);
    
    System.out.println("to delete: " + n.next.data);
    deleteNodeInMiddle(n.next);
    
    while(n != null){
      System.out.println(n.data);
      n = n.next;
    }
  }
  
  public static boolean deleteNodeInMiddle(LinkedListNode n) {
    if(n.next == null || n == null)
      return false; //is tail or head, so don't return
    
    LinkedListNode next = n.next;
    n.data = next.data;
    n.next = next.next;
    
    return true;
  }
}
