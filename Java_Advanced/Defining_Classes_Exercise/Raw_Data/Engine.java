package Raw_Data;


public class Engine {
    private int speed;
    private int power;

    public Engine(int speed, int power)
    {
        this.speed = speed;
        this.power = power;
    }

    public int getPower()
    {
        return this.power;
    }
}