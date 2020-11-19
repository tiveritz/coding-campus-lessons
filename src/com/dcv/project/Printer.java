package src.com.dcv.project;

import java.text.NumberFormat;
import java.util.Currency;

public class Printer {
	public static void printFormattedCurrency(String startString, int value, String endString) {
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		Currency currency = Currency.getInstance("EUR");
		nf.setCurrency(currency);

		String formatted = nf.format(value);
		
		StringBuilder sb = new StringBuilder();
		sb.append(startString)
		  .append(formatted)
		  .append(endString);
		
		System.out.println(sb);
	}

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

	public static void printFormattedTable(int[] indexes, String[][] content) {
		int count = 1;
		int firstColWidth = Integer.toString(indexes.length).length();
		int secondColWidth = 0;
		int thirdColWidth = 0;
		int fourthColWidth = 0;

		for (int i = 0; i < indexes.length; i++) {
			int row = indexes[i];
			if (content[row][0].length() > secondColWidth) {
				secondColWidth = content[row][0].length();
			}
			if (content[row][1].length() > thirdColWidth) {
				thirdColWidth = content[row][1].length();
			}

			int numberLength = content[row][2].length();
			int formattedNumberLength = 5 + numberLength + numberLength/3; //€_00.000.000,00
			if (formattedNumberLength > fourthColWidth) {
				fourthColWidth = formattedNumberLength;
			}
		}

		StringBuilder sb = new StringBuilder();
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		Currency currency = Currency.getInstance("EUR");
		nf.setCurrency(currency);
		
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
