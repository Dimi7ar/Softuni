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
        boolean flag = true;

        // combine data
        while (flag) {
            boolean internalFlag = false;
            for (Person person : list) {
                for (Person secondPerson : list) {
                    if (!person.equals(secondPerson)) {
                        if ((person.getName().equals(secondPerson.getName()) && !person.getName().isBlank())
                                || (person.getBirth().equals(secondPerson.getBirth()) && !person.getBirth().isBlank())) {
                            if (!secondPerson.getName().isBlank())
                                person.setName(secondPerson.getName());
                            if (!secondPerson.getBirth().isBlank())
                                person.setBirth(secondPerson.getBirth());
                            person.getParents().addAll(secondPerson.getParents());
                            person.getChildren().addAll(secondPerson.getChildren());
                            list.remove(secondPerson);
                            internalFlag = true;
                            break;
                        }
                    }
                }
                if(internalFlag)
                break;
            }
            if(!internalFlag)
            flag = false;
        }

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
        String firstPersonArgs, secondPersonArgs;
        boolean containsFirst, containsSecond;

        switch (command) {
            case 1:
                firstPersonArgs = input[0] + " " + input[1];
                secondPersonArgs = input[3] + " " + input[4];
                containsFirst = list.stream().anyMatch(e -> e.getName().equals(firstPersonArgs));
                containsSecond = list.stream().anyMatch(e -> e.getName().equals(secondPersonArgs));
                if (!containsFirst)
                    list.add(new Person(firstPersonArgs));
                if (!containsSecond)
                    list.add(new Person(secondPersonArgs));

                Person firstPersonCaseOne = list.stream().filter(e -> e.getName().equals(firstPersonArgs))
                        .findFirst().get();
                Person secondPersonCaseOne = list.stream().filter(e -> e.getName().equals(secondPersonArgs))
                        .findFirst().get();

                firstPersonCaseOne.getChildren().add(secondPersonCaseOne);
                secondPersonCaseOne.getParents().add(firstPersonCaseOne);
                break;
            case 2:
                firstPersonArgs = input[0] + " " + input[1];
                secondPersonArgs = input[3];
                containsFirst = list.stream().anyMatch(e -> e.getName().equals(firstPersonArgs));
                containsSecond = list.stream().anyMatch(e -> e.getBirth().equals(secondPersonArgs));
                if (!containsFirst)
                    list.add(new Person(firstPersonArgs));
                if (!containsSecond)
                    list.add(new Person(secondPersonArgs));

                Person firstPersonCaseTwo = list.stream().filter(e -> e.getName().equals(firstPersonArgs))
                        .findFirst().get();
                Person secondPersonCaseTwo = list.stream().filter(e -> e.getBirth().equals(secondPersonArgs))
                        .findFirst().get();

                firstPersonCaseTwo.getChildren().add(secondPersonCaseTwo);
                secondPersonCaseTwo.getParents().add(firstPersonCaseTwo);
                break;
            case 3:
                firstPersonArgs = input[0];
                secondPersonArgs = input[2] + " " + input[3];
                containsFirst = list.stream().anyMatch(e -> e.getBirth().equals(firstPersonArgs));
                containsSecond = list.stream().anyMatch(e -> e.getName().equals(secondPersonArgs));
                if (!containsFirst)
                    list.add(new Person(firstPersonArgs));
                if (!containsSecond)
                    list.add(new Person(secondPersonArgs));

                Person firstPersonCaseThree = list.stream().filter(e -> e.getBirth().equals(firstPersonArgs))
                        .findFirst().get();
                Person secondPersonCaseThree = list.stream().filter(e -> e.getName().equals(secondPersonArgs))
                        .findFirst().get();

                firstPersonCaseThree.getChildren().add(secondPersonCaseThree);
                secondPersonCaseThree.getParents().add(firstPersonCaseThree);
                break;
            case 4:
                firstPersonArgs = input[0];
                secondPersonArgs = input[2];
                containsFirst = list.stream().anyMatch(e -> e.getBirth().equals(firstPersonArgs));
                containsSecond = list.stream().anyMatch(e -> e.getBirth().equals(secondPersonArgs));
                if (!containsFirst)
                    list.add(new Person(firstPersonArgs));
                if (!containsSecond)
                    list.add(new Person(secondPersonArgs));

                Person firstPersonCaseFour = list.stream().filter(e -> e.getBirth().equals(firstPersonArgs))
                        .findFirst().get();
                Person secondPersonCaseFour = list.stream().filter(e -> e.getBirth().equals(secondPersonArgs))
                        .findFirst().get();

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
