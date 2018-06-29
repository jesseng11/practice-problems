import java.io.*;
import java.util.*;

public class DP_Fibonacci {
  public static void main(String[] args) {
    System.out.println(fib(9));
  }
  
  public static int fib(int n) {
//     if (n <= 1)
//       return n;
    
//     return fib(n-1) + fib(n-2);
    
    int a = 0;
    int b = 1;
    int c;
    
    if(n == 0)
      return a;
    
    for(int i = 2; i <= n; i++) {
      c = a + b;
      a = b;
      b = c;
    }
    
    return b;
  }
}

