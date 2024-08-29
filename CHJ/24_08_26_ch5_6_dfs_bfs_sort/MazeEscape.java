

import org.w3c.dom.Node;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


/*


5 6
101010
111111
000001
111111
111111

1->2 3 7 4
2->5 6 8 4

링크드리스트에는 객체인덱스를 담아
graphData[0]은 (0,0)이야.

연결리스트 노드에 담는 정보는 바뀌는 정보가 아니여야해. 왜냐면 중복되기 때문이야.
1에도 4가있고 2에도 4가 있는데 각각의 노드는 연동이 안돼. 서로 다른 객체야

Node[][] record 이런식으로 따로 만들어놓아야해.
기록용 노드와 연결리스트 노드는 따로 구분해야 함.

연결리스트 노드에 담아야 할 정보 : 다음 위치에 대한 정보(다음 위치 인덱스)
기록용 노드에 담아야 할 정보 : 실시간으로 수정할 정보


* */
public class MazeEscape {

    static class Node {

        public Node(int idx, int x, int y, int bakemono) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.bakemono = bakemono;
        }

        int idx;
        int x;
        int y;
        int bakemono;
//        int miniDistance;

        public int getIdx(){
            return this.idx;
        }
        public int getX(){
            return this.x;
        }
        public int getY(){
            return this.y;
        }
        public int getBakemono(){
            return this.bakemono;
        }
//        public int getMiniDistance(){
//            return this.miniDistance;
//        }
//        public void setIdx(int idx){
//            this.idx = idx;
//        }
//        public void setX(int x){
//            this.x = x;
//        }
//        public void setY(int y){
//            this.y = y;
//        }
//        public void setBakemono(int bakemono) {
//            this.bakemono = bakemono;
//        }
//        public void setMiniDistance(int miniDistance) {
//            this.miniDistance = miniDistance;
//        }

        @Override
        public String toString() {
            return String.format("( %d (%d,%d), %d)",idx, x, y, bakemono);
        }

    }

    static int n;
    static int m;
    static int functionCount;
    static int minDistance = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception{

        //N M 크기임
        //미로에 괴물잇음
        //첫위치 1,1임 0,0이란게 없음
        //괴물잇으면 0 없으면 1
        //탈출을 위한 최소거리 최소로 건너는 칸의 개수
        //1,1에서 N,M으로 가야함

        //있는길인지 확인하고/ 북서남동 확인하고 1이면 건너야해
        //거기에다 남쪽 동쪽에 가중치를 둬야해. 서쪽 북쪽에는 가중치가 낮아
        //최대한 남쪽 동쪽으로 가야함
        //가중치두려면 노드를 객체로 만들어야하지? 아니면 노드를 리스트로 만들어.


        //연결리스트로 하면 모든길에 대해 북서남동을 만들고
        //남쪽 동쪽중에 택해야되는데 남쪽으로 가면 막힌길이야. 그러면 동쪽으로 가야해.
        //막힌길인지 판단해야되지? 막힌길로도 가봐 그리고 막히면 버려.

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = bufferedReader.readLine().split(" ");

        n = Integer.parseInt(inputs[0]);
        m = Integer.parseInt(inputs[1]);

        List<LinkedList<Node>> graphData = new ArrayList<>(n*m);

        for (int i = 0; i < n*m; i++) {
            graphData.add(new LinkedList<>());
        }//End of For

        int[][] map = new int[n][m];
        int[][] visited = new int[n][m];
        int[][] miniDistance = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(bufferedReader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        }//End of For
        for (int[] line : map) {
            System.out.println(Arrays.toString(line));
        }

        miniDistance[0][0] = 1;

        int count = 0;

        //북서남동
        //-- ++
        //xy xy
        int[] dx = {-1,0,1,0};
        int[] dy = {0,-1,0,1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];//4,3이라면 4*n + 3 아니야?
                    int ny = j + dy[k];
                    if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                        graphData.get(count).add(new Node(nx*m + ny ,nx,ny,map[nx][ny]));
                    }
                }//End of For
                count++;
            }//End of For
        }//End of For

        for (LinkedList<Node> nodes : graphData) {
            System.out.println(nodes);//0,0부터 4,5까지여야함 ㅇㅇ 성공햇음
        }
        //연결을 다해놧고 이제 반복해야돼.

        dfs(graphData,0,0,0, visited,miniDistance);

        System.out.println("miniDistance");
        for (int[] ints : miniDistance) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("visited");
        for (int[] ints : visited) {
            System.out.println(Arrays.toString(ints));
        }


    }//End Of Main

    //연결리스트 반복할거고, x,y시작할거고 걸을때마다 최소거리 구할거임. 모든 길 다 걸을 거임.
    //node.get(x) node.get(y)
    static void dfs(List<LinkedList<Node>> graphData, int idx, int x, int y, int[][] visited, int[][] miniDistance) {
        functionCount++;
        System.out.printf("%d번째 재귀호출 시작 :: 방문한 곳 :: (%d,%d) \n",functionCount,x,y);

        //탈출 조건 확인 :: 얘를 안하면, 무한반복이 되는건 아님. 모든 경로를 다 돌 것이다.
        if (x == n - 1 && y == m - 1 && miniDistance[x][y] != 0) {
            minDistance = Math.min(minDistance,miniDistance[x][y]);
            System.out.println("\u001B[31m@@@@@@@@@@@@@최소 거리를 구했습니다."+minDistance);
            System.out.println("miniDistance");
            for (int[] ints : miniDistance) {
                System.out.println(Arrays.toString(ints));
            }
            System.out.println("\u001B[0m");
            return;
        }

        visited[x][y] = 1;//얘를 탈출조건 위로 올리면, 마지막 공간을 방문을 하고 탈출을 한다. 탈출은 하나의 case가 완성되었을때 하는거다.
        //그러면 마지막 공간은 1이 되기에 다음 case에는 이미 간 곳이 되어버린다. 그러면 x = n-1, y= m-1이 안되니까 영원히 탈출 못하고 모든 경로를 다 돌게 된다.




        //방문할 곳 정하기 방문하는 조건
        for (Node node : graphData.get(idx)) {
            System.out.println("idx :: " + idx + " node :: " + node);
            if(node.getBakemono() == 1 && visited[node.getX()][node.getY()] == 0) {
                //노드를 방문하기로 결정했다.
                //방문할 노드의 최단거리를 올린다.
                //방문조건 if문 안과 그 위 바깥 visited[x][y]의 차이는 뭐냐?
                //뭐냐면 여기는 어느 방을 탐색할 지 결정하는 곳이고, 위에는 탐색이 끝나 방문하는 곳이다.
                //최단거리는 여기서 구해야한다. 현재 위치와 다음 탐색할 방에 대한 정보(Node)는 여기서 얻는다.
                //여기 바깥에서는 다음 탐색할 방에 대한 정보가 없다.
                miniDistance[node.getX()][node.getY()] = miniDistance[x][y] + 1;
                System.out.println("idx :: " + idx + " node :: " + node + "를 방문하기로 결정");
                dfs(graphData, node.getIdx(), node.getX(), node.getY(), visited, miniDistance);
            }
        }

        //다시 방문 해제. 전부 방문하고 방문해제함. 이전 갈래길 다시 건너보기임. 출력해보면 안다.
        System.out.println("막다른 길에 도달했음");
        visited[x][y] = 0;
        System.out.printf("%d번째 재귀호출 종료 :: \n",functionCount);
        functionCount--;
    }
}

/*

5 6
101010
111111
000001
111111
111111


* */