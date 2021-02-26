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
				String line = reader.nextLine();


				// Quick fix to clean data for Bonaire
				line = line.replaceAll("Bonaire, ", "Bonaire ");
				
				// As a workaround just ignore countries with problematic data
				if (line.contains("Cases_on_an_international_conveyance_Japan") ||
					line.contains("Wallis_and_Futuna")) {
					continue;
				}
				// End Workaround

				DailyCovidDTO dcdto = new DailyCovidDTO(line.split(","));
				data.append(dcdto);
			}
			reader.close();

		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}
		
		ConsoleLogger.logLinesAndTime("Processed", lines, System.currentTimeMillis() - start);

		data.csvExportTopCountries();
		data.csvExportAverageCasesPer100k();
		data.csvExportCumulativeCasesLast14Days();
	}
}
