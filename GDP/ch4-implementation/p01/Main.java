import java.io.BufferedInputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(new BufferedInputStream(System.in));

        String[] input = sc.next().split("");
        int row = input[1].charAt(0) - '0' - 1;
        int column = input[0].charAt(0) - 'a';

        int answer = solution(row, column);
        System.out.println(answer);

        sc.close();
    }

    static int solution(int row, int column) {
        int count = 0;

        for (int r : new int[] { -2, -1, 1, 2 }) {
            int cDist = 3 - Math.abs(r);
            for (int c : new int[] { -1, 1 }) {
                if (isAllowedCoord(row + r, column + c * cDist)) {
                    count++;
                }
            }
        }

        return count;
    }

    static boolean isAllowedCoord(int row, int column) {
        return row >= 0 && row < 8
                && column >= 0 && column < 8;
    }
}