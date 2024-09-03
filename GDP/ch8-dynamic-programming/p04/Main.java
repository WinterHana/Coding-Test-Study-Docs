import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int answer = solution(n, m, coins);
        System.out.println(answer);

        sc.close();
    }

    static int solution(int n, int m, int[] coins) {
        Map<Integer, Integer> dpTable = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dpTable.put(coins[i], 1);
        }
        return dp(m, coins, dpTable);
    }

    static int dp(int m, int[] coins, Map<Integer, Integer> dpTable) {
        if (m <= 0) {
            return -1;
        }

        if (dpTable.containsKey(m)) {
            return dpTable.get(m);
        }

        int min = -1;
        for (int c : coins) {
            int from = dp(m - c, coins, dpTable);
            if (min == -1 || from < min) {
                min = from;
            }
        }
        if (min == -1) {
            dpTable.put(m, -1);
            return -1;
        }
        min++;
        dpTable.put(m, min);
        return min;
    }
}
