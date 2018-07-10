import java.io.*;
import java.util.*;

/*
Given an array arr[] of n integers, 
construct a Product Array prod[] (of same size) 
such that prod[i] is equal to the product of all 
the elements of arr[] except arr[i]. Solve it 
without division operator and in O(n).
*/

public class Math_ProductArray {
  public static void main(String[] args) {
      int arr[] = {10, 3, 5, 6, 2};
      productArray(arr);
  }
  
  public static int[] productArray(int[] arr) {
    int[] left = new int[arr.length];
    int[] right = new int[arr.length];
    int[] product = new int[arr.length];
    
    left[0] = 1;
    right[arr.length-1] = 1;
    
    for(int i = 1 ; i < arr.length; i++) {
      left[i] = arr[i-1] * left[i-1];
    }
    
    for(int i = arr.length-2; i >= 0; i--) {
      right[i] = arr[i+1] * right[i+1];
    }
    
    for(int i = 0; i < arr.length; i++) {
      product[i] = left[i] * right[i];
      System.out.print(product[i] + " ");
    }
    
    return product;
  }
}

