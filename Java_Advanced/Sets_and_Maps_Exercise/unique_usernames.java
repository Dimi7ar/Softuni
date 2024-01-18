package Sets_and_Maps_Exercise;

import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.Scanner;

public class unique_usernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashSet<String> map = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) 
            map.add(scanner.nextLine());
        Arrays.stream(map.toArray()).forEach(System.out::println);
        scanner.close();
    }
}
