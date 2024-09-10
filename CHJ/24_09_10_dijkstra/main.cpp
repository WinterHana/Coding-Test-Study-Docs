#include <iostream>
#include <vector>
#include <queue>
#include <limits>

using namespace std;

const int INF = numeric_limits<int>::max(); // 무한대 값 설정

// 노드의 개수, 간선의 개수
int n, m;
vector<pair<int, int>> graph[100001]; // 그래프 정보 저장
int min_distance[100001]; // 최단 거리 테이블

void dijkstra(int start) {
    // 우선순위 큐 사용. (거리, 노드 번호)
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    // 시작 노드로 가기 위한 최단 경로는 0으로 설정하고, 큐에 삽입
    pq.push({0, start});
    min_distance[start] = 0;

    while (!pq.empty()) {
        // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        int dist = pq.top().first;
        int now = pq.top().second;
        pq.pop();

        // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        if (min_distance[now] < dist) continue;

        // 현재 노드와 연결된 다른 인접한 노드들을 확인
        for (int i = 0; i < graph[now].size(); i++) {
            int cost = dist + graph[now][i].second; // 현재 노드를 거쳐서 다른 노드로 이동하는 거리
            if (cost < min_distance[graph[now][i].first]) {
                min_distance[graph[now][i].first] = cost;
                pq.push({cost, graph[now][i].first});
            }
        }
    }
}

int main() {
    cin >> n >> m; // 노드 개수와 간선 개수 입력받기
    int start;
    cin >> start; // 시작 노드 번호 입력받기

    // 최단 거리 테이블을 모두 무한대로 초기화
    fill(min_distance, min_distance + 100001, INF);

    // 간선 정보 입력받기
    for (int i = 0; i < m; i++) {
        int a, b, c;
        cin >> a >> b >> c;
        graph[a].push_back({b, c});
    }

    // 다익스트라 알고리즘을 수행
    dijkstra(start);

    // 모든 노드로 가기 위한 최단 거리를 출력
    for (int i = 1; i <= n; i++) {
        if (min_distance[i] == INF) {
            cout << "INFINITY" << endl; // 도달할 수 없는 경우
        } else {
            cout << min_distance[i] << endl; // 도달할 수 있는 경우 거리 출력
        }
    }

    return 0;
}

/*
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */
