import java.util.Random;

public class Random_PasswordGenerator {
	private static String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static String lowercase = "abcdefghijklmnopqrstuvwxyz";
	private static String numbers = "0123456789";
	private static String symbols = "!@#$%^&*_=+-/.?<>)";
    
    public static void main(String[] args) {
    	System.out.println(generatePw(5, true, true, true, true));
    	System.out.println(generatePw(5, false, true, false, true));
    	System.out.println(generatePw(5, true, false, true, false));
    	System.out.println(generatePw(5, false, false, false, false));
    }
    
    public static String generatePw(int passwordLength, boolean allowUppercase, boolean allowLowercase, boolean allowNums, boolean allowSymbols) {
    	if(passwordLength == 0) {
    		throw new Error("Password length must be greater than 0");
    	}
    
    	char[] pwArr = new char[passwordLength];
    	
    	StringBuilder sb = new StringBuilder();
    	
    	if(allowUppercase)
    		sb.append(uppercase);
    	if(allowLowercase)
    		sb.append(lowercase);
    	if(allowNums)
    		sb.append(numbers);
    	if(allowSymbols)
    		sb.append(symbols);
    	
    	String validChars = sb.toString();
    	
    	if(validChars.isEmpty()) {
    		throw new Error("Must allow at least one valid character set");
    	}
    	
    	Random rand = new Random();
    	
    	for(int i = 0; i < passwordLength; i++) {
    		pwArr[i] = validChars.charAt(rand.nextInt(validChars.length()));
    	}
    	
    	return String.valueOf(pwArr);
    }
}
