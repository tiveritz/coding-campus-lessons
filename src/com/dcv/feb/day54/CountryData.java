package src.com.dcv.feb.day54;


public class CountryData implements Comparable<CountryData>{
	private String name;
	private int totalCases;
	private int popData;
	private int recordCount;

	public CountryData(String name) {
		this.name = name;
		this.totalCases = 0;
		this.popData = 0;
		this.recordCount = 0;
	}

	// -- SETTER -------------------------------------------------------
	public void addData(DailyCovidDTO dcdto) {
		recordCount++;
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

	public int getAverageCasesPer100k() {
		double averageCasesPer100 = (totalCases / recordCount) / (popData / 100000.0);
		return (int) Math.round(averageCasesPer100);
	}

	public String[] getAverageCasesPer100kInfo() {
		double averageCasesPer100 = (totalCases / recordCount) / (popData / 100000.0);
		return new String[] {name, Long.toString(Math.round(averageCasesPer100))};
	}

	// -- INTERFACE ----------------------------------------------------
	@Override
	public int compareTo(CountryData other) {
		int compareCases = other.getTotalCases(); 
		return compareCases - totalCases;  
	}
}
