package src.com.dcv.nov;


// Extends functionality for Day23 -> imporve fault tolerance

public class Day24Part01 {
	public static void faultTolerant() {
		System.out.println("Nothing relevant to print. Methods in this class get called by Day23");

	}
	
	
	public static void isString(String string) {

	}

	public static boolean isInt(String string) {
		try { 
			Integer.parseInt(string); 
		} catch(NumberFormatException e) { 
			return false; 
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}
}
