package src.com.dcv.nov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class Day23Part01 {
	public static void helloWorldFileReader() {
		
		String[][] data = readCSV("src/com/dcv/nov/data/hours.csv", ",");
		String[][] cleanedData = getDataWithoutHeader(data);
		String[][] validatedData = getValidatedData(cleanedData);

		//printAll(validatedData);
		
		String[] names = Day22Part01.getNames(validatedData);
		int[] hoursSum = Day22Part01.calculateHoursSum(names, validatedData);

		int loanPerHour = 8;
		int[] salary = Day22Part01.calculateLoan(names, hoursSum, loanPerHour);
		Day22Part01.printLoan(names, salary);
		Day22Part01.printAverage(names, hoursSum, validatedData);
		
	}

    public static String[][] readCSV(String filepath, String separator){
        Vector<String[]> content = new Vector<>();
        try{
            BufferedReader br = new BufferedReader(new FileReader(filepath));
            while (br.ready()){
                String line = br.readLine();
                content.add(line.split(separator));
            }
            br.close();
        } catch (IOException ioException){
            ioException.printStackTrace();
        }

        return content.toArray(String[][]::new);
	}
	
	/*
	private static void printAll(String[][] data) {
		for (String[] row : data) {
			for (String col : row) {
				System.out.println(col + " ");
			}
			System.out.println();
		}
	}
	*/

	private static String[][] getDataWithoutHeader(String[][] data){
		String[][] arr = new String[data.length-1][data[0].length];

		for (int row = 1; row < data.length; row++) {
			arr[row-1] = data[row];
		}
		return arr;
	}

	private static String[][] getValidatedData(String[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			/*
			if (!Day24Part01.isString(arr[row][])) {
				System.out.println(arr[row][0] + "not a string");
			}*/
			if (!Day24Part01.isInt(arr[row][1])) {
				int userRow = row + 2;
				System.out.println("Warning: '" + arr[row][1] + "' in row " + userRow + " is not an int");
				arr[row][1] = null;
			}
		}
		return arr;
	}
}
