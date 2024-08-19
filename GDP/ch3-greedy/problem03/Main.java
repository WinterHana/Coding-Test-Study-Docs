import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];
        int k = input[1];

        int answer = solution(n, k);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(int n, int k) {
        int m = n;
        int count = 0;
        while (m != 1) {
            int modulo = m % k;
            if (modulo == 0) {
                m /= k;
                count++;
            } else {
                m -= modulo;
                count += modulo;
            }
        }
        return count;
    }
}