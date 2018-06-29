import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

/*
Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000

I can be placed before V (5) and X (10) to make 4 and 9. 
X can be placed before L (50) and C (100) to make 40 and 90. 
C can be placed before D (500) and M (1000) to make 400 and 900.
*/

public class MathString_IntToRoman {
  public static void main(String[] args) {
    System.out.println(intToRoman(3));
    System.out.println(intToRoman(4));
    System.out.println(intToRoman(9));
    System.out.println(intToRoman(58));
    System.out.println(intToRoman(1994));
  }
  
  public static String intToRoman(int num) {
    if(num < 1 || num > 3999) return "";
    
    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder sb = new StringBuilder();
    
    int i = 0;
    while(num > 0) {
      while(num >= values[i]) {
         num -= values[i];
         sb.append(roman[i]);
      }
      
      i++;
    }
    
    return sb.toString();
  }
}

