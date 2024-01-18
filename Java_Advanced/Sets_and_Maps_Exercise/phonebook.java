package Sets_and_Maps_Exercise;

import java.util.HashMap;
import java.util.Scanner;

public class phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, String> map = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] temp = input.split("-");
            map.put(temp[0], temp[1]);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")) {
            if (map.containsKey(input))
                System.out.printf("%s -> %s%n", input, map.get(input));
            else
                System.out.printf("Contact %s does not exist.%n", input);
            input = scanner.nextLine();
        }
        scanner.close();
    }
}
