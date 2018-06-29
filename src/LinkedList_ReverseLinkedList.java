import java.io.*;
import java.util.*;

public class LinkedList_ReverseLinkedList {
	public static void main(String[] args) {
		LLNode head = new LLNode(1);
		head.next = new LLNode(2);
		head.next.next = new LLNode(3);
		head.next.next.next = new LLNode(4);
		
		LLNode reversed = reverseLinkedList(head);
		
		while(reversed != null) {
			System.out.println(reversed.data);
			reversed = reversed.next;
		}
		
		LLNode oneElement = new LLNode(5);
		
		LLNode reversedOne = recursiveReverse(oneElement);

		while(reversedOne != null) {
			System.out.println(reversedOne.data);
			reversedOne = reversedOne.next;
		}
	}
	
	public static LLNode reverseLinkedList(LLNode head) {
		LLNode newHead = null;
		
		while(head != null) {
			LLNode temp = head.next;
			head.next = newHead;
			newHead = head;
			head = temp;
		}
		
		return newHead;
	}
	
	public static LLNode recursiveReverse(LLNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		LLNode temp = head.next;
		head.next = null;
		
		LLNode newHead = recursiveReverse(temp);
		temp.next = head;
		
		return newHead;
	}
}

class LLNode {
	public int data;
	public LLNode next;
	
	public LLNode(int d) {
		data = d;
		next = null;
	}
}