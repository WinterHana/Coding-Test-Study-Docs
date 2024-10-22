## 🗨️ 개념

---

## 1. 선택 정렬

데이터가 무작위로 여러 개 있을 때, 이 중에서 가장 작은 데이터를 선택해 맨 앞에 있는 데이터와 바꾸고, 그 다음 작은 데이터를 선택해 앞에서 두 번째 데이터와 바꾸는 과정을 반복한다. 가장 작은 것을 선택한다는 의미에서 선택 정렬이라고 한다.

## 2. 삽입 정렬

데이터를 하나씩 확인하며, 각 데이터를 적절한 위치에 “삽입”한다. 

현재 리스트에서 데이터가 거의 정렬되어 있는 상태라면 매우 빠르게 동작한다.

⇒ **O(N^2)**

- 버블 정렬

## 3. 퀵 정렬

https://gmlwjd9405.github.io/2018/05/10/algorithm-quick-sort.html#google_vignette

https://gmlwjd9405.github.io/2018/05/08/algorithm-merge-sort.html

기준을 설정한 다음 큰 수와 작은 수를 교환한 후 리스트를 반으로 나누는 방식으로 동작한다.

## 4. 계수 정렬

특정한 조건이 부합할 때만 사용할 수 있지만 매우 빠른 정렬 알고리즘. 다른 정렬과는 달리 비교 기반의 정렬 알고리즘이 아니다.

https://lktprogrammer.tistory.com/48

→ 데이터의 크기 범위가 제한되어 정수 형태로 표현할 수 있을 때만 사용 가능

(예시 : 0 이상 100 이하인 성적 데이터를 정렬할 때)

## 📌 문제 풀이

---

### 실전 문제  1 : 위에서 아래로

---

참고 문제 : 없음

```java
import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[N];

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        for(Integer num : arr) {
            System.out.println(num);
        }
    }
}
```

### 실전 문제 2 : 성적이 낮은 순서로 학생 출력하기

---

참고 문제 : 없음

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return this.score - o.score;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Student[] arr = new Student[N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Student s = new Student(st.nextToken(), Integer.parseInt(st.nextToken()));
            arr[i] = s;
        }

        Arrays.sort(arr);

        for(Student s : arr) {
            System.out.print(s.name + " ");
        }
    }
}
```

### 실전 문제 3 : 두 배열의 원소 교체

---

참고 문제 : 없음

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        Integer[] B = new Integer[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for(int i = 0; i < K; i++) {
            if(A[i] >= B[i]) break;
            else {
                int tmp = A[i];
                A[i] = B[i];
                B[i] = tmp;
            }
        }

        System.out.println(Arrays.stream(A).sum());
    }
}
```

## ✨ 참고 자료

---

상단 참조