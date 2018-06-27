import java.io.*;
import java.util.*;

public class InorderSuccessorBST {
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
    System.out.println(inorderSuccessor(root.left.left).data); // 5 --> 7
    System.out.println(inorderSuccessor(root.left.right.right).data); //17 --> 20
    System.out.println(inorderSuccessor(root.right).data); //30
  }
  
  public static TreeNode inorderSuccessor(TreeNode n) {
    /*if(n has right subtree)
      return leftmost child in right subtree
      
    else {
      while(n is right child of n.parent) {
        n = n.parent;
      }
      
      return n.parent;
    }*/
    
    if(n == null)
      return null;
    
    if(n.right != null) 
      return getLeftmostChild(n.right);
    
    else {
      TreeNode node = n;
      TreeNode parent = node.parent;
      
      while(parent != null && parent.left != node) {
        node = parent;
        parent = parent.parent;
      }
      
      return parent == null ? null : parent;
    }
  }
  
  public static TreeNode getLeftmostChild(TreeNode n) {
    if(n == null)
      return null;
    
    while(n.left != null) {
      n = n.left; 
    }
    
    return n;
  }
}