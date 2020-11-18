package src.com.dcv.project;

import java.util.Arrays;


public class BudgetFK {

	private static final String FILENAME = "offenerhaushalt_fk_2019.csv";
	private static final String FILEPATH = "src/com/dcv/project/raw_data/";
	private static Boolean hasHeader = true;

	public static void driver() {

		String file = FILEPATH + FILENAME;
		String[][] data = Reader.readCSV(file, ';');
		// String[] header = hasHeader ? data[0] : null; -> Preparation for later use
		String[][] content = hasHeader
						   ? Arrays.copyOfRange(data, 1, data.length)
						   : Arrays.copyOfRange(data, 0, data.length); 


		// #1 Get total budget ---------------------------------------------------------------------
		int totalBudget = getTotalBudget(data);
		Printer.printFormattedCurrency("Total Budget 2019: ", totalBudget, "\n");


		// #2 Get 10 highest Items -----------------------------------------------------------------
		Printer.printFormattedTable(getHighestItemIndexes(content, 10), content);


		// #3 Get 10 Lowest Items. Only values > 0 -------------------------------------------------
		Printer.printFormattedTable(getLowestItemIndexes(content, 10), content);


		// #4 Get sum of schools -------------------------------------------------------------------
		String[] schools = {"Volksschule", "Mittelschule", "Polytechnische"};
		int schoolsSum = getSpecificSum(schools, content);
		Printer.printFormattedCurrency("Schools: ", schoolsSum, "");
		

		// #5 Percentage of the Total Budget -------------------------------------------------------
		double schoolPercentage = (schoolsSum / (double)totalBudget);
		Printer.printFormattedPercentage("Schools percentage: ", schoolPercentage, "\n");
		

		// #6 Get sum of kindergarden --------------------------------------------------------------
		String[] kindergarden = {"Kindergarten", "Ganztagskindergarten", "Ganztageskindergarten"};
		int kindergardenSum = getSpecificSum(kindergarden, content);
		Printer.printFormattedCurrency("Kindergarden: ", kindergardenSum, "");
		

		// #7 Percentage of the Total Budget -------------------------------------------------------
		double kindergardenPercentage = (kindergardenSum / (double)totalBudget);
		Printer.printFormattedPercentage("Kindergarden percentage: ", kindergardenPercentage, "\n");
	}
	

	private static int getTotalBudget(String[][] data) {
		int result = 0;
		int row =  hasHeader ? 1 : 0;
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

	// Helper methods ----------------------------------------------------------
	
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
	
	private static int getSpecificSum(String[] searchTerms, String[][] arr) {
		int sum = 0;
		
		for (String[] row : arr) {
			if (containsFromList(row[0], searchTerms)) {
				sum += Integer.parseInt(row[2]);
			}
		}
		return sum;
	}
	
	private static boolean containsFromList(String string, String[] searchTerms) {
		boolean contains = false;
		
		for (String searchTerm : searchTerms) {
			if (string.toLowerCase().contains(searchTerm.toLowerCase())) {
				contains = true;
				break;
			}
		}
		return contains;
	}
	
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
