package src.com.dcv.feb.day54;

import java.util.Arrays;
import java.util.Vector;


public class Data {
	private Vector<CountryData> countries;
	private final String EXPORT_PATH = "src/com/dcv/feb/day54/output/";

	public Data() {
		this.countries = new Vector<CountryData>();
	}

	// -- FACTORY ------------------------------------------------------
	public void append(DailyCovidDTO dcdto) {
		String countryName = dcdto.getCountryName();

		CountryData countryData = getCountryData(countryName);
		if (countryData == null) {
			CountryData newCountry = new CountryData(countryName);
			newCountry.addData(dcdto);
			countries.add(newCountry);
		} else {
			countryData.addData(dcdto);
		}
	}

	// -- GETTER -------------------------------------------------------
	private CountryData getCountryData(String countryName) {
		CountryData country = null;

		for (CountryData countryData : countries) {
			if (countryData.getName().equals(countryName)) {
				return countryData;
			}
		}
		return country;
	}

	// -- METHODS ------------------------------------------------------
	public void csvExportTopCountries() {
		long start = System.currentTimeMillis();

		CountryData[] countries = getCopyOfCountryData();
		Arrays.sort(countries);

		String[][] exportData = new String[countries.length][];

		for (int i = 0; i < countries.length; i++) {
			exportData[i] = countries[i].getTotalCasesInfo();
		}

		String[] head = new String[]{"countryName", "totalCases"};
		CsvWriter.write(EXPORT_PATH + "covid-toplist.csv", head, exportData);

		ConsoleLogger.logLinesAndTime("Wrote", exportData.length+1, System.currentTimeMillis() - start);
	}

	public void csvExportAverageCasesPer100k() {
		long start = System.currentTimeMillis();

		CountryData[] countries = getCopyOfCountryData();
		Arrays.sort(countries, new SortByAverage100kDescending());

		String[][] exportData = new String[countries.length][];

		for (int i = 0; i < countries.length; i++) {
			exportData[i] = countries[i].getAverageCasesPer100kInfo();
		}

		String[] head = new String[]{"countryName", "averageCasesPer100k"};
		CsvWriter.write(EXPORT_PATH + "average-cases-per-100k.csv", head, exportData);
		
		ConsoleLogger.logLinesAndTime("Wrote", exportData.length+1, System.currentTimeMillis() - start);
	}

	public void csvExportCumulativeCasesLast14Days() {
		long start = System.currentTimeMillis();

		String[][] exportData = new String[countries.size()][];

		for (int i = 0; i < countries.size(); i++) {
			exportData[i] = countries.get(i).getCumulativeCases14Days();
		}

		String[] head = new String[]{"countryName", "cumulativeCases14Days"};
		CsvWriter.write(EXPORT_PATH + "max-cumulative-14-days.csv", head, exportData);
		
		ConsoleLogger.logLinesAndTime("Wrote", exportData.length+1, System.currentTimeMillis() - start);
	}

	// -- HELPER -------------------------------------------------------
	private CountryData[] getCopyOfCountryData() {
		CountryData[] getCopyOfCountryData = new CountryData[countries.size()];

		for (int i = 0; i < getCopyOfCountryData.length; i++) {
			getCopyOfCountryData[i] = countries.get(i);
		}
		return getCopyOfCountryData;
	}
}
