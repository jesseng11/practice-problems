import java.io.*;
import java.util.*;

public class String_PalindromePermutation {
  public static void main(String[] args) {
    String str = "Tact Co oa";
    
    System.out.println(isPalindromePermutation(str));
  }
  
  //time O(n)
  //space O(1)
  public static boolean isPalindromePermutation(String str) {
    str = str.replaceAll("\\s", "");
    str = str.toLowerCase();
    
    int numOdd = 0;
    int[] charCount = new int[128];
    
    for(char c: str.toCharArray()) {
      charCount[c]++;
    }
    
    for(int i = 0; i < 128; i++) {
      numOdd += charCount[i] % 2; 
    }
    
    return numOdd <= 1;
  }
}
