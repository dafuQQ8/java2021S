import java.util.function.Supplier;
import java.util.stream.IntStream;

public class j8 {


    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Supplier <IntStream> intStream = () -> IntStream.of(intArray);
        System.out.println("Average: " + intStream.get().average().orElse(0) +
                "\nMin: " + intStream.get().min().orElse(0) +
                "\nEquals 0: " + intStream.get().filter(x -> x == 0).count() +
                "\nGreater than 0: " + intStream.get().filter(x -> x > 0).count() +
                "\nIntStream multiplication value: " + intStream.get().reduce(1, (a, b) -> a * b));
        intStream.get().map(i -> i * 2).forEach(System.out::println);



    }
}
