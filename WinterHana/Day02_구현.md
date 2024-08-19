## 🗨️ 개념

구현 유형의 문제 = 풀이를 떠올리는 것은 쉽지만 소스코드로 옮기기 어려운 문제

흔히들 ‘피지컬을 요구하는’ 문제라고 볼 수 있다!

(예시 : 코드가 길어지는 문제, 특정 소수점 자리까지 출력하는 문제, 문자열이 입력으로 주어졌을 때 한 문자 단위로 끊어서 리스트에 넣어야 하는 문제(파싱) 등..)

여기서는 완전 탐색과 시뮬레이션 유형을 한 번 보도록 하자

- 완전 탐색 : 모든 경우의 수를 주저 없이 다 계산하는 해결 방법
- 시뮬레이션 : 문제에서 제시한 알고리즘을 한 단계씩 차례대로 직접 수행해야 하는 문제

## 📌 문제 풀이

### 예제 문제  1 : 상하좌우

---

참고 문제 : 없음

1. 처음 풀었을 때 : 직관적으로 접근

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int N;
    public Point(int N) {
        this.N = N;
        this.x = 1;
        this.y = 1;
    }

    public void move(String s) {
        if (s.equals("R")) {
            y++;
            if (y > N) y--;
        } else if (s.equals("L")) {
            y--;
            if (y < 1) y++;
        } else if (s.equals("U")) {
            x--;
            if (x < 1) x++;
        } else if (s.equals("D")) {
            x++;
            if (x > N) x--;
        }
    }

    public void print() {
        System.out.println(x + " " + y);
    }

}
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point point = new Point(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()) {
            String s = st.nextToken();
            point.move(s);
        }

        point.print();
    }
}
```

1. 답지 활용 : 배열을 이용해서 좀 더 유연하게 풀이함

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;
    int N;
    int[] dx;
    int[] dy;
    String[] orders;

    public Point(int N) {
        this.N = N;
        this.x = 1;
        this.y = 1;
        this.dx = new int[] {0, 0, -1, 1};
        this.dy = new int[] {1, -1, 0, 0};
        this.orders = new String[] {"R", "L", "U", "D"};
    }

    public void move(String s) {
        int nx;
        int ny;
        for(int i = 0; i < orders.length; i++) {
            if(s.equals(orders[i])) {
                nx = this.x + dx[i];
                ny = this.y + dy[i];
                if(nx < 1 || nx > this.N || ny < 1 || ny > this.N) {
                    // blank
                } else {
                    this.x = nx;
                    this.y = ny;
                }
                break;
            }
        }
    }

    public void print() {
        System.out.println(x + " " + y);
    }

}
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Point point = new Point(N);

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreElements()) {
            String s = st.nextToken();
            point.move(s);
        }

        point.print();
    }
}
```

### 예제 문제 2 : 시각

---

참고 문제 : 없음

간단하게 생각하면 될 껄 좀 꼬아서 생각하다 시간 좀 걸림..

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    String hour = String.valueOf(i);
                    String min = String.valueOf(j);
                    String second = String.valueOf(k);
                    if(hour.contains("3") || min.contains("3") || second.contains("3")) count++;
                }
            }
        }

        System.out.println(count);
    }
}
```

### 실전 문제 1 : 왕실의 나이트

---

참고 문제 : 없음

Java 모범답안 : 

https://github.com/ndb796/python-for-coding-test/blob/master/4/3.java

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String order = br.readLine();
        String[] positions = order.split("");
        int x = (int) (positions[0].charAt(0)) - 96;
        int y = Integer.parseInt(positions[1]);

        // System.out.println("x : " + x + " y : " + y);

        int[] dx = {2, 2, -2, -2, 1, -1, 1, -1};
        int[] dy = {1, -1, 1, -1, 2, 2, -2, -2};
        int size = 8;

        int count = 0;
        for(int i = 0; i < dx.length; i++) {
		        // 도착할 위치
            int nx = x + dx[i];
            int ny = y + dy[i];
						// 점검
            if(nx >= 1 && nx <= size && ny >= 1 && ny <= size) {
                count++;
            }
        }

        System.out.println(count);
    }
}
```

### 실전 문제 2 : 게임 개발

---

참고 문제 : 없음

Java 모범답안 : 

https://github.com/ndb796/python-for-coding-test/blob/master/4/4.java

```jsx
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] field = new int[N][M];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int face = Integer.parseInt(st.nextToken());
        
        // 오른쪽으로 도는게 아니라 왼쪽으로 도는거임 ^^7
        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, -1, 0, 1};

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        int count = 0;
        while(true) {
//            System.out.println(x + " " + y);
//            System.out.println(face);
//            System.out.println(count);
            int nx = x + moveX[face % 4];
            int ny = y + moveY[face % 4];
            if (count == 4) {
                nx = x + moveX[(face + 2) % 4];
                ny = y + moveY[(face + 2) % 4];
                if(field[nx][ny] == 1) {
                    break;
                } else {
                    count = 0;
                    x = nx;
                    y = ny;
                }
            } else if (field[nx][ny] == 0) {
                count = 0;
                field[nx][ny] = -1;
                x = nx;
                y = ny;
            } else if (field[nx][ny] == 1 || field[nx][ny] == -1) {
                count++;
                face++;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(field[i][j] == -1) result++;
            }
        }

        System.out.println(result);
    }
}
```

## ✨ 참고 자료

없음