import java.io.Console;
import java.util.ArrayDeque;
import java.util.Scanner;

import javax.print.DocFlavor.STRING;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        ArrayDeque<Integer> openBrackets = new ArrayDeque<Integer>();
        for (int i = 0; i < input.length(); i++)
        {
            Character current = input.charAt(i);
            if (current == '(')
            {
               openBrackets.push(i);
            }
            else if (current == ')')
            {
               int startIndex = openBrackets.pop();
               System.out.println(input.substring(startIndex, i+1));
            }
        }
    }
}
