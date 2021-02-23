package src.com.dcv.feb.day54;

import java.io.FileWriter;
import java.io.IOException;
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

	public void getTopCountries() {
		CountryData[] sortedCountries = new CountryData[countries.size()];

		for (int i = 0; i < sortedCountries.length; i++) {
			sortedCountries[i] = countries.get(i);
		}

		Arrays.sort(sortedCountries);

		try {
			FileWriter topCountriesFile = new FileWriter("src/com/dcv/feb/day54/output/covid-toplist.csv", true);
			topCountriesFile.write("countryName,totalCases\n");
			for (CountryData countryData : sortedCountries) {
				String countryName = countryData.getCaseInfo()[0];
				String totalCases = countryData.getCaseInfo()[1];
				topCountriesFile.write(countryName + "," + totalCases + "\n");
			}
			topCountriesFile.close();
		} catch (IOException ioe) {
			System.out.println("IOException");
			ioe.printStackTrace();
		}

	}

}
