import java.util.ArrayDeque;
import java.util.Scanner;

public class basic_stack_operations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split("\\s");
        int n = Integer.valueOf(numbers[0]) - Integer.valueOf(numbers[1]);
        int x = Integer.valueOf(numbers[2]);
        String[] input = scanner.nextLine().split("\\s");
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        int min = Integer.MAX_VALUE;
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            deque.push(Integer.parseInt(input[i]));
        }
        if (deque.isEmpty()) {
            System.out.println(0);
            flag = false;
        }
        while (!deque.isEmpty()) {
            if (min > deque.peek()) {
                min = deque.peek();
            }
            if (deque.peek() == x) {
                System.out.println(true);
                flag = false;
            }
            deque.pop();
        }
        if (flag) {
            System.out.println(min);
        }

        scanner.close();
    }
}
