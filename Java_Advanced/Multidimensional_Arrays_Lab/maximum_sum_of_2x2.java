import java.util.Arrays;
import java.util.Scanner;

public class maximum_sum_of_2x2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] rowsAndColumns = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[][] matrix = new int[rowsAndColumns[0]][rowsAndColumns[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }
        int[] result = findSubMatrix(matrix);
        StringBuilder sb = new StringBuilder();
        sb.append(matrix[result[1]][result[2]] + " " + matrix[result[1]][result[2] + 1]).append("\n");
        sb.append(matrix[result[1] + 1][result[2]] + " " + matrix[result[1] + 1][result[2] + 1]).append("\n");
        sb.append(result[0]);
        System.out.println(sb.toString().trim());
        scanner.close();
    }

    public static int[] findSubMatrix(int[][] matrix) {
        int[] max = new int[3];
        for (int r = 0; r < matrix.length - 1; r++) {
            for (int c = 0; c < matrix[r].length - 1; c++) {
                int submatrix = matrix[r][c] + matrix[r + 1][c] + matrix[r][c + 1] + matrix[r + 1][c + 1];
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
