package DefiningClasses.Exercises.CompanyRoster;

public class Employee {
    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    //    public Employee(String name, double salary, String position, String department, String email) {
//        this(name, salary, position, department);
//        this.email = email;
//    }
//    public Employee(String name, double salary, String position, String department, int age) {
//        this(name, salary, position, department);
//        this.age = age;
//    }
//    public Employee(String name, double salary, String position, String department, String email, int age) {
//        this(name, salary, position, department);
//        this.email = email;
//        this.age = age;
//    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %.2f %s %d", this.name, this.salary, this.email, this.age);
    }
}
