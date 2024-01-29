package Speed_Racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            list.add(new Car(input[0], Double.parseDouble(input[1]), Double.parseDouble(input[2])));
        }
        String[] input = scanner.nextLine().split("\\s+");

        while (!input[0].equals("End"))
        {
            final String model = input[1];
            final int distance = Integer.parseInt(input[2]);
            list.stream().filter(e -> e.getModel().equals(model)).forEach(e -> e.Drive(distance));
            input = scanner.nextLine().split("\\s+");
        }
        list.stream().forEach(e -> System.out.println(e.toString()));
    }
}
