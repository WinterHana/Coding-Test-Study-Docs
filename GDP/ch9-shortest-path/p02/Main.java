import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        Map<Integer, Set<Edge>> outsource = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            outsource.put(i, new HashSet<>());
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            outsource.get(x).add(new Edge(x, y, z));
        }

        int[] answer = solution(n, outsource, c);

        System.out.println(answer[0] + " " + answer[1]);

        sc.close();
    }

    static int[] solution(int n, Map<Integer, Set<Edge>> outsource, int c) {
        Map<Integer, Integer> distanceMap = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            if (i == c) {
                distanceMap.put(i, 0);
            } else {
                distanceMap.put(i, Integer.MAX_VALUE);
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((n1, n2) -> n1.dist - n2.dist);
        pq.add(new Node(c, 0));

        Set<Integer> visited = new HashSet<>();

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            visited.add(node.node);

            Set<Edge> oursourceEdges = outsource.get(node.node);

            for (Edge edge : oursourceEdges) {
                if (visited.contains(edge.tar)) {
                    continue;
                }

                int a = distanceMap.get(edge.tar);
                int b = distanceMap.get(edge.src) + edge.w;

                if (a > b) {
                    distanceMap.put(edge.tar, b);
                }
                pq.add(new Node(edge.tar, b));
            }
        }

        return new int[] {
            (int)distanceMap.values().stream().filter((d) -> d < Integer.MAX_VALUE && d > 0).count(),
            distanceMap.values().stream().filter((d) -> d < Integer.MAX_VALUE).max((n1, n2) -> n1 - n2).get()
        };
    }

    static class Edge {
        int src;
        int tar;
        int w;

        public Edge(int src, int tar, int w) {
            this.src = src;
            this.tar = tar;
            this.w = w;
        }
    }

    static class Node {
        int node;
        int dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}