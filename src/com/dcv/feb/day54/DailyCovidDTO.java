package src.com.dcv.feb.day54;

public class DailyCovidDTO {
	private String countryName;
	private String totalCases;

	public DailyCovidDTO(String[] csvLine) {
		this.totalCases = csvLine[4];
		this.countryName = csvLine[6];
	}

	// -- GETTER -------------------------------------------------------
	public String getCountryName() {
		return countryName;
	}

	public String getTotalCases() {
		return totalCases;
	}
}
