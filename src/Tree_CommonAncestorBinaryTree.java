import java.io.*;
import java.util.*;

public class Tree_CommonAncestorBinaryTree {
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
    System.out.println(commonAncestor(root.left.left.left, root.left.right).data);
    System.out.println(commonAncestor2(root, root.left.left, root.left.left.right).data);
    System.out.println(commonAncestor3(root, root.left, root.right).data);
    
                       
  }
  
  //SOLUTION 1: with links to parents
  //similar to linkedlist intersecting node problem
  //O(d) where d is the depth of the deeper node
  public static TreeNode commonAncestor(TreeNode p, TreeNode q) {
    int delta = depth(p) - depth(q);
    TreeNode first = delta > 0 ? q : p; // shallower node
    TreeNode second = delta > 0 ? p : q; //deeper node
    second = goUpBy(second, Math.abs(delta)); //move deeper node up
    
    while(first != second && first != null && second != null) {
      first = first.parent;
      second = second.parent;
    }
    
    return first == null || second == null ? null : first;
  }
  
  public static int depth(TreeNode node) {
    int depth = 0;
    while(node != null) {
      node = node.parent;
      depth++;
    }
    return depth;
  }
  
  public static TreeNode goUpBy(TreeNode node, int delta) {
    while(delta > 0 && node != null) {
      node = node.parent;
      delta--;
    }
    return node;
  }
  
  //SOLUTION 2: with links to parent (best worst time runtime)
  //O(t) where t is the size of the subtree for the first common ancestor
  //worse time is O(n) where n is the num of nodes in the tree. This runtime is derived by noticing that each node in that subtree is searched once only
  public static TreeNode commonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
    if(!covers(root, q) || !covers(root, p))
      return null;
    else if(covers(p, q))
      return p;
    else if(covers(q, p))
      return q;
    
    TreeNode sibling = getSibling(p);
    TreeNode parent = p.parent;
    while(!covers(sibling, q)) {
      sibling = getSibling(parent);
      parent = parent.parent;
    }
    
    return parent;
  }
  
  public static boolean covers(TreeNode root, TreeNode p) {
    if(root == null)
      return false;
    if(root == p)
      return true;
    return covers(root.left, p) || covers(root.right, p);
  }
  
  public static TreeNode getSibling(TreeNode node) {
    if(node == null || node.parent == null)
      return null;
    
    TreeNode parent = node.parent;
    
    if(parent.left == node)
      return parent.right;
    else
      return parent.left;
  }
  
  //SOLUTION 3
  //O(n) on a balanced tree
  public static TreeNode commonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
    if(!covers(root, q) || !covers(root, p))
      return null;
    
    return ancestorHelper(root, p, q);
  }
  
  public static TreeNode ancestorHelper(TreeNode root, TreeNode p, TreeNode q) {
    if(root == null || root == p || root == q)
      return root;
    
    boolean pIsOnLeft = covers(root.left, p);
    boolean qIsOnLeft = covers(root.left, q);
    
    if(pIsOnLeft != qIsOnLeft)
      return root;
    
    TreeNode childSide = pIsOnLeft ? root.left : root.right;
    return ancestorHelper(childSide, p, q);
  }
}

