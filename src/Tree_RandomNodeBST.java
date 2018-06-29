import java.io.*;
import java.util.*;

public class Tree_RandomNodeBST {
  public static void main(String[] args) {
    RandomTreeNode root = new RandomTreeNode(20);
    root.insertInOrder(10);
    root.insertInOrder(30);
    root.insertInOrder(5);
    root.insertInOrder(15);
    root.insertInOrder(17);
    root.insertInOrder(3);
    root.insertInOrder(7);
/*
              20
          10      30
       5     15
    3    7      17
*/
    
    System.out.println(root.getRandomNode().data);
  
  }
}

class RandomTreeNode {
  public int data;
  public RandomTreeNode left;
  public RandomTreeNode right;
  public RandomTreeNode parent;
  private int size = 0;
  
  public RandomTreeNode(int d) {
    data = d;
    size = 1;
  }
  
  //in balanced tree, this would be O(logn)
  public RandomTreeNode getRandomNode() {
    Random random = new Random();
    int index = random.nextInt(size);
    
    int leftSize = left == null ? 0 : left.size;
    
    if(index < leftSize)
      return left.getRandomNode();
    else if(index == leftSize)
      return this;
    else
      return right.getRandomNode();
  }
  
  public void insertInOrder(int d) {
    if (d <= data) {
      if(left == null)
        setLeftChild(new RandomTreeNode(d));
      else
        left.insertInOrder(d);
    }
    else {
      if(right == null)
        setRightChild(new RandomTreeNode(d));
      else
        right.insertInOrder(d);
    }
    
    size++;
  }
  
  public int size() {
    return size; 
  }
  
  public RandomTreeNode find(int d) {
    if(data == d)
      return this;
    else if(d <= data)
      return left != null ? left.find(d) : null;
    else if(d > data)
      return right != null ? right.find(d) : null;
    return null;
  }
  
  public void setLeftChild(RandomTreeNode left) {
    this.left = left;
    if(left != null) {
      left.parent = this;
    }
  }
  
  public void setRightChild(RandomTreeNode right) {
    this.right = right;
    if(right != null)
      right.parent = this;
  }
}