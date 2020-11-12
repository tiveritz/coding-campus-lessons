package src.com.dcv.nov;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;


public class Day22Part01 {

    /* Achtung! 
     * Nicht mein Code -> kopiert von Discord Gruppe
     * 
     */

    public static void hoursList() {
        String[][] hourList = getHoursList();

        int[] hoursSum = calculateHoursSum(hourList);

        int loanPerHour = 8;
        int[] salary = calculateLoan(hoursSum, loanPerHour);

        printLoan(salary);

        //theLambdaWay(hourList, loanPerHour);
    }

    public static void printLoan(int[] salary) {
        System.out.println("Alex bekommt " + salary[0] + "€ ausbezahlt.");
        System.out.println("Daniel bekommt " + salary[1] + "€ ausbezahlt.");
        System.out.println("Michael bekommt " + salary[2] + "€ ausbezahlt.");
    }

    // Extensiont of Day23
    public static void printAverage(String[][] hoursList, int[] hoursSum) {
        int daysAlex = 0;
        int daysDaniel = 0;
        int daysMichael = 0;

        for(String[] day : hoursList){
            String name = day[0];
            switch(name) {
                case "Alex":
                    daysAlex++;
                    break;
                case "Daniel":
                    daysDaniel++;
                    break;
                case "Michael":
                    daysMichael++;
                    break;
            }
        }
        
        double averageAlex = 1.0 * hoursSum[0] / daysAlex;
        double averageDaniel = 1.0 * hoursSum[1] / daysDaniel;
        double averageMichael = 1.0 * hoursSum[2] / daysMichael;
        System.out.println("Alex average hours: " + averageAlex);
        System.out.println("Daniel average hours: " + averageDaniel);
        System.out.println("Michael average hours: " + averageMichael);
    }  

    public static int[] calculateLoan(int[] hoursSum, int loanPerHour) {
        int[] salary = new int[3];
        for (int i = 0; i < hoursSum.length; i++){
            salary[i] = hoursSum[i] * loanPerHour;
        }
        return salary;
    }

    public static int[] calculateHoursSum(String[][] hourList) {
        int[] hoursSum = new int[3];
        for(String[] entry : hourList){
            String name = entry[0];
            int hoursSumIndex = 0;
            switch(name){
                case "Alex":
                    hoursSumIndex = 0;
                    break;
                case "Daniel":
                    hoursSumIndex = 1;
                    break;
                case "Michael":
                    hoursSumIndex = 2;
                    break;
            }
            hoursSum[hoursSumIndex] = hoursSum[hoursSumIndex] + Integer.parseInt(entry[1]);
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
