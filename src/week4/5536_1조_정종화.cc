// Subject: Study of Algorithm with SSAFY
// ProblemNo: B5536
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;
using lld = long long;
#define MX 50
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct pairs{
    int x, io, idx;
    bool operator<(pairs tar){
        if(x == tar.x) return io < tar.io;
        return x < tar.x;
    }
};

struct cuboid{
    int p[6], idx;
} c[50];

int N, K, sweep_info[3][50]; //x, y의 sweeping 결과를 저장
lld res;

void sweep(int d, lld total){
    if(!total) return;
    if(d == 3){
        res += total;
        return;
    }
    vector<pairs> v;
    for(int i = 0; i < N; i++){
        if(d && !sweep_info[d - 1][i]) continue;
        v.push_back({c[i].p[d], 1, c[i].idx});
        v.push_back({c[i].p[d + 3], 0, c[i].idx});
    }
    sort(v.begin(), v.end());
    int cnt, before;
    cnt = before = 0;
    for(auto now : v){
        if(cnt >= K){
            sweep(d + 1, total * (now.x - before));
            before = now.x;
        }
        cnt += 2 * now.io - 1;
        sweep_info[d][now.idx] = now.io;
        if(now.io && cnt == K) before = now.x;
    }
}


int main() {
	fastio;
	
	cin >> N >> K;
	for(int i = 0; i < N; i++) {
	    for(int j = 0; j < 6; j++) cin >> c[i].p[j];
	    c[i].idx = i;
	}
	sweep(0, 1);
	cout << res;
	
	return 0;
}