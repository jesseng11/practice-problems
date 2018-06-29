import java.io.*;
import java.util.*;

public class Tree_ValidBST {
  public static void main(String[] args) {
	    TreeNode root = new TreeNode(5);
	    TreeNode left = new TreeNode(3);
	    TreeNode right = new TreeNode(7);
	    TreeNode subchild = new TreeNode(1);
	    
	    root.left = left;
	    root.right = right;
	    left.left = subchild;
	    
	    System.out.println(isValidBST(root));
  }
  
  //on balanced tree, space is O(logn) on stack
  //O(n) time and the best since any algorithm must touch each node
  public static boolean isValidBST(TreeNode root) {
    return isValidBST(root, null, null);  
  }
  
  public static boolean isValidBST(TreeNode root, Integer min, Integer max) {
    if(root == null)
      return true;
    
    if(min != null && root.data < min)
      return false;
    
    if(max != null && root.data >= max)
      return false;
    
    return 
      isValidBST(root.left, min, root.data) 
      && 
      isValidBST(root.right, root.data, max);
  }
  
  //Another approach
  public Integer lastNode = null; 
  public boolean inOrderTraversalIsBST(TreeNode n) {
    if(n == null)
      return true;
    
    if(!inOrderTraversalIsBST(n.left))
      return false;
    
    if(lastNode != null && lastNode >= n.data)
      return false;
    
    lastNode = n.data;
    
    if(!inOrderTraversalIsBST(n.right))
      return false;
    
    return true;
  }
}