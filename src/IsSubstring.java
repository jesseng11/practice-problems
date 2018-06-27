import java.io.*;
import java.util.*;

public class IsSubstring {
  public static void main(String[] args) {
    String s1 = "for";
    String s2 = "geeksforgeeks";
    
    int result = isSubstring(s1, s2);
    
    System.out.println(s2.contains(s1));
    
    System.out.println("Present at index: " + result);
  }
  
  public static int isSubstring(String s1, String s2) {
    int m = s1.length();
    int n = s2.length();
    
    for(int i = 0; i <= n - m; i++) {
      int j;
      
      for(j = 0; j < m; j++) {
        if(s2.charAt(i + j) != s1.charAt(j))
          break;
      }
      
      if(j == m)
        return i;
    }
    
    return -1;
  }
}

