package Company_Roster;

import java.text.DecimalFormat;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age)
    {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;

    }
    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }
    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }
    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    @Override
    public String toString() {
        return name + " " + String.format("%.2f ", salary) + email + " " + age;
    }

    public double getSalary() {
        return this.salary;
    }

    public String getDepartment() {
        return this.department;
    }
}