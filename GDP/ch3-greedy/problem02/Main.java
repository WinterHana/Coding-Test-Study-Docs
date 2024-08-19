import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] firstLine = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < firstLine[0]; i++) {
            matrix.add(Arrays.stream(br.readLine().split(" ")).map(Integer::valueOf).collect(Collectors.toList()));
        }
        int answer = solution(matrix);
        bw.write(String.valueOf(answer));

        bw.flush();
        bw.close();
        br.close();
    }

    static int solution(List<List<Integer>> matrix) {
        int max = 0;
        for (List<Integer> row : matrix) {
            max = Math.max(max, Collections.min(row, (n1, n2) -> n1 - n2));
        }
        return max;
    }
}