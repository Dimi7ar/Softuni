package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class applied_arithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        String input = scanner.nextLine();

        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(n -> n + 1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(n -> n * 2)
                .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(n -> n - 1)
                .collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(e -> System.out.print(e + " "));

        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    listInput = add.apply(listInput);
                    break;
                case "multiply":
                    listInput = multiply.apply(listInput);
                    break;
                case "subtract":
                    listInput = subtract.apply(listInput);
                    break;
                case "print":
                    print.accept(listInput);
                    System.out.println();
                    break;
            }
            input = scanner.nextLine();
        }
    }
}
