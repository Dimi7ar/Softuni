package Opinion_Poll;

public class Person {
    private String name;
    private int age;
    public Person (String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString() {
        return name + " - " + age;
    }
    public String getName() {
        return this.name;
    }
}