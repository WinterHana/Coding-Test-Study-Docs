## 🗨️ 개념

---

(자료 구조 개념은 책 보면서 넘어가기)

### DFS(깊이 우선 탐색, Depth First Search)

그래프에서 깊은 부분을 우선적으로 탐색

한 정점에서 시작해 다음 경로로 넘어가기 전에 해당 경로를 완벽하게 탐색할 때 사용한다.

- 미로를 탐색할 때, 해당 분기에서 갈 수 있을 때까지 계속 가다가 더 이상 갈 수 없게 되면 다시 가장 가까운 갈림길로 돌아와서 다른 방향으로 다시 탐색하는 방법
- 모든 경우를 하나하나 다 탐색할 때 사용한다.
- 검색 속도는 BFS에 비해 느리다

### BFS(너비 우선 탐색, Bread First Search)

그래프에서 가장 가까운 부분을 우선적으로 탐색

한 정점에서 가장 인접한 노드를 먼저 넓게 탐색하면서 깊이 내려가며 탐색한다.

- 최단 경로(다익스트라, 플로이드)를 찾는데 활용한다.

참고 문제 : 백준 1260번_DFS와 BFS(https://www.acmicpc.net/problem/1260)

## 📌 문제 풀이

---

### 실전 문제  1 : 음료수 얼려 먹기

---

참고 문제 : 백준 1012번_유기농 배추(https://www.acmicpc.net/problem/1012)

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] graph; // 그래프
    // static boolean[][] check;
    static int N;
    static int M;

    static void dfs(int i, int j) {
        // check[i][j] = true;
        graph[i][j] = 1;

        if(i - 1 >= 0 && graph[i - 1][j] == 0) dfs(i - 1, j);
        if(i + 1 < N && graph[i + 1][j] == 0) dfs(i + 1, j);
        if(j - 1 >= 0 && graph[i][j - 1] == 0) dfs(i, j - 1);
        if(j + 1 < M && graph[i][j + 1] == 0) dfs(i, j + 1);
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        // check = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            String[] numbers = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(numbers[j]);
                // if(graph[i][j] == 1) check[i][j] = true;
            }
        }

        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(graph[i][j] == 0) {
                    dfs(i, j);
                    count++;
                }

            }
        }

        System.out.println(count);
//        for(int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++) {
//                System.out.print(graph[i][j]);
//            }
//            System.out.println();
//        }
    }
}
```

### 실전 문제 2 : 미로 탈출

---

참고 문제 : 백준 2178번_미로 탐색 - 동일 문제
(https://www.acmicpc.net/problem/2178)

```jsx

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * 괴물이 있는 부분 : 0
 * 괴물이 없는 부분 : 1
 * 시작칸과 마지막 칸은 항상 1
 * 칸을 셀 때는 시작 칸과 마지막 칸을 모두 포함해서 계산한다.
 */
class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static int[][] graph;
    public static LinkedList<Point> queue;

    public static int bfs(int N, int M) {
        queue = new LinkedList<>();
        Point start = new Point(0, 0);
        queue.add(start);
        int count = 1;

        while(!queue.isEmpty()) {
            Point p = queue.poll();

//            if(p.x - 1 >= 0 && graph[p.x - 1][p.y] == 1) {
//                graph[p.x - 1][p.y] = ++count;
//                queue.add(new Point(p.x - 1, p.y));
//            } else if(p.x + 1 < N && graph[p.x + 1][p.y] == 1) {
//                graph[p.x + 1][p.y] = ++count;
//                queue.add(new Point(p.x + 1, p.y));
//            } else if(p.y - 1 >= 0 && graph[p.x][p.y - 1] == 1) {
//                graph[p.x][p.y - 1] = ++count;
//                queue.add(new Point(p.x, p.y - 1));
//            } else if(p.y + 1 < M && graph[p.x][p.y + 1] == 1) {
//                graph[p.x][p.y + 1] = ++count;
//                queue.add(new Point(p.x, p.y + 1));
//            }

//            if(p.x + 1 < N && graph[p.x + 1][p.y] == 1) {
//                graph[p.x + 1][p.y] = ++count;
//                queue.add(new Point(p.x + 1, p.y));
//            }  else if(p.y + 1 < M && graph[p.x][p.y + 1] == 1) {
//                graph[p.x][p.y + 1] = ++count;
//                queue.add(new Point(p.x, p.y + 1));
//            }

            if(p.x - 1 >= 0 && graph[p.x - 1][p.y] == 1) {
                graph[p.x - 1][p.y] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x - 1, p.y));
            }
            if(p.x + 1 < N && graph[p.x + 1][p.y] == 1) {
                graph[p.x + 1][p.y] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x + 1, p.y));
            }
            if(p.y - 1 >= 0 && graph[p.x][p.y - 1] == 1) {
                graph[p.x][p.y - 1] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y - 1));
            }
            if(p.y + 1 < M && graph[p.x][p.y + 1] == 1) {
                graph[p.x][p.y + 1] = graph[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y + 1));
            }

        }

        return graph[N - 1][M - 1];
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(line[j]);
            }
        }

        int result = bfs(N, M);
        System.out.println(result);

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                System.out.print(graph[i][j]);
            }
            System.out.println();
        }
    }
}
```

## ✨ 참고 자료

---

1. DFS, BFS

https://hstory0208.tistory.com/entry/알고리즘-깊이-우선-탐색DFS와-너비-우선-탐색BFS

1. **StringTokenizer vs split**

https://inpa.tistory.com/entry/JAVA-☕-Split-StringTokenizer-문자열-자르기-비교하기#자바_문자열_자르기

https://docs.oracle.com/javase/8/docs/api/java/util/StringTokenizer.html

1. Input data

(실전 문제 1)

15 14
00000111100000
11111101111110
11011101101110
11011101100000
11011111111111
11011111111100
11000000011111
01111111111111
00000000011111
01111111111000
00011111111000
00000001111000
11111111110011
11100011111111
11100011111111

(실전 문제 2)

5 6
101010
111111
000001
111111
111111

3 3
110
010
011