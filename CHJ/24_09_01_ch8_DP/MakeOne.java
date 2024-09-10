import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


/**
x = int(input())

 d = [0] * 30001

 for i in range(2, x + 1):
    d[i] = d[i - 1] + 1
    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
     if i % 3 == 0:
         d[i] = min(d[i], d[i // 3] + 1)
     if i % 5 == 0:
         d[i] = min(d[i], d[i // 5] + 1)

 print(d[x]);
 */


/**
 * 26이면 1빼고 5로나누고 5로 나누네
 * 26이면 2로나누고 13되고 1빼고 12 되면 3으로 나누고,, 4
 * 2로나누어떨어져도 1빼고 5로 나누면 더 이득이라는게 기묘해
 * 다이나믹 프로그래밍....
 * 27이면 1빼고 1뺴고 5나누고 5나누고 4번
 * 27이면 3나누고 3나누고 3나누면 3번
 * 28이면 1뺴고 + 3나누기3번
 * 29면 2빼고 + 3나누기3번
 * 30이면 5나누고 6되지 1뺴고 5나눠
 * 1 2 3 4 5 6 7 8 9 10 11 ... 25 27
 * <p>
 * 1을 빼다가 5로 나누는 전략
 * 1을 빼다가 3으로 나누는 전략
 * 1을 뺴다가 2로 나누는 전략
 * <p>
 * 2,3,5로 나누는 전략
 * 결과를 담아야대 그리고 max를 꺼내야대
 * X는 3만이야.
 * <p>
 * 이런거 아니야. 4가지 전략으로 모든 경우의 수를 해보고 결과값을 담아.
 *
 *
 * 그걸 봐야대 중복되는 연산이 많다는 걸 알아차릴 수 있어. 왜냐하면
 * 27이 9로 되었을떄 9의 최소연산을 안다면 기존에 계산 횟수에서 9의 최소연산을 더하면 되니까.
 * 그래서 f(1)부터 최소연산수를 모두 구해가면서 바텀업방식으로 구현한다면 되지.
 *
 */
public class MakeOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        System.out.println(minOperations(x));
        scanner.close();
    }

    public static int minOperations(int x) {
        int[] d = new int[30001];

        for (int i = 2; i <= x; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0) {
                d[i] = Math.min(d[i], d[i / 2] + 1);
            }
            if (i % 3 == 0) {
                d[i] = Math.min(d[i], d[i / 3] + 1);
            }
            if (i % 5 == 0) {
                d[i] = Math.min(d[i], d[i / 5] + 1);
            }
        }

        return d[x];
    }
}