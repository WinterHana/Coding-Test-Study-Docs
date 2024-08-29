import java.io.PrintStream;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class MethodReferences {

    public static void main(String[] args) {
        Function<String, Integer> parseIntFunction = Integer::parseInt;
        Integer number = parseIntFunction.apply("123");

        Integer number2 = Integer.parseInt("123");

        PrintStream out = System.out;
        Consumer<String> printer = out::println;
        printer.accept("Hello, World");

        Function<String, Integer> stringLengthFunction = String::length;
        Function<String, Integer> stringIntegerFunction2 = s -> s.length();
        int length = stringLengthFunction.apply("apple");
        int length2 = "apple".length();

        Stream<String> stream = Stream.of("a","b","c");

                //스트림의 toArray는 IntFunction을 인자로 받네

        int maxValue = Math.max(5,10);
        int powValue = (int) Math.pow(5,10);

        System.out.println(powValue);


        double value = 123.456;
        double roundedValue = Math.round(value*100) / 100.0 ;
        System.out.println(roundedValue);

        int[] array = {1,2,3,5,5};
        Arrays.stream(array).asDoubleStream();

    }//End Of Main

}
