import java.io.*;
import java.util.*;

public class LRUCache {
  int capacity;
  HashMap<Integer, QueueNode> cache;
  QueueNode head;
  QueueNode tail;
  
  public LRUCache(int size) {
    capacity = size;
    cache = new HashMap<Integer, QueueNode>();
    head = null;
    tail = null;
  }
  
  //O(1)
  public int get(int key) {
    if(cache.containsKey(key)) {
      QueueNode n = cache.get(key);
      remove(n);
      moveToHead(n);
      return n.value;
    }
    
    return -1;
  }
  
  private void remove(QueueNode n) {
    if(n.prev != null)
      n.prev.next = n.next;
    else
      head = n.next;
    
    if(n.next != null)
      n.next.prev = n.prev;
    else
      tail = n.prev;
  }
  
  private void moveToHead(QueueNode n) {
    n.prev = null;
    n.next = head;
    
    if(head != null)
      head.prev = n;
    
    head = n;
    
    if(tail == null)
      tail = head;
  }
  
  //O(1)
  public void put(int key, int value) {
    if(cache.containsKey(key)) {
      QueueNode old = cache.get(key);
      old.value = value;
      remove(old);
      moveToHead(old);
    }
    else {
      QueueNode n = new QueueNode(key, value);
      
      if(cache.size() >= capacity) {
        cache.remove(tail.key);
        remove(tail);
      }
      
      moveToHead(n);
      cache.put(key, n);
    }
  }

  public static void main(String[] args) {
    int capacity = 5;
    LRUCache lr = new LRUCache(capacity);
    
    lr.put(1, 1);

    lr.put(2, 2);

    lr.put(3, 3);

    lr.put(4, 4);

    lr.put(5, 5);
    
    for(QueueNode n: lr.cache.values())
      System.out.print(n.value + " ");
    System.out.println();
    System.out.println("head: " + lr.head.value);

    System.out.println(lr.get(3));
    
    for(QueueNode n: lr.cache.values())
      System.out.print(n.value + " ");
    System.out.println();
    System.out.println("head: " + lr.head.value);

    lr.put(6, 6);
    
    for(QueueNode n: lr.cache.values())
      System.out.print(n.value + " ");
    System.out.println();
    System.out.println("head: " + lr.head.value);

    lr.put(7, 7);
    
    for(QueueNode n: lr.cache.values())
      System.out.print(n.value + " ");
    System.out.println();
    System.out.println("head: " + lr.head.value);
    
    System.out.println(lr.get(2));
    
    for(QueueNode n: lr.cache.values())
      System.out.print(n.value + " ");
    System.out.println();
    System.out.println("head: " + lr.head.value);
    
    System.out.println(lr.get(5));
    
    for(QueueNode n: lr.cache.values())
      System.out.print(n.value + " ");
    System.out.println();
    System.out.println("head: " + lr.head.value);
  }
}

class QueueNode {
  int key;
  int value;
  QueueNode prev;
  QueueNode next;
  
  public QueueNode(int key, int value) {
    this.key = key;
    this.value = value;
  }
}