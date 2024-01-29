package Raw_Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> list = new ArrayList();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            Engine engine = new Engine(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
            Cargo cargo = new Cargo(Integer.parseInt(input[3]), input[4]);
            Tire[] tires = new Tire[] {
                    new Tire(Double.parseDouble(input[5]), Integer.parseInt(input[6])),
                    new Tire(Double.parseDouble(input[7]), Integer.parseInt(input[8])),
                    new Tire(Double.parseDouble(input[9]), Integer.parseInt(input[10])),
                    new Tire(Double.parseDouble(input[11]), Integer.parseInt(input[12]))
            };
            list.add(new Car(model, engine, cargo, tires));
        }
        String input = scanner.nextLine();
        Predicate<Car> checkCargoType = car -> {
            switch (input) {
                case "fragile":
                    Double[] tirePressures = car.getTirePressures();
                    for (Double tirePressure : tirePressures)
                        if (tirePressure < 1)
                            return true;
                    return false;
                case "flamable":
                    int enginePower = car.getEnginePower();
                    if (enginePower > 250)
                        return true;
                    return false;
                default:
                    return false;
            }
        };

        list.stream().filter(checkCargoType).forEach(e -> System.out.println(e.getModel()));
    }
}
