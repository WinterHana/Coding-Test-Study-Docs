import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/*
 * 입력값 설명
 * 노드1번에 연결된 노드는 노드2, 노드3, 노드8
 * 노드2번에 연결된 노드는 노드1, 노드7
 2 3 8
 1 7
 1 4 5
 3 5
 3 4
 7
 2 6 8
 1 7
 * */
public class trash {
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader
                = new BufferedReader(new InputStreamReader(System.in));

        int n = 9; // 노드 개수
        List<LinkedList<Integer>> graph = new ArrayList<>(n);
        boolean[] visited = new boolean[n];


        //그래프 제작 : 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }//End of For
        //그래프 제작 : 정보 추가
        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] parts = line.split(" ");
            for (String part : parts ) {
                graph.get(i).add(Integer.parseInt(part));
            }
        }//End of For

        for (LinkedList<Integer> list : graph){
            Collections.sort(list);
        }

        dfs(graph, 1, visited);

    }

    //그래프, 시작위치, 방문기록표
    static void dfs(List<LinkedList<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int next : graph.get(v)) {
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
//        for (int i = 0; i < graph.get(v).size(); i++) {
//            if (!visited[graph.get(v).get(i)]) {
//                dfs(graph, graph.get(v).get(i), visited);
//            }
//        }//End of For



    }

}
