package src.com.own.oct;

public class Code02 {
    public static void calendar() {
        int daysInMonth = 31;
        int startDay = 2;
        
        // Prepare the actual starDay Index and the required amount of rows
        int startDayIndex = startDay - 1;
        int amountOfRows = (int)Math.ceil((daysInMonth + startDayIndex) / 7.0);
        
        // Initialize two dimensional array
        int[][] calendar = new int[amountOfRows][7];
        
        // Create and print the header
        System.out.println("| MO | DI | MI | DO | FR | SA | SO |\n------------------------------------");
        
        // Fill the array with values
        for (int row = 0; row < calendar.length; row++) {
            if (row == 0) {
                calendarRow(row, startDayIndex, 1, 7-startDayIndex, calendar);
            } else {
                int start = row * 7 + 1 - startDayIndex;
                calendarRow(row, 0, start, daysInMonth, calendar);
            }
        }
    
        // Print calendar
        for (int row = 0; row < calendar.length; row++) {
            
            System.out.print("| ");
            for (int col = 0; col < calendar[row].length; col++) {
                if (calendar[row][col] == 0) {
                    System.out.print("   | ");
                } else if (calendar[row][col] < 10) {
                    System.out.print(calendar[row][col] + "  | ");
                } else {
                    System.out.print(calendar[row][col] + " | ");
                }
            }
            System.out.println();
        }
    }
    
    public static void calendarRow(int row, int startIndex, int day,
                                   int endDay, int[][] arr) {
                                       
        for (int i = startIndex; i < arr[row].length; i++) {
            if (day <= endDay) {
                arr[row][i] = day;
                day += 1;
            } else {
                break;
            }
        }
    }
}
