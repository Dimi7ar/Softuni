import java.util.Arrays;
import java.util.Scanner;

public class maximum_sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(rowsAndColumns[0]);
        System.out.println(rowsAndColumns[1]);
        System.out.println(sumMatrix(matrix));
        scanner.close();
    }

    public static int sumMatrix(int[][] matrix) {
        int result = 0;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                result += matrix[r][c];
            }
        }
        return result;
    }
}
