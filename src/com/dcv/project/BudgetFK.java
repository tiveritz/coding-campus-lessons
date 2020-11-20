package src.com.dcv.project;

import java.util.Arrays;


public class BudgetFK {

	private static final String FILENAME = "offenerhaushalt_fk_2019.csv";
	private static final String FILEPATH = "src/com/dcv/project/raw_data/";
	private static final Boolean HAS_HEADER = true;

	public static void driver() {

		// #1 Read CSV -----------------------------------------------------------------------------
		String file = FILEPATH + FILENAME;
		String[][] data = Reader.readCSV(file, ';');

		// #2 Handle irrelevant data ---------------------------------------------------------------
		String[] header = HAS_HEADER ? data[0] : null;
		String[][] content = HAS_HEADER
						   ? Arrays.copyOfRange(data, 1, data.length)
						   : Arrays.copyOfRange(data, 0, data.length); 

		// #3 Get total budget ---------------------------------------------------------------------
		int totalBudget = getTotalBudget(data);
		Printer.printFormattedCurrency("\n\nTotal Budget 2019: ", totalBudget, "\n");
		

		// #4 Get 10 highest Items -----------------------------------------------------------------
		Printer.printFormattedTable(getHighestItemIndexes(content, 10), content, header);


		// #5 Get 10 Lowest Items. Only values > 0 -------------------------------------------------
		// This doesn't show good data if there are lot of items with the same vorranschlag
		Printer.printFormattedTable(getLowestItemIndexes(content, 10), content, header);


		// #6 Get sum of schools -------------------------------------------------------------------
		String[] schools = {"Volksschule", "Mittelschule", "Polytechnische"};
		int schoolsSum = getSpecificSum(schools, content);
		Printer.printFormattedCurrency("Schools: ", schoolsSum, "");
		

		// #7 Percentage of the Total Budget -------------------------------------------------------
		double schoolPercentage = (schoolsSum / (double)totalBudget);
		Printer.printFormattedPercentage("Schools percentage: ", schoolPercentage, "\n");
		

		// #8 Get sum of kindergarden --------------------------------------------------------------
		String[] kindergarden = {"Kindergarten", "Ganztagskindergarten", "Ganztageskindergarten"};
		int kindergardenSum = getSpecificSum(kindergarden, content);
		Printer.printFormattedCurrency("Kindergarden: ", kindergardenSum, "");
		

		// #9 Percentage of the Total Budget -------------------------------------------------------
		double kindergardenPercentage = (kindergardenSum / (double)totalBudget);
		Printer.printFormattedPercentage("Kindergarden percentage: ", kindergardenPercentage, "\n");
	}


	/** Returns the sum of all values in column 2.
	  * @param data two dimensional array with data, without header
	  * @return sum of all values in column 2
	  */
	private static int getTotalBudget(String[][] data) {
		int result = 0;
		int row =  HAS_HEADER ? 1 : 0;
		while (row < data.length) {
			if (isInt(data[row][2])) {
				result += Integer.parseInt(data[row][2]);
			} else {
				System.out.println("Error: value not an Integer in row " + row);
			}
			row++;
		}
		return result;
	}

	/** Returns an array with the indexes of the highest items in column 2.
	  * @param data two dimensional array with data, without header
	  * @param amount number of values to search
	  * @return array with the indexes of the highest items, sorted descending
	  */
	private static int[] getHighestItemIndexes(String[][] data, int amount) {
		int indexes[] = new int[amount];

		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = -1;
		}

		for (int i = 0; i < indexes.length; i++) {
			int highest = Integer.MIN_VALUE;
			int currIndex = 0;
			for (int row = 0; row < data.length; row++) {
				int value = Integer.parseInt(data[row][2]);
				if (value > highest && !isInArray(indexes, row)) {
					highest = value;
					currIndex = row;
				}
			}
			indexes[i] = currIndex;
		}
		return indexes;
	}

	/** Returns an array with the indexes of the lowest items in column 2.
	  * @param data two dimensional array with data, without header
	  * @param amount number of values to search
	  * @return array with the indexes of the lowest items, sorted ascending
	  */
	private static int[] getLowestItemIndexes(String[][] data, int amount) {
		int indexes[] = new int[amount];

		for (int i = 0; i < indexes.length; i++) {
			indexes[i] = -1;
		}

		for (int i = 0; i < indexes.length; i++) {
			int lowest = Integer.MAX_VALUE;
			int currIndex = 0;
			for (int row = 0; row < data.length; row++) {
				int value = Integer.parseInt(data[row][2]);
				if (value > 0 && value < lowest && !isInArray(indexes, row)) {
					lowest = value;
					currIndex = row;
				}
			}
			indexes[i] = currIndex;
		}
		return indexes;
	}

	/** Returns the sum of items in column 2 depending on search terms in column 0.
	  * @param searchTerms array of search terms
	  * @param arr two dimensional array with dat
	  * @return sum of found items
	  */
	private static int getSpecificSum(String[] searchTerms, String[][] arr) {
		int sum = 0;
		
		for (String[] row : arr) {
			if (containsStringFromArray(row[0], searchTerms)) {
				sum += Integer.parseInt(row[2]);
			}
		}
		return sum;
	}


	// Helper methods ------------------------------------------------------------------------------
	
	/** Checks whether an int is insiede an array.
	  * @param arr the array to be searched
	  * @param compValue the value to check
	  * @return true if the value is in the array, false if not
	  */
	private static boolean isInArray(int[] arr, int compValue) {
		boolean inArray = false;

		for (int arrValue : arr) {
			if (arrValue == compValue) {
				inArray = true;
				break;
			}
		}
		return inArray; 
	}
	
	/** Check whether a String contains at least one String from an array.
	  * @param string the String to check
	  * @param searchTerms the array with the search Strings
	  * @return true if at least one String from array is in String
	  */
	private static boolean containsStringFromArray(String string, String[] searchTerms) {
		boolean contains = false;
		
		for (String searchTerm : searchTerms) {
			if (string.toLowerCase().contains(searchTerm.toLowerCase())) {
				contains = true;
				break;
			}
		}
		return contains;
	}
	
	/** Checks whether a given String can be parsed as int 
	  * @param string String to check
	  * @return true if String can be parsed to int, false if not
	  */
	private static boolean isInt(String string) {
		boolean isInt = true;

		try { 
			Integer.parseInt(string); 
		} catch(NumberFormatException e) { 
			return false; 
		} catch(NullPointerException e) {
			return false;
		}
		return isInt;
	}
}
