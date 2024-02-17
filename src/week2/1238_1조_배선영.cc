#include <iostream>
#include <vector>
#include <queue>
#define MAX 1002
using namespace std;

vector<pair<int, int>> v[MAX];
int N, M, X;
int maxPrice = -1; // 비용 갱신
int result = 0;
int dis[MAX] = { 0 }; // 파티 참석 후 마을로 돌아오는 거리 저장

void init() {
    for (int i = 0; i < MAX; i++) {
        dis[i] = 987654321;
    }
}

void graph(int start, int end) {
    // 우선 순위 큐
    // 거리 계산 배열

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    init();
    pq.push({ 0, start}); // 거리 값, 시작 위치
    dis[start] = 0;

    while (!pq.empty()) {
        int cnode = pq.top().second;
        int cnum = pq.top().first;
        pq.pop();

        if (cnode == end) {
            result = dis[cnode];
            break;
        }

        for (int i = 0; i < v[cnode].size(); i++) {
            // 다음 노드로 이동
            // num에 다음 노드까지 비용 더해서 최단 거리 갱신
            int nnode = v[cnode][i].first;
            int nnum = v[cnode][i].second + cnum;

            if (nnum < dis[nnode]) {
                dis[nnode] = nnum;
                pq.push({ nnum, nnode });
            }
        }
    }
}

int main() {
    cin >> N >> M >> X;
    int A, B, T;

    for (int i = 0; i < M; i++) {
        cin >> A >> B >> T;
        v[A].push_back({ B,T });
    }

    for (int i = 1; i <= N; i++) {
        // 파티 갈 때 
        graph(i, X);
        int cost1 = result;
        // 집으로 올 때
        graph(X, i);
        int cost2 = result;
        maxPrice = max(cost1 + cost2, maxPrice);
    }
    cout << maxPrice << '\n';
}