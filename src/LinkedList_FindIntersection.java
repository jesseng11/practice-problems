import java.io.*;
import java.util.*;

public class LinkedList_FindIntersection {
  public static void main(String[] args) {
    LinkedListNode l1 = new LinkedListNode(3);
    l1.appendToTail(5);
    l1.appendToTail(9);
    l1.appendToTail(7);
    l1.appendToTail(2);
    l1.appendToTail(1);
    
    LinkedListNode copyIntersect = l1.next.next.next; //7
    System.out.println("copyIntersect: " + copyIntersect.data);
    
    LinkedListNode l2 = new LinkedListNode(1);
    // l2.setNext(new LinkedListNode(4));
    // l2.setNext(new LinkedListNode(6));
    l2.setNext(copyIntersect);
    copyIntersect = copyIntersect.next;
    
    // LinkedListNode temp = l2;
    // while(temp != null) {
    //   System.out.println(temp.data);
    //   temp = temp.next;
    // }
    
    System.out.println("findIntersection: " + findIntersection(l1, l2).data);
    
  }
  
  //O(a+b) where a and b are lengths of the two lists
  //O(1) space
  public static LinkedListNode findIntersection(LinkedListNode l1, LinkedListNode l2) {
    if(l1 == null || l2 == null)
      return null;
    
    Result result1 = getSizeAndTail(l1);
    Result result2 = getSizeAndTail(l2);
    
    //no intersection
    if(result1.tail != result2.tail)
      return null;
    
    LinkedListNode shorter = (result1.size > result2.size) ? l2 : l1;
    LinkedListNode longer = (result1.size > result2.size) ? l1: l2;
    
    int diff = Math.abs(result1.size - result2.size);
    System.out.println("diff: " + diff);
    
    for(int i = 0; i < diff; i++) {
      longer = longer.next;
    }
    
    while(shorter != longer) {
      shorter = shorter.next;
      longer = longer.next;
    }
    
    return longer;
  }
  
  public static Result getSizeAndTail(LinkedListNode node) {
    if(node == null)
      return null;
    
    int size = 1;
    LinkedListNode curr = node;
    
    while(curr.next != null) {
      curr = curr.next;
      size++;
    }
    
    Result result = new Result(curr, size);
    return result;
  }
}


class Result {
  public LinkedListNode tail; 
  public int size;
  
  public Result(LinkedListNode t, int s) {
    this.tail = t;
    this.size = s;
  }
}