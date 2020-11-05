package src.com.dcv.nov;

import java.lang.Math;


public class Day20Part01 {
    public static void twoDimensionalArray() {
        int height = 20;
        int width = 20;

        char[][] myArray = new char[height][width];

        fillTwoDimensionalArray(myArray, ' ');

        /* Print square:
         * starting point (coordinates -> Row / Col)
         * size (sideLength)
         */

        /* Print triangle:
         * -> to be printed in the middle!
         * only a sideLength is required
         */

        int squareRow = 5;
        int squareCol = 5;
        int sideLength = 6;

        char[][] square = getSquare(myArray, squareRow, squareCol, sideLength);
        printTwoDimensionalArray(square);
        System.out.println("--------------------");

        // int triangleLength = 7;
        // char[][] triangle = getTriangle(myArray, triangleLength);
        // printTwoDimensionalArray(triangle);

        int lineStartRow = 2;
        int lineStartCol = 3;
        int lineEndRow = 10;
        int lineEndCol = 12;

        char[][] line = getLine(myArray, lineStartRow, lineStartCol, lineEndRow, lineEndCol);
        printTwoDimensionalArray(line);
        System.out.println("--------------------");

    }

    public static void fillTwoDimensionalArray(char[][] arr, char character) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = character;
            }
        }
    }

    public static void printTwoDimensionalArray(char[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(arr[row][col]);
            }
            System.out.println();
        }
    }

    public static void addToArray(char[][]arr, int rowIndex, int colIndex, char character) {
        arr[rowIndex][colIndex] = character;
    }

    public static char[][] getSquare(char[][] arr, int startRow, int startCol, int length) {

        char[][] square = copyTwoDimensionalArray(arr);

        int rowMaxIndex = startRow + length;
        int colMaxIndex = startCol + length;

        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                // boolean tests
                boolean isInRow = row > startRow && row < rowMaxIndex;
                boolean isInCol = col > startCol && col < colMaxIndex;

                if (isInRow && isInCol) {
                    square[row][col] = '·';
                }
            }
        }
        return square;
    }

    public static char[][] getLine(char[][] arr, int intLineStartRow, int intLineStartCol, int intLineEndRow, int intLineEndCol) {
        double lineStartRow = intLineStartRow;
        double lineStartCol = intLineStartCol;
        double lineEndRow = intLineEndRow;
        double lineEndCol = intLineEndCol;

        char[][] line = copyTwoDimensionalArray(arr);
        // linear functions: y(x) = k * x + d
        // take care: function coordinate system and console coordinate system
        // have their y inverted

        double k = (lineEndRow - lineStartRow) / (lineEndCol - lineStartCol);
        //System.out.println(k);

        double d = lineStartRow - k * lineStartCol;
        //System.out.println(d);

        for (int row = 0; row < line.length; row++) {
            for (int col = 0; col < line[row].length; col++) {
                int inRow = (int)Math.round(k * col + d);
                int inCol = (int)Math.round((row - d) / k);
                if (
                    row == inRow && col == inCol &&
                    row >= lineStartRow && row <= lineEndRow &&
                    col >= lineStartCol && col <= lineEndCol
                    ) {
                    line[row][col] = '·';
                }
            }
        }

        return line;
    }

    
    public static char[][] copyTwoDimensionalArray(char[][] oldArr) {
        char[][] newArr = new char[oldArr.length][oldArr[0].length];
        
        for(int i = 0; i < oldArr.length; i++) {
            for(int j = 0; j < oldArr[i].length; j++) {
                newArr[i][j] = oldArr[i][j];
            }
        }
        return newArr;
    }
}

/* failed triangle approach
public static char[][] getTriangle(char[][] arr, int length) {

    char[][] triangle = copyTwoDimensionalArray(arr);
    double innerRadius = (1.0/6.0) * Math.sqrt(3) * length;
    System.out.println(innerRadius);

    int p1Row = 2;
    int p1Col = 5;
    int p2Row = 10;
    int p2Col = 10;
    int p3Row = 10;
    int p3Col = 2;

    int toCheckRow = 5;
    int toCheckCol = 5;

    float alpha = ((p2Col - p3Col)*(toCheckRow - p3Row) + (p3Row - p2Row)*(toCheckCol - p3Col)) /
        ((p2Col - p3Col)*(p1Row - p3Row) + (p3Row - p2Row)*(p1Col - p3Col));
    float beta = ((p3Col - p1Col)*(toCheckRow - p3Row) + (p1Row - p3Row)*(toCheckCol - p3Col)) /
        ((p2Col - p3Col)*(p1Row - p3Row) + (p3Row - p2Row)*(p1Col - p3Col));
    float gamma = 1.0f - alpha - beta;

    if (alpha > 0 && beta > 0 && gamma > 0) {
        System.out.println("it is inside");
    } else {
        System.out.println("it is not inside");
    }


    for (int row = 0; row < triangle.length; row++) {
        for (int col = 0; col < triangle[row].length; col++) {
            // boolean tests
            boolean isInTriangleRow = false;
            boolean isInTriangleCol = false;

            if (isInTriangleRow && isInTriangleCol) {
                triangle[row][col] = '·';
            }
        }
    }

    return triangle;
}
*/