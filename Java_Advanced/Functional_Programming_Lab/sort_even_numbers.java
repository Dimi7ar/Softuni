package Functional_Programming_Lab;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class sort_even_numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(", ")).map(Integer::parseInt).filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(numbers.toString().replaceAll("\\[|]", ""));
        Collections.sort(numbers);
        System.out.println(numbers.toString().replaceAll("\\[|]", ""));
    }   
}
