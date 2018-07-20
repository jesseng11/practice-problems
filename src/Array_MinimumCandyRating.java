import java.util.*;

/*
There are N children standing in a line. Each child is assigned a rating value. You are giving candies to these children subjected to the following requirements:

1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.

What is the minimum candies you must give?
 */

public class Array_MinimumCandyRating {
	public static void main(String[] args) {
		int[] ratings = {1, 4, 3, 3, 3, 1};
		System.out.println("Minimum candy: " + minCandy(ratings));
	}
	
	public static int minCandy(int[] ratings) {
		int result = 0;
		
		if(ratings == null || ratings.length == 0)
			return result;
		
		int[] candies = new int[ratings.length];
		candies[0] = 1;
		
		//ascending ratings 
		//left to right
		for(int i = 1; i < ratings.length; i++) {
			if(ratings[i] > ratings[i-1])
				candies[i] = candies[i-1] + 1;
			else
				candies[i] = 1;
		}

		result = candies[ratings.length-1];
		
		for(int i = 0; i < candies.length; i++) {
			System.out.print(candies[i] + " ");
		}
		System.out.println();
		
		//descending ratings
		//right to left
		for(int i = ratings.length-2; i >= 0; i--) {
			int curr = 1;
			if(ratings[i] > ratings[i+1])
				curr = candies[i+1] + 1;

			candies[i] = curr;
			result += candies[i];
		}
		
		for(int i = 0; i < candies.length; i++) {
			System.out.print(candies[i] + " ");
		}
		System.out.println();
		
		return result;
	}
}
