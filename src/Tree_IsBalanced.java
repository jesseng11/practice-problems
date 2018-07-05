import java.io.*;
import java.util.*;

public class Tree_IsBalanced {
  public static void main(String[] args) {
	    TreeNode root = new TreeNode(20);
	    root.insertInOrder(10);
	    root.insertInOrder(30);
	    root.insertInOrder(5);
	    root.insertInOrder(15);
	    //root.insertInOrder(17);
	    //root.insertInOrder(3);
	    //root.insertInOrder(7);
	/*
	              20
	          10      30
	       5     15
	    3    7      17
	*/
	    System.out.println(isBalancedTree(root));
	    System.out.println(isBalanced(root));
  }
  
  //Solution 1: recursive
  //O(nlogn) time since each node is touched once per node above it
  public static int getHeight(TreeNode root) {
    if(root == null)
      return -1;
    
    return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
  }
  
  public static boolean isBalancedTree(TreeNode root) {
    if(root == null)
      return true;
    
    int diff = getHeight(root.left) - getHeight(root.right);
    
    if(Math.abs(diff) > 1)
      return false;
    
    return isBalancedTree(root.left) && isBalancedTree(root.right);
  }
  
  //Solution 2: cut calls to getHeight
  //O(n) time, O(h) space where h is height of tree
  public static int checkHeight(TreeNode root) {
    if(root == null)
      return -1;
    
    int leftHeight = checkHeight(root.left);
    if(leftHeight == Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    
    int rightHeight = checkHeight(root.right);
    if(rightHeight == Integer.MIN_VALUE)
      return Integer.MIN_VALUE;
    
    int diff = Math.abs(leftHeight - rightHeight);
    if(diff > 1)
      return Integer.MIN_VALUE;
    
    return Math.max(leftHeight, rightHeight) + 1;
  }
  
  public static boolean isBalanced(TreeNode root) {
    return checkHeight(root) != Integer.MIN_VALUE; 
  }
}