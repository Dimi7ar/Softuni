package Car_Salesman;


public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine, int weight, String color)
    {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public Car(String model, Engine engine, int weight) {
        this(model, engine, weight, "n/a");
    }

    public Car(String model, Engine engine, String color) {
        this(model, engine, -1, color);
    }
    public Car(String model, Engine engine) {
        this(model, engine, -1, "n/a");
    }

    @Override
    public String toString() {
        if (this.weight == -1)
        return this.model + ":\n" + engine.toString() + String.format("Weight: n/a%nColor: %s", this.color);
        return this.model + ":\n" + engine.toString() + String.format("Weight: %d%nColor: %s", this.weight, this.color);
    }
}