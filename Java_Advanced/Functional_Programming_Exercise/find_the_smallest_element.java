package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class find_the_smallest_element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> listInput = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt)
                .collect(Collectors.toList());
        Function<List<Integer>, Integer> findIndex = list -> list.indexOf(list.stream().min(Integer::compareTo).get());
        System.out.println(findIndex.apply(listInput));
        scanner.close();
    }
}
