import java.io.*;
import java.util.*;

public class String_IsRotation {
  public static void main(String[] args) {
    System.out.println(isStrRotation("waterbottle", "erbottlewat"));
  }
  
  //O(n)
  static boolean isStrRotation(String s1, String s2) {
    if(s1.length() != s2.length())
      return false;
    
    String s1s1 = s1 + s1;
    
    return s1s1.contains(s2);
  }
}
