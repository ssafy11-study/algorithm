// Subject: Study of Algorithm with SSAFY
// ProblemNo: B20313
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 1000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct road{
    int U, V, T[101];
    road():U(-1), V(-1) {}
    road(int u, int v, int t):U(u), V(v){ T[0] = t; }
} r[2000];

struct info{
    lld tar, k, idx; //var idx also used with dist
};
struct cmp{
    bool operator()(info a, info b){
        return a.idx > b.idx;
    }
};

int N, M, K, A, B, u, v, t;
lld dist[MX][101];
vector<info> gph[MX];
priority_queue<info, vector<info>, cmp> pq;

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> M >> A >> B; A--; B--;
    for(int i = 0; i < M; i++){
        cin >> u >> v >> t; u--; v--;
        gph[u].push_back({v, -1, i});
        gph[v].push_back({u, -1, i});
        r[i] = road(u, v, t);
    }
    cin >> K;
    for(int i = 1; i <= K; i++){
        for(int j = 0; j < M; j++) cin >> r[j].T[i];
    }
    
    for(int i = 0; i < N; i++) for(int j = 0; j <= K; j++) dist[i][j] = 1e14;
    dist[A][0] = 0;
    pq.push({A, 0, dist[A][0]});
    
    while(!pq.empty()){
        info now = pq.top(); pq.pop();
        if(dist[now.tar][now.k] != now.idx) continue;
        for(auto next : gph[now.tar]){
            for(int k = now.k; k <= K; k++){
                if(dist[next.tar][k] > now.idx + r[next.idx].T[k]){
                    dist[next.tar][k] = now.idx + r[next.idx].T[k];
                    pq.push({next.tar, k, dist[next.tar][k]});
                }
            }
        }
    }
    lld res = 1e13;
    for(int i = 0; i <= K; i++) res = min(res, dist[B][i]);
    cout << res;

    return 0;
}
