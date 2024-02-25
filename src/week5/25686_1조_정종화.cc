// Subject: Study of Algorithm with SSAFY
// ProblemNo: B25686
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 65
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N;
void dfs(int idx, int gap, int n){
    if(n == 1){
        cout << idx << ' ';
        return;
    }
    dfs(idx, gap * 2, (n + 1) / 2);
    dfs(idx + gap, gap * 2, n / 2);
}

int main(int argc, char** argv){
    fastio;
    
    cin >> N;
    dfs(1, 1, N);

    return 0;
}
