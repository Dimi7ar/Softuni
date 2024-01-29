package Opinion_Poll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> list = new ArrayList();
        for (int i = 0; i < n; i++)
        {
            String[] input = scanner.nextLine().split("\\s+");
            int age = Integer.parseInt(input[1]);
            if(age > 30)
            {
                list.add(new Person(input[0], age));
            }
        }
        list = list.stream().sorted(Comparator.comparing(Person::getName)).collect(Collectors.toList());
        list.stream().forEach(e -> System.out.println(e.toString()));
    }
}
