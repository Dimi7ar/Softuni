import java.util.ArrayDeque;
import java.util.Scanner;


public class decimal_to_binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.valueOf(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();

        while (input != 0) {
            stack.push(input % 2);
            input /= 2;
        }
        String result = "";
        while (!stack.isEmpty()) {
            result = result + stack.pop().toString();
        }

        System.out.println(result);
        scanner.close();
    }
}
