import java.io.*;
import java.util.*;

public class String_ContainsAllCharsForWord {
  public static void main(String[] args) {
    String str = "goaal";
    char[] arr = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ;
    
    System.out.println(containsAllChars(str, arr));
  }
  
  public static boolean containsAllChars(String str, char[] arr)   {
    if(str == null || arr == null) return false;
    if(str.length() > arr.length) return false;
    
    int[] count = new int[128];
    
    for(char c: arr)
      count[c]++;
    
    char[] strArr = str.toCharArray();
    
    for(char s: strArr) {
      if(count[s] > 0)
        count[s]--;
      else
        return false;
    }
    
    return true;
  }
}
