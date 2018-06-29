import java.io.*;
import java.util.*;

public class String_SortChar {
  // Method to sort a mixed string
  public static String sortString(String inputString)
  {
      // convert input string to Character array
      Character tempArray[] = new Character[inputString.length()];
      for (int i = 0; i < inputString.length(); i++) {
          tempArray[i] = inputString.charAt(i);
      }


      // Sort, ignoring case during sorting
      Arrays.sort(tempArray, new Comparator<Character>(){

          @Override
          public int compare(Character c1, Character c2)
          {
              // ignoring case
              return Character.compare(Character.toLowerCase(c1),
                                      Character.toLowerCase(c2));
          }
      });

      // using StringBuilder to convert Character array to String
      StringBuilder sb = new StringBuilder(tempArray.length);
      for (Character c : tempArray)
          sb.append(c.charValue());

      return sb.toString();
  }
  
  public static String mergesortString(String[] strings) {
    StringBuilder sb = new StringBuilder();
    
    for(String str: strings)
      sb.append(str);
    
    char[] orderedArr = sb.toString().toCharArray();
    
    Arrays.sort(orderedArr);
    
    return new String(orderedArr);
  }
     
  // Driver method
  public static void main(String[] args)
  {
      String inputString = "GeeksforGeeks";
      String outputString = sortString(inputString);

      System.out.println("Input String : " + inputString);
      System.out.println("Output String : " + outputString);
    
    String[] strings = new String[] {"what", "is", "going", "on"};
    String result = mergesortString(strings);
    System.out.println(result);
  }
}

