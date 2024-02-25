// Subject: Study of Algorithm with SSAFY
// ProblemNo: B3621
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 100001
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int n, d, x, res;
int cnt[MX];

int cal(int num){
    return max(0, (num - 2) / (d - 1)); //(num - d) + (d - 2) / (d - 1)
}

int main(int argc, char** argv){
    fastio;
    
    cin >> n >> d;
    for(int i = 1; i <= n; i++){
        cin >> x;
        cnt[x]++;
    }
    for(int i = 0; i <= n; i++) res += cal(cnt[i]);
    cout << res;
    
    return 0;
}
