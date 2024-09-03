import java.util.Scanner;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger answer = solution(sc.nextInt());
        System.out.println(answer);

        sc.close();
    }

    static BigInteger solution(int n) {
        Map<Integer, BigInteger> dpTable = new HashMap<>();
        dpTable.put(1, BigInteger.valueOf(1L));
        dpTable.put(2, BigInteger.valueOf(3L));
        return dp(n, dpTable).mod(BigInteger.valueOf(10007L));
    }

    static BigInteger dp(int n, Map<Integer, BigInteger> dpTable) {
        if (dpTable.containsKey(n)) {
            return dpTable.get(n);
        }

        BigInteger from2 = dp(n - 2, dpTable);
        BigInteger from1 = dp(n - 1, dpTable);

        BigInteger count = from1.add(from2.multiply(BigInteger.valueOf(2L)));
        dpTable.put(n, count);
        return count;
    }
}
