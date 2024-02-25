// Subject: Study of Algorithm with SSAFY
// ProblemNo: B25550
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

int N, M, v[MX][MX];
lld total;

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> M;
    for(int i = 0; i < N; i++) for(int j = 0; j < M; j++) cin >> v[i][j];
    for(int i = 1; i < N - 1; i++){
        for(int j = 1; j < M - 1; j++){
            int ans = v[i][j] - 1;
            for(int k = 0; k < 4; k++) ans = min(ans, v[i + "2011"[k] - '1'][j + "1120"[k] - '1']);
            total += max(ans, 0);
        }
    }
    cout << total;
    
    return 0;
}
