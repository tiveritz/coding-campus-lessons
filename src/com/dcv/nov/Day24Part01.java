package src.com.dcv.nov;

import java.io.FileWriter;
import java.io.IOException;


// Extends functionality for Day23 -> imporve fault tolerance

public class Day24Part01 {
	public static void additionalMethodsForDay23() {
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

	public static void writeCSV(String filename, String[] names, int[] salary) {
        try {
			FileWriter file = new FileWriter("src/com/dcv/nov/data/" + filename);
			
			for (int row = 0; row < names.length; row++) {
				file.write(names[row] + "," + salary[row] + "\n");
			}
            file.close();
        } catch (IOException e) {
            System.out.println("Badly handled error");
        }
    }
}
