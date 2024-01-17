import java.util.TreeMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class average_students_grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TreeMap<String, List<Double>> map = new TreeMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            double grade = Double.parseDouble(input[1]);
            if (!map.containsKey(input[0])) {
                List<Double> temp = new ArrayList<>();
                temp.add(grade);
                map.put(input[0], temp);
            } else {
                List<Double> temp = map.get(input[0]);
                temp.add(grade);
                map.put(input[0], temp);
            }
        }
        for (String key : map.keySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(key + " -> ");
            double sum = 0;
            for (Double grade : map.get(key)) {
                sb.append(String.format("%.2f ", grade));
                sum += grade;
            }
            sb.append(String.format("(avg: %.2f)", sum / map.get(key).size()));
            System.out.println(sb.toString().trim());
        }
        scanner.close();
    }
}
