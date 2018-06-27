import java.io.*;
import java.util.*;

/*
 * Given n numbers, each with some frequency of 
 * occurrence. Return a random number with 
 * probability proportional to its frequency of 
 * occurrence.
 */
public class RandomNumWithFreq {
  public static void main(String[] args) {
    int[] arr = {1, 2, 3, 4};
    int[] freq = {10, 5, 20, 100};
    
    for (int i = 0; i < 5; i++)
      System.out.println("random value: " + getRandom(arr, freq));
  }
  
  public static int findCeil(int[] arr, int rand, int low, int high) {
    int mid;
    while(low < high) {
      mid = (low + high) / 2;
      if(rand > arr[mid])
        low = mid + 1;
      else
        high = mid;
    }
    
    return (arr[low] >= rand) ? low : -1;
  }
  
  public static int getRandom(int[] values, int[] freq) {
    int size = values.length;
    
    int[] cumulativeSum = new int[size];
    
    cumulativeSum[0] = freq[0];
    for(int i = 1; i < size; i++) {
      cumulativeSum[i] = cumulativeSum[i - 1] + freq[i];
    }
    
    for(int i = 0; i < size; i++)
      System.out.print(cumulativeSum[i] + " ");
    System.out.println();
    
    Random rand = new Random();
    //Generate random num in the range of 0 - sum(freq)
    int random = rand.nextInt(cumulativeSum[size-1]);
    System.out.println("random: " + random);
    
    int indexC = findCeil(cumulativeSum, random, 0, size-1);
    
    return values[indexC];
  }
}
