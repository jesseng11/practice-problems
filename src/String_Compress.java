import java.io.*;
import java.util.*;

public class String_Compress {
  public static void main(String[] args) {
    System.out.println(compressString("aabcccccaaa"));
  }
  
  //Use StringBuilder to avoid string concatenation which operates at O(n^2)
  
  //O(n)
  static String compressString(String str) {
    StringBuilder newStr = new StringBuilder();
    
    int count = 0;
    
    for(int i = 0; i < str.length(); i++) {
      count++;
      
      if(i+1 >= str.length() || 
         str.charAt(i) != str.charAt(i+1)) {
        newStr.append(str.charAt(i));
        newStr.append(count);
        count = 0;
      }
    }
    
    return newStr.length() > str.length() ? str : newStr.toString();
  }
}
