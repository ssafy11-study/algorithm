// Subject: Study of Algorithm with SSAFY
// ProblemNo: B2236
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;
using lld = long long;
#define MX 100000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct info{
    int val, idx;
    bool operator<(info tar){
        return val > tar.val;
    }
} v[50];

int N, K, res[50], cnt[50], ptr;

int main() {
	fastio;
	
	cin >> N >> K;
	for(int i = 0; i < N; i++){
	    cin >> v[i].val;
	    v[i].idx = i;
	}
	sort(v, v + N);
	for(int i = 0; i < min(N, K); i++) {
	    res[v[i].idx] = v[i].idx + 1;
	    cnt[ptr++] = v[i].idx + 1;
	}
    for(int i = 0; i < K; i++) cout << cnt[i] << '\n';
	for(int i = 0; i < N; i++) cout << res[i] << '\n';
	
	return 0;
}
