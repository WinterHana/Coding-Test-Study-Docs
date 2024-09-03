import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = solution(sc.nextInt());
        System.out.println(answer);

        sc.close();
    }

    static int solution(int num) {
        Map<Integer, Integer> dpTable = new HashMap<>();
        dpTable.put(1, 0);
        return dp(num, dpTable);
    }

    static int dp(int n, Map<Integer, Integer> dpTable) {
        if (dpTable.containsKey(n)) {
            return dpTable.get(n);
        }

        int[] from = { -1, -1, -1, -1 };

        if (n % 5 == 0) {
            from[0] = dp(n / 5, dpTable);
        }
        if (n % 3 == 0) {
            from[1] = dp(n / 3, dpTable);
        }
        if (n % 2 == 0) {
            from[2] = dp(n / 2, dpTable);
        }
        from[3] = dp(n - 1, dpTable);

        int min = Arrays.stream(from).filter((num) -> num != -1).min().getAsInt() + 1;
        dpTable.put(n, min);
        return min;
    }
}
