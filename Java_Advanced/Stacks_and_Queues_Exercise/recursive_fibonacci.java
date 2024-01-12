import java.util.Scanner;
import java.util.TreeMap;

public class recursive_fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<Integer, Long> map = new TreeMap<Integer, Long>();
        System.out.println(fibonacci(n, map));
        scanner.close();
    }

    public static long fibonacci(int n, TreeMap<Integer, Long> map) {
        if (n < 2) {
            return 1;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }

        long temp = fibonacci(n - 1, map) + fibonacci(n - 2, map);
        map.put(n, temp);
        return temp;
    }
}
