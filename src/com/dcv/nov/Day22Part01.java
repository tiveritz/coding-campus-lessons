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
