package Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class matrix_shuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[rowsAndColumns[0]][rowsAndColumns[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("END")) {
            if(check(input, rowsAndColumns))
            {
                System.out.println("Invalid input!");
            }
            else {
            swapIndexes(matrix, Integer.parseInt(input[1]), Integer.parseInt(input[2]), Integer.parseInt(input[3]), Integer.parseInt(input[4]));
            }
            input = scanner.nextLine().split("\\s+");
        }
        scanner.close();
    }

    public static void swapIndexes(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
        printMultiDimensionalArray(matrix);
    }
    public static boolean check(String[] input, int[] rowsAndColumns)
    {
        if (input.length != 5)
        return true;
        int row1 = Integer.parseInt(input[1]);
        int col1 = Integer.parseInt(input[2]);
        int row2 = Integer.parseInt(input[3]);  
        int col2 = Integer.parseInt(input[4]);
        boolean flag = (!input[0].equals("swap")) || row1 < 0 || row1 > rowsAndColumns[0] || col1 < 0 || col1 > rowsAndColumns[1] || row2 < 0 || row2 > rowsAndColumns[0] || col2 < 0 || col2 > rowsAndColumns[1];
        return flag;    
    }
    public static void printMultiDimensionalArray(String[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < matrix[r].length; c++) {
                sb.append(matrix[r][c]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
