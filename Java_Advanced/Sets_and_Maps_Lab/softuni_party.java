import java.util.TreeSet;
import java.util.Scanner;

public class softuni_party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        TreeSet<String> set = new TreeSet<String>();
        while (!input.equals("PARTY")) {
            set.add(input);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {
            set.remove(input);
            input = scanner.nextLine();
        }
        System.out.println(set.size());
        for (String guest : set) {
            System.out.println(guest);
        }
        scanner.close();
    }
}
