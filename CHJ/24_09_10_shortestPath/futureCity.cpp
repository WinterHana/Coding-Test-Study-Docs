#include <bits/stdc++.h>
#define INF 1e9
using namespace std;

int n,m;
int graph[101][101];
// graph[a][b]는 노드 a에서 노드 b로 가는 비용
int main(void) {

    cin >> n >> m;

    //최단 거리 테이블을 모두 무한으로 초기화
    //배열의 시작주소와 끝주소
    for (int i = 0; i < 101; ++i) {
        fill(graph[i],graph[i]+101,INF);
    }

    //자기 자신에서 자기 자신으로 가는 비용은 0으로 초기화
    for (int a = 1; a <= n; ++a) {
        for (int b = 1; b <= n; ++b) {
            if (a == b) graph[a][b] = 0;
        }
    }
    //--- 테이블 초기화

    //문제 조건에 따라서 a에서 b로 가는 비용은 1로 설정(간선)
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;
        graph[a][b] = 1;
        graph[b][a] = 1;
    }

    // 거쳐 갈 노드 X와 최종 목적지 노드 K를 입력받기
    int x, k;
    cin >> x >> k;


    // 점화식에 따라 플로이드 워셜 알고리즘을 수행
    //거쳐가는거 생각하지 말고 a에서 b까지의 최단거리를 구하자.
    for (int m = 1; m <= n; m++) {
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                graph[a][b] = min(graph[a][b], graph[a][k] + graph[k][b]);
            }
        }
    }

    //1에서 k를 거쳐 x로 가는 최단거리를 구하는건
    //1에서 k까지의 최단거리와 k에서 x까지의 최단거리를 구하는 것과 같음. 이게 핵심

    // 수행된 결과를 출력
    int distance = graph[1][k] + graph[k][x];

    // 도달할 수 없는 경우, -1을 출력
    if (distance >= INF) {
        cout << "-1" << '\n';
    }
    // 도달할 수 있다면, 최단 거리를 출력
    else {
        cout << distance << '\n';
    }
}


/*
5 7
1 2
1 3
2 4
3 4
3 5
4 5
4 5

마지막 4 5가 x=4 k=5이다.
1에서 k로 그다음 x로 가야한다.
 */