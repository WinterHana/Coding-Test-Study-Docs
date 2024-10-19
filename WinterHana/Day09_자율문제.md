## 🗨️ 개념
문제 : www.acmicpc.net/problem/12865

### 1. 배낭 문제(Knapsack Problem)

담을 수 있는 **최대 무게가 정해진 배낭**과 함께 각각의 **무게**와 **가치**가 주어진 아이템의 집합이 주어졌을 때, 배낭에 담음 아이템들의 **가치가 최대**가 되도록 하는 아이템들의 부분집합을 찾는 문제이다.

### 2. 분류

1. **짐을 쪼갤 수 있는 경우(Fraction knapsack problem)** : 그리디 알고리즘으로 해결 가능하다. 짐들의 무게당 가치를 구한 다음 이를 내림차순으로 정렬 후 무게 제한에 도달할 때까지 더해준다.
2. **짐을 쪼갤 수 없는 경우(0/1 knapsack problem)** : DP(동적 계획법)으로 해결한다.

### 3. LCS(Longest Common Subsequence) : 최장 공통 부분 수열

두 시퀀스(문자열, 리스트 등) 순서를 변경하지 않고 양쪽 시퀀스에서 모두 찾아낼 수 있는 가장 긴 부분 수열을 찾는 문제

- 예시 문제 : LCS
    
    https://www.acmicpc.net/problem/9251
    
1. 아이디어 : 두 시퀀스의 각 위치이 대해, 해당 위치까지의 최장 공통 부분 수열의 길이를 저장하는 2차원 배열을 만든다.

→ dp[i][j] : 첫 번째 시퀀스의 i번째 원소와 두 번째 시퀀스의 j번째 원소까지 고려했을 때의 최장 공통 부분 수열의 길이


참고 자료 : https://jouureee.tistory.com/52

### 4. 0/1 knapsack problem

1. 조건
- n개의 아이템이 있다. 그리고 각 아이템은 가치(value)와 무게(weight)를 가진다
- 최대 무게가 W인 배낭이 있다.
- **배낭의 무게 한도를 초과하지 않으면서 가치의 합을 최대화하려면 어떤 아이템을 배낭에 넣어야 하는가?**
1. 점화식

참고 자료 : https://st-lab.tistory.com/141

## 📌 문제 풀이 및 코드

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N + 1][K + 1];

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(weights[i] > j) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weights[i]] + values[i]);
            }
        }

        System.out.println(dp[N][K]);
    }
```

## ✨ 참고 자료
https://howudong.tistory.com/106
https://the-ze.tistory.com/entry/LCSLongest-Common-Subsequence-Knapsack
https://www.acmicpc.net/problem/9251