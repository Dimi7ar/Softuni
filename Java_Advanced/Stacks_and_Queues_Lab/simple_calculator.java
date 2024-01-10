import java.util.ArrayDeque;
import java.util.Scanner;


public class simple_calculator {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] inputArray = input.split("\\s");
        ArrayDeque<String> stack = new ArrayDeque<String>();

        for (Integer i = 0; i < inputArray.length; i++) {
            stack.add(inputArray[i]);
        }
        Integer result = Integer.parseInt(stack.pop());
        while (!stack.isEmpty()) {
            if (stack.pop().equals("+")) {
                result += Integer.parseInt(stack.pop());
            } else {
                result -= Integer.parseInt(stack.pop());
            }
        }

        System.out.println(result);
        scanner.close();
    }
}
