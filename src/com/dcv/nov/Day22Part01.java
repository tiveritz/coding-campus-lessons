package src.com.dcv.nov;

import java.util.Arrays;
import java.util.Map;
import java.util.Vector;
import java.util.stream.Collectors;


public class Day22Part01 {

    /* Attention! 
     * Not entirely my code, some elements have been copied
     * 
     */

    public static void hoursList() {
        String[][] hoursList = getHoursList();
        String[] names = getNames(hoursList);

        int[] hoursSum = calculateHoursSum(names, hoursList);

        int loanPerHour = 8;
        int[] salary = calculateLoan(names, hoursSum, loanPerHour);

        printLoan(names, salary);

        //theLambdaWay(hoursList, loanPerHour);
    }

    public static void printLoan(String[] names, int[] salary) {
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " gets " + salary[i] + "€");
        }
    }

    public static String[] getNames(String[][] arr) {
        Vector<String> names = new Vector<String>();

        for (String[] name : arr) {
            if (!names.contains(name[0])) {
                names.add(name[0]);
            }
        }

        String[] namesArr = new String[names.size()];

        int i = 0;
        for (String name : names) {
            namesArr[i] = name;
            i++;
        }

        return namesArr;
    }

    // Extensiont of Day23
    public static void printAverage(String[] names, int[] hoursSum, String[][] hoursList) {

        int i = 0;
        for (String name : names) {
            int nameDays = 0;
                for (String[] namesRow : hoursList) {
                    if (namesRow[0].equals(name)) {
                        nameDays++;
                    }
                }

            double average = 1.0 * hoursSum[i] / nameDays;
            System.out.println(name + " average hours: " + average);
            i++;
        }
    }  

    public static int[] calculateLoan(String[] names, int[] hoursSum, int loanPerHour) {
        int[] salary = new int[names.length];
        for (int i = 0; i < names.length; i++){
            salary[i] = hoursSum[i] * loanPerHour;
        }
        return salary;
    }

    public static int[] calculateHoursSum(String[] names, String[][] hoursList) {
        int[] hoursSum = new int[names.length];

        int i = 0;
        for (String name : names) {
            for (String[] nameRow : hoursList) {
                if (nameRow[0].equals(name)) {
                    hoursSum[i] += Integer.parseInt(nameRow[1]);
                }
            }
            i++;
        }

        return hoursSum;
    }

    private static String[][] getHoursList() {
        String[][] hourList = {{"Daniel", "7"},
                {"Alex", "9"},
                {"Michael", "8"},
                {"Daniel", "5"},
                {"Daniel", "3"},
                {"Alex", "7"},
                {"Michael", "6"},
                {"Alex", "4"},
                {"Michael", "5"}};
        return hourList;
    }

    public static void theLambdaWay(String[][] hourList, int loanPerHour){
        Map<String, Integer> result = Arrays.stream(hourList)
                .collect(Collectors.toMap(
                        entry -> entry[0],
                        entry -> Integer.parseInt(entry[1]) * loanPerHour,
                        Integer::sum)
                );
        for (var entry:result.entrySet()) {
            System.out.println(entry.getKey() + " bekommt " + entry.getValue() + "€ ausbezahlt.");
        }
    }
}
