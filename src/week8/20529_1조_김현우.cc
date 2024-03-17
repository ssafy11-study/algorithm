#include <iostream>
#include <vector>
#include <climits>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int T, N;
vector<string> v, tgt;
int min_result = 13;

void comb(int srcIdx, int tgtIdx){
    if(tgtIdx == 3){
        int count = 0;
        for(int i = 0; i < 4; i++){
            if(tgt[0][i] != tgt[1][i]) count++;
            if(tgt[0][i] != tgt[2][i]) count++;
            if(tgt[1][i] != tgt[2][i]) count++;
            if(min_result < count)return;
        }
        if(min_result>count) min_result = count;
        return;
    }
    if(srcIdx == N)return;
    tgt[tgtIdx] = v[srcIdx];
    comb(srcIdx+1,tgtIdx+1);
    comb(srcIdx+1,tgtIdx);
}


int main(void){
    fastio;
    cin >> T;
    tgt.resize(3);
    for(int t = 0; t < T; t++){
        v.clear();
        min_result = 13;
        cin >> N;
        v.resize(N);
        for(int i = 0; i < N; i++)cin >> v[i];
        if(N > 32){
            cout << 0 << "\n";
            continue;
        }
        comb(0,0);
        cout << min_result <<"\n";
    }
}