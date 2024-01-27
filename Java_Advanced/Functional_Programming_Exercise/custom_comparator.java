package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class custom_comparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Comparator<Integer> customComparator = (first, second) -> {
            if (first % 2 == 0 && second % 2 != 0)
            return -1;
            else if (first % 2 != 0 && second % 2 == 0)
            return 1;
            else
            return first.compareTo(second);

        };
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).sorted(customComparator).forEach(e - > System.out.print(e + " "));
        scanner.close();
    }
}
