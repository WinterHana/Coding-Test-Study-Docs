import java.math.BigInteger;

public class Fibonacci {

    public static BigInteger fiboSum(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ZERO;
        } else if (n.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        } else {
            return fiboSum(n.subtract(BigInteger.TWO)).add(fiboSum(n.subtract(BigInteger.ONE)));
        }
    }

    public static BigInteger factorialSum(BigInteger n) {
        if (n.equals(BigInteger.ZERO)) {
            return BigInteger.ONE;
        } else {
            return n.multiply(factorialSum(n.subtract(BigInteger.ONE)));
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 500; i++) {
            BigInteger iBigInt = BigInteger.valueOf(i);
            System.out.printf("팩토리얼 %d 번째 실행 :: %s\n", i, factorialSum(iBigInt).toString());
        }

        for (int i = 0; i < 500; i++) {
            BigInteger iBigInt = BigInteger.valueOf(i);
            System.out.printf("피보나치 %d 번째 실행 :: %s\n", i, fiboSum(iBigInt).toString());
        }
    }
}
