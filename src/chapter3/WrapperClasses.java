package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class WrapperClasses {
    public static void main(String[] args) {
        /*
         * За преобразуване на примитивни типове в клас обвивка, може да бъде използван метода в boxed на интерфейса Stream.
         * Също така можете да бъде използван метода mapToObj, или метода collect с три аргумента.
         */

        List<Integer> firstList = IntStream.iterate(1, x -> x * 3).limit(10).boxed().collect(Collectors.toList());
        print(firstList);

        /*
         * Методите mapToInt, mapToLong и mapToDouble преобразуват потоци от обекти в потоци от съответните примитивни типове.
         * Методът mapToObj, присъстващ в интерфейсите IntStream, LongStream и DoubleStream, преобразува стойности на примитивните
         * типове към екземпляри на съответните класове обвивки.
         */

        List<Long> secondList = LongStream.rangeClosed(11, 20).mapToObj(Long::valueOf).collect(Collectors.toList());
        print(secondList);

        /*
         * <R> R collect(Supplier<R> supplier, ObjIntConsumer<R> accumulator, BiConsumer<R,R> combiner)
         */

        List<Double> thirdList = DoubleStream
                .iterate(1.0, x -> x * 2.5)
                .limit(10)
                .collect(ArrayList<Double>::new, ArrayList::add, ArrayList::addAll);
        print(thirdList);
    }

    private static <T> void print(List<T> list) {
        for (int a = 0; a < list.size(); a++) {
            if(a < list.size() - 1) System.out.print(list.get(a) + ", ");
            else System.out.println(list.get(a));
        }
    }
}
