//https://www.acmicpc.net/submit/19597
#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;
using lld = long long;
#define MX 150
#define MOD 100000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int T, N;
string v[MX][2];
int w[150];
bool FLAG;

void solution(int before, int idx){
    if(idx == N){
        for(int i = 0; i < N; i++) cout << w[i];
        cout << '\n';
        FLAG = false;
        return;
    }
    for(int i = 0; FLAG && i < 2; i++){
        if(!idx || v[idx - 1][before] <= v[idx][i]){
            w[idx] = i;
            solution(i, idx + 1);
        }
    }
}


int main(int argc, char** argv){
    fastio;

    cin >> T;
    while(T--){
        cin >> N;
        for(int i = 0; i < N; i++){
            cin >> v[i][0];
            v[i][1] = v[i][0];
            reverse(v[i][1].begin(), v[i][1].end());
        }
        FLAG = true;
        solution(0, 0);
    }
    
    return 0;
}

