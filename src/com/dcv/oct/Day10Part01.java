package src.com.dcv.oct;

public class Day10Part01 {
    // gib das pascal'sche dreieck aus
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1 4 6 4 1
    // 1 5 10 10 5 1
    public static void pascal(int rows) {

        for (int row = 1; row <= rows + 1; row++) {
            for (int col = 1; col <= row; col++) {
                int res = pascalCalc(row, col);
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

    public static int pascalCalc(int row, int col) {
        if (col == 1 || col == row) {
            return 1;
        }
        return pascalCalc(row - 1, col - 1) + pascalCalc(row - 1, col);
    }

    // Zusatzaufgabe: bau ein caching ein, um die codeausführungen zu beschleunigen

    public static void pascalWithCaching(int rows) {

        long[][] cache = new long[rows][rows];

        for (int row = 1; row <= rows; row++) {
            for (int col = 1; col <= row; col++) {
                long res = pascalCalcCaching(row, col, cache);
                System.out.print(res + " ");
            }
            System.out.println();
        }
    }

    public static long pascalCalcCaching(int row, int col, long[][] cache) {
        if (cache[row - 1][col - 1] != 0) {
            return cache[row - 1][col - 1];
        }
        if (col == 1 || col == row) {
            return 1;
        }
        long res = pascalCalcCaching(row - 1, col - 1, cache) + pascalCalcCaching(row - 1, col, cache);
        cache[row - 1][col - 1] = res;
        return res;
    }
}