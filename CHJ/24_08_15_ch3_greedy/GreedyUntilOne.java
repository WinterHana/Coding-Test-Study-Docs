import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class GreedyUntilOne {
    public static void main(String[] args) throws IOException {

        //N이 K로 나누어떨어질때는 N을 K로 나눌 수 있어
        //N에서 1을 뺄 수 있어
        //두개를 1이 될떄까지 반복해서 수행해

        /*
        * N = 17 K = 4야
        * 1번 수행시 16
        * 2번 수행시 4
        * 3번 수행시 1
        * 총 3번이야. 최소횟수를 구해야해
        * */

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> inputList =
                Arrays.stream(
                        Arrays
                .stream((bufferedReader.readLine()).split(" "))
                .mapToInt(Integer::parseInt)
                .toArray())
                .boxed()
                .collect(Collectors.toCollection(ArrayList::new));
        int n = inputList.get(0);
        int m = inputList.get(1);
        System.out.printf("N :: %d <> M :: %d\n",n,m);
        //25 5 잖아?
        //만약 현재 N이 5로 나누어 떨어지면
        int executeCount = 0;
        int currentN = n;

         while(currentN != 1) {
             if (currentN % m == 0) {
                 currentN = currentN / m;
                 executeCount++;
             } else {
                 currentN--;
                 executeCount++;
             }
         }
        System.out.printf("executeCount :: %d, currentN :: %d",executeCount,currentN);

    }//End Of Main


}
