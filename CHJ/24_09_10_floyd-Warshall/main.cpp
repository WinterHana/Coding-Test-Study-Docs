#include <iostream>
#include <vector>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max(); // 무한대 값 설정

int main() {
    int n, m; // 노드의 개수(n)와 간선의 개수(m) 입력
    cin >> n >> m;

    // 2차원 리스트(그래프 표현), 모든 값을 무한으로 초기화
    vector<vector<int>> graph(n + 1, vector<int>(n + 1, INF));

    // 자기 자신에게 가는 비용은 0으로 초기화
    for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
            if (a == b) graph[a][b] = 0;
        }
    }

    // 각 간선에 대한 정보를 입력받아, 그 값으로 초기화
    for (int i = 0; i < m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        graph[a][b] = c; // A에서 B로 가는 비용을 C로 설정
    }

    // 점화식에 따라 플로이드 워셜 알고리즘 수행
    for (int k = 1; k <= n; k++) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                if (graph[a][k] != INF && graph[k][b] != INF) {
                    graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
    }

    // 수행된 결과 출력
    for (int a = 1; a <= n; a++) {
        for (int b = 1; b <= n; b++) {
            // 도달할 수 없는 경우, 무한(INFINITY)라고 출력
            if (graph[a][b] == INF) {
                cout << "INFINITY" << " ";
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                cout << graph[a][b] << " ";
            }
        }
        cout << endl;
    }

    return 0;
}
