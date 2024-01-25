package Sets_and_Maps_Exercise;

import java.util.TreeSet;
import java.util.Arrays;
import java.util.Scanner;

public class periodic_table {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeSet<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++)
            Arrays.stream(scanner.nextLine().split("\\s+")).forEach(set::add);
            Arrays.stream(set.toArray()).forEach(elem -> System.out.printf("%s ", elem));
            scanner.close();
    }
}
