package src.com.dcv.feb.day54;

import java.util.Arrays;
import java.util.Vector;


public class Data {
	private Vector<CountryData> countries;

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

	public void csvExportTopCountries() {
		CountryData[] sortedCountries = new CountryData[countries.size()];

		for (int i = 0; i < sortedCountries.length; i++) {
			sortedCountries[i] = countries.get(i);
		}

		Arrays.sort(sortedCountries);

		String[][] exportData = new String[sortedCountries.length][];

		for (int i = 0; i < sortedCountries.length; i++) {
			exportData[i] = sortedCountries[i].getCaseInfo();
		}

		String path = "src/com/dcv/feb/day54/output/covid-toplist.csv";
		String[] head = new String[]{"countryName", "totalCases"};
		CsvWriter.write(path, head, exportData);
	}
}
