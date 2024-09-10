import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;




/*
4 5
00110
00011
11111
00000

재귀호출이라는거는 A B C D E
* */

public class DrinkIce {

    static int n;
    static int m;
    static int count;
    static boolean counted;
    static int functionCount = 0;
    public static void main(String[] args) throws Exception{
        ///칸막이 있으면 1
        //구멍 뚫려있으면 연결된거
        //행렬식으로 4 x 5 얼음틀 생성 세로 가로
        //

        BufferedReader bufferedReader
                =new BufferedReader(new InputStreamReader(System.in));

        String[] line1 = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(line1[0]);
        m = Integer.parseInt(line1[1]);

        String line;

        int[][] data = new int[n][m];//0 0 n이 올라가면 남 m이 올라가면 동

        for (int j = 0; j < n; j++) {
            line = bufferedReader.readLine();
            int[] oneLineArr= Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
            data[j] = oneLineArr;
        }//End of For

        System.out.printf("n :: %d, m :: %d \n",n,m);
        for (int[] ints :data) {
            System.out.println(Arrays.toString(ints));
        }


        //북이야? 그러면 y=0이야. -1,0
        //서야? 북과 순서 반대니 0,-1
        //남이야? 북과 부호 반대니 1,0
        //동이야? 0,1
        //


//        List<LinkedList<Integer>> graph = new ArrayList<>(n);
        boolean[][] visited = new boolean[n][m];
        int order = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.printf("[%d,%d]를 기준으로 시작해서 아이스크림 만들수 있는지 찾을겁니다 :: %d회\n",i,j,order);
                dfs(data,i,j,visited,counted);
                functionCount = 0;
                counted=false;
                System.out.printf("counted :: %s\n", String.valueOf(false));
                order++;
            }//End of For
        }//End of For


        System.out.println("visited 표");

        int[][] visitedInt
                = Arrays.stream(visited)
                        .map(row -> IntStream.range(0,row.length)
                                        .map(i->row[i] ? 1 : 0)
                                        .toArray()
                                ).toArray(int[][]::new);

                //boolean[] int[]로 바꺼야함.
        System.out.printf("count :: %d\n",count);

        for (int[] ints : visitedInt) {
            System.out.println(Arrays.toString(ints));
        }

//
//        for (int i = 0; i < n; i++) {
//            graph.add(new LinkedList<>());
//        }//End of For

        //그래프 정보 추가
        //이게 어려워. graph.get(i)하고 상하좌우의 value를 담아야 해.

//        for (int i = 0; i < n; i++) {
//            graph.get(i).
//        }//End of For


        //0이면 갈 수 있고 1이면 갈 수 없어.
        //노드 값은 좌표값인거여.
        //링크드리스트로하면
        //0번부터 19번까지 노드야.
        // 링크드 리스트인거로 하자.
        //0번 부터 19번까지 상하좌우
    }//End Of Main

    static void dfs(int[][] data, int x, int y, boolean[][] visited, boolean counted){
        functionCount++;
        int[] dx = {-1, 0, 1, 0};//북서남동
        int[] dy = {0, -1, 0, 1};

        //북서남동 반복, 동쪽을 봣는데 0이면 탐색하고 1이면 탐색못해. 그렇게 다 찾으면 됨. 그걸 모든 요소에 반복.

        if(data[x][y] == 0 && !visited[x][y]){
            visited[x][y] = true;
            System.out.printf("[%d,%d]를 방문 완료했습니다.\n",x,y);
        }

        for (int i = 0; i < dx.length; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            //값이 0이면서 false 즉 방문 안한거여야만 방문할거야. newX나 newY가 범위에 벗어나지 않았는지 부터 봐야해.
            if(newX >= 0 && newX < n && newY >= 0 && newY < m){
                if(!visited[newX][newY]){
                    if(data[newX][newY] == 0) {

                        String direction = switch (i) {
                            case 0 -> "북";
                            case 1 -> "서";
                            case 2 -> "남";
                            case 3 -> "동";
                            default -> "오류";
                        };

                        System.out.printf("현재 위치 :: [%d,%d]이고, ",x,y);
                        System.out.printf("%s쪽 :: [%d,%d]를 방문합니다.\n",direction,newX,newY);
//                        visited[newX][newY] = true;

                        if(!counted){
                            count++;
                            counted=true;
                            System.out.printf("아이스크림수를 세지 않았으므로 셉니다. count :: %d\n",count);
                        }


                        dfs(data,newX,newY,visited,counted);
                    }
                }
            }

        }//End of For
        System.out.printf("%d번째 함수 :: 재귀호출이 끝났습니다.\n",functionCount);
        functionCount--;
    }//End of dfs
}
