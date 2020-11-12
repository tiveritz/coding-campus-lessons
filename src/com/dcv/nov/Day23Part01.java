package src.com.dcv.nov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class Day23Part01 {
	public static void helloWorldFileReader() {
		String[][] data = readCSV("src/com/dcv/nov/data/hours.csv", ",");
		String[][] cleanedData = getDataWithoutHeader(data);
		
		int[] hoursSum = Day22Part01.calculateHoursSum(cleanedData);

		int loanPerHour = 8;
		int[] salary = Day22Part01.calculateLoan(hoursSum, loanPerHour);
		Day22Part01.printLoan(salary);
		Day22Part01.printAverage(cleanedData, hoursSum);

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
	
	private static void printAll(String[][] data) {
		for (String[] row : data) {
			for (String col : row) {
				System.out.println(col + " ");
			}
			System.out.println();
		}
	}

	private static String[][] getDataWithoutHeader(String[][] data){
		String[][] arr = new String[data.length-1][data[0].length];

		for (int row = 1; row < data.length; row++) {
			arr[row-1] = data[row];
		}
		return arr;
	};
}
