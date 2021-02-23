package src.com.dcv.feb.day54;


public class CountryData implements Comparable<CountryData>{
	private String name;
	private int totalCases;
	private int popData;

	public CountryData(String name) {
		this.name = name;
		this.totalCases = 0;
		this.popData = 0;
	}

	// -- SETTER -------------------------------------------------------
	public void addData(DailyCovidDTO dcdto) {
		try {
			totalCases += Integer.parseInt(dcdto.getTotalCases());
			if (popData == 0) {
				popData += Integer.parseInt(dcdto.getPopData());
			}
		} catch (NumberFormatException nfe) {
			System.out.println("An error occured when parsing data");
			nfe.printStackTrace();
		}
	}

	// -- GETTER -------------------------------------------------------
	public String getName() {
		return this.name;
	}

	public int getTotalCases() {
		return totalCases;
	}

	public String[] getCaseInfo() {
		return new String[] {name, Integer.toString(totalCases)};
	}

	// -- INTERFACE ----------------------------------------------------
	@Override
	public int compareTo(CountryData other) {
		int compareCases = other.getTotalCases(); 
		return compareCases - totalCases;  
	}
}
