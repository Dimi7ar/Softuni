package Sets_and_Maps_Exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class fix_emails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop"))
                break;
            String email = scanner.nextLine();
            if (validEmail(email, map))
                map.put(name, email);
        }
        map.keySet().forEach(key -> System.out.printf("%s -> %s%n", key, map.get(key)));
        scanner.close();
    }

    public static boolean validEmail(String email, LinkedHashMap map) {
        String[] temp = email.split(".+[@].+[.]");
        if(temp[1].equals("us") || temp[1].equals("uk") || temp[1].equals("com"))
        return false;

        return true;
    }
}
