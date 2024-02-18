// Subject: Study of Algorithm with SSAFY
// ProblemNo: B9530
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

struct match{
    int S, R;
    bool operator<(match tar){
        return (tar.S - tar.R) < (S - R);
    }
} v[MX];

int N, G, res;

int main() {
	fastio;
	
	cin >> N >> G;
	for(int i = 0; i < N; i++) cin >> v[i].S >> v[i].R;
	sort(v, v + N);
	for(int i = 0; i < N; i++){
	    int fake = v[i].R - v[i].S + 1;
	    if(fake > 0){
	        int ptr = min(G, fake);
	        v[i].S += ptr;
	        G -= ptr;
	    }
	    if(v[i].R == v[i].S) res++;
	    if(v[i].R < v[i].S) res += 3;
	}
	cout << res;
	
	return 0;
}