import java.util.Arrays;
import java.util.Scanner;

public class positions_of {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixRowsAndColumn = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt)
                .toArray();
        int[][] matrix = new int[matrixRowsAndColumn[0]][matrixRowsAndColumn[1]];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        int numberToFind = Integer.parseInt(scanner.nextLine());
        findNumbers(matrix, numberToFind);
        scanner.close();
    }

    public static void findNumbers(int[][] matrix, int number) {
        boolean flag = true;
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[r].length; c++) {
                if (matrix[r][c] == number) {
                    System.out.println(r + " " + c);
                    flag = false;
                }
            }
        }

        if (flag)
            System.out.println("not found");
    }
}
