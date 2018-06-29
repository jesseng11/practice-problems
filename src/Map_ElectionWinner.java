import java.io.*;
import java.util.*;

/*In elections that use the ballot box system for voting, 
 * each voter writes the name of a candidate on a ballot and places it in the ballot box.
 * The candidate with the highest number of votes wins the election. 
 * If two or more candidates have the same number of votes, then the tied candidates' names are ordered
 * alphabetically and the last name in the alphabetical order wins.
*/
public class Map_ElectionWinner {
	public static void main(String[] args) {
		String[] tally = {"Alex", "Michael", "Harry", "Dave", "Michael", "Victor", "Harry", "Alex", "Mary", "Mary"};
		
		System.out.println(electionWinner(tally));
		System.out.println(electionWinner2(tally));
	}
	
	public static String electionWinner(String[] votes) {
		if(votes.length == 0) {
			return null;
		}
		
		Map<String, Integer> map = new TreeMap<String, Integer>(Collections.reverseOrder());
		
		for(String name: votes) {
			if(map.containsKey(name)) {
				int newVotes = map.get(name) + 1;
				map.put(name, newVotes);
			}
			else {
				map.put(name, 1);
			}
		}
		
		String winner = Collections.max(map.entrySet(), Map.Entry.comparingByValue()).getKey();
		
		return winner;
	}
	
	//if you can't use treemap...
	public static String electionWinner2(String[] votes) {
		if(votes.length == 0) {
			return null;
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(String name: votes) {
			if(map.containsKey(name)) {
				int newVotes = map.get(name) + 1;
				map.put(name, newVotes);
			}
			else {
				map.put(name, 1);
			}
		}
		
		ArrayList<String> candidates = new ArrayList<String>();
		int maxVotes = 0;
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			if(entry.getValue() > maxVotes)
				maxVotes = entry.getValue();
		}

		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			if(entry.getValue() == maxVotes)
				candidates.add(entry.getKey());
		}
		
		Collections.sort(candidates);
		
		String winner = candidates.get(candidates.size()-1);
		
		return winner;
	}
}
