package Multidimensional_Arrays_Exercise;

import java.util.Arrays;
import java.util.Scanner;

public class maximum_sum_3x3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int[] result = findMaxSubMatrix(matrix);
        StringBuilder sb = new StringBuilder();
        sb.append("Sum = " + result[0]).append("\n");
        sb.append(matrix[result[1]][result[2]] + " " + matrix[result[1]][result[2] + 1] + " " + matrix[result[1]][result[2] + 2]).append("\n");
        sb.append(matrix[result[1] + 1][result[2]] + " " + matrix[result[1] + 1][result[2] + 1] + " " + matrix[result[1] + 1][result[2] + 2]).append("\n");
        sb.append(matrix[result[1] + 2][result[2]] + " " + matrix[result[1] + 2][result[2] + 1] + " " + matrix[result[1] + 2][result[2] + 2]).append("\n");
        System.out.println(sb.toString().trim());
        scanner.close();
    }

    public static int[] findMaxSubMatrix(int[][] matrix) {
        int[] max = new int[3];
        for (int r = 0; r < matrix.length - 2; r++) {
            for (int c = 0; c < matrix[r].length - 2; c++) {
                int submatrix = matrix[r][c] + matrix[r][c + 1] + matrix[r][c + 2]
                        + matrix[r + 1][c] + matrix[r + 1][c + 1] + matrix[r + 1][c + 2]
                        + matrix[r + 2][c] + matrix[r + 2][c + 1] + matrix[r + 2][c + 2];
                if (submatrix > max[0]) {
                    max[0] = submatrix;
                    max[1] = r;
                    max[2] = c;
                }
            }
        }
        return max;
    }
}
