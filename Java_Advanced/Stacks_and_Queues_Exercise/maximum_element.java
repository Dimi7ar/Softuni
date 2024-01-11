import java.util.ArrayDeque;
import java.util.Scanner;

public class maximum_element {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s");
            int command = Integer.valueOf(input[0]);
            switch (command)
            {
                case 1:
                deque.push(Integer.valueOf(input[1]));
                break;
                case 2:
                deque.pop();
                break;
                case 3:
                System.out.println(deque.stream().max(Integer::compareTo).get());
                break;
            }
        }
        scanner.close();
    }
}
