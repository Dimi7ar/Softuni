import java.util.Scanner;

public class intersection_of_two_matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        String[][] matrixOne = new String[rows][columns];
        String[][] matrixTwo = new String[rows][columns];
        for (int y = 0; y < 2; y++) {
            for (int i = 0; i < matrixOne.length; i++) {
                if (y == 0)
                    matrixOne[i] = scanner.nextLine().split("\\s+");
                else
                    matrixTwo[i] = scanner.nextLine().split("\\s+");
            }
        }
        String[][] resultMatrix = compare(matrixOne, matrixTwo);
        printMultiDimensionalArray(resultMatrix);
        scanner.close();
    }

    public static String[][] compare(String[][] matrixOne, String[][] matrixTwo) {
        String[][] resultMatrix = new String[matrixOne.length][matrixOne[0].length];
        for (int r = 0; r < matrixOne.length; r++) {
            for (int c = 0; c < matrixOne[r].length; c++) {
                resultMatrix[r][c] = ((matrixOne[r][c].equals(matrixTwo[r][c])) && (matrixOne[r][c] != "*"))
                        ? matrixOne[r][c]
                        : "*";
            }
        }
        return resultMatrix;
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
