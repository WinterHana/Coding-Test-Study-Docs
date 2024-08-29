import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
4 55555555
100000000 55555555 888888888 444444444

* */
public class OptimizedTteokbokki {
    public static void main(String[] args) throws IOException {
        long startTime = System.nanoTime();
        BufferedReader br = new BufferedReader(new FileReader("CHJ\\24_08_29_ch7_binarySearch\\input.txt"));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tteoks = new int[N];
        st = new StringTokenizer(br.readLine());
        br.close(); // 파일 닫기
        int max = 0;
        for (int i = 0; i < N; i++) {
            tteoks[i] = Integer.parseInt(st.nextToken());

        }
        for (int i = 0; i < N; i++) {
            max = Math.max(max, tteoks[i]);
        }//End of For



        System.out.println(binarySearch(tteoks, M, 0, max));
        System.out.printf("실행시간 : %.6f 초\n", (System.nanoTime() - startTime)/1e9);
    }

    private static int binarySearch(int[] tteoks, int target, int start, int end) {
        int result = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            long sum = calculateSum(tteoks, mid);

            if (sum >= target) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
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