
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Hello {
    public static void main(String[] args) {

        IntStream intStream = IntStream.of(1, 0, 1, 1, 0);
        int[] intArray = intStream.toArray();

        boolean[] booleans = new boolean[intArray.length];

        for (int i = 0; i < intArray.length; i++) {

            booleans[i] = (intArray[i] == 1);

        }//End of For

        System.out.println(Arrays.toString(booleans));

    }//End Of Main
}
