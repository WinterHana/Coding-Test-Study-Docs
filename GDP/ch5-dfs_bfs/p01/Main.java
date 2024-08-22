import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = input[0];

        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }

        int answer = solution(matrix);
        System.out.println(answer);

        br.close();
    }

    static int solution(int[][] matrix) {
        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    count++;
                    dfs(matrix, row, col);
                }
            }
        }
        return count;
    }

    static void dfs(int[][] matrix, int row, int col) {
        matrix[row][col] = 1;
        for (int direction = 0; direction < 4; direction++) {
            int rowDir = (direction - 1) % 2;
            int colDir = (direction - 2) % 2;
            int nextRow = row + rowDir;
            int nextCol = col + colDir;
            if (isSearchable(matrix, nextRow, nextCol)) {
                dfs(matrix, nextRow, nextCol);
            }
        }
    }

    static boolean isSearchable(int[][] matrix, int row, int col) {
        return withinRange(matrix.length, row) && withinRange(matrix[row].length, col)
                && matrix[row][col] != 1;
    }

    static boolean withinRange(int arrLen, int idx) {
        return idx >= 0 && idx < arrLen;
    }
}