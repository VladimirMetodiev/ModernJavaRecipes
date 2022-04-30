package chapter6.staff;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Staff staff = new Staff();
        staff.addEmployee(new Employee(1000, "Vladimir Metodiev"));
        staff.addEmployee(new Employee(1001, "Anna Dimitrova"));
        staff.addEmployee(new Employee(1002, "Teodor Iordanov"));
        staff.addEmployee(new Employee(1003, "Ralitza Ivanova"));
        staff.addEmployee(new Employee());

        staff.getEmployeeSet().stream().sorted(Comparator.comparing(Employee::getId)).forEach(System.out::println);
        printLine();

        System.out.println(staff.findEmployeeById(1003));
        System.out.println(staff.findEmployeeById(3000));
        printLine();

        staff.findEmployeeById(1000).ifPresent(System.out::println);
        staff.findEmployeeById(5000).ifPresent(System.out::println);
        printLine();

        System.out.println(staff.findEmployeeById(1001).isPresent() ? staff.findEmployeeById(1001).get() : "There isn't such employee.");
        System.out.println(staff.findEmployeeById(8000).isPresent() ? staff.findEmployeeById(8000) : "There isn't such employee.");
        printLine();
    }

    private static void printLine() {
        System.out.println("------------------------------");
    }
}
