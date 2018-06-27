import java.io.*;
import java.util.*;

public class IterativePreorderBinaryTree {
  public static void main(String[] args) {
    BinaryTree tree = new BinaryTree();
    tree.root = new BinaryTreeNode(10);
    tree.root.left = new BinaryTreeNode(8);
    tree.root.right = new BinaryTreeNode(2);
    tree.root.left.left = new BinaryTreeNode(3);
    tree.root.left.right = new BinaryTreeNode(5);
    tree.root.right.left = new BinaryTreeNode(2);
    tree.iterativePreorder();
  }
}

// A binary tree node
class BinaryTreeNode {
  public int data;
  public BinaryTreeNode left;
  public BinaryTreeNode right;

  public BinaryTreeNode(int item) {
    data = item;
    left = right = null;
  }
}

class BinaryTree {
  public BinaryTreeNode root;
  
  public void iterativePreorder() {
     iterativePreorder(root);
  }
  
  public void iterativePreorder(BinaryTreeNode node) {
    if(node == null)
      return;
    
    Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
    stack.push(node);
    
    while(!stack.isEmpty()) {
      BinaryTreeNode n = stack.pop();
      
      System.out.println(n.data);
      
      if(n.right != null)
        stack.push(n.right);
      
      if(n.left != null)
        stack.push(n.left);
    }
  }
}