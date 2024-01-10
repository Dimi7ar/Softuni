import java.util.ArrayDeque;
import java.util.Scanner;


public class reverse_numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s");

        ArrayDeque<String> deque = new ArrayDeque<String>();
        String result = "";

        for (int i = 0; i < input.length; i++)
        {
            deque.push(input[i]);
        }
        while(!deque.isEmpty())
        {
            result = result + " " + deque.pop();
        }

        System.out.println(result);
        scanner.close();
    }
}
