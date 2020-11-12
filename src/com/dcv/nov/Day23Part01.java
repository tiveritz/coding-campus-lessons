package src.com.dcv.nov;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;


public class Day23Part01 {
	public static void helloWorldFileReader() {
		String[][] data = readCSV("src/com/dcv/nov/data/addresses.csv", ",");

		for (String[] row : data) {
			for (String col : row) {
				System.out.println(col + " ");
			}
			System.out.println();
		}
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
}
