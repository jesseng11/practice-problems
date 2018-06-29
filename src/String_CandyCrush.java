import java.io.*;
import java.util.*;

public class String_CandyCrush {
  public static void main(String[] args) {
    String str = "abbbbcc"; //acc
    String str2 = "abcccbb"; //a
    
    System.out.println(candyCrush(str));
    System.out.println(candyCrush(str2));
  }
  
  public static String candyCrush(String str) {
    StringBuilder sb = new StringBuilder(str);
    
    int count = 1;
    int lastIndex = 0;
    
    int i = 0;
    while(i < sb.length()) {
      // System.out.println("i: " + i);
      // System.out.println("sb.charAt(i): " + sb.charAt(i));
      // System.out.println("lastIndex++: " + lastIndex);
      // System.out.println("count: " + count);
      
      if(i+1 < sb.length() && sb.charAt(i) == sb.charAt(i+1)) {
        count++;
        i++;
      }
      
      else {
        if(count >= 3) {
          sb.delete(lastIndex, lastIndex + count); 
          
          i = 0; //reset
        }
        else {
          i++; 
        }
        
        lastIndex = i;
        count = 1;
      }
    }
    
    return sb.toString();
  }
}

