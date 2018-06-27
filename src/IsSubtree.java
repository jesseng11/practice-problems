import java.io.*;
import java.util.*;

public class IsSubtree {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(20);
    root.insertInOrder(10);
    root.insertInOrder(30);
    root.insertInOrder(5);
    root.insertInOrder(15);
    root.insertInOrder(17);
    root.insertInOrder(3);
    root.insertInOrder(7);
/*
              20
          10      30
       5     15
    3    7      17
*/
    
    TreeNode subtree = new TreeNode(5);
    subtree.insertInOrder(3);
    subtree.insertInOrder(7);
    
    System.out.println(isSubtree(root, subtree));
    System.out.println(containsTree(root, subtree));
  }
  
  //SOLUTION 1
  //time and space are both O(n + m)
  public static boolean isSubtree(TreeNode tree1, TreeNode tree2) {
    StringBuilder order1 = new StringBuilder();
    StringBuilder order2 = new StringBuilder();
    
    buildPreOrderString(tree1, order1);
    buildPreOrderString(tree2, order2);
    
    System.out.println(order1.toString());
    System.out.println(order2.toString());
    
    return order1.indexOf(order2.toString()) != -1;
  }
  
  public static void buildPreOrderString(TreeNode node, StringBuilder order) {
    if(node == null) {
      order.append("X ");
      return;
    }
    
    else 
      order.append(node.data + " ");
    
    buildPreOrderString(node.left, order);
    buildPreOrderString(node.right, order);
  }
  
  //SOLUTION 2  
  //space: O(logn + logm)
  //time: worsetime O(nm)
  //but tighter gound time would be O(n + km) because we do not actuall call matchTree on ever node in T1. We call it k times where k is the number of occurences of t2's root in t1
  public static boolean containsTree(TreeNode r1, TreeNode r2) {
    if(r2 == null)
      return true;
    
    return subTree(r1, r2);
  }
  
  public static boolean subTree(TreeNode r1, TreeNode r2) {
    if(r1 == null)
      return false;
    
    //each time the node in t1 matches the root of t2, call matchTree
    else if(r1.data == r2.data && matchTree(r1, r2))
      return true;
    
    return subTree(r1.left, r2) || subTree(r1.right, r2);
  }
  
  public static boolean matchTree(TreeNode r1, TreeNode r2) {
    if(r1 == null && r2 == null)
      return true;
    
    else if(r1 == null || r2 == null)
      return false;
    
    else if(r1.data != r2.data)
      return false;
    
    return matchTree(r1.left, r2.left) && matchTree(r1.right, r2.right);
  }
}