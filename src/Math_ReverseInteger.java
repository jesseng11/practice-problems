import java.io.*;
import java.util.*;

public class Math_ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverseInt(1385));
  }
  
  public static int reverseInt(int num) {
    int reversedNum = 0;
    
    while(num != 0) {
      int rightmost = num % 10; //get rightmost
      reversedNum = reversedNum * 10 + rightmost; //push it left to expose 0 for addition
      num = num / 10; //remove rightmost
    }
    
    if(reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
      throw new IllegalArgumentException();
    
    return reversedNum;
  }
}

