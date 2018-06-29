import java.io.*;
import java.util.*;

public class String_IsPalindrome {
  public static void main(String[] args) {
    String str = "abcdcba";
    String str2 = "Noo";
    
    System.out.println(isPalindrome(str));
    System.out.println(isPalindrome(str2));
    System.out.println(isPalindromeReverse(str));
    System.out.println(isPalindromeReverse(str2));
  }
  
  public static boolean isPalindrome(String str) {
    String clean = str.replaceAll("\\s", "").toLowerCase();
    int length = clean.length();
    
    int front = 0;
    int back = length-1;
    
    while(back > front) {
      if(clean.charAt(front) != clean.charAt(back))
         return false;
      
      front++;
      back--;
    }
    
    return true;
  }
  
  public static boolean isPalindromeReverse(String str) {
    String clean = str.replaceAll("\\s", "").toLowerCase();
    
    StringBuilder sb = new StringBuilder(clean);
    
    StringBuilder reverse = sb.reverse();
    
    return (reverse.toString().equals(str));
  }
}
