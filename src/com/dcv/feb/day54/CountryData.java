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

	public String getName() {
		return this.name;
	}

	public void addData(String[] line) {
		try {
			totalCases += Integer.parseInt(line[4]);
			if (popData == 0) {
				popData += Integer.parseInt(line[9]);
			}
		} catch (NumberFormatException nfe) {
			System.out.println("An error occured when parsing data");
			nfe.printStackTrace();
		}
	}

	public int getTotalCases() {
		return totalCases;
	}

	public int compareTo(CountryData other) {
        int compareCases = other.getTotalCases(); 
        return compareCases - totalCases;  
    }

	public String[] getCaseInfo() {
		return new String[] {name, Integer.toString(totalCases)};
	}
}
