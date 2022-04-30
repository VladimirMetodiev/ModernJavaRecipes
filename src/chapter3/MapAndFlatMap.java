package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapAndFlatMap {
    public static void main(String[] args) {
        Customer picard = new Customer("Jean-Luc Picard");
        Customer riker = new Customer("William Riker");
        Customer troi = new Customer("Deanna Troi");
        Customer data = new Customer("Data");

        picard.addOrder(new Order(134568)).addOrder(new Order(293194)).addOrder(new Order(838841));
        riker.addOrder(new Order(286759)).addOrder(new Order(838841)).addOrder(new Order(186755)).addOrder(new Order(134568));
        troi.addOrder(new Order(838841)).addOrder(new Order(696969)).addOrder(new Order(529385));
        data.addOrder(new Order(111111)).addOrder(new Order(101011));

        List<Customer> list = new ArrayList<>(Arrays.asList(picard, riker, troi, data));

        // Методът map се използва, когато на всеки вход съответсва един и само един изход.
        list.stream().map(Customer::getName).forEach(System.out::println);
        print();

        // Методът flatMap се използва, когато за всеки елемент на потока, се поражда нов поток.
        list.stream()
                .flatMap(customer -> customer.getOrders().stream())
                .forEach(st -> System.out.println(st.getId()));
    }

    private static void print() {
        System.out.println("------------------------------");
    }
}

class Customer {
    private String name;
    private List<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() { return name; }

    public List<Order> getOrders() { return orders; }

    public Customer addOrder(Order order) {
        orders.add(order);
        return this;
    }
}

class Order {
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}