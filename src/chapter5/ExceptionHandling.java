package chapter5;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExceptionHandling {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(23, 60, 18, 42, 7);
        List<Integer> result;
        int factor = 0;

        // Първи начин за обработване на изключение - чрез вмъкване на try-catch в методът map
        result = list.stream()
                .map(element -> {
                    try {
                        return element / factor;
                    } catch (ArithmeticException ex) {
                        return -1;
                    }
                }).collect(Collectors.toList());

        System.out.println(result);



        // Втори начин за обработване на изключение - чрез изнасяне на функцията извиквана в map, в отделен метод
        result = list.stream().map(element -> divide(element, factor)).collect(Collectors.toList());

        System.out.println(result);



        int otherFactor = 2;
        result = list.stream().map(element -> divide(element, otherFactor)).collect(Collectors.toList());

        System.out.println(result);



        String source = "https://docs.oracle.com/en/java/javase/index.html";
        List<String> url = encodeValues(source);

        System.out.println(url);



        url = Arrays.stream(new String[]{source}).map(wrapper(s -> URLEncoder.encode(s, "UTF-8"))).collect(Collectors.toList());

        System.out.println(url);
    }

    private static Integer divide(Integer value, Integer factor) {
        try {
            return value / factor;
        } catch (ArithmeticException e) {
            return -1;
        }
    }

    private static List<String> encodeValues(String... values) {
        return Arrays.stream(values)
                .map(str -> {
                    try {
                        return URLEncoder.encode(str, "UTF-8");
                    }
                    catch (UnsupportedEncodingException ex) {
                        return "";
                    }
                })
                .collect(Collectors.toList());
    }

    private static <T, R, E extends Exception> Function<T, R> wrapper(FunctionWithException<T, R, E> funEx) {
        return arg -> {
            try {
                return funEx.apply(arg);
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        };
    }
}
