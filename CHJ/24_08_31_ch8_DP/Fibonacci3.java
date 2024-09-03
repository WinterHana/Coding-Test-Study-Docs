import java.math.BigInteger;
import java.util.Arrays;

public class Fibonacci3 {

    static BigInteger[] d = new BigInteger[100];

    static BigInteger fibo(int x, int depth, String caller) {
        if (x == 1 || x == 2) {
            return BigInteger.ONE;
        }

        if (!d[x].equals(BigInteger.ZERO)) {
            return d[x];
        }

        BigInteger result1 = fibo(x - 1, depth + 1, "fibo(" + x + ")");
        BigInteger result2 = fibo(x - 2, depth + 1, "fibo(" + x + ")");

        d[x] = result1.add(result2);
        return d[x];
    }

    public static void main(String[] args) {
        // 배열 초기화
        for (int i = 0; i < 100; i++) {
            d[i] = BigInteger.ZERO;
        }

        // 재귀 함수 호출
        System.out.println("피보나치 결과: " + fibo(99, 1, "main"));
    }
}
