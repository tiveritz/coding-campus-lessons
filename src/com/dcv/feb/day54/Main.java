package src.com.dcv.feb.day54;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Data data = new Data();

		try {
			File file = new File("src/com/dcv/feb/day54/data/covid19.csv");
			Scanner reader = new Scanner(file);
			boolean firstLine = true;

			while (reader.hasNextLine()) {
				if (firstLine) {
					reader.nextLine();
					firstLine = false;
					continue;
				}

				String[] line = reader.nextLine().split(",");
				data.append(line);
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File was not found");
			e.printStackTrace();
		}
		data.getTopCountries();
	}

}
