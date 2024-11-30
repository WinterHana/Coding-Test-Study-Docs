## 문제 풀이
https://www.acmicpc.net/problem/1717
```
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 1717번 : 집합의 표현
 * union 연산과 find 연산을 직접 구현하고 그 결과를 조건에 맞게 출력한다.
 */
public class Main {
    // set : 집합을 Array로 표현한다.
    public static int[] set;

    // union : 주어진 집합을 합친다.
    public static void union(int a, int b) {
        // a가 대표 노드, b가 대표 노드를 따라가는 대상이라고 가정한다.
        // 만약, a, b가 서로 다른 대표 노드를 가지고 있다면, 위 규칙에 따라 노드를 바꾼다.
        int mainA = find(a);
        int mainB = find(b);
        if(mainA != mainB) {
            set[mainB] = mainA;
        }
    }

    // find : 주어진 target의 대표 노드를 찾는다.
    public static int find(int target) {
        if(target == set[target]) {
            return target;
        } else {
            return set[target] = find(set[target]);
        }
    }

    public static void main(String[] args) throws Exception {
        // 1. 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 2. 배열 생성
        set = new int[n + 1];
        for(int i = 0; i < set.length; i++) {
            set[i] = i;
        }

        // 3. m번의 입력을 받고 그 결과를 반영 및 출력
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(order == 0) {
                // 서로 다른 집합을 하나의 집합으로 만든다.
                union(a, b);
            } else {
                // find를 통해 대표 노드를 찾고, 동일하면 같은 집합이다.
                if(find(a) == find(b)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
```