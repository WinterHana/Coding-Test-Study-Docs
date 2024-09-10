#include <bits/stdc++.h>
#define INF 1e9 // 무한을 의미하는 값으로 10억을 설정

using namespace std;

// 노드의 개수(N), 간선의 개수(M), 시작 노드 번호(Start)
int n, m, start;
// 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
vector<pair<int, int> > graph[30001];
// 최단 거리 테이블 만들기
int d[30001];

void dijkstra(int start) {
    priority_queue<pair<int, int> > pq;
    // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
    pq.push({0, start});
    d[start] = 0;
    while (!pq.empty()) { // 큐가 비어있지 않다면
        // 가장 최단 거리가 짧은 노드에 대한 정보 꺼내기
        int dist = -pq.top().first; // 현재 노드까지의 비용, 최단시간
        int now = pq.top().second; // 현재 노드번호
        pq.pop();
        // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
        // 무한이 아니면 모두 처리된 적이 있는거다.
        if (d[now] < dist) continue;
        // 현재 노드와 연결된 다른 인접한 노드들을 확인
        for (int i = 0; i < graph[now].size(); i++) {

            //현재까지의 비용 + 현재 노드에서 인접 노드로 이동하는 데 비용이 graph[now][i].second이고
            int cost = dist + graph[now][i].second;// 그래프는 second가 비용, 우선순위 큐는 first가 비용
            // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
            // 이미 저장된 최단거리 vs 현재에서 구한 최단거리
            if (cost < d[graph[now][i].first]) {
                d[graph[now][i].first] = cost;
                pq.push(make_pair(-cost, graph[now][i].first));
            }
        }
    }
}

int main(void) {
    cin >> n >> m >> start;

    // 모든 간선 정보를 입력받기
    // 노드와 간선에 대한 정보가 있는 그래프를 초기화
    for (int i = 0; i < m; i++) {
        int x, y, z;
        cin >> x >> y >> z;
        // X번 노드에서 Y번 노드로 가는 시간(비용)이 Z라는 의미
        graph[x].push_back({y, z});
    }

    // 최단 거리 테이블을 모두 무한으로 초기화
    fill(d, d + 30001, INF);
    
    // 다익스트라 알고리즘을 수행
    dijkstra(start);

    // 도달할 수 있는 노드의 개수
    int count = 0;
    // 도달할 수 있는 노드 중에서, 가장 멀리 있는 노드와의 최단 거리
    int maxDistance = 0;
    for (int i = 1; i <= n; i++) {
        // 도달할 수 있는 노드인 경우
        if (d[i] != INF) {
            count += 1;
            maxDistance = max(maxDistance, d[i]);
        }
    }

    // 시작 노드는 제외해야 하므로 count - 1을 출력
    cout << count - 1 << ' ' << maxDistance << '\n';
}