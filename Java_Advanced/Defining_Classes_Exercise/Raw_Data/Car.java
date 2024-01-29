package Raw_Data;


public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires = new Tire[4];

    public Car(String model, Engine engine, Cargo cargo, Tire[] tires)
    {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    @Override
    public String toString() {
        return this.model;
    }

    public String getModel() {
        return this.model;
    }

    public Double[] getTirePressures() {
        return new Double[] {
            tires[0].getPressure(),
            tires[1].getPressure(),
            tires[2].getPressure(),
            tires[3].getPressure()
        };
    }
    public int getEnginePower() {
        return this.engine.getPower();
    }
}