import java.util.*;

public class Heap_MedianStreamData {
	public static void main(String[] args) {
		
	}
	
	//O(nlogn), have a queue keeping track of latest k elements, removing old elements from an array as needed from getFirst in queue, sort array, and get the median by index 
	//if even length, return average of the middle two. Otherwise return the one element in middle.
	
	//O(n), have a queue keeping track of latest k elements and an array continuously shifting incoming elements to maintain sort order
	
	//O(logn)
	public static double medianWithSize(Iterator<Integer> iterator, int k) {
		LinkedList<Integer> latestKElements = new LinkedList<Integer>();
		Queue<Integer> leftHeap = new PriorityQueue<Integer>(); //MIN HEAP
		Queue<Integer> rightHeap = new PriorityQueue<Integer>(20, Collections.reverseOrder()); //MAX HEAP
		
		int numElements = 0;
		
		while(iterator.hasNext()) {
			Integer data = iterator.next();
			
			latestKElements.addLast(data);
			
			if(latestKElements.size() > k) {
				Integer old = latestKElements.getFirst();
				latestKElements.removeFirst();
				
				if(leftHeap.peek() <= old)
					leftHeap.remove(old);
				else if(rightHeap.peek() >= old)
					rightHeap.remove(old);
			}
			
			rightHeap.add(data);
			
			if(numElements % 2 == 0) {
				if(!leftHeap.isEmpty() && rightHeap.peek() > leftHeap.peek()) {
					Integer maxHeaproot = rightHeap.poll();
					Integer minHeaproot = leftHeap.poll();
					rightHeap.add(minHeaproot);
					rightHeap.add(maxHeaproot);
				}
			}
			else {
				leftHeap.add(rightHeap.poll());
			}
			
			numElements++;
		}
		
		if(numElements % 2 != 0) {
			return rightHeap.peek().doubleValue();
		}
		
		return (rightHeap.peek() + leftHeap.peek()) / 2.0;
	}
}
