package Speed_Racing;


public class Car {
    private String model;
    private double fuel_amount;
    private double fuel_cost;
    private int distance_traveled;

    public Car(String model, double fuel_amount, double fuel_cost)
    {
        this.model = model;
        this.fuel_amount = fuel_amount;
        this.fuel_cost = fuel_cost;
    }

    @Override
    public String toString() {
        return this.model + " " + String.format("%.2f ", this.fuel_amount) + this.distance_traveled;
    }

    public void Drive(int distance) {
        double neededFuel = distance * this.fuel_cost;
        if(neededFuel > this.fuel_amount)
            System.out.println("Insufficient fuel for the drive");
        else
        {
            this.fuel_amount -= neededFuel;
            distance_traveled += distance;
        }
    }
    public String getModel() {
        return this.model;
    }

}