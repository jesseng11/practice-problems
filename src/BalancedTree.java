import java.io.*;
import java.util.*;

public class BalancedTree {
  public static void main(String[] args) {
    ArrayList<String> strings = new ArrayList<String>();
    strings.add("Hello, World!");
    strings.add("Welcome to CoderPad.");
    strings.add("This pad is running Java 8.");

    for (String string : strings) {
      System.out.println(string);
    }
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