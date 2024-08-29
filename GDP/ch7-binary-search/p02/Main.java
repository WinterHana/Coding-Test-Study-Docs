import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] dducks = new int[n];
        for (int i = 0; i < n; i++) {
            dducks[i] = sc.nextInt();
        }

        int answer = solution(m, dducks);
        System.out.println(answer);

        sc.close();
    }

    static int solution(int m, int[] dducks) {
        int max = 0;
        for (int d : dducks) {
            if (max < d) {
                max = d;
            }
        }

        return binarySerach(0, max, m, dducks);
    }

    static int binarySerach(int lower, int upper, int m, int[] dducks) {
        int center = (lower + upper) / 2;
        int totalDducksLen = Arrays.stream(dducks).map((d) -> d - center < 0 ? 0 : d - center).reduce(0, Integer::sum);
        if (lower == upper) {
            return totalDducksLen;
        }

        if (totalDducksLen == m) {
            return totalDducksLen;
        } else if (totalDducksLen < m) {
            return binarySerach(lower, center - 1, m, dducks);
        } else {
            return binarySerach(center + 1, upper, m, dducks);
        }
    }
}