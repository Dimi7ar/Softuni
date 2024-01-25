package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class reverse_and_exclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> isDivisible = number -> number % n == 0;
        Collections.reverse(listInput);
        listInput.removeIf(isDivisible);
        listInput.stream().forEach(e -> System.out.print(e + " "));
        scanner.close();
    }
}
