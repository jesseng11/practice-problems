import java.io.*;
import java.util.*;

public class NumIsland {
  public static void main(String[] args) {
    int[][] map = new int[][] {
    {0,0,0,0,0,0,1,0},
    {0,0,1,1,0,0,1,0},
    {0,0,0,0,0,1,1,1},
    {1,1,1,0,0,0,0,0},
    {0,1,1,0,1,1,0,1},
    {0,0,0,0,1,0,0,1},
    {0,1,0,0,1,0,0,0}};
    
    System.out.println(numberOfIslands(map));
  }
  
  public static int numberOfIslands(int [][] map) {
    int number = 0;
    
    for(int i = 0; i < map.length; i++) {
      for(int j = 0; j < map[0].length; j++) {
        if(map[i][j] == 1) {
          number++;
          turnToZero(map, i, j);
        }
      }
    }
    
    return number;
  }
  
  public static void turnToZero(int [][] map, int x, int y) {
    if(x < 0 || y < 0 || x >= map.length || y >= map[0].length || map[x][y] == 0)
      return;
    
    map[x][y] = 0;
    
    turnToZero(map, x+1, y);
    turnToZero(map, x-1, y);
    turnToZero(map, x, y+1);
    turnToZero(map, x, y-1);
  }
}