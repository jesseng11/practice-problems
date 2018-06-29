import java.io.*;
import java.util.*;

public class LinkedList_PartitionAtX {
  public static void main(String[] args) {
    LinkedListNode list = new LinkedListNode(3);
    list.appendToTail(5);
    list.appendToTail(8);
    list.appendToTail(5);
    list.appendToTail(10);
    list.appendToTail(2);
    list.appendToTail(1);
    
    list = partition(list, 5);
    
    while(list!=null){
      System.out.println(list.data);
      list = list.next;
    }
  }
  
  public static LinkedListNode partition(LinkedListNode node, int x) {
    LinkedListNode head = node;
    LinkedListNode tail = node;
    
    while(node != null) {
      LinkedListNode next = node.next;
      
      if(node.data < x) {
        node.next = head;
        head = node;
      }
      else {
        tail.next = node;
        tail = node;
      }
      
      node = next;
    }
    
    tail.next = null;
    return head;
  }
}