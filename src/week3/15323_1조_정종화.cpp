//https://www.acmicpc.net/submit/15323
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 10000
#define MOD 100000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N, Q, ptr[26];
vector<string> v[26];
string s;
char c;

int main(int argc, char** argv){
    fastio;

    cin >> N >> Q;
    for(int i = 0; i < N; i++) {
        cin >> s;
        v[s[0] - 'a'].push_back(s);
    }
    for(int i = 0; i < 26; i++) sort(v[i].begin(), v[i].end());
    while(Q--){
        cin >> c;
        int tar = c - 'a';
        cout << v[tar][ptr[tar]] << '\n';
        ptr[tar] = (ptr[tar] + 1) % v[tar].size();
    }
    
    return 0;
}

