import java.io.*;
import java.util.*;

public class ConwayGameOfLife {
  public static void main(String[] args) {
    ArrayList<Coordinates> state = new ArrayList<>();
    state.add(new Coordinates(0, -1));
    state.add(new Coordinates(0, 0));
    state.add(new Coordinates(0, 1));
    
    System.out.println(state);
    state = tick(state);
    System.out.println(state);
  }
  
  public static ArrayList<Coordinates> getNeighbors(Coordinates cell) {
    ArrayList<Coordinates> neighbors = new ArrayList<Coordinates>();
    
    neighbors.add(new Coordinates(cell.x, cell.y+1)); //bottom
    neighbors.add(new Coordinates(cell.x, cell.y-1)); //top
    neighbors.add(new Coordinates(cell.x+1, cell.y)); //right
    neighbors.add(new Coordinates(cell.x-1, cell.y)); //left
    neighbors.add(new Coordinates(cell.x+1, cell.y+1)); //top right
    neighbors.add(new Coordinates(cell.x+1, cell.y-1)); //top left
    neighbors.add(new Coordinates(cell.x-1, cell.y+1)); //bottom right
    neighbors.add(new Coordinates(cell.x-1, cell.y-1)); //bottom left
    
    return neighbors;
  }
  
  public static ArrayList<Coordinates> tick(ArrayList<Coordinates> state) {
    ArrayList<Coordinates> nextState = new ArrayList<Coordinates>();
    
    for(Coordinates cell: state) {
      int countTouching = 0;
      
      ArrayList<Coordinates> neighbors = getNeighbors(cell);
      
      for(Coordinates neighboringCell: neighbors) {
        if(state.contains(neighboringCell)) {
          countTouching++;
        }
        else {
          //dead cells
        }
      }
      
      if(countTouching < 2) {
        //it dies, do nothing
      }
      else if(countTouching == 2 || countTouching == 3) {
        nextState.add(cell); 
      }
      else if(countTouching > 3) {
        //it dies, do nothing 
      }
    }
    
    return nextState;
  }
}

class Coordinates {
  public int x;
  public int y;
  
  public Coordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  public String toString() {
    return "(" + this.x + ", " + this.y + ")"; 
  }
  
  @Override
  public int hashCode() {
    return Objects.hash(x, y); 
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    
    if(o == null || getClass() != o.getClass())
      return false;
    
    Coordinates that = (Coordinates) o;
    
    return x == that.x && y == that.y;
  }
}