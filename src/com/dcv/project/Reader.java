package src.com.dcv.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class Reader {
	public static String[][] readCSV(String filepath, char separator){
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
}
