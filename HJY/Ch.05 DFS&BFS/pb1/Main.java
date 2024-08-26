import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    public static int n, m;
    public static int[][] graph = new int [1000][1000];

    //
    public static boolean dfs(int x, int y) {
        
        //범위 확인 후 벗어나면 탐색 종료
        if(x <= -1 || x >= n || y <=-1 || y >= m) {
            return false;
        }

        if(graph[x][y] == 0) {
            graph[x][y] = 1;

            //모든 위치 호출하기
            dfs(x-1, y);
            dfs(x, y-1);
            dfs(x+1, y);
            dfs(x, y+1);
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        //맵 정보 입력
        for(int i=0 ; i<n ; i++) {
            String str = sc.nextLine();
            for(int j=0 ; j<m ; j++) {
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        int result = 0;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(dfs(i,j)) {
                    result +=1;
                }
            }
        }
        System.out.println(result);
    }
}