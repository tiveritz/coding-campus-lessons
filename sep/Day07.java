public class Day07 {
    public static void leapYear() {
        // Output all leap years from 1990 until 2040
        // Rules for leap years:
        // #1 Year number must be divisibly by four
        // #2 Not divisibly by 100
        // #3 End-of-centory years must be divisible by 400

        int firstYear = 1800;
        int lastYear = 2100;

        boolean isDivFour = false;
        boolean isDivHundr = false;
        boolean isDivFourhundr = false;

        for (int year = firstYear; year <= lastYear; year++) {
            isDivFour = false;
            isDivHundr = false;
            isDivFourhundr = false;

            if (year % 4 == 0) {
                isDivFour = true;
            }
            if (year % 100 == 0) {
                isDivHundr = true;
            }
            if (year % 400 == 0) {
                isDivFourhundr = true;
            }

            // Check for all conditions and output year
            if ((isDivFour && !isDivHundr) || isDivFourhundr) {
                System.out.println(year);
            }
        }
    }
}
