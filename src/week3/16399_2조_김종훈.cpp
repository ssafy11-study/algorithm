#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

constexpr ll INF = 1'000'000'000'000'000LL;

ll C, E, D, N;
vector<ll> dist, cost, dp;

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    cin >> C >> E >> D >> N;
    
    if (N == 0) {
        cout << (C >= E * D? 0 : -1) << '\n';
        return 0;
    }
    
    ll remain_dist = D;
    
    dist.assign(N, 0); for (auto& n : dist) cin >> n;
    cost.assign(N, 0); for (auto& n : cost) cin >> n;
    dp.assign(C + 1, 0);
    
    for (int i = 0; i < N; ++i) {
        remain_dist -= dist[i];
        
        vector<ll> tmp(C + 1, INF);
        
        ll need = E * dist[i];
        
        if (C < need) {
            cout << "-1\n";
            return 0;
        }
        
        // 전 주유소에서 채워서 도착할 때
        for (int j = need; j <= C; ++j) {
            tmp[j - need] = dp[j];
        }
        
        // 이번 주유소에서 채울 때
        for (int j = 1; j <= C; ++j) {
            tmp[j] = min(tmp[j], tmp[j - 1] + cost[i]);
        }
        
        dp = move(tmp);
    }
    
    if (C < E * remain_dist) {
        cout << "-1\n";
        return 0;
    }
    
    cout << dp[E * remain_dist] << '\n';
}