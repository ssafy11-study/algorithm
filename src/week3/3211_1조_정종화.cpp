//https://www.acmicpc.net/submit/3211
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

int N, v[MX];

int main(int argc, char** argv){
    fastio;

    cin >> N;
    for(int i = 0; i < N; i++) cin >> v[i];
    sort(v, v + N);
    for(int i = 0; i < N; i++){
        if(v[i] <= i){
            cout << i + 1;
            return 0;
        }
    }
    
    return 0;
}

