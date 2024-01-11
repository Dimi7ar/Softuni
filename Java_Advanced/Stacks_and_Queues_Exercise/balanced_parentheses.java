import java.util.ArrayDeque;
import java.util.Scanner;

public class balanced_parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputOne = scanner.nextLine().split("");
        ArrayDeque<String> deque = new ArrayDeque<String>();
        boolean flag = true;
        for (int i = 0; i < inputOne.length; i++) {
            String current = inputOne[i];
            if (current.equals("(") || current.equals("[") || current.equals("{")) {
                deque.push(current);
            } else {
                switch (current) {
                    case ")":
                        if (deque.peek().equals("(")) {
                            deque.pop();
                        } else {
                            flag = false;
                        }
                        break;
                    case "]":
                        if (deque.peek().equals("[")) {
                            deque.pop();
                        } else {
                            flag = false;
                        }
                        break;
                    case "}":
                        if (deque.peek().equals("{")) {
                            deque.pop();
                        } else {
                            flag = false;
                        }
                        break;
                }
            }
        }
        if (!flag || !deque.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

        scanner.close();
    }
}
