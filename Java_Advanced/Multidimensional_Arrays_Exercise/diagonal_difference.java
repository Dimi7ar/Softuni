package Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class diagonal_difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rowsAndColumns = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rowsAndColumns][rowsAndColumns];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(findDifference(matrix));
        scanner.close();
    }

    public static int findDifference(int[][] matrix) {
        int primary = 0;
        int secondary = 0;
        for (int c = 0; c < matrix.length; c++) {
            primary += matrix[c][c];
            secondary += matrix[matrix.length - c - 1][c];
        }
        return Math.abs(primary - secondary);
    }
}
