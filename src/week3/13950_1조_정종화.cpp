//https://www.acmicpc.net/submit/13950
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 100000
#define MOD 100000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N, res, x;
int tar[2][MX], cnt[2][MX];

bool dfs1(int now){
    if(tar[0][now] == -1) return (tar[0][now] == tar[1][now]);
    bool ret = dfs1(tar[0][now]) && (tar[0][now] == tar[1][now]);
    if(!ret) {
        res++;
        tar[0][now] = -1;
    }
    return ret;
}

void dfs2(int now){
    if(tar[1][now] == -1) return;
    res += (tar[0][now] != tar[1][now]);
    dfs2(tar[1][now]);
}


int main(int argc, char** argv){
    fastio;

    cin >> N;
    for(int i = 0; i < N; i++) tar[0][i] = tar[1][i] = -1;
    for(int t = 0; t < 2; t++){
        for(int i = 0; i < N; i++){
            cin >> x;
            if(x){
                tar[t][x - 1] = i;
                cnt[t][i]++;
            }
        }
    }
    for(int i = 0; i < N; i++) if(!cnt[0][i]) dfs1(i);
    for(int i = 0; i < N; i++) if(!cnt[1][i]) dfs2(i);
    cout << res;
    
    return 0;
}

