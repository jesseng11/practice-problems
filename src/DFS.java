import java.io.*;
import java.util.*;

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
  public static boolean dfs(Graph g, Node start, Node end) {
    if(start == end)
      return true;
    
    start.state = 1;
    
    for(Node n: start.children) {
      if(n.state == -1) {
        if(n == end)
          return true;
        else
          dfs(g, n, end);
      }
    }
    
    return false;
  }
}