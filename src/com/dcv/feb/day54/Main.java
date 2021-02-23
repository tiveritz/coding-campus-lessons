package src.com.dcv.feb.day54;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Data data = new Data();

		long start = System.currentTimeMillis();
		int lines = 0;

		try {
			File file = new File("src/com/dcv/feb/day54/data/covid19.csv");
			Scanner reader = new Scanner(file);
			boolean firstLine = true;

			while (reader.hasNextLine()) {
				lines++;
				if (firstLine) {
					reader.nextLine();
					firstLine = false;
					continue;
				}

				DailyCovidDTO dcdto = new DailyCovidDTO(reader.nextLine().split(","));
				data.append(dcdto);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}
		data.csvExportTopCountries();

		long finish = System.currentTimeMillis();

		System.out.println("processed " + lines + " lines in " + (finish - start) + "ms");
	}

}
