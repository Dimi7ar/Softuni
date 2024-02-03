package Family_Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Person target = new Person(scanner.nextLine());
        List<Person> list = new ArrayList<>();
        list.add(target);
        String[] input = scanner.nextLine().split("\\s+");

        // filling people's data
        while (!input[0].equals("End")) {
            int command = checkCommand(input);
            addPerson(command, list, input);
            input = scanner.nextLine().split("\\s+");
        }

        String targetName = target.getName();
        String targetBirth = target.getBirth();

        // get parents
        for (Person person : list) {
            if (!target.getParents().contains(person)) {
                for (Person child : person.getChildren()) {
                    if (child.getName().equals(targetName) || child.getBirth().equals(targetBirth)) {
                        target.getParents().add(person);
                    }
                }
            }
        }

        // get children
        for (Person person : list) {
            if (!target.getChildren().contains(person)) {
                for (Person parent : person.getParents()) {
                    if (parent.getName().equals(targetName) || parent.getBirth().equals(targetBirth)) {
                        target.getChildren().add(person);
                    }
                }
            }
        }

        System.out.println(target.toString());
    }

    public static void addPerson(int command, List<Person> list, String[] input) {
        switch (command) {
            case 1:
                String caseOneFirstPersonName = input[0] + " " + input[1];

                break;
            case 2:
                Person firstPersonCaseTwo = new Person(input[0] + " " + input[1]);
                Person secondPersonCaseTwo = new Person(input[3]);
                if (!list.stream().anyMatch(e -> e.getName().equals(firstPersonCaseTwo.getName())))
                    list.add(firstPersonCaseTwo);
                if (!list.stream().anyMatch(e -> e.getBirth().equals(secondPersonCaseTwo.getBirth())))
                    list.add(secondPersonCaseTwo);
                firstPersonCaseTwo.getChildren().add(secondPersonCaseTwo);
                secondPersonCaseTwo.getParents().add(firstPersonCaseTwo);
                break;
            case 3:
                Person firstPersonCaseThree = new Person(input[0]);
                Person secondPersonCaseThree = new Person(input[2] + " " + input[3]);
                if (!list.stream().anyMatch(e -> e.getBirth().equals(firstPersonCaseThree.getBirth())))
                    list.add(firstPersonCaseThree);
                if (!list.stream().anyMatch(e -> e.getName().equals(secondPersonCaseThree.getName())))
                    list.add(secondPersonCaseThree);
                firstPersonCaseThree.getChildren().add(secondPersonCaseThree);
                secondPersonCaseThree.getParents().add(firstPersonCaseThree);
                break;
            case 4:
                Person firstPersonCaseFour = new Person(input[0]);
                Person secondPersonCaseFour = new Person(input[2]);
                if (!list.stream().anyMatch(e -> e.getBirth().equals(firstPersonCaseFour.getBirth())))
                    list.add(firstPersonCaseFour);
                if (!list.stream().anyMatch(e -> e.getBirth().equals(secondPersonCaseFour.getBirth())))
                    list.add(secondPersonCaseFour);
                firstPersonCaseFour.getChildren().add(secondPersonCaseFour);
                secondPersonCaseFour.getParents().add(firstPersonCaseFour);
                break;
            case 5:
                String name = input[0] + " " + input[1];
                String birth = input[2];
                boolean foundName = list.stream().anyMatch(e -> e.getName().equals(name));
                boolean foundBirth = list.stream().anyMatch(e -> e.getBirth().equals(birth));
                if (foundName) {
                    list.stream().filter(e -> e.getName().equals(name)).findFirst().get().setBirth(birth);
                } else if (foundBirth) {
                    list.stream().filter(e -> e.getBirth().equals(birth)).findFirst().get().setName(name);
                } else {
                    list.add(new Person(name, birth));
                }
                break;

            default:
                break;
        }
    }

    public static int checkCommand(String[] input) {
        int inputLength = input.length;
        switch (inputLength) {
            case 5:
                return 1;
            case 4:
                if (input[2].equals("-"))
                    return 2;
                return 3;
            case 3:
                if (input[1].equals("-"))
                    return 4;
                return 5;
            default:
                return 6;
        }
    }
}
