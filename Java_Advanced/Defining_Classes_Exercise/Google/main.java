package Google;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import Google.Person;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> list = new ArrayList();
        String[] input = scanner.nextLine().split("\\s+");
        while (!input[0].equals("End")) {
            String name = input[0];
            if (!list.stream().anyMatch(e -> e.getName().equals(name)))
                list.add(new Person(name));
            String command = input[1];
            if(command.equals("company"))
            input[input.length - 1] = String.format("%.2f", Double.parseDouble(input[input.length - 1]));
            String rest = "";
            for (int i = 2; i < input.length; i++)
                rest = rest + input[i] + " ";
            switch (command) {
                case "company":
                    list.stream().filter(e -> e.getName().equals(name)).findFirst().get().setCompany(rest);
                    break;
                case "car":
                    list.stream().filter(e -> e.getName().equals(name)).findFirst().get().setCar(rest);
                    break;
                case "pokemon":
                    list.stream().filter(e -> e.getName().equals(name)).findFirst().get().getPokemons().add(rest);
                    break;
                case "parents":
                    list.stream().filter(e -> e.getName().equals(name)).findFirst().get().getParents().add(rest);
                    break;
                case "children":
                    list.stream().filter(e -> e.getName().equals(name)).findFirst().get().getChildren().add(rest);
                    break;
            }
            input = scanner.nextLine().split("\\s+");
        }
        input = scanner.nextLine().split("\\s+");
        String result = input[0];
        System.out.println(list.stream().filter(e -> e.getName().equals(result)).findFirst().get().toString());
    }
}
