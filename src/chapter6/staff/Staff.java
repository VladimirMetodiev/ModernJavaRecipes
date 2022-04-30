package chapter6.staff;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Staff {
    private Set<Employee> employeeSet = new HashSet<>();

    public void addEmployee(Employee employee) {
        employeeSet.add(employee);
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public Optional<Employee> findEmployeeById(int id) {
        Optional<Employee> employee = Optional.empty();

        for (Employee e : employeeSet) {
            if(e.getId() == id) employee = Optional.of(e);
        }

        return employee;
    }
}



