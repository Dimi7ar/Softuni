import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class voina_number_game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> playerOneCards = new LinkedHashSet<Integer>();
        LinkedHashSet<Integer> playerTwoCards = new LinkedHashSet<Integer>();
        int round = 0;
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(playerOneCards::add);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(playerTwoCards::add);
        while (round < 50) {
            round++;
            int firstNumber = playerOneCards.iterator().next();
            playerOneCards.remove(firstNumber);
            int secondNumber = playerTwoCards.iterator().next();
            playerTwoCards.remove(secondNumber);
            if (playerOneCards.isEmpty() || playerTwoCards.isEmpty())
                break;

            if (firstNumber > secondNumber) {
                playerOneCards.add(firstNumber);
                playerOneCards.add(secondNumber);
            } else if (secondNumber > firstNumber) {
                playerTwoCards.add(firstNumber);
                playerTwoCards.add(secondNumber);
            }
            else {
                playerOneCards.add(firstNumber);
                playerTwoCards.add(secondNumber);
            }
        }
        String result = "";
        if (playerTwoCards.size() > playerOneCards.size())
            result = "Second player win!";
        else if (playerOneCards.size() > playerTwoCards.size())
            result = "First player win!";
        else
            result = "Draw!";
        System.out.println(result);

        scanner.close();
    }
}
