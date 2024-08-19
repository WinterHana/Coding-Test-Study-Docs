import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int initRow = sc.nextInt();
        int initCol = sc.nextInt();
        int initDir = sc.nextInt();

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int answer = solution(initRow, initCol, initDir, map);
        System.out.println(answer);

        sc.close();
    }

    static int solution(int initRow, int initCol, int initDir, int[][] map) {
        int currentRow = initRow;
        int currentCol = initCol;
        int currentDir = initDir;

        int count = 0;
        while (true) {
            if (map[currentRow][currentCol] != -1) {
                map[currentRow][currentCol] = -1;
                count++;
            }

            currentDir = (currentDir + 4 - 1) % 4;

            if (isNoWayToProceed(currentRow, currentCol, map)) {
                int backRow = currentRow - ((currentDir - 1) % 2);
                int backCol = currentCol + ((currentDir - 2) % 2);

                if (canBack(backRow, backCol, map)) {
                    currentRow = backRow;
                    currentCol = backCol;
                    continue;
                } else {
                    return count;
                }
            }
            
            int nextRow = currentRow + ((currentDir - 1) % 2);
            int nextCol = currentCol - ((currentDir - 2) % 2);

            if (canProceed(nextRow, nextCol, map)) {
                currentRow = nextRow;
                currentCol = nextCol;
            }
        }
    }

    static boolean canProceed(int row, int col, int[][] map) {
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length) {
            return false;
        }
        return map[row][col] == 0;
    }

    static boolean canBack(int row, int col, int[][] map) {
        if (row < 0 || row >= map.length || col < 0 || col >= map[0].length) {
            return false;
        }
        return map[row][col] != 1;
    }

    static boolean isNoWayToProceed(int row, int col, int[][] map) {
        if (row > 0 && map[row - 1][col] == 0) {
            return false;
        }
        if (row < map.length - 1 && map[row + 1][col] == 0) {
            return false;
        }
        if (col > 0 && map[row][col - 1] == 0) {
            return false;
        }
        if (col < map[0].length - 1 && map[row][col - 1] == 0) {
            return false;
        }
        return true;
    }
}