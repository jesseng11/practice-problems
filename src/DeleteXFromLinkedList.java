import java.io.*;
import java.util.*;

public class DeleteXFromLinkedList {
  public static void main(String[] args) {
    LinkedListNode node = new LinkedListNode(1);
    node.appendToTail(2);
    node.appendToTail(3);
    node.appendToTail(2);
    node.appendToTail(1);
    
    LinkedListNode result = deleteXFromList(node, 2);
    while(result != null) {
      System.out.println(result.data);
      result = result.next;
    }
  }
  
  public static LinkedListNode deleteXFromList(LinkedListNode node, int x) {
    LinkedListNode helper = new LinkedListNode();
    helper.next = node;
    LinkedListNode p = helper;
    
    while(p.next != null) {
      if(p.next.data == x)
        p.next = p.next.next;
      else
        p = p.next;
    }
    
    return helper.next;
  }
}
