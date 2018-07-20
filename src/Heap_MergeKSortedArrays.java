import java.util.*;

public class Heap_MergeKSortedArrays {
	public static void main(String[] args) {
		int[][] arr = {
				{1,3,5},
				{2,4}
		};
		
		int[] result = merge(arr);
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	//Okay solution: combine all the array elements and sort them. O(kn * log(kn))
	
	//O(kn * log(k)
	public static int[] merge(int[][] arr) {
		PriorityQueue<PriorityQueueNode> pq = new PriorityQueue<PriorityQueueNode>();
	
		int size = 0;
		for(int i = 0; i < arr.length; i++) {
			size += arr[i].length;
			if(arr[i].length > 0) {
				pq.add(new PriorityQueueNode(i, 0, arr[i][0]));
			}
		}
		
		int[] result = new int[size];
		
		for(int i = 0; !pq.isEmpty(); i++) {
			PriorityQueueNode n = pq.poll();
			
			result[i] = n.value;
			int newIndex = n.index + 1;
			
			if(newIndex < arr[n.array].length) {
				pq.add(new PriorityQueueNode(n.array, newIndex, arr[n.array][newIndex]));
			}
		}
		
		return result;
	}
}

class PriorityQueueNode implements Comparable<PriorityQueueNode> {
	int array;
	int index;
	int value;
	
	public PriorityQueueNode(int a, int i, int v) {
		array = a;
		index = i;
		value = v;
	}
	
	public int compareTo(PriorityQueueNode n) {
		if(value > n.value)
			return 1;
		if(value < n.value)
			return -1;
		return 0;
	}
}