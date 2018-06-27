import java.io.*;
import java.util.*;

/*
Count all possible paths from top left to bottom right of a mXn matrix.
The problem is to count all the possible paths from top left to bottom right of a mXn matrix with the constraints that from each cell you can either move only to right or down.
*/
public class NumPathsInMatrixDP {
  public static void main(String[] args) {
    //System.out.println(badNumOfPaths(3, 3));
    System.out.println(numberOfPaths(3, 3));
  }
  
  //really bad exponential solution O(k^n) where k is constant
  public static int badNumOfPaths(int m, int n) {
    // If either given row number is first or 
    // given column number is first
    if(m == 1 || n == 1)
      return 1;
    
    // If diagonal movements are allowed then 
    // the last addition is required.
    return badNumOfPaths(m-1, n) + badNumOfPaths(m, n-1);
    // + badNumOfPaths(m-1, n-1);
  }
  /*
  The time complexity of above recursive solution is exponential. There are many overlapping subproblems. We can draw a recursion tree for numberOfPaths(3, 3) and see many overlapping subproblems. The recursion tree would be similar to Recursion tree for Longest Common Subsequence problem.
So this problem has both properties (see this and this) of a dynamic programming problem. Like other typical Dynamic Programming(DP) problems, recomputations of same subproblems can be avoided by constructing a temporary array count[][] in bottom up manner using the above recursive formula.
  */
  
  //DYNAMIC PROGRAMMING
  //O(mn)
  public static int numberOfPaths(int m, int n) {
    //create a 2D table to store results of subproblems
    int[][] count = new int[m][n];
    
    //count paths to reach cell in first column
    for(int i = 0; i < m; i++) 
      count[i][0] = 1;
    
    //count paths to reach cell in first row
    for(int j = 0; j < n; j++)
      count[0][j] = 1;
    
    //calculate bottom up using recursive solution
    for(int i = 1; i < m; i++) {
      for(int j = 1; j < n; j++) {
        count[i][j] = count[i-1][j] + count[i][j-1];
        //+ count[i-1][j-1]; //IF DIAGONAL IS ALLOWED
      }
    }
    
    //printing for understanding purposes yes
    for(int i = 0; i < m; i++) {
      for(int j = 0; j < n; j++) {
        System.out.print(count[i][j] + " ");
      }
      System.out.println();
    }
    
    return count[m-1][n-1];
  }
}

