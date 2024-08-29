import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GreedyCardGame {

    //N 행의 개수 M 열의 개수
    //조건은 행 선택하고 가장 낮은 카드 뽑아야해
    //최대의 카드를 뽑아야함 숫자 4가 있어도 2가 정답임
    //

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader
                = new BufferedReader(
                        new InputStreamReader(System.in)
        );

        Supplier<int[]> reader = () -> {
            try {
                return Arrays
                        .stream((bufferedReader.readLine()).split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        int[] firstLine = reader.get();

        int n = firstLine[0];
        int m = firstLine[1];


        //어차피 다 읽어야 해. 안읽을 수 없음
        List<Integer> rowCard;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            rowCard = Arrays.stream(reader.get())
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));

            maxValue = Math.max(maxValue,rowCard.stream().min(Integer::compareTo).orElseThrow());

        }//End of For
        System.out.printf("두구두구두구... 정답은.. %d", maxValue);

    }//End Of Main
}
