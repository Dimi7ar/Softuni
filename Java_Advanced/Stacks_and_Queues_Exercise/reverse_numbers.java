import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class reverse_numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(deque::push);
        String result = "";

        while (!deque.isEmpty()) {
            result = result + " " + deque.pop();
        }

        System.out.println(result);
        scanner.close();
    }
}
