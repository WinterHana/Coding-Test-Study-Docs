## 🗨️ 개념

---

**다이나믹 프로그래밍 : 중복되는 연산을 줄이자.**

(예시 : 피보나치 수열)

다이나믹 프로그래밍을 사용할 때, 다음과 같은 조건을 만족해야 한다.

1. 큰 문제를 작은 문제로 나눌 수 있다,.
2. 작은 문제에서 구한 정답은 그것을 포함하는 큰 문제에서도 동일하다.

피보나치 수열은 이러한 조건을 만족하는 대표적인 문제이므로, 이 문제를 메모이제이션 기법을 통해 해결하자

※ 메모이제이션 : 한 번 구한 결과를 메모리 공간에 메모해두고 같은 식을 다시 호출하면 메모한 결과를 그대로 가져오는 기법. 메모이제이션은 값을 저장하는 방법이므로 캐싱이라고도 한다.

이는 퀵 정렬의 분할 정복과 비교될 수 있는데, 다이나믹 프로그래밍과 분할 정복의 차이점은 다이나믹 프로그래밍은 문제들이 서로 영향을 미치고 있다는 점이다. 즉, 한 번 해결했던 문제를 다시 해결한다.

기본적으로 반복문을 이용한 다이나믹 프로그래밍이 더 성능이 좋다.

탑 다운 방식(하향식) : 재귀 함수를 이용하여 다이나믹 프로그래밍 소스코드를 작성하는 방법. 즉, 큰 문제를 해결하기 위해 작은 문제를 호출한다.

보텀업 방식(상향식) : 반복문을 이용하여 소스코드를 작성하는 방법. 즉, 작은 문제부터 차근차근 답을 도출한다. (전형적인 방식)

※ 입력이 많으면 그리디 또는 다이나믹 프로그래밍을 의심해보자

## 📌 문제 풀이

---

### 실전 문제  1 : 1로 만들기

---

참고 문제 : https://www.acmicpc.net/problem/1463

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        arr[1] = 0;
        for(int i = 2; i <= N; i++) {
            arr[i] = arr[i - 1] + 1;
            if(i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }

            if(i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }

            if(i % 5 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 5] + 1);
            }
        }

        System.out.println(arr[N]);
    }
}
```

### 실전 문제 2 : 개미 전사

---

참고 문제 : 

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        int[] result = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        result[1] = arr[1];
        for(int i = 2; i < N + 1; i++) {
            result[i] = Math.max(result[i - 2] + arr[i], result[i - 1]);
        }

        System.out.println(result[N]);
    }
}
```

### 실전 문제 3 : 바닥 공사

---

참고 문제 : https://www.acmicpc.net/problem/11727

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] result = new int[N + 1];
        result[1] = 1; result[2] = 3;
        for(int i = 3; i < N + 1; i++) {
            result[i] = (result[i - 1] + 2 * result[i - 2]) % 796796;
        }

        System.out.println(result[N]);
    }
}
```

### 실전 문제 4 : 효율적인 화폐 구성+

---

참고 문제 : https://www.acmicpc.net/problem/14916

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int[] dp = new int[M + 1];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i < M + 1; i++) {
            dp[i] = 10001; // MAX_VALUE로 하면 Overflow 발생
        }

//        for(int i = 1; i < M + 1; i++) {
//            for(int num : arr) {
//                if(i - num >= 0) {
//                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
//                }
//            }
//        }

        for(int i = 1; i < M + 1; i++) {
            for(int num : arr) {
                if(i - num >= 0 && dp[i - num] != 10001) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }

        for(int num : dp) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println((dp[M] == 10001) ? -1 : dp[M]);
    }
}
```

## ✨ 참고 자료

---