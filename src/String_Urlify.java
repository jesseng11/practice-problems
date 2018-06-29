import java.io.*;
import java.util.*;

public class String_Urlify {
  public static void main(String[] args) {
    String str = "Mr John Smith    ";
    int trueLength = 13;
    
    urlify(str.toCharArray(), trueLength);
  }
  
  //O(n)
  public static void urlify(char[] str, int trueLength) {
    int spaceCount = 0;
    
    for(int i = 0; i < trueLength; i++) {
      if(str[i] == ' ')
        spaceCount++;
    }
    
    int totalLength = 2 * spaceCount + trueLength;
    
    for(int i = trueLength - 1; i >= 0; i--) {
      if(str[i] == ' ') {
        str[totalLength-1] = '0';
        str[totalLength-2] = '2';
        str[totalLength-3] = '%';
        
        totalLength -= 3;
      }
      else {
        str[totalLength-1] = str[i];
        totalLength--;
      }
    }
    
    System.out.println(new String(str));
  }
}
