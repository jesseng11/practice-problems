import java.io.*;
import java.util.*;

//Search for a number in a sorted array
public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
    
    System.out.println("found at index: " + binarySearchRecursive(arr, 9, 0, arr.length-1));
  }
  
  public static int binarySearch(int[] sortedArray, int key, int low, int high) {
    int index = -1;
     
    while (low <= high) {
        int mid = (low + high) / 2;
        if (sortedArray[mid] < key) {
            low = mid + 1;
        } else if (sortedArray[mid] > key) {
            high = mid - 1;
        } else if (sortedArray[mid] == key) {
            index = mid;
            break;
        }
    }
    return index;
  }
  
  public static int binarySearchRecursive(int[] sortedArray, int key, int low, int high) {
      int middle = (low + high) / 2;

      if (high < low) {
        return -1;
      }

      if (key == sortedArray[middle]) {
        return middle;
      } 
      else if (key < sortedArray[middle]) {
        return binarySearchRecursive(sortedArray, key, low, middle - 1);
      } 
      else {
        return binarySearchRecursive(sortedArray, key, middle + 1, high);
      }
  }
}
