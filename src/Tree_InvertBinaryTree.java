import java.io.*;
import java.util.*;

public class Tree_InvertBinaryTree {
	  public static void main(String[] args) {
	    TreeNode root = new TreeNode(20);
	    root.insertInOrder(10);
	    root.insertInOrder(30);
	    root.insertInOrder(5);
	    root.insertInOrder(15);
	/*
	              20
	          10      30
	       5     15	
	*/
	    
	    StringBuilder order1 = new StringBuilder();
	    buildPreOrderString(root, order1);
	    
	    System.out.println(order1.toString());
	    
	    StringBuilder order2 = new StringBuilder();
	    buildPreOrderString(invertTree(root), order2);
	    
	    System.out.println(order2.toString());
	    
	  }
	  
	  //since each node in the tree is visited only once, the time is O(n)
	  //because of recursion, space is O(n) where n is height of tree
	  public static TreeNode invertTree(TreeNode root) {
	    if(root == null)
	      return null;
	    
	    TreeNode right = invertTree(root.right);
	    TreeNode left = invertTree(root.left);
	    
	    root.right = left;
	    root.left = right;
	    
	    return root;
	  }
	  
	  public static TreeNode iterativeInvertTree(TreeNode root) {
	    if(root == null)
	      return null;
	    
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    
	    queue.add(root);
	    
	    while(!queue.isEmpty()) {
	      TreeNode curr = queue.poll();
	      
	      TreeNode temp = curr.left;
	      curr.left = curr.right;
	      curr.right = temp;
	      
	      if(curr.left != null)
	        queue.add(curr.left);
	      if(curr.right != null)
	        queue.add(curr.right);
	    }
	    
	    return root;
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
}
