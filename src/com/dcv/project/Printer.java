package src.com.dcv.project;

import java.text.NumberFormat;
import java.util.Locale;


public class Printer {
	private static Locale austria = new Locale("at", "AT");
	private static NumberFormat nf = NumberFormat.getCurrencyInstance(austria);
	
	/** Prints a String to the console with start, currency formatted value and end. Start and end
	  * can be empty Strings.
	  * @param startString start String
	  * @param value value to be formatted as currency
	  * @param endString end String
	  */
	public static void printFormattedCurrency(String startString, int value, String endString) {
		String formatted = nf.format(value);
		
		StringBuilder sb = new StringBuilder();
		sb.append(startString)
		  .append(formatted)
		  .append(endString);
		
		System.out.println(sb);
	}

	/** Prints a String to the console with start, precentage formatted value and end. Start and end
	  * can be empty Strings.
	  * @param startString start String
	  * @param value value to be formatted as percentage.
	  * @param endString end String
	  */
	public static void printFormattedPercentage(String startString, double value, String endString) {
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2); // Set minimum not maximum, cause default minimum = 0
		String formatted = nf.format(value);

		StringBuilder sb = new StringBuilder();
		sb.append(startString)
		  .append(formatted)
		  .append(endString);
		
		System.out.println(sb);
	}

	/** Prints a formatted Table from an array of indexes. Formatting includes header, row numbering
	  * Vertical table lines and currency formatting.
	  * @param indexes array of indexes from the content to be printed
	  * @param content two dimensional array with data
	  * @param header array with the column names
	  */
	public static void printFormattedTable(int[] indexes, String[][] content, String[] header) {
		int count = 1;
		int firstColWidth = Integer.toString(indexes.length).length();
		int secondColWidth = header[0].length();
		int thirdColWidth = header[1].length();
		int fourthColWidth = header[2].length();

		for (int i = 0; i < indexes.length; i++) {
			int row = indexes[i];
			if (content[row][0].length() > secondColWidth) {
				secondColWidth = content[row][0].length();
			}
			if (content[row][1].length() > thirdColWidth) {
				thirdColWidth = content[row][1].length();
			}

			int numberLength = content[row][2].length();
			int formattedNumberLength = 5 + numberLength + numberLength/3; // Consider formatting (€ ,.00)
			if (formattedNumberLength > fourthColWidth) {
				fourthColWidth = formattedNumberLength;
			}
		}

		StringBuilder sb = new StringBuilder();

		sb.append(String.format("%-" + firstColWidth + "s", "")).append("   ");
		sb.append(String.format("%-" + secondColWidth + "s", header[0])).append("   ");
		sb.append(String.format("%-" + thirdColWidth + "s", header[1])).append("   ");
		sb.append(String.format("%" + fourthColWidth + "s", header[2])).append("\n");
		
		for (int index : indexes) {
			int value = Integer.parseInt(content[index][2]);
			sb.append(String.format("%-" + firstColWidth + "s", count)).append(" | ");
			sb.append(String.format("%-" + secondColWidth + "s", content[index][0])).append(" | ");
			sb.append(String.format("%-" + thirdColWidth + "s", content[index][1])).append(" | ");
			sb.append(String.format("%" + fourthColWidth + "s", nf.format(value))).append("\n");		
			count++;
			}
		System.out.println(sb);
	}
}
