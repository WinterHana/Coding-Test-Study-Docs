import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class StreamBasedTteokbokki {
    static int m;
    static int[] tteoks;

    public static void main(String[] args) throws Exception{
        // 현재 작업 디렉토리 출력
        long startTime = System.nanoTime(); // 시간 측정을 입력 후로 이동
        String filePath = "CHJ\\24_08_29_ch7_binarySearch\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        int[] st = Arrays.stream(bufferedReader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = st[0];
        int m = st[1];
        IntStream tteokStream = Arrays.stream(bufferedReader.readLine().split(" "))
                .mapToInt(Integer::parseInt);
        tteoks = tteokStream.toArray();
        bufferedReader.close(); // 파일 닫기
        int maxH = IntStream.of(tteoks).max().orElseThrow();

//        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
//        int n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        tteoks = new int[n];
//        st = new StringTokenizer(bufferedReader.readLine());
//        bufferedReader.close();
//        int maxH = 0;
//        for (int i = 0; i < n; i++) {
//            tteoks[i] = Integer.parseInt(st.nextToken());
//            maxH = Math.max(maxH,tteoks[i]);
//        }//End of For

        int result = search(0, maxH + 1);
        long endTime = System.nanoTime(); // 종료 시간 측정

        System.out.println(result);
        System.out.printf("실행시간 : %.6f 초\n", (endTime - startTime) / 1e9);
    }

    public static int search(int startP, int endP) {
        endP = endP - 1; // exclusive
        while (startP <= endP) {
            int insertP = startP + (endP - startP) / 2;
//            long finalInsertP = insertP;

//            long sum = Arrays.stream(tteoks)
//                    .map(element -> Math.max(0, element - finalInsertP))
//                    .sum();
            long sum = calculateSum(tteoks, insertP);

            if (m == sum) {
                return insertP;
            } else if (m > sum) {
                endP = insertP - 1;
            } else {
                startP = insertP + 1;
            }
        }
        return startP - 1;
    }
    private static long calculateSum(int[] tteoks, int height) {
        long sum = 0;
        for (int tteok : tteoks) {
            if (tteok > height) {
                sum += tteok - height;
            }
        }
        return sum;
    }
}
