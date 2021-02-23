package src.com.dcv.feb.day54;

import java.io.FileWriter;
import java.io.IOException;


public class CsvWriter {
	

	public static void write(String path, String[] head, String[][] data) {
		try {
			FileWriter topCountriesFile = new FileWriter(path, true);
			CsvWriter.writeLine(topCountriesFile, head);
			for (String[] line : data) {
				CsvWriter.writeLine(topCountriesFile, line);
			}
			topCountriesFile.close();
		} catch (IOException ioe) {
			System.out.println("IOException");
			ioe.printStackTrace();
		}
	}

	private static void writeLine(FileWriter file, String[] line) throws IOException {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < line.length; i++) {
			sb.append(line[i]);

			if (i == line.length-1) {
				sb.append("\n");
			} else {
				sb.append(",");
			}
		}
		file.write(sb.toString());
	}
}
