import java.io.*;
import java.util.*;

public class MathString_RomanToInt {
  public static void main(String[] args) {
    String str = "MCMIV";
    System.out.println("Integer form of Roman Numeral" +
                       " is " + romanToInt(str));
  }
  
  // This function returns value of a Roman symbol
  public static int value(char r)
  {
    if (r == 'I')
        return 1;
    if (r == 'V')
        return 5;
    if (r == 'X')
        return 10;
    if (r == 'L')
        return 50;
    if (r == 'C')
        return 100;
    if (r == 'D')
        return 500;
    if (r == 'M')
        return 1000;
    return -1;
  }
  
  public static int romanToInt(String str) {
    int result = 0;
    
    for(int i = 0; i < str.length(); i++) {
      int value = value(str.charAt(i));
      
      if(i+1 < str.length()) {
        int next = value(str.charAt(i+1));
        
        if(value > next)
          result += value;
        
        else {
          result = result + next - value;
          i++;
        }
      }
      
      else {
        result += value;
        i++;
      }
    }
    
    return result;
  }
}

