import java.math.BigInteger;
import java.util.Arrays;

/**
 * A: 호출 B 생성등장) C 종료 D 복귀 E 종료
 *
 * 종료하면 복귀하고 호출하면 생성된다.
 *
 * A와 B를 묶어서 보자.
 * A가 호출되는 즉시 반드시 B가 덩달아 찍힌다.
 * 처음에 B가 한번 찍힌다.
 * A-1는 A-2보다 위에 있다. 다른 알파벳도 마찬가지이다.
 * 그러니 순서가 바뀌면 재귀가 종료됐다는 뜻임.
 * 그 다음 (A-1 B)가 먼저 97번 찍히고
 * 그 다음 (A-1 B C-1)가 1번 찍히고
 * 그 다음 (D-1 A-2 B C-1 D-2 E)가 2번 찍힌다. (f(4)구하는 과정과 f(5)구하는 과정)
 *
 * 그 다음 (D-1 A-2 B C-2 D-2 E)가 95번 찍힌다. 복귀,호출,생성,종료,복귀,종료 캐시리턴
 *
 * 순서를 정확히 알았어. 이제 추상적으로 이해를 해보면,
 * 먼저 99부터 2까지 전부 스택을 생성해.
 * 그리고 2가 종료(3으로 복귀해). 1을 호출(생성)하고 1이 종료(3으로 복귀)
 * 그리고 3이 종료(4로 복귀해). 2를 호출(생성)하고 2가 종료(4로 복귀)
 * 그리고 n-1이 종료(n으로 복귀해). n-2를 호출(생성)하고 n-2가 종료(n으로 복귀)
 *
 * f(1) f(2)는 1을 반환하고 그게 아니면 캐쉬를 반환하도록 하는거야
 * 1을 반환하는 경우가 3번있네.
 * 왜냐면 f(1)과 f(2)는 캐시에 저장을 안하고 1을 리턴해.
 * f(3) = f(2) + f(1), f(2) = 1 (1번) f(1) = 1 (1번)
 * f(4) = f(3) + f(2), f(2) = 1 (1번)
 * 이렇게 총 3번이야.
 * f(3)을 구할때는
 * f(3)부터는 캐시에 보관하는 거지. index 3부터 99까지 97번 저장을 하네. 97개를 갖는거야.
 * 그리고 끝.
 */
public class Fibonacci2 {

    static BigInteger[] d = new BigInteger[100];

    static BigInteger fibo(int x, int depth, String caller) {
        // 재귀 함수 시작 시 호출자 정보와 함께 출력
        System.out.println("B(재귀생성) : fibo(" + x + ")가 생성되었음 "+caller + "로부터 (depth: " + depth + ") d[]: " + Arrays.toString(d));

        if (x == 1 || x == 2) {
            System.out.printf("C-1(재귀종료) : 캐시가 없어요. *1반환* 후 종료 : fibo (%d) %s로 부터 (depth: %d) d[%d] :: %d\n",x,caller,depth,x,d[x]);
            return BigInteger.ONE;//제일 마지막 스택이 종료가 됨. fibo(2)종료
        }


        //캐시가 있다면
        if (!d[x].equals(BigInteger.ZERO)) {
            // 캐시된 값이 있을 때 배열의 상태와 반환할 값을 출력
            System.out.println("C-2(재귀종료) : 캐시가 있어요. 캐시된 값 반환 후 종료 : fibo(" + x + ") "+caller+"로 부터"+" (depth: " + depth + ") d[" + x + "]: " + d[x]);
            return d[x];
        }

        // 각 재귀 호출을 구분하여 출력
        //f(3)=f(2)+f(1)에서 f(2)
        System.out.println("A-1(재귀호출) : fibo(" + (x - 1) + ")를 호출 중 " + "fibo(" + x + ")로부터" + " (depth: " + (depth + 1) + ")");
        BigInteger result1 = fibo(x - 1, depth + 1, "fibo(" + x + ")");
        System.out.println("\nD-1(재귀복귀) : fibo(" + x + ")로 복귀 " + "fibo(" + (x - 1) + ")로부터" + " (depth: " + depth + ") 결과: " + result1);

        //f(3)=f(2)+f(1)에서 f(1)
        System.out.println("A-2(재귀호출) : fibo(" + (x - 2) + ")를 호출 중 " + "fibo(" + x + ")로부터" + " (depth: " + (depth + 1) + ")");
        BigInteger result2 = fibo(x - 2, depth + 1, "fibo(" + x + ")");
        System.out.println("D-2(재귀복귀) : fibo(" + x + ")로 복귀 " + "fibo(" + (x - 2) + ")로부터" + " (depth: " + depth + ") 결과: " + result2);

        // 결과를 합산하고 배열 갱신
        d[x] = result1.add(result2);

        // 재귀 함수 종료 전 배열의 상태와 현재 계산 결과 출력
        System.out.println("E(재귀종료 및 저장) : fibo(" + x + ")종료 이제 "+caller+"으로"+" (depth: " + depth + ") 저장 :: d[" + x + "] = " + d[x]);
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
