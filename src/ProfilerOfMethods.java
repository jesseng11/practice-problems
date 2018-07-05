import java.io.*;
import java.util.*;

/*
 * Single threaded
 * 
 * Example 1:
 * T1 Method1 Enter
 * T2 Method2 Enter
 * T3 Method2 Exit
 * T4 Method1 Exit
 * T5 Method3 Enter
 * T6 Method3 Exit
 * 
 * prints out
 * T1 - T4 Method1
 *    T2 - T3 Method2
 * T5 - T6 Method3
 * 
 * Example 2:
 * T1 Method1 Enter
 * T2 Method1 Enter
 * T3 Method1 Exit
 * T4 Method1 Exit
 * T5 Method1 Enter
 * T6 Method1 Exit
 * 
 * prints out
 * T1 - T4 Method1
 *    T2 - T3 Method1
 * T5 - T6 Method2
 */
public class ProfilerOfMethods {
	public static void main(String[] args) {
		ProfileInput[] arr = {
				new ProfileInput("T1", "Method1", 0),
				new ProfileInput("T2", "Method2", 0),
				new ProfileInput("T3", "Method2", 1),
				new ProfileInput("T4", "Method1", 1),
				new ProfileInput("T5", "Method3", 0),
				new ProfileInput("T6", "Method3", 1)
		};
		
		System.out.println("test1: ");
		printProfiler(arr);
		
		ProfileInput[] arr2 = {
				new ProfileInput("T1", "Method1", 0),
				new ProfileInput("T2", "Method1", 0),
				new ProfileInput("T3", "Method1", 1),
				new ProfileInput("T4", "Method1", 1),
				new ProfileInput("T5", "Method2", 0),
				new ProfileInput("T6", "Method2", 1)
		};

		System.out.println("test2: ");
		printProfiler(arr2);
	}

	public static void printProfiler(ProfileInput[] profiles) {
		Profiler[] arrToPrint = new Profiler[profiles.length/2];
		Stack<Profiler> activeProfiles = new Stack<Profiler>();
		int index = 0;
		
		for(int i = 0; i < profiles.length; i++) {
			if(profiles[i].status == 0) {
				Profiler res = new Profiler(profiles[i].time, profiles[i].method, index);
				activeProfiles.push(res);
				index++;
			}
			else {
				Profiler res = activeProfiles.pop();
				res.end = profiles[i].time;
				res.numTabs = activeProfiles.size();
				arrToPrint[res.order] = res;
			}
		}
		
		for(Profiler prof: arrToPrint) {
			while(prof.numTabs > 0) {
				System.out.print("   ");
				prof.numTabs--;
			}
			System.out.print(prof.start + " - " + prof.end + " " + prof.method);
			System.out.println();
		}
	}
}

class ProfileInput {
	public String time;
	public String method;
	
	//0 is Enter, 1 is Exit
	public int status;
	
	public ProfileInput(String t, String m, int s) {
		this.time = t;
		this.method = m;
		this.status = s;
	}
}

class Profiler {
	public String start;
	public String end;
	public String method;
	public int order;
	public int numTabs;
	
	public Profiler(String start, String method, int order) {
		this.start = start;
		this.method = method;
		this.order = order;
	}
}