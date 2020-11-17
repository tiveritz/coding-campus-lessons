package src.com.dcv.project;

import java.util.Arrays;
import java.util.Vector;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class BudgetFK {

	private static final String FILENAME = "offenerhaushalt_fk_2019.csv";
	private static final String FILEPATH = "src/com/dcv/project/raw_data/";
	private static Boolean hasHeader = true;
	private static char separator = ';';

	public static void driver() {

		String file = FILEPATH + FILENAME;
		String[][] data = readCSV(file, separator);
		String[] header = hasHeader ? data[0] : null;

		System.out.println(Arrays.toString(header));
		String[][] content = hasHeader ? Arrays.copyOfRange(data, 1, data.length) : Arrays.copyOfRange(data, 0, data.length); 

		// #1 Get total budget
		int totalBudget = getTotalBudget(data);
		System.out.println(totalBudget);
		System.out.println();

		// #2 Get 10 highest Items
		printRows(getHighestItemIndexes(content, 10), content);
		System.out.println();

		// #3 Get 10 Lowest Items. Attention: consider only values > 0
		printRows(getLowestItemIndexes(content, 10), content);
		System.out.println();

		// #4 Get sum of schools
		String[] schools = {"Volksschule", "Mittelschule", "Polytechnische"};
		int schoolsSum = getSpecificSum(schools, content);
		System.out.println(schoolsSum);

		// #5 Percentage of the Total Budget
		double schoolPercentage = (schoolsSum / (double)totalBudget) * 100;
		System.out.println(schoolPercentage);
	

	}


	private static String[][] readCSV(String filepath, char separator){
		Vector<String[]> data = new Vector<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(filepath));
			
			while (br.ready()) {
					String line = br.readLine();
					if (!line.isEmpty()) {
						data.add(line.split(Character.toString(separator)));
					}
				}
			br.close();
			
		} catch (IOException ioe){
			ioe.printStackTrace();
		}
		
		String[][] dataArr = data.toArray(String[][]::new);
		return dataArr;
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

	private static void printRows(int[] indexes, String[][] content) {
		int count = 1;
		for (int index : indexes) {
			System.out.println(count + " - " +content[index][0] + " " + content[index][1] + " " + content[index][2]);
			count++;
		}
	}

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
			if (string.contains(searchTerm)) {
				contains = true;
				break;
			}
		}
		return contains;
	}

	private static boolean isInt(String string) {
		try { 
			Integer.parseInt(string); 
		} catch(NumberFormatException e) { 
			return false; 
		} catch(NullPointerException e) {
			return false;
		}
		return true;
	}

	private static String[][] ArraysDeepCopy(String[][] arr) {
		String[][] arrCopy = new String[arr.length][];

		for (int row = 0; row < arrCopy.length; row++) {
			arrCopy[row] = Arrays.copyOf(arr[row], arr[row].length);
		}

		return arrCopy;
	}
}
