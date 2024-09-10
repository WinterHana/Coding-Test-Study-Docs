import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

/*
5 3
1 2 5 4 3
5 5 6 6 5

min함수에서 지금 iterate하는건 object잖아 맞지? min에서 인자로 함수를 넣어야하는데 그 함수는 어떤 조건을 지녔어?




* */

public class ExchangeElem {

    public static void main(String[] args) throws Exception{
        //int arr A B
        //바치연 A와 B 원소 하나를 각각 골라 바꿔 K 번
        //A의 합이 최대가 되어야함 그걸 출력해야함

        //A의 최소를 선택해 B의 최대를 선택해. 그걸 바꿔 그걸 K번 반복
        //그 후 A 합 구해.

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

        String[] stringInputArr = bufferedReader.readLine().split(" ");

        int[] inputArr = Arrays.stream(stringInputArr)
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = inputArr[0];
        int k = inputArr[1];

        int[] A = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] B = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

//        System.out.println(Arrays.toString(A));
//        System.out.println(Arrays.toString(B));

        int minIndexA = 0;
        int minValueA = 0;
        int maxIndexB = 0;
        int maxValueB =0;
        int answer = 0;

        for (int i = 0; i < k; i++) {
            //A의 min 구해야대
            int[] minValueIndex = IntStream.range(0, A.length)
                    .mapToObj(j -> new int[]{A[j], j})
                    .min((a,b) -> Integer.compare(a[0],b[0]))
                    .orElseThrow();

            minIndexA = minValueIndex[1];
            minValueA = minValueIndex[0];

            //B의 max 구해야대
            int[] maxValueIndex = IntStream.range(0, B.length)
                    .mapToObj(j -> new int[]{B[j], j})
                    .max((a,b) -> Integer.compare(a[0],b[0]))
                    .orElseThrow();

            maxIndexB = maxValueIndex[1];
            maxValueB = maxValueIndex[0];

            //바꿔치기해
            if(minValueA < maxValueB) {
                A[minIndexA] = maxValueB;
                B[maxIndexB] = minValueA;
            }
        }//End of For

        System.out.println(Arrays.stream(A).sum());

    }//End Of Main
}
