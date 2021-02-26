package src.com.dcv.feb.day54;

import java.util.ArrayList;

public class CountryData implements Comparable<CountryData> {
	private String name;
	private int totalCases;
	private int popData;
	private int recordCount;
	private ArrayList<Integer> cases; 

	public CountryData(String name) {
		this.name = name;
		this.totalCases = 0;
		this.popData = 0;
		this.recordCount = 0;
		this.cases = new ArrayList<>();
	}

	// -- SETTER -------------------------------------------------------
	public void addData(DailyCovidDTO dcdto) {
		recordCount++;
		try {
			int dailyCases = Integer.parseInt(dcdto.getCases());
			cases.add(dailyCases);
			totalCases += dailyCases;
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

	public String[] getTotalCasesInfo() {
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

	public String[] getCumulativeCases14Days() {
		// This is only working if original data is sorted and every country has >= 14 entries
		int cumulativeCases = 0;

		for (int i = 0; i < 14; i++) {
			cumulativeCases += cases.get(i);
		}
		return new String[] {name, Integer.toString(cumulativeCases)};
	}

	// -- INTERFACE ----------------------------------------------------
	@Override
	public int compareTo(CountryData other) {
		int compareCases = other.getTotalCases(); 
		return compareCases - totalCases;  
	}
}
