import java.util.LinkedHashSet;
import java.util.Scanner;

public class softuni_party {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        LinkedHashSet<String> set = new LinkedHashSet<>();
        while (!input.equals("PARTY")) {
            set.add(input);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("END")) {
            set.remove(input);
            input = scanner.nextLine();
        }
        for (String guest : set)
            if (isVip(guest))
            {
                System.out.println(guest);
                set.remove(guest);
            }

        for (String guest : set)
            System.out.println(guest);

        scanner.close();
    }

    public static boolean isVip(String guest) {
        return Character.isDigit(guest.charAt(0));
    }
}
