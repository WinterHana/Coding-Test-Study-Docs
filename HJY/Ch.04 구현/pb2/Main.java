import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int n, m, x, y, direction;

    public static int[][] d = new int[50][50];

    public static int[][] arr = new int[50][50];

    public static int dx[] = {-1, 0, 1, 0};
    public static int dy[] = {0, 1, 0, -1};

    public static void left_turn() {
        direction -= 1;
        if(direction == -1) {
            direction = 3;
        }
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //맵 크기 입력 받기
        n = sc.nextInt();
        m = sc.nextInt();

        //현재 캐릭터의 좌표 및 방향 입력 받기
        x = sc.nextInt();
        y = sc.nextInt();
        direction = sc.nextInt();

        d[x][y] = 1;

        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int count = 1;
        int turn = 0;
        while (true) {
            left_turn();
            int nx = x + dx[direction];
            int ny = y + dy[direction];

            if(d[nx][ny] == 0 && arr[nx][ny] == 0) {
                d[nx][ny] = 1;
                x = nx;
                y = ny;
                count += 1;
                turn = 0;
                continue;
            }
            else turn += 1;

            if(turn == 4) {
                nx = x - dx[direction];
                ny = y - dy[direction];

                if(arr[nx][ny] ==0) {
                    x = nx;
                    y = ny;
                }
                else break;
                turn = 0;
            }
        }
        
        System.out.println(count);
    }
}