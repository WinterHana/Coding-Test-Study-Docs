import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Main {
    

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] stores = new int[n];
        for (int i = 0; i < n; i++) {
            stores[i] = sc.nextInt();
        }

        int answer = solution(stores);
        System.out.println(answer);

        sc.close();
    }

    static int solution(int[] stores) {
        int n = stores.length;
        Map<Integer, int[]> dpTable = new HashMap<>();
        dpTable.put(0, new int[] { stores[0], 1 });
        dpTable.put(1, new int[] {
                stores[0] < stores[1] ? stores[1] : stores[0],
                stores[0] < stores[1] ? 1 : 0
        });
        return dp(n - 1, dpTable, stores)[0];
    }

    static int[] dp(int n, Map<Integer, int[]> dpTable, int[] stores) {
        if (dpTable.containsKey(n)) {
            return dpTable.get(n);
        }

        int[] fromPrev1 = dp(n - 1, dpTable, stores);
        int[] max;
        if (fromPrev1[1] == 0) {
            max = new int[] { fromPrev1[0] + stores[n], 1 };
        } else {
            int[] fromPrev2 = dp(n - 2, dpTable, stores);
            if (fromPrev1[0] < fromPrev2[0] + stores[n]) {
                max = new int[] { fromPrev2[0] + stores[n], 1 };
            } else {
                max = new int[] { fromPrev1[0], 0 };
            }
        }
        dpTable.put(n, max);
        return max;
    }
}
