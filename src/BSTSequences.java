import java.io.*;
import java.util.*;

public class BSTSequences {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(20);
    root.insertInOrder(10);
    root.insertInOrder(30);
    root.insertInOrder(5);
    root.insertInOrder(15);
/*
              20
          10      30
       5     15
*/
    System.out.println(allSequences(root));
  }
  
  public static ArrayList<LinkedList<Integer>> allSequences(TreeNode node) {
    ArrayList<LinkedList<Integer>> results = new ArrayList<LinkedList<Integer>>();
    
    if(node == null) {
      results.add(new LinkedList<Integer>());
      return results;
    }
    
    LinkedList<Integer> prefix = new LinkedList<Integer>();
    prefix.add(node.data);
    
    ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
    ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);
    
    for(LinkedList<Integer> left: leftSeq) {
      for(LinkedList<Integer> right: rightSeq) {
        ArrayList<LinkedList<Integer>> weaved = new ArrayList<LinkedList<Integer>>();
        weaveLists(left, right, weaved, prefix);
        results.addAll(weaved);
      }
    }
    
    return results;
  }
  
  @SuppressWarnings("unchecked")
  public static void weaveLists(LinkedList<Integer> first, 
                           LinkedList<Integer> second, 
                           ArrayList<LinkedList<Integer>> results, 
                           LinkedList<Integer> prefix) {
    
    if(first.size() == 0 || second.size() == 0) {
      LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
      result.addAll(first);
      result.addAll(second);
      results.add(result);
      return;
    }
    
    int headFirst = first.removeFirst();
    prefix.addLast(headFirst);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    first.addFirst(headFirst);
    
    int headSecond = second.removeFirst();
    prefix.addLast(headSecond);
    weaveLists(first, second, results, prefix);
    prefix.removeLast();
    second.addFirst(headSecond);
  }
}

