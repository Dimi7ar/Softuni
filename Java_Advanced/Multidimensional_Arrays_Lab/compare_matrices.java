import java.util.Arrays;
import java.util.Scanner;

public class compare_matrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] matrixRowsAndColumn = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrixOne = new int[matrixRowsAndColumn[0]][matrixRowsAndColumn[1]];
        for (int i = 0; i < matrixOne.length; i++) {
            matrixOne[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        matrixRowsAndColumn = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[][] matrixTwo = new int[matrixRowsAndColumn[0]][matrixRowsAndColumn[1]];
        for (int i = 0; i < matrixTwo.length; i++) {
            matrixTwo[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(compare(matrixOne, matrixTwo));
        scanner.close();
    }

    public static boolean compare(int[][] x, int[][] y) {
        if(x.length != y.length)
        return false;
        if(x[0].length != y[0].length)
        return false;
        for(int r = 0; r < x.length; r++)
        {
            for (int c = 0; c < x[r].length; c++)
            {
                if(x[r][c] != y[r][c])
                    return false;
            }
        }
        return true;
    }
}
