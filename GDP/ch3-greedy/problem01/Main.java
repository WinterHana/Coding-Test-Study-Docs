import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = solution(firstLine[1], firstLine[2], secondLine);
        bw.write(String.valueOf(answer));
        
        bw.flush();
        br.close();
        bw.close();
    }

    static int solution(int m, int k, int[] array) {
        int max = 0;
        int secondMax = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                secondMax = max;
                max = array[i];
            }
        }

        int count = m / (k + 1);
        int left = m % (k + 1);
        return count * (max * k + secondMax) + max * left;
    }
}