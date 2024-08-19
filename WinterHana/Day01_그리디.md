## 🗨️ 개념

어떠한 문제가 있을 때 단순 무식하게, 탐욕적으로 문제를 푸는 알고리즘.

**문제를 풀기 위한 최소한의 아이디어를 떠올릴 수 있는 능력을 요구한다.**

기준에 따라 좋은 것을 선택하는 알고리즘이므로 문제에서 ‘가장 큰 순서대로’, ‘가장 작은 순서대로’ 와 같은 기준을 알게 모르게 제시해주기 때문에 이를 참고하면 좋다.

### 그리디 알고리즘의 정당성

그리디 알고리즘으로 문제의 해법을 찾았을 때는 **그 해법이 정당한지 검토해야 한다.** 

## 📌 문제 풀이

### 문제  1 : 큰 수의 법칙
---
참고 문제 : 없음

1. 직관적으로 풀이한 방법

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int first = numbers[N - 1];
        int second = numbers[N - 2];

        int sum = 0;
        int count = 0;
        for(int i = 0; i < M; i++) {
            if(count < K) {
                sum += first;
                count++;
            } else {
                count = 0;
                sum += second;
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(sum);
        System.out.println(sb.toString());
    }
}
```

1. 수학적 공식을 세워 풀이하는 방식

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] numbers = new int[N];
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);
        int first = numbers[N - 1];
        int second = numbers[N - 2];

        // 가장 큰 수가 더해지는 횟수
        int count = (int) (M / (K + 1)) * K + M % (K + 1);

        // 결과
        int result = count * first + (M - count) * second;
        System.out.println(result);
    }
}
```

### 문제 2 : 숫자 카드 게임

---

참고 문제 : 없음

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] numbers = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                numbers[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            int min = Arrays.stream(numbers[i]).min().getAsInt();
            if(result < min) result = min;
        }

        System.out.println(result);
    }
}
```

### 문제 3 : 1이 될 때까지

---

참고 문제 : https://www.acmicpc.net/problem/1463 백준 1463번

1. 본인 풀이

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

        int count = 0;
        while(N != 1) {
            if(N % K == 0) N /= K;
            else N--;
            count++;
        }

        System.out.println(count);
    }
}
```

1. 문제 답안 (최적화)

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

        int count = 0;
        while(true) {
			      // (N == K로 나누어 떨어지는 수)가 될 때까지 1씩 빼기
            int target = (N / K) * K;
            count += (N - target);

            N = target;
			      // N이 K보다 작을 때 반복문 탈출
            if (N < K) break;
            count += 1;
            N /= K;
        }
        // 남은 수에 대하여 1씩 빼기
        count += (N - 1);

        System.out.println(count);
    }
}
```

## ✨ 참고 자료