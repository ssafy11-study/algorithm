//https://www.acmicpc.net/submit/16399
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 10001
#define MOD 100000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct station{
    lld s, p;
} v[1001];

lld C, E, D, N, ptr, res;
lld dp[MX][501]; //dist / capacity


int main(int argc, char** argv){
    fastio;

    cin >> C >> E >> D >> N;
    for(int i = 0; i < N; i++) cin >> v[i].s, v[i].s += i? v[i - 1].s : 0;
    for(int i = 0; i < N; i++) cin >> v[i].p;
    for(int i = 0; i <= D; i++) for(int j = 0; j <= C; j++) dp[i][j] = 1e12;
    dp[0][C] = 0;
    
    for(int i = 0; i < D; i++){
        if(ptr < N && v[ptr].s == i){ //주유소 도착
            for(int j = C; j >= 0; j--){
                if(dp[i][j] == 1e12) continue;
                for(int k = 1; j + k <= C; k++){
                    dp[i][j + k] = min(dp[i][j + k], dp[i][j] + k * v[ptr].p);
                }
            }
            ptr++;
        }
        for(int j = E; j <= C; j++){
            if(dp[i][j] == 1e12) continue;
            dp[i + 1][j - E] = min(dp[i + 1][j - E], dp[i][j]);
        }
    }
    res = 1e12;
    for(int i = 0; i <= C; i++) res = min(res, dp[D][i]);
    if(res == 1e12) cout << -1;
    else cout << res;
    
    return 0;
}
