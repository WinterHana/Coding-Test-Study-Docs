import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = solution(sc.nextInt());
        System.out.println(answer);

        sc.close();
    }

    static int solution(int n) {
        Map<Integer, Integer> dpTable = new HashMap<>();
        dpTable.put(1, 1);
        dpTable.put(2, 3);
        return dp(n, dpTable) % 796797;
    }

    static int dp(int n, Map<Integer, Integer> dpTable) {
        if (dpTable.containsKey(n)) {
            return dpTable.get(n);
        }

        int from2 = dp(n - 2, dpTable);
        int from1 = dp(n - 1, dpTable);

        int count = from1 + from2 * 2;
        dpTable.put(n, count);
        return count;
    }
}
