package Company_Roster;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        HashMap<String, List<Employee>> map = new HashMap<>();
        Double highestAverage = Double.MIN_VALUE;
        String highestAverageName = "";
        for (int i = 0; i < n; i++) {
            // 0 - name, 1 - salary, 2 - position, 3 - department, 4 - email, 5 - age
            String[] input = scanner.nextLine().split("\\s+");
            String department = input[3];
            map.putIfAbsent(department, new ArrayList<>());
            switch (input.length) {
                case 4:
                    map.get(department).add(new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3]));
                    break;
                case 5:
                    try {
                        map.get(department).add(new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3],
                                Integer.parseInt(input[4])));
                    } catch (Exception e) {
                        map.get(department).add(
                                new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3], input[4]));
                    }
                    break;
                case 6:
                    map.get(department).add(new Employee(input[0], Double.parseDouble(input[1]), input[2], input[3],
                            input[4], Integer.parseInt(input[5])));
                    break;
            }
        }

        for (String department : map.keySet())
        {
            double sum = 0;
            int count = 0;
            for(Employee employee : map.get(department))
            {
                sum += employee.getSalary();
                count++;
            }
            double average = sum / count;
            if (highestAverage < average)
            {
                highestAverage = average;
                highestAverageName = department;
            }
        }
        System.out.println("Highest Average Salary: " + highestAverageName);
        for (Employee employee : map.get(highestAverageName).stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).collect(Collectors.toList()))
        {
            System.out.println(employee.toString());
        }
    }
}
