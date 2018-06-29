import java.io.*;
import java.util.*;

public class Graph_DetectCycleDirectedGraph {
  public static void main(String[] args) {
    GraphCyclicChecker graph = new GraphCyclicChecker(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 0);
    graph.addEdge(2, 3);
    graph.addEdge(3, 3);

    if(graph.isCyclic())
        System.out.println("GraphCyclicChecker contains cycle");
    else
        System.out.println("GraphCyclicChecker doesn't contain cycle");
  }
}

class GraphCyclicChecker {
  private int V;
  private List<List<Integer>> adj;
  
  public GraphCyclicChecker(int V) {
    this.V = V;
    adj = new ArrayList<>(V);
    
    for(int i = 0; i < V; i++)
      adj.add(new LinkedList<>());
  }
  
  public void addEdge(int source, int dest) {
    adj.get(source).add(dest); 
  }
  
  public boolean isCyclic() {
    boolean[] visited = new boolean[V];
    boolean[] recursionStack = new boolean[V];
    
    for(int i = 0; i < V; i++) {
        if(isCyclicHelper(i, visited, recursionStack))
          return true;
    }
    
    return false;
  }
  
  private boolean isCyclicHelper(int i, boolean[] visited, boolean[] recursionStack) {
    if(recursionStack[i])
      return true;
    
    if(visited[i])
      return false;
    
    visited[i] = true;
    recursionStack[i] = true;
    
    List<Integer> children = adj.get(i);
    
    for(Integer c: children) {
      if(isCyclicHelper(c, visited, recursionStack))
        return true;
    }
    
    recursionStack[i] = false;
    
    return false;
  }
}