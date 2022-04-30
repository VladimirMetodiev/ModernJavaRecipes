package chapter6.business;

import java.util.Optional;

public class Management {
    public static void main(String[] args) {
        Department marketing = new Department();
        Manager marketingManager = new Manager("Anna Dimitrova");
        marketing.setBoss(marketingManager);

        Department finance = new Department();
        Manager financeManager = new Manager(null);
        finance.setBoss(financeManager);

        // Взимам значението на полето name
        System.out.printf("Name: %s%n", marketing.getBoss().orElse(new Manager("Unknown")).getName());
        System.out.printf("Name: %s%n", finance.getBoss().orElse(new Manager("Unknown")).getName());

        // Метода map връща Optional резултат
        System.out.printf("Name: %s%n", marketing.getBoss().map(Manager::getName));
        System.out.printf("Name: %s%n", finance.getBoss().map(Manager::getName));


        Company successCorp = new Company();
        Department logistics = new Department();
        Manager logisticsManager = new Manager("Boris Ivanov");
        logistics.setBoss(logisticsManager);
        successCorp.setDepartment(logistics);

        // Методът getDepartment връща Optional резултат
        System.out.printf("Department manager: %s%n", successCorp.getDepartment().flatMap(Department::getBoss).map(Manager::getName));


        Optional<Company> company = Optional.of(successCorp);
        String managerName = company.flatMap(Company::getDepartment).flatMap(Department::getBoss).map(Manager::getName).orElse("Unknown");
        System.out.println(managerName);
    }
}
