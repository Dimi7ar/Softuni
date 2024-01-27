package Functional_Programming_Exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class predicate_party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Predicate<String> predicate;
        List<String> list = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("Party!")) {
            String command = input[0];
            String option = input[1];
            String param = input[2];
            switch (option) {
                case "StartsWith":
                    predicate = name -> name.startsWith(param);
                    break;
                case "EndsWith":
                    predicate = name -> name.endsWith(param);
                    break;
                default:
                    predicate = name -> name.length() == Integer.parseInt(param);
                    break;
            }
            if (command.equals("Remove")) {
                list.removeIf(predicate);
            } else if (command.equals("Double")) {
                List<String> doubleList = list.stream().filter(predicate).collect(Collectors.toList());
                list.addAll(doubleList);
            }
            input = scanner.nextLine().split("\\s+");
        }
        if (list.isEmpty())
            System.out.println("Nobody is going to the party!");
        else
            System.out.print(list.stream().sorted().collect(Collectors.joining(", ")) + " are going to the party!");

        scanner.close();
    }
}
