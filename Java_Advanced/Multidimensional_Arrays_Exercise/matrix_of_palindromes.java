package Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class matrix_of_palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[][] matrix = new String[input[0]][input[1]];
        fillMatrix(matrix);
        printMultiDimensionalArray(matrix);
        scanner.close();
    }

    public static void fillMatrix(String[][] matrix) {
        int token = 97;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++)
            {
                matrix[r][c] = "" + (char)(token + r) + (char)(token + r + c) + (char)(token + r);
            }
        }

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
