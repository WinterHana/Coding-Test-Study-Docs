import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFSExample2 {
    public static void main(String[] args) throws IOException {

        /*
         * 입력값 설명
         * 노드1번에 연결된 노드는 노드2, 노드3, 노드8
         * 노드2번에 연결된 노드는 노드1, 노드7
         * 2 3 8
         * 1 7
         * 1 4 5
         * 3 5
         * 3 4
         * 7
         * 2 6 8
         * 1 7
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드의 개수
        int n = 9;
        //그래프
        List<LinkedList<Integer>> graph = new ArrayList<>(n);
        //방문기록표
        boolean[] visited = new boolean[n];

        // 그래프 초기화
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        // 그래프 정보 추가 (BufferedReader로 입력받기)
        for (int i = 1; i < n; i++) {
            String line = br.readLine();  // 한 줄 입력받기
            String[] parts = line.split(" ");  // 공백 기준으로 문자열 분리
            for (String part : parts) {
                graph.get(i).add(Integer.parseInt(part));  // 각 부분을 정수로 변환하여 그래프에 추가
            }
        }

        // 각 노드의 인접 리스트를 낮은 숫자 순으로 정렬
        for (LinkedList<Integer> list : graph) {
            Collections.sort(list);
        }

        System.out.println("DFS starting from vertex 1:");
        dfs(graph, 1, visited);
    }

    static void dfs(List<LinkedList<Integer>> graph, int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");

        for (int next : graph.get(v)) {
            if (!visited[next]) {
                dfs(graph, next, visited);
            }
        }
    }
}