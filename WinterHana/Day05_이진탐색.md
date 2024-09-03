## 🗨️ 개념

---

### 개요

- **순차 탐색** : 리스트 안에 있는 특정한 데이터를 찾기 위해 앞에서부터 데이터를 하나씩 차례대로 확인하는 방법
- **이진 탐색** : **배열 내부의 데이터가 정렬**되어 있을 때, **시작점**과 **끝점**, **중간점**을 통해 찾을려는 데이터와 중간점 위치에 있는 **데이터를 반복적으로 비교하여 원하는 데이터를 찾는 과정**

### 이진 탐색 코드(Java)

자주 나오는 문제 유형이므로 코드를 계속 보고 외우도록 하자

```java
import java.util.*;

public class Main {

    // 이진 탐색 소스코드 구현(반복문)
    public static int binarySearch(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            // 찾은 경우 중간점 인덱스 반환
            if (arr[mid] == target) return mid;
            
            // 중간점의 값보다 찾고자 하는 값이 작은 경우 왼쪽 확인
            else if (arr[mid] > target) end = mid - 1;
            
            // 중간점의 값보다 찾고자 하는 값이 큰 경우 오른쪽 확인
            else start = mid + 1; 
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 원소의 개수(n)와 찾고자 하는 값(target)을 입력받기 
        int n = sc.nextInt();
        int target = sc.nextInt();

        // 전체 원소 입력받기 
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 이진 탐색 수행 결과 출력 
        int result = binarySearch(arr, target, 0, n - 1);
        if (result == -1) {
            System.out.println("원소가 존재하지 않습니다.");
        }
        else {
            System.out.println(result + 1);
        }
    }

}
```

### 유의사항

- 탐색 범위가 큰 상황에서 이진 탐색을 한 번 고려해보자. (1000만 이상)

### 트리 자료구조

노드와 노드의 연결로 표현한다. 데이터베이스 시스템이나 파일 시스템과 같은 곳에서 많은 양의 데이터를 관리하기 위한 목적으로 사용한다.

1. 트리는 부모 노드와 자식 노드의 관계로 표현된다.
2. 트리의 최상단 노드를 루트 노드라고 한다.
3. 트리의 최하단 노드를 단말 노드라고 한다.
4. 트리에서 일부를 떼어내도 트리 구조이며 이를 서브 트리라 한다.
5. 트리는 파일 시스템과 같이 계층적이고 정렬된 데이터를 다루기에 적합하다.

### 이진 탐색 트리

1. 부모 노드보다 왼쪽 자식 노드가 작다.
2. 부모 노드보다 오른쪽 자식 노드가 크다.

⇒ **왼쪽 자식 노드 < 부모 노드 < 오른쪽 자식 노드**

## 📌 문제 풀이

### 실전 문제  1 : 부품 찾기

---

참고 문제 : [https://www.acmicpc.net/problem/1920](https://www.acmicpc.net/problem/10815) / https://www.acmicpc.net/problem/10816

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 가게 부품
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);

        // 2. 손님 확인 요소
        int M = Integer.parseInt(br.readLine());
        int[] targets = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        // 3. 이진 탐색
        for(int target : targets) {
            boolean isContain = false;
            int max = N - 1;
            int min = 0;
            while(max >= min) {
                int mid = (max + min) / 2;
                // System.out.println("mid : " + mid + " min : " + min + " max : " + max);
                if(numbers[mid] == target) {
                    isContain = true;
                    break;
                } else if (numbers[mid] > target) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            }

            System.out.print((isContain) ? "yes " : "no ");
        }
    }
}
```

**이진 탐색**으로 푸는 방법 외에도, **계수 정렬**, **집합 자료형** 등 여러가지 방법으로 풀 수 있다.

### 실전 문제 2 : 떡볶이 떡 만들기

---

참고 문제 : https://www.acmicpc.net/problem/1654 / https://www.acmicpc.net/problem/2805 / https://www.acmicpc.net/problem/2512

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // 1. 입력 및 정렬
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] riceCake = new int[M];
        for(int i = 0; i < N; i++) {
            riceCake[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(riceCake);

        // 2. 이진 탐색
        int max = riceCake[N - 1];
        int min = riceCake[0];
        int result = 0;
        while(max >= min) {
            int mid = (max + min) / 2;
            // System.out.println("mid : " + mid + " max : " + max + " min : " + min);
            int sum = 0;
            for(int r : riceCake) {
                sum += ((r - mid) > 0) ? r - mid : 0;
            }

            if(sum < M) {
                max = mid - 1;
            } else {
                result = mid;
                min = mid + 1;
            }
        }

        System.out.println(result);
    }
}
```

## ✨ 참고 자료

---

상단 참고