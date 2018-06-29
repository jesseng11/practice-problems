import java.io.*;
import java.util.*;

// projects: a, b, c, d, e, f
// dependencies: (a,d), (f,b), (b,d), (f,a), (d,c)
// output: f, e, a, b, d, c
public class Graph_BuildOrder {
  public static void main(String[] args) {
    String[] projects = new String[] {"a", "b", "c", "d", "e", "f"};
    String[][] dependencies = new String[][] { {"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"} };
    
    Project[] result = findBuildOrder(projects, dependencies);
    
    for(Project project: result) {
      System.out.println(project.getName()); 
    }
  }
  
  //O(P + D)
  public static Project[] findBuildOrder(String[] projects, String [][] dependencies) {
    GraphProject graph = buildGraphProject(projects, dependencies);
    return orderProjects(graph.getNodes());
  }
  
  public static GraphProject buildGraphProject(String[] projects, String[][] dependencies) {
    GraphProject graph = new GraphProject();
    
    for(String project: projects) {
      graph.getOrCreateNode(project); 
    }
    
    for(String[] dependency: dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }
    
    return graph;
  }
  
  public static Project[] orderProjects(ArrayList<Project> projects) {
    Project[] order = new Project[projects.size()];
    
    //get all non dependent
    int endOfList = 0; 
    for(Project project: projects) {
      if(project.getNumDependencies() == 0) {
        order[endOfList] = project;
        endOfList++;
      }
    }
    
    int toBeProcessed = 0;
    while(toBeProcessed < order.length) {
      Project current = order[toBeProcessed];
      
      //circular dependency since there are no remaining projects with zero dependencies
      if(current == null)
        return null;
        
      ArrayList<Project> children = current.getChildren();
      for(Project child: children) {
        child.decrementDependencies();
      
        if(child.getNumDependencies() == 0) {
          order[endOfList] = child;
          endOfList++;
        }
      }
      
      toBeProcessed++;
    }
    
    return order;
  }
}

class GraphProject {
  private ArrayList<Project> nodes = new ArrayList<Project>();
  private HashMap<String, Project> map = new HashMap<String, Project>();
  
  public Project getOrCreateNode(String name) {
    if(!map.containsKey(name)) {
      Project node = new Project(name);
      nodes.add(node);
      map.put(name, node);
    }
    
    return map.get(name);
  }
  
  public void addEdge(String startName, String endName) {
    Project start = getOrCreateNode(startName);
    Project end = getOrCreateNode(endName);
    
    start.addNeighbor(end);
  }
  
  public ArrayList<Project> getNodes() {
    return nodes; 
  }
}

class Project {
  private ArrayList<Project> children = new ArrayList<Project>();
  private HashMap<String, Project> neighborMap = new HashMap<String, Project>();
  private String name;
  private int dependencies = 0;
  
  public Project(String n) {
    name = n; 
  }
  
  public void addNeighbor(Project node) {
    if(!neighborMap.containsKey(node.getName())) {
      children.add(node);
      neighborMap.put(node.getName(), node);
      node.incrementDependencies();
    }
  }
  
  public void incrementDependencies() {
    dependencies++; 
  }
       
  public void decrementDependencies() {
    dependencies--;
  }
       
  public String getName() {
    return name;
  }
  
  public ArrayList<Project> getChildren() {
    return children; 
  }
  
  public int getNumDependencies() {
    return dependencies; 
  }
}