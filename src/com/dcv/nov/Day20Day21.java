package src.com.dcv.nov;

import java.lang.Math;


public class Day20Day21 {
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
        int lTriangle = 15;
        printCanvas(getTriangleToCanvas(canvas, xCenterTriangle, yCenterTriangle, lTriangle));

        // Print triangle into center of the canvas
        printCanvas(getTriangleToCanvas(canvas, lTriangle));

        // Print circle with defined center coordinates
        int xCenterCircle = 10;
        int yCenterCircle = 10;
        int radius = 10;
        printCanvas(getCircleToCanvas(canvas, xCenterCircle, yCenterCircle, radius));
        
        // Print circle into center of canvas
        printCanvas(getCircleToCanvas(canvas, radius));
    }

  /** Fills a passed two dimensional aray with a given character.
    * Overwrites the passed array. 
    * @param arr The array to be filled
    * @param character The caracter the array is filled with
    */
    private static void fillCanvas(char[][] arr, char character) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[row].length; col++) {
                arr[row][col] = character;
            }
        }
    }

  /** Prints the row - inversed array into the console.
    * @param arr Two dimensional array
    */
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
    
  /** Returns the duplicated two dimensional array
    * @param oldArr Two dimensional array
    * @return The duplicated array
    */
    private static char[][] copyCanvas(char[][] oldArr) {
        char[][] newArr = new char[oldArr.length][oldArr[0].length];
        
        for(int i = 0; i < oldArr.length; i++) {
            for(int j = 0; j < oldArr[i].length; j++) {
                newArr[i][j] = oldArr[i][j];
            }
        }
        return newArr;
    }

  /** Calculates the x and y center of the array and passes them with the
    * original arguments to the overloaded method. 
    * @param arr Two dimensional char[][]
    * @param length Side length of the square
    */
    private static char[][] getSquareToCanvas(char[][] arr, int length) {
        int startRow = arr.length / 2 - length / 2;
        int startCol = arr[0].length / 2 - length / 2;
        return getSquareToCanvas(arr, startRow, startCol, length);
    }

  /** Returns a new two dimensional array with a square
    * @param arr A two dimensional char[][]
    * @param xMin The x starting coordinate of the square
    * @param yMin The y starting coordinate of the square
    * @param length Side length of the square
    * @return A copy of the passed array with the square
    */
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

  /** Passes the same paramters to the overloaded methods along with the 
    * copyArray boolean set to true 
    */
    private static char[][] getLineToCanvas(char[][] arr, int xMin, int yMin, int xMax, int yMax) {
        return(getLineToCanvas(arr, xMin, yMin, xMax, yMax, true));
    }

  /** Returns a two dimensional array with the line
    * @param arr Two dimensional array
    * @param xMin Starting x coordinate of Point 1
    * @param yMin Starting y coordinate of Point 1
    * @param xMax Starting x coordinate of Point 2
    * @param yMax Starting y coordinate of Point 2
    * @param copyArray Boolean that determines wheter to change original array
                       or use a duplicate
    * @return Duplicated or original array with line
    */
    private static char[][] getLineToCanvas(char[][] arr, int xMin, int yMin, int xMax, int yMax, boolean copyArray) {
        /*
         *      y
         *      ^    
         *      |
         * yMax-|       *
         *      |    *
         * yMin-|  *
         *       ---------> x
         *         |     |
         *       xMin  xMax
         *
         * The difficulty here is, that the direction of the line matters for
         * the loop. (xMin can be higher than xMax)
         */
        
        char[][] line = arr;

        if (copyArray) {
            line = copyCanvas(arr);
        }

        double k = 1.0 * (yMax - yMin) / (xMax - xMin);
        double d = 1.0 * yMin - k * xMin;

        // Add points with y(x) = k * x + d
        int loopStartX = Math.min(xMin, xMax);
        int loopEndX = Math.max(xMin, xMax);

        for (int x = loopStartX; x < loopEndX+1; x++) {
            int y = (int)Math.round(k * x + d);
            line[y][x] = '·';
        }

        // Add points with x(y) = (y - d) / k
        
        int loopStartY = Math.min(yMin, yMax);
        int loopEndY = Math.max(yMin, yMax);

        for (int y = loopStartY; y < loopEndY; y++) {
            int x = (int)Math.round(1.0 * (y - d) / k);
            line[y][x] = '·';
        }

        return line;
    }

  /** Calculates the x and y center of the array and passes them with the
    * original arguments to the overloaded method. 
    * @param arr Two dimensional char[][]
    * @param length Side length of the triangle
    */
    private static char[][] getTriangleToCanvas(char[][] arr, int length) {
        int xCenter = arr.length / 2;
        int yCenter = arr[0].length / 2;
        return getTriangleToCanvas(arr, xCenter, yCenter, length);
    }

  /** Returns a two dimensional with the triangle
    * @param arr Two dimensional char[][]
    * @param xCenter Center x coordinate of the triangle
    * @param yCenter Center y coordinate of the triangle
    * @param length Side length of the triangle
    * @return Duplicate of the array with the triangle
    */
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
        
        int P2x = xMin + length-1;
        int P2y = yMin;

        int P1x = (int)Math.round(xMin + length / 2);
        int P1y = (int)Math.round(yMin + height-1);

        getLineToCanvas(triangle, P1x, P1y, P2x, P2y, false);
        getLineToCanvas(triangle, P2x, P2y, P3x, P3y, false);
        getLineToCanvas(triangle, P3x, P3y, P1x, P1y, false);

        return triangle;
    }

  /** Calculates the x and y center of the array and passes them with the
    * original arguments to the overloaded method. 
    * @param arr Two dimensional char[][]
    * @param r Radius of the circle
    */
    private static char[][] getCircleToCanvas(char[][] arr, int r) {
        int xCenter = arr.length / 2;
        int yCenter = arr[0].length / 2;
        return getCircleToCanvas(arr, xCenter, yCenter, r);
    }

  /** Returns a two dimensional array with the circle
      * @param arr Two dimensional char[][]
      * @param xCenter Center x coordinate of the circle
      * @param yCenter Center y coordinate of the circle
      * @param r Radius of the circle
      * @return Duplicate of the array with the circle
      */
    public static char[][] getCircleToCanvas(char[][] arr, int xCenter, int yCenter, int r) {
        /*
         *   y
         *   ^
         *   |    *  * 
         *   |  *      *
         *   |  *      *
         *   |    *  *
         *    -------------> x
         * r... radius
         * a... xCenter
         * b... yCenterTriangle
         * r^2 = (x-a)^2 + (y-b)^2
         * 
         * The difficulty here is to consider that the square root
         * in the circle formular returns + and -
         */

        char[][] circle = copyCanvas(arr);

        // Add the points with y(x) = ±sqrt(r^2 - (x-a)^2) + b
        int loopStartX = xCenter - r;
        int loopEndX = xCenter + r;

        for (int x = loopStartX; x < loopEndX+1; x++) {
            double point = Math.sqrt(Math.pow(r, 2) - Math.pow((x - xCenter),2));

            int yPos = (int)Math.round(point + yCenter);
            int yNeg = (int)Math.round(-point + yCenter);

            circle[yPos][x] = '·';
            circle[yNeg][x] = '·';
        }

        // Add the points with x(y) = ±sqrt(r^2 - (y - b)^2) + a
        int loopStartY = yCenter - r;
        int loopEndY = yCenter + r;

        for (int y = loopStartY; y < loopEndY+1; y++) {
            double point = Math.sqrt(Math.pow(r, 2) - Math.pow((y - yCenter), 2));

            int xPos = (int)Math.round(point + yCenter);
            int xNeg = (int)Math.round(-point + yCenter);

            circle[y][xPos] = '·';
            circle[y][xNeg] = '·';
        }

        return circle;
    }
}
