package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class consumer_print {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printName = n -> System.out.println(n);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printName);
    }   
}
