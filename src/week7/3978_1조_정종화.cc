//https://www.acmicpc.net/submit/3978
//author:asz2325
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 10010
#define MOD 998244353
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int T, N, M, K, tar;
bool vtd[MX];
string s;

void mark(int idx){
    int ans = 0;
    for(int i = idx; i < idx + M; i++){
        if(i >= N) return;
        ans = ans * K + s[i] - 'a';
        if(ans >= MX) return;
    }
    vtd[ans] = true;
}

string decode(int idx){
    string ret = "";
    for(int i = 0; i < M; i++){
        ret += (idx % K) + 'a';
        idx /= K;
    }
    reverse(ret.begin(), ret.end());
    return ret;
}

int main(int argc, char** argv){
    fastio;
    
    cin >> T;
    while(T--){
        cin >> N >> M >> K >> s;
        fill(vtd, vtd + MX, false);
        for(int i = 0; i < s.size(); i++) mark(i);
        for(int i = 0; i < MX; i++){
            if(!vtd[i]){
                tar = i;
                break;
            }
        }
        cout << decode(tar) << '\n';
    }
    

    return 0;
}
