// Subject: Study of Algorithm with SSAFY
// ProblemNo: B6185
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 100
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N, M, route[10000], dist[MX][MX];
lld total;


int main(int argc, char** argv){
    fastio;
    
    cin >> N >> M;
    for(int i = 0; i < M; i++) cin >> route[i], route[i]--;
    for(int i = 0; i < N; i++) for(int j = 0; j < N; j++) cin >> dist[i][j];
    for(int k = 0; k < N; k++){
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(dist[i][j] > dist[i][k] + dist[k][j]){
                    dist[i][j] = dist[i][k] + dist[k][j];
                }
            }
        }
    }
    for(int i = 1; i < M; i++) total += dist[route[i - 1]][route[i]];
    cout << total;

    return 0;
}
