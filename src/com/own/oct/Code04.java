package src.com.own.oct;


public class Code04 {
    public static void graph() {
        /* Write a program that takes an array with data and displays a graph
         * (dots) in the console. Make the height adjustable (automatically 
         * fit the data to the given height). Also implement x and z labelling
         */

        int[] data = {1, 2, 4, 5, 6, 7, 9, 9, 8, 7, 8, 6, 6, 4, 3, 5, 7, 8, 9, 9, 8, 7, 5, 4, 3, 3, 2, 2, 2};
        
        String[][] visu = prepareVisualisation(data);
        printVisualisation(visu);

    }

    public static String[][] prepareVisualisation(int[] data) {
        int maxDataHeight = javaIsUnnecessarilyComplicated(data);
        int height = maxDataHeight + 1; // This can be adjusted
        int width = data.length;

        String[][] visu = new String[height + 1][width + 1];
        
        for (int row = 0; row < visu.length; row++) {
            for (int col = 0; col < visu[row].length; col++) {
                visu[row][col] = "";
            }
        }

        for (int col = 0; col < width; col++) {
            int dataHeight = data[col] * height / maxDataHeight;
            visu[dataHeight][col + 1] = "·";
        }

        for (int row = 0; row < visu.length; row++) {
            if (row == 0) {
                for (int col = 0; col <= width; col++) {
                    visu[0][col] = Integer.toString(col);
                }
            } else {
                int yLabel = maxDataHeight * (row + 1) / (height + 1);
                visu[row][0] = Integer.toString(yLabel);
            }
        }

        return visu;
    }

    public static void printVisualisation(String[][] visu) {
        int row = visu.length - 1;
        System.out.println("\n");
        
        while (row >= 0) {
            for (int col = 0; col < visu[row].length; col++) {
                System.out.print(String.format("%3s", visu[row][col]));
            }
            row--;
            System.out.println();
        }
        System.out.println("\n");
    }

    public static int javaIsUnnecessarilyComplicated(int[] arr){
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
          if (arr[i] > max) {
            max = arr[i];
          }
        }
        return max;
    }
}
