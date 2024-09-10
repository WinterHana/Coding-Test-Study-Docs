/*

세로 x 가로
2 x N

세로는 언제나 2임

2 x 3이면


이 문제도 마땅한 수학적 공식이 떠오르지가 않는다.
그렇지만 뭔가 반복적인 노가다를 하면 답이 나올 것 같다.
연역적 추론은 밝혀내지 못했다.
나는 귀납적으로 추론 해보는 전략을 취했다.
그 전략을 취했고, 그래서 a1,a2,a3 case를 분석해보게 되었다.
동일한 작업이 반복된다.
전체합 = 부분합의 합인지 보자.

a1은 1가지
a2는 3가지
a3는 5가지이다.를 보면 a1과 a2의 조합으로 만들어진다는 걸 알아냈다.
부분합을 통해 전체합을 도출해보자

#

* */

import java.util.Scanner;

public class FloorConstruction {

    static int[] d = new int[1001];

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(n);

        d[1] = 1;
        d[2] = 3;

        for (int i = 3; i < n+1 ; i++) {
            d[i] = (d[i-1] + 2 * d[i-2]) % 796796;
        }//End of For

        System.out.println(d[n]);

    }//End Of Main

}
