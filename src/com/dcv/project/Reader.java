package src.com.dcv.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class Reader {
	/** Reads a .csv file and writes all data into two dimensional array.
	  * @param file complete path to the file, including filename and file extension
	  * @param separator .csv data separator
	  * @return two dimensional array with data
	  */
	public static String[][] readCSV(String file, char separator){
		Vector<String[]> data = new Vector<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			
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
}
