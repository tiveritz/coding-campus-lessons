package src.com.dcv.nov;

import java.lang.Math;


public class Day20Part01 {
    public static void canvasShapes() {
        // Prepare canvas
        int height = 28;
        int width = 28;

        char[][] canvas = new char[height][width];
        fillCanvas(canvas, ' ');

        // Print square with defined starting point
        int xMinSquare = 6;
        int yMinSquare = 4;
        int lSquare = 6;
        printCanvas(getSquareToCanvas(canvas, xMinSquare, yMinSquare, lSquare));

        // Print square into the center of the canvas
        printCanvas(getSquareToCanvas(canvas, lSquare));

        // Print line
        int xMinLine = 3;
        int yMinLine = 2;
        int xMaxLine = 15;
        int yMaxLine = 19;
        printCanvas(getLineToCanvas(canvas, xMinLine, yMinLine, xMaxLine, yMaxLine));
        
        // Print triangle with defined center coordinates
        int xCenterTriangle = 8;
        int yCenterTriangle = 6;
        int lTriangle = 14;
        printCanvas(getTriangleToCanvas(canvas, xCenterTriangle, yCenterTriangle, lTriangle));

        // Print triangle into center of the canvas
        printCanvas(getTriangleToCanvas(canvas, lTriangle));
    }

    private static void fillCanvas(char[][] arr, char character) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = character;
            }
        }
    }

    private static void printCanvas(char[][] arr) {
        System.out.println("y");
        System.out.println("↑");
        for (int row = arr.length-1; row >= 0; row--) {
            System.out.print('|');
            for (int col = 0; col < arr[row].length; col++) {
                System.out.print(" " + arr[row][col]);
            }
            System.out.println();
        }
        System.out.println(" " + "-".repeat(arr[0].length * 2) + "→ x" + "\n\n");
    }

    private static char[][] getSquareToCanvas(char[][] arr, int length) {
        int startRow = arr.length / 2 - length / 2;
        int startCol = arr[0].length / 2 - length / 2;
        return getSquareToCanvas(arr, startRow, startCol, length);
    }

    private static char[][] getSquareToCanvas(char[][] arr, int xMin, int yMin, int length) {

        char[][] square = copyCanvas(arr);

        int colMaxIndex = xMin + length;
        int rowMaxIndex = yMin + length;

        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                // boolean tests
                boolean isInRow = row >= yMin && row < rowMaxIndex;
                boolean isInCol = col >= xMin && col < colMaxIndex;

                if (isInRow && isInCol) {
                    square[row][col] = '·';
                }
            }
        }
        return square;
    }
    
        private static char[][] copyCanvas(char[][] oldArr) {
            char[][] newArr = new char[oldArr.length][oldArr[0].length];
            
            for(int i = 0; i < oldArr.length; i++) {
                for(int j = 0; j < oldArr[i].length; j++) {
                    newArr[i][j] = oldArr[i][j];
                }
            }
            return newArr;
        }

    private static char[][] getLineToCanvas(char[][] arr, int xMin, int yMin, int xMax, int yMax) {
        return(getLineToCanvas(arr, xMin, yMin, xMax, yMax, true));
    }

    private static char[][] getLineToCanvas(char[][] arr, int xMin, int yMin, int xMax, int yMax, boolean copyArray) {
        /* linear functions: y(x) = k * x + d
         *
         *      y
         *      ^    
         *      |
         * yMax-|       *
         *      |    *
         * yMin-|  *
         *       ---------> x
         *         |     |
         *       xMin  xMax
         */
        
        char[][] line = arr;

        if (copyArray) {
            line = copyCanvas(arr);
        }

        double k = 1.0 * (yMax - yMin) / (xMax-1 - xMin);
        double d = 1.0 * yMin - k * xMin;

        // Declare loopVariables, because xMin can be higher than xMax depending
        // on the direction of the line
        int loopStart = Math.min(xMin, xMax);
        int loopEnd = Math.max(xMin, xMax);

        for (int x = loopStart; x < loopEnd; x++) {
            int y = (int)Math.round(k * x + d);
            line[y][x] = '·';
        }
        return line;
    }

    private static char[][] getTriangleToCanvas(char[][] arr, int length) {
        int xCenter = arr.length / 2;
        int yCenter = arr[0].length / 2;
        return getTriangleToCanvas(arr, xCenter, yCenter, length);
    }

    private static char[][] getTriangleToCanvas(char[][] arr, int xCenter, int yCenter, int length) {
        char[][] triangle = copyCanvas(arr);

        // Actually a triangle is just 3 lines, so we use the line function for
        // that. Some preparation is needed to get the starting and ending 
        // coordinates for all the lines

        /*
         *   y
         *   ^    
         *   |     P1
         *   |     /\
         *   |    /  \
         *   |P3 ------ P2
         *    ---------> x
         */

        double height = Math.sqrt(Math.pow(length, 2) - Math.pow((length / 2.0), 2));

        int xMin = (int)Math.round(xCenter - length / 2.0);
        int yMin = (int)Math.round(yCenter - height / 2.0);

        int P3x = xMin;
        int P3y = yMin;
        
        int P2x = xMin + length;
        int P2y = yMin;

        int P1x = (int)Math.round(xMin + length / 2);
        int P1y = (int)Math.round(yMin + height);

        getLineToCanvas(triangle, P1x, P1y, P2x, P2y, false);
        getLineToCanvas(triangle, P2x, P2y, P3x, P3y, false);
        getLineToCanvas(triangle, P3x, P3y, P1x, P1y, false);

        return triangle;
    }
}
