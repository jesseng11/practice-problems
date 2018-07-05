import java.io.*;
import java.util.*;

//DFS is preferred if we want to visit every node in the graph
public class DFS {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
  }
  
  //O(V+E)
  public static boolean dfs(Graph g, Graph.Node start, Graph.Node end) {
    if(start == end)
      return true;
    
    for(Graph.Node n: g.getNodes()) {
	  n.state = Graph.State.Unvisited;
	}
    
    start.state = Graph.State.Visited;
    
    for(Graph.Node n: start.getAdjacent()) {
      if(n.state == Graph.State.Unvisited) {
        if(n == end)
          return true;
        else
          dfs(g, n, end);
      }
    }
    
    return false;
  }
}