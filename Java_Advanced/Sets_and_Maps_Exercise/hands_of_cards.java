package Sets_and_Maps_Exercise;

import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class hands_of_cards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, HashSet<String>> map = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] cmds = input.split(": ");
            map.putIfAbsent(cmds[0], new HashSet<>());
            fillPlayerCards(map.get(cmds[0]), cmds[1]);
            input = scanner.nextLine();
        }
        System.out.println();
        map.keySet().forEach(key -> System.out.printf("%s: %d%n", key, countCards(map.get(key))));
        scanner.close();
    }

    public static void fillPlayerCards(HashSet<String> playerCards, String drawnCards) {
        String[] cards = drawnCards.split(", ");
        Arrays.stream(cards).forEach(playerCards::add);

    }

    public static Integer countCards(HashSet<String> cards) {
        int sum = 0;
        for (String card : cards) {
            int currValue = 0;
            boolean flag = true;
            if (Character.isDigit(card.charAt(0))) {
                if (String.valueOf(card.charAt(0)).equals("1") && String.valueOf(card.charAt(1)).equals("0")) {
                    currValue = 10;
                    flag = false;
                } else
                    currValue = Integer.parseInt(String.valueOf(card.charAt(0)));
            } else {
                switch (card.charAt(0)) {
                    case 'J':
                        currValue = 11;
                        break;
                    case 'Q':
                        currValue = 12;
                        break;
                    case 'K':
                        currValue = 13;
                        break;
                    case 'A':
                        currValue = 14;
                        break;
                }
            }
            Character type = flag ? card.charAt(1) : card.charAt(2);
            switch (type) {
                case 'S':
                    currValue *= 4;
                    break;
                case 'H':
                    currValue *= 3;
                    break;
                case 'D':
                    currValue *= 2;
                    break;
                case 'C':
                    currValue *= 1;
                    break;
            }
            sum += currValue;
        }
        return sum;
    }
}
