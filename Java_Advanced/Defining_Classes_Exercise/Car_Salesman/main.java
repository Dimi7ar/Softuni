package Car_Salesman;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Engine> engineList = new ArrayList();
        List<Car> carList = new ArrayList();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            switch (input.length) {
                case 2:
                engineList.add(new Engine(model, power));
                    break;
                case 3:
                    try {
                        engineList.add(new Engine(model, power, Integer.parseInt(input[2])));
                    } catch (Exception e) {
                        engineList.add(new Engine(model, power, input[2]));
                    }
                    break;
                case 4:
                        engineList.add(new Engine(model, power, Integer.parseInt(input[2]), input[3]));
                        break;
            }
        }
        n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            Engine engine = engineList.stream().filter(e -> e.getModel().equals(input[1])).findFirst().get();
            switch (input.length) {
                case 2:
                carList.add(new Car(model, engine));
                    break;
                case 3:
                    try {
                        carList.add(new Car(model, engine, Integer.parseInt(input[2])));
                    } catch (Exception e) {
                        carList.add(new Car(model, engine, input[2]));
                    }
                    break;
                case 4:
                        carList.add(new Car(model, engine, Integer.parseInt(input[2]), input[3]));
                        break;
            }
        }
        carList.stream().forEach(e -> System.out.println(e.toString()));
    }
}
