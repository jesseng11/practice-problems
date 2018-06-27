import java.io.*;
import java.util.*;

public class CountPathsWithSumBinaryTree {
  public static void main(String[] args) {
    TreeNode root3 = new TreeNode(3);
    root3.setLeftChild(new TreeNode(3));
    root3.setRightChild(new TreeNode(-2));
    
    TreeNode root2 = new TreeNode(2);
    root2.setRightChild(new TreeNode(-1));
    
    TreeNode root5 = new TreeNode(5);
    root5.setLeftChild(root3);
    root5.setRightChild(root2);
    
    TreeNode rootNeg3 = new TreeNode(-3);
    rootNeg3.setRightChild(new TreeNode(11));
    
    TreeNode root = new TreeNode(10);
    root.setLeftChild(root5);
    root.setRightChild(rootNeg3);
    
/*
              10
          5       -3
       3     2        11
    3    -2      1
*/
    
    System.out.println(countPathsWithSum(root, 8));
  }
  
  //O(n^2)
  public static int countPathsWithSum(TreeNode root, int targetSum) {
    if(root == null)
      return 0;
    
    int fromRoot = countPathsWithSumFromNode(root, targetSum, 0);
    
    int fromLeft = countPathsWithSum(root.left, targetSum);
    int fromRight = countPathsWithSum(root.right, targetSum);
    
    return fromRoot + fromLeft + fromRight;
  }
  
  public static int countPathsWithSumFromNode(TreeNode root, int targetSum, int currSum) {
    if(root == null)
      return 0;
    
    currSum += root.data;
    
    int totalCount = 0;
    if(currSum == targetSum)
      totalCount++;
    
    totalCount += countPathsWithSumFromNode(root.left, targetSum, currSum);
    totalCount += countPathsWithSumFromNode(root.right, targetSum, currSum);
    
    return totalCount;
  }
}

