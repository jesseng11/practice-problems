import java.util.*;

public class Math_FractionToDecimal {
	public static void main(String[] args) {
		fractionToDecimal(1, 2);
		fractionToDecimal(2, 1);
		fractionToDecimal(2, 3);
	}
	
	public static String fractionToDecimal(int numr, int denr) {
		if(numr == 0)
			return "0";
		if(denr == 0)
			return "";
		
		StringBuilder result = new StringBuilder();
		
		if((numr > 0) ^ (denr > 0))
			result.append("-");
		
		long num = Math.abs((long) numr);
		long den = Math.abs((long) denr);
		
		result.append(num/den);
		
		long rem = num % den;
		System.out.println(num%den);
		if(rem == 0) {
			return result.toString();
		}
		result.append(".");
		
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		map.put(rem, result.length());
		
		while(rem != 0) {
			rem *= 10;
			result.append(rem/den);
			rem %= den;
			
			if(map.containsKey(rem)) {
				int index = map.get(rem);
				result.insert(index, "(");
				result.append(")");
				break;
			}
			else {
				map.put(rem, result.length());
			}
		}
		
		//System.out.println(result.toString());
		return result.toString();
	}
}
