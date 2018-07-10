import java.io.*;
import java.util.*;

public class Math_ReverseInteger {
  public static void main(String[] args) {
    System.out.println(reverseInt(1385));
  }
  
  //O(log(num))
  public static int reverseInt(int num) {
    int reversedNum = 0;
    
//    while(num != 0) {
//      int rightmost = num % 10; //get rightmost
//      reversedNum = reversedNum * 10 + rightmost; //push it left to expose 0 for addition
//      num = num / 10; //remove rightmost
//    }
//    
//    if(reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
//      throw new IllegalArgumentException();
    
    while (num != 0) {
        int pop = num % 10;
        num /= 10;
        if (reversedNum > Integer.MAX_VALUE/10 || (reversedNum == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
        if (reversedNum < Integer.MIN_VALUE/10 || (reversedNum == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
        reversedNum = reversedNum * 10 + pop;
    }
    
    return reversedNum;
  }
}

