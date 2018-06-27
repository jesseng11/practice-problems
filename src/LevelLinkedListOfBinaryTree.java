import java.io.*;
import java.util.*;

public class LevelLinkedListOfBinaryTree {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
  }
  
  //bst approach iterative O(n) time
  //return O(n) data, so space too is O(n)
  public static ArrayList<LinkedList<TreeNode>> createLevelList(TreeNode root) {
    if(root == null) return null;
    
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
    
    LinkedList<TreeNode> list = new LinkedList<TreeNode>();
    
    list.add(root);
    
    while(list.size() > 0) {
      lists.add(list);
      
      LinkedList<TreeNode> parents = list;
      list = new LinkedList<TreeNode>();
      
      for(TreeNode parent: parents) {
        if(parent.left != null)
          list.add(parent.left);
        if(parent.right != null)
          list.add(parent.right);
      }
    }
    
    return lists;
  }
  
  
  //recursive pre-order approach
  //each recursive call results in O(logn) to the stack
  //but O(n) data must be returned, so time is O(n)
  public static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
    createLevelLinkedList(root, lists, 0);
    return lists;
  }
  
  public static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
    if(root == null)
      return;
    
    LinkedList<TreeNode> list = null;
    
    if(lists.size() == level) {
      list = new LinkedList<TreeNode>();
      
      lists.add(list);
    }
    else {
      list = lists.get(level); 
    }
    
    list.add(root);
    
    createLevelLinkedList(root.left, lists, level+1);
    createLevelLinkedList(root.right, lists, level+1);
    
    return;
  }
}