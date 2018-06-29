import java.io.*;
import java.util.*;

public class LinkedList_FindStartOfCycle {
  public static void main(String[] args) {
    LinkedListNode circularList = new LinkedListNode(1);
    
    LinkedListNode a = new LinkedListNode(2);
    LinkedListNode b = new LinkedListNode(3);
    LinkedListNode c = new LinkedListNode(4);
    circularList.setNext(a);
    a.setNext(b);
    b.setNext(c);
    
    LinkedListNode temp = circularList;
    while(temp != null) {
      System.out.println(temp.data);
      temp = temp.next;
    }
    
    LinkedListNode d = new LinkedListNode(5);
    LinkedListNode e = new LinkedListNode(6);
    LinkedListNode f = new LinkedListNode(7);
    LinkedListNode g = new LinkedListNode(8);
    LinkedListNode h = new LinkedListNode(9);
    
    d.setNext(e); //start of cycle
    e.setNext(f);
    f.setNext(g);
    g.setNext(h);
    h.setNext(d); //CYCLE CREATION!
    
    c.setNext(d); //link the straight list to cycle
    
    findStartOfCycle(circularList);
  }
  
  //find meeting point
  //this will be LOOP_SIZE - k steps into the linked list
  public static LinkedListNode findStartOfCycle(LinkedListNode node) {
    LinkedListNode slow = node;
    LinkedListNode fast = node;
    
    while(fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;
      
      if(slow == fast){ //collision
        System.out.println("collision at: " + slow.data);
        break;
      }
    }
    
    //check if there is actually a cycle
    if(fast == null || fast.next == null)
      return null;
    
    slow = node; //move slow to head
    
    //keep fast at meeting point. Each are k steps from the loop start
    //move at same pace to meet at loop start
    while(slow != fast) {
      slow = slow.next;
      fast = fast.next;
    }
    
    System.out.println("starting point of cycle at: " + fast.data);
    return fast;
  }
}
