// Subject: Study of Algorithm with SSAFY
// ProblemNo: B7043
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <stack>
using namespace std;
using lld = long long;
#define MX 25000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct info{
    int s, e;
    bool operator<(info tar){
        if(s == tar.s) return e > tar.e;
        return s < tar.s;
    }
} v[MX];

int N, T, idx, after, ep, res;

int main() {
	fastio;
	
	cin >> N >> T;
	for(int i = 0; i < N; i++) cin >> v[i].s >> v[i].e, v[i].e++;
	sort(v, v + N);
	
	ep = after = 1;
	for(int i = 0; i < N; i++){
	    if(ep < v[i].s){
	        ep = after; res++;
	        if(ep < v[i].s){
	            cout << -1;
	            return 0;
	        }
	    }
	    after = max(after, v[i].e);
	}
	if(ep <= T){
	    ep = after; res++;
	    if(ep <= T){
	        cout << -1;
	        return 0;
	    }
	}
	cout << res;
	
	
	return 0;
}