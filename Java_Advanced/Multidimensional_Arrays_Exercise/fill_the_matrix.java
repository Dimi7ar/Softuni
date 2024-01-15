package Multidimensional_Arrays_Exercise;

import java.util.Scanner;

public class fill_the_matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        int rowsAndColumns = Integer.parseInt(input[0]);
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];
        fillMatrix(matrix, input[1]);
        printMultiDimensionalArray(matrix);
        scanner.close();
    }

    public static void fillMatrix(int[][] matrix, String pattern) {
        int count = 1;
        boolean flag = true;
        for (int c = 0; c < matrix.length; c++) {
            if (pattern.equals("A") || flag) {
                for (int r = 0; r < matrix.length; r++) {
                    matrix[r][c] = count;
                    count++;

                }
                flag = false;
            } else {
                for (int r = matrix.length - 1; r > -1; r--) {
                    matrix[r][c] = count;
                    count++;
                }
                flag = true;
            }
        }

    }
    public static void printMultiDimensionalArray(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < matrix[r].length; c++) {
                sb.append(matrix[r][c]).append(" ");
            }
            System.out.println(sb.toString().trim());
        }
    }
}
