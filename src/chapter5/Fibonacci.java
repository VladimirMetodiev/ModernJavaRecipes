package chapter5;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Fibonacci {
    private static Map<Long, BigInteger> fibonacci = new HashMap<>();

    private static BigInteger calculateFibonacciNumber(long num) {
        if (num == 0) return BigInteger.ZERO;
        if (num == 1) return BigInteger.ONE;
        return fibonacci.computeIfAbsent(num, n -> calculateFibonacciNumber(n - 2).add(calculateFibonacciNumber(n - 1)));
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long number = Long.parseLong(input.nextLine());
        System.out.println(calculateFibonacciNumber(number));
    }
}
