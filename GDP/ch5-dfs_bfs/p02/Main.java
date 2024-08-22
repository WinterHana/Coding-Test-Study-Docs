import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static java.util.AbstractMap.SimpleEntry;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];

        int[][] labirynth = new int[n][];

        for (int i = 0; i < n; i++) {
            labirynth[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = solution(labirynth);
        System.out.println(answer);

        br.close();
    }

    static int solution(int[][] labirynth) {
        Queue<SimpleEntry<SimpleEntry<Integer, Integer>, Integer>> searchQueue = new LinkedList<>();
        searchQueue.add(new SimpleEntry<>(new SimpleEntry<>(0, 0), 1));

        int min = Integer.MAX_VALUE;
        while (!searchQueue.isEmpty()) {
            SimpleEntry<SimpleEntry<Integer, Integer>, Integer> current = searchQueue.poll();
            SimpleEntry<Integer, Integer> coord = current.getKey();
            int row = coord.getKey();
            int col = coord.getValue();
            int dist = current.getValue();

            if (row == labirynth.length - 1 && col == labirynth[0].length - 1) {
                min = min > dist ? dist : min;
            }

            if (withinRange(labirynth[row].length, col + 1) && labirynth[row][col + 1] != 0) {
                searchQueue.add(new SimpleEntry<>(new SimpleEntry<>(row, col + 1), dist + 1));
            }
            if (withinRange(labirynth.length, row + 1) && labirynth[row + 1][col] != 0) {
                searchQueue.add(new SimpleEntry<>(new SimpleEntry<>(row + 1, col), dist + 1));
            }
        }
        return min;
    }

    static boolean withinRange(int arrLen, int idx) {
        return idx >= 0 && idx < arrLen;
    }
}
