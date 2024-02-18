// Subject: Study of Algorithm with SSAFY
// ProblemNo: B5431
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

int T, N, x, idx, idx2, l, r;
vector<int> v;
vector<int> cnt;
lld res;

lld query(int n){
    if(n == 0) return 1;
    lld dp[50] = {0,};
    dp[0] = 1; dp[1] = cnt[0];
    for(int i = 2; i <= n; i++){
        for(int j = 0; j < i; j++) dp[i] += dp[j];
        dp[i] *= cnt[i - 1];
    }
    lld ret = 0;
    for(int i = 0; i <= n; i++) ret += dp[i];
    return ret;
}

int main() {
	fastio;
	
	cin >> T;
	while(T--){
	    cin >> N;
	    v.clear(); cnt.clear(); res = 0;
	    while(N--){
	        cin >> x;
	        idx = lower_bound(v.begin(), v.end(), x) - v.begin();
	        idx2 = upper_bound(v.begin(), v.end(), x) - v.begin();
	        if(idx2 != v.size()) res += query(idx);
	        if(idx != v.size() && v[idx] == x) cnt[idx]++;
	        else{
	            v.push_back(x);
	            cnt.push_back(1);
	            for(int i = v.size() - 1; i != idx; i--) {
	                swap(v[i], v[i - 1]);
	                swap(cnt[i], cnt[i - 1]);
	            }
	        }
	    }
        l = r = -999;
	    cout << res << '\n';
	}
	
	return 0;
}
