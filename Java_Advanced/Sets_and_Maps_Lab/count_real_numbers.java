import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class count_real_numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
        LinkedHashMap<Double, Integer> map = new LinkedHashMap<>();
        for (Double number : input) {
            if (!map.containsKey(number)) {
                map.put(number, 1);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }
        for (Double key : map.keySet())
        {
            System.out.println(String.format("%.1f -> %d", key, map.get(key)));
        }
        scanner.close();
    }
}
