package src.com.dcv.feb.day54;

public class DailyCovidDTO {
	private String countryName;
	private String cases;
	private String popData;

	public DailyCovidDTO(String[] csvLine) {
		this.cases = csvLine[4];
		this.countryName = csvLine[6];
		this.popData = csvLine[9];
	}

	// -- GETTER -------------------------------------------------------
	public String getCountryName() {
		return countryName;
	}

	public String getCases() {
		return cases;
	}

	public String getPopData() {
		return popData;
	}
}
