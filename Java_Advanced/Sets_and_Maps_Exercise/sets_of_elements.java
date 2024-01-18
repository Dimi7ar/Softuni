package Sets_and_Maps_Exercise;

import java.util.LinkedHashSet;
import java.util.Arrays;
import java.util.Scanner;

public class sets_of_elements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] n = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        for (int i = 1; i <= n[0] + n[1]; i++) 
        {
            int currNum = Integer.parseInt(scanner.nextLine());
             if(i <= n[0])
             set1.add(currNum);
             else
             set2.add(currNum);
        }
        for (int num : set1)
        {
            if(set2.contains(num))
            System.out.printf("%d ", num);
        }
        scanner.close();
    }
}
