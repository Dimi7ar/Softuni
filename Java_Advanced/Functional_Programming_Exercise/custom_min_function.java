package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class custom_min_function {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Function<Integer[], Integer> func = n -> Arrays.stream(n).min(Integer :: compareTo).get();
        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new);
        System.out.println(func.apply(numbers));
        scanner.close();
    }   
}
