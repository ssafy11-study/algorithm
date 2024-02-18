// Subject: Study of Algorithm with SSAFY
// ProblemNo: B13473
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

int w, h, ax, ay, bx, by;

int main() {
	fastio;
	
	cin >> w >> h >> ax >> ay >> bx >> by;
	if(ax != bx) cout << ax << ' ' << 0 << ' ' << bx << ' ' << h;
	else cout << 0 << ' ' << ay << ' ' << w << ' ' << by;
	
	return 0;
}