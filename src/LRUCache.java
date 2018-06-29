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

  //Return the value associated with the key or null if the key doesn't exist
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
  
  /**
   *  If key already exists, replace the current value with the new value.
   *  If the key doesn't exist, add the new key/value entry to the cache.
   *  If the addition of the new entry causes the number of entries to exceed numEntries, remove the oldest entry based on the last time the entry is accessed (either through put or get).
   */
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
    if(tail == null) {
        tail = n;
        head = n;
    }
    
    n.prev = null;
    n.next = head;
    head.prev = n;
    head = n;
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

//doubly linked list
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