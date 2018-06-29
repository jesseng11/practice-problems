import java.io.*;
import java.util.*;

public class String_OneEditAway {
  public static void main(String[] args) {
    System.out.println(isOneEditAway("pale","ple"));
    System.out.println(isOneEditAway("pales","pale"));
    System.out.println(isOneEditAway("pale","bale"));
    System.out.println(isOneEditAway("pale","bake"));
  }
  
  //O(n)
  static boolean isOneEditAway(String s, String t) {
    if(s.length() == t.length())
      return isOneReplace(s, t);
    else if(s.length()+1 == t.length())
      return isOneRemoveOrInsert(s, t);
    else if(s.length()-1 == t.length())
      return isOneRemoveOrInsert(t, s);
    else
      return false;
  }
  
  static boolean isOneReplace(String s, String t) {
    boolean foundOne = false;
    
    for(int i = 0; i < s.length(); i++) {
      if(s.charAt(i) != t.charAt(i)) {
        if(foundOne) 
          return false;
        else 
          foundOne = true;
      }
    }
    
    return true;
  }
  
  static boolean isOneRemoveOrInsert(String shorter, String longer) {
    int shortIndex = 0;
    int longIndex = 0;
    
    while (shortIndex < shorter.length() && longIndex < longer.length()) {
      if(shorter.charAt(shortIndex) == longer.charAt(longIndex)) {
        shortIndex++;
        longIndex++;
      }
      else {
        if(shortIndex != longIndex) 
          return false;
        
        longIndex++;
      }
    }
    
    return true;
  }
}
