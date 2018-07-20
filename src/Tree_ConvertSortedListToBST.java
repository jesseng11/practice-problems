import java.util.*;

public class Tree_ConvertSortedListToBST {
	public static LinkedListNode head;
	
	public static void main(String[] args) {
		LinkedListNode h = new LinkedListNode(1);
		h.appendToTail(2);
		h.appendToTail(3);
		h.appendToTail(4);
		h.appendToTail(5);
		h.appendToTail(6);
		h.appendToTail(7);
		
		TreeNode root = sortedListToBST(h);
		preOrder(root);
	}
	
	public static TreeNode sortedListToBST(LinkedListNode h) {
		if(h == null)
			return null;
		
		head = h;
		int len = getLength(head);
		
		return sortedListToBST(0, len-1);
	}
	
	public static int getLength(LinkedListNode head) {
		int length = 0;
		LinkedListNode p = head;
		
		while(p != null) {
			length++;
			p = p.next;
		}
		
		return length;
	}
	
	public static TreeNode sortedListToBST(int start, int end) {
		if(start > end)
			return null;
		
		int mid = (start + end) / 2;
		
		//bottom up
		TreeNode left = sortedListToBST(start, mid-1);
		TreeNode root = new TreeNode(head.data);
		head = head.next;
		TreeNode right = sortedListToBST(mid+1, end);
		
		root.left = left;
		root.right = right;
		
		return root;
	}
	
	  /* A utility function to print preorder traversal of BST */
	  public static void preOrder(TreeNode node) {
	    if (node == null) {
	        return;
	    }
	    System.out.print(node.data + " ");
	    preOrder(node.left);
	    preOrder(node.right);
	  }
}
