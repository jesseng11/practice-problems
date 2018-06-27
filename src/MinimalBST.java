import java.io.*;
import java.util.*;

public class MinimalBST {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4, 5, 6, 7};
    createMinimalBst(arr);
  }
  
  public static TreeNode createMinimalBst(int[] arr) {
    TreeNode result = createMinimalBst(arr, 0, arr.length-1);
    preOrder(result);
    return result;
  }
  
  public static TreeNode createMinimalBst(int[] arr, int start, int end) {
    if(end < start) 
      return null;
    
    int middle = (start + end) / 2;
    
    TreeNode node = new TreeNode(arr[middle]);
    
    node.left = createMinimalBst(arr, start, middle - 1);
    node.right = createMinimalBst(arr, middle + 1, end);
    
    return node;
  }
  
  /* A utility function to print preorder traversal of BST */
  public static void preOrder(TreeNode node) {
    if (node == null) {
        return;
    }
    System.out.print(node.data + " ");
    preOrder(node.left);
    preOrder(node.right);
  }
}