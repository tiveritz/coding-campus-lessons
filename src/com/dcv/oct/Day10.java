package src.com.dcv.oct;

public class Day10 {
    public static void pascal(int rows) {

        for (int row = 1; row <= rows+1; row++) {
            for (int col = 1; col <= row; col++ ) {
                int res = pascalCalc(row, col);
                System.out.print(res + " ");
            }
        System.out.println();
        }
    }

    public static int pascalCalc(int row, int col) {
        if (col == 1 || col == row) {
            return 1;
        } else {
            int res = pascalCalc(row-1, col-1) + pascalCalc(row-1, col);
            return res;
        }
    }
}