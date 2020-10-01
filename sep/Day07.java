package sep;

public class Day07 {
    public static void leapYear() {
        // Output all leap years from 1990 until 2040
        // Rules for leap years:
        // #1 Year number must be divisibly by four
        // #2 Not divisibly by 100
        // #3 End-of-century years must be divisible by 400

        int firstYear = 1800;
        int lastYear = 2100;

        boolean isDivBy4 = false;
        boolean isDivBy100 = false;
        boolean isDivBy400 = false;

        for (int year = firstYear; year <= lastYear; year++) {
            isDivBy4 = false;
            isDivBy100 = false;
            isDivBy400 = false;

            if (year % 4 == 0) {
                isDivBy4 = true;
            }
            if (year % 100 == 0) {
                isDivBy100 = true;
            }
            if (year % 400 == 0) {
                isDivBy400 = true;
            }

            // Check for all conditions and output year
            if (isDivBy4 && (!isDivBy100 || isDivBy400)) {
                System.out.println(year);
            }
        }
    }
}
