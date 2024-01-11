import java.util.ArrayDeque;
import java.util.Scanner;

public class basic_queue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputOne = scanner.nextLine().split("\\s");
        String[] inputTwo = scanner.nextLine().split("\\s");
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int s = Integer.valueOf(inputOne[1]);
        int x = Integer.valueOf(inputOne[2]);

        for (int i = 0 + s; i < inputTwo.length; i++) {
            deque.offer(Integer.valueOf(inputTwo[i]));
        }
        if (deque.isEmpty()) {
            System.out.println(0);
        } else if (deque.contains(x)) {
            System.out.println(true);
        } else {
            System.out.println(deque.stream().min(Integer::compareTo).get());
        }
        scanner.close();
    }
}
