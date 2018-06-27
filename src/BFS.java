import java.io.*;
import java.util.*;

public class BFS {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
  }
  
  //O(V+E) this is better because you go through closest relationships first
  //need to mark as visited or not to avoid cycles/repetition of nodes
  public static boolean bfs(Graph g, Node start, Node end) {
    if(start == end)
      return true;
    
    LinkedList<Node> queue = new LinkedList<Node>();
    
    for(Node n: g.nodes) {
      n.state = -1;
    }
    
    start.state = 0;
    queue.add(start);
    
    Node curr;
    
    while(!queue.isEmpty()) {
      curr = queue.removeFirst();
      
      if(curr != null) {
        for(Node n: curr.children) {
          if(n.state == -1) {
            if(n == end)
              return true;
            else {
              n.state = 0;
              queue.addLast(n); 
            }
          }
        }
        
        curr.state = 1;
      }
    }
    
    return false;
  }
}