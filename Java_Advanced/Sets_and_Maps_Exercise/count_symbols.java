package Sets_and_Maps_Exercise;

import java.util.TreeMap;
import java.util.Scanner;

public class count_symbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        TreeMap<Character, Integer> map = new TreeMap<>();
        for (char character : input)
        {
            if(!map.containsKey(character))
            map.put(character, 1);
            else
            map.put(character, map.get(character) + 1);
        }
        map.keySet().forEach(key -> System.out.printf("%c: %d time/s%n", key, map.get(key)));
        scanner.close();
    }
}
