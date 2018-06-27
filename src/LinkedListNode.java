
public class LinkedListNode {
  public LinkedListNode next, prev, last;
  public int data;
  
  public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
    data = d;
    setNext(n);
    setPrevious(p);
  }
  
  public LinkedListNode(int d) {
    data = d; 
  }
  
  public LinkedListNode() {
  }
  
  public void setNext(LinkedListNode n) {
    next = n;
    
    if(this == last) {
      last = n; 
    }
    
    if(n != null && n.prev != this) {
      n.setPrevious(this);
    }
  }
  
  public void setPrevious(LinkedListNode p) {
    prev = p;
    
    if(p != null && p.next != this) {
      p.setNext(this); 
    }
  }
  
  public LinkedListNode clone() {
    LinkedListNode next2 = null;
    
    if(next != null) {
      next2 = next.clone(); 
    }
    
    LinkedListNode head2 = new LinkedListNode(data, next2, null);
    return head2;
  }
  
  public void appendToTail(int d) {
    LinkedListNode end = new LinkedListNode(d);
    LinkedListNode n = this;
    
    while(n.next != null) {
      n = n.next; 
    }
    
    n.next = end;
    last = end;
  }
  
  public LinkedListNode deleteNode(LinkedListNode head, int d) {
    LinkedListNode n = head; 
    
    if(n.data == d)
      return head.next;
    
    while(n.next != null) {
      if(n.next.data == d) {
        n.next = n.next.next;
        return head;
      }
      
      n = n.next;
    }
    
    return head;
  }
}