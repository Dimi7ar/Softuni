package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class knights_of_honor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Consumer<String> printName = n -> System.out.println("Sir " + n);
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(printName);
        scanner.close();
    }   
}
