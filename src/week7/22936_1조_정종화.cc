// Subject: Study of Algorithm with SSAFY
// ProblemNo: B22936
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 50010
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>


int N, M, s[1000], e[1000], mark[MX], idx, val;

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> M;
    for(int i = 0; i < M; i++){
        cin >> s[i] >> e[i];
        mark[s[i]]++; mark[e[i] + 1]--;
    }
    for(int i = 1; i < MX; i++) mark[i] += mark[i - 1];
    for(int i = 1; i < MX; i++) mark[i] += mark[i - 1];
    idx = val = 0;
    for(int i = 7 * N; i < MX; i++) {
        if(val < mark[i] - mark[i - 7 * N]) {
            val = mark[i] - mark[i - 7 * N];
            idx = i - 7 * N + 1;
        }
    }
    int res = 0;
    for(int i = 0; i < N; i++){
        int l = idx + 7 * i;
        int r = idx + 7 * i + 6;
        for(int j = 0; j < M; j++){
            if((s[j] < l && e[j] < l) || (s[j] > r && e[j] > r)) continue;
            res++;
        }
    }
    cout << res;
    
    return 0;
}