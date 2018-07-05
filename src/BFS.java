import java.io.*;
import java.util.*;

//Best for finding shortest path or any path between two nodes, BFS is better than DFS
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
  public static boolean bfs(Graph g, Graph.Node start, Graph.Node end) {
    if(start == end)
      return true;
    
    LinkedList<Graph.Node> queue = new LinkedList<Graph.Node>();
    
    for(Graph.Node n: g.getNodes()) {
      n.state = Graph.State.Unvisited;
    }
    
    start.state = Graph.State.Visiting;
    queue.add(start);
    
    Graph.Node curr;
    
    while(!queue.isEmpty()) {
      curr = queue.removeFirst();
      
      if(curr != null) {
        for(Graph.Node n: curr.getAdjacent()) {
          if(n.state == Graph.State.Unvisited) {
            if(n == end)
              return true;
            else {
              n.state = Graph.State.Visiting;
              queue.addLast(n); 
            }
          }
        }
        
        curr.state = Graph.State.Visited;
      }
    }
    
    return false;
  }
}