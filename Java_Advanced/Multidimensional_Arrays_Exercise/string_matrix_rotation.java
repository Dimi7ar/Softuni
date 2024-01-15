package Multidimensional_Arrays_Exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class string_matrix_rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rotation = Integer.parseInt(scanner.nextLine().replaceAll("[^\\d+]", ""));
        while (rotation > 360) {
            rotation -= 360;
        }
        List<String> list = new ArrayList<String>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            list.add(input);
            input = scanner.nextLine();
        }
        int longestWord = list.stream().map(String::length).max(Integer::compareTo).get();
        Character[][] normalMatrix = fillMatrix(list, longestWord);
        switch (rotation) {
            case 0:
                printMultiDimensionalArray(normalMatrix);
                break;
            case 90:
                printMultiDimensionalArray(rotate90(normalMatrix));
                break;
            case 180:
                printMultiDimensionalArray(rotate180(normalMatrix));
                break;
            case 270:
                printMultiDimensionalArray(rotate270(normalMatrix));
                break;
            case 360:
                printMultiDimensionalArray(normalMatrix);
                break;
        }
        scanner.close();
    }

    public static Character[][] fillMatrix(List<String> list, int longestWord) {
        Character[][] result = new Character[list.size()][longestWord];
        for (int r = 0; r < list.size(); r++) {
            String currentWord = list.get(r);
            int currentWordLength = currentWord.length();
            for (int c = 0; c < longestWord; c++) {
                if (c >= currentWordLength)
                    result[r][c] = ' ';
                else
                    result[r][c] = currentWord.charAt(c);
            }
        }
        return result;
    }

    public static Character[][] rotate90(Character[][] matrix) {
        Character[][] result = new Character[matrix[0].length][matrix.length];
        for (int r = 0; r < matrix[0].length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                result[r][c] = matrix[matrix.length - c - 1][r];
            }
        }

        return result;
    }

    public static Character[][] rotate180(Character[][] matrix) {
        Character[][] result = new Character[matrix.length][matrix[0].length];
        for (int r = 0; r < matrix.length; r++) {
            Character[] currentWord = matrix[matrix.length - r - 1];
            for (int c = 0; c < matrix[0].length; c++) {
                result[r][c] = currentWord[currentWord.length - c - 1];
            }
        }

        return result;
    }

    public static Character[][] rotate270(Character[][] matrix) {
        Character[][] result = new Character[matrix[0].length][matrix.length];
        for (int r = 0; r < matrix[0].length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                result[r][c] = matrix[c][matrix[0].length - r - 1];
            }
        }

        return result;
    }

    public static void printMultiDimensionalArray(Character[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < matrix[r].length; c++) {
                sb.append(matrix[r][c]);
            }
            System.out.println(sb.toString());
        }
    }
}
