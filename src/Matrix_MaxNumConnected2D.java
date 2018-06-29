import java.io.*;
import java.util.*;

/*
.XXXXXX....
...X..XX..X
...XXXX....
..X.....X..
..XXX..XX..
.....XX....

do not count diagonals
 */

//This solution has a time complexity of O(mn)
public class Matrix_MaxNumConnected2D {
  public static void main(String[] args) {
    int[][] test1 = {
    {0,1,1,1,1,0},
    {0,0,0,0,0,0},
    {1,0,0,0,1,0},
    {0,0,0,0,1,1},
    {0,0,0,1,1,1}}; //return 6
    
    int[][] test2 = {
    {0,1,1,1,1,1,1,0,0,0,0},
    {0,0,0,1,0,0,1,1,0,0,1},
    {0,0,0,1,1,1,1,0,0,0,0},
    {0,0,1,0,0,0,0,0,1,0,0},
    {0,0,1,1,1,0,0,1,1,0,0},
    {0,0,0,0,0,1,1,0,0,0,0}}; //return 13
    
    int[][] test3 = {
    {1,1,1},
    {1,1,1},
    {1,1,1}}; //return 9
    
    int[][] test4 = {
    {0,0,0},
    {0,0,0},
    {0,0,0}}; //return 0  
    
    int[][] test5 = {{}}; //return 0
    
    System.out.println("Max number of connected 'X' for test1: " + maxConnectedCount(test1));
    System.out.println("Max number of connected 'X' for test2: " + maxConnectedCount(test2));
    System.out.println("Max number of connected 'X' for test3: " + maxConnectedCount(test3));
    System.out.println("Max number of connected 'X' for test4: " + maxConnectedCount(test4));
    System.out.println("Max number of connected 'X' for test5: " + maxConnectedCount(test5));
  }
  
  public static int maxConnectedCount(int[][] arr) {
    int maxCount = 0;
    int width = arr.length;
    int height = arr[0].length;
    
    for(int i = 0; i < width; i++) {
      for(int j = 0; j < height; j++) {
        //printArr(arr);
        int currCount = getNumTouching(arr, i, j);
        maxCount = Math.max(currCount, maxCount);
      }
    }
    
    return maxCount;
  }
  
  public static int getNumTouching(int[][] arr, int x, int y) {
    if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length || arr[x][y] == 0)
      return 0;
    
    arr[x][y] = 0;
    
    return 1 + getNumTouching(arr, x+1, y)
      + getNumTouching(arr, x-1, y)
      + getNumTouching(arr, x, y+1)
      + getNumTouching(arr, x, y-1);
  }

  public static void printArr(int[][] arr) {
    int width = arr.length;
    int height = arr[0].length;
    
    for(int i = 0; i < width; i++) {
      for(int j = 0; j < height; j++) {
         System.out.print(arr[i][j] + " ");
      }
      System.out.println();
    }
    System.out.println("*******************");
  }
}