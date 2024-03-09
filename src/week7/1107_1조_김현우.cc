#include <iostream>
#include <vector>
#include <cmath>
#include <climits>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int N, M;
int min_click = INT_MAX;
bool notwork[10]= {false,};
int src[10] = {0,1,2,3,4,5,6,7,8,9};
vector<int> tgt;

void perm(int tgtIdx){
    if(tgtIdx == tgt.size()){
        int tmp = 0;
        for(int i = 0; i < tgt.size(); i++){
            tmp *= 10;
            tmp += tgt[i];
        }
        int click = 0;
        if(tmp != 100)click = tgt.size();
        click += abs(N-tmp);
        if(min_click>click)min_click = click;
        return;
    }
    for(int i = 0; i < 10; i++){
        if(notwork[i])continue;
        tgt[tgtIdx] = src[i];
        perm(tgtIdx+1);
    }
}

int main(void){
    fastio;
    int tmp;
    cin >> N >> M;
    for(int i = 0; i < M; i++){
        cin >> tmp;
        notwork[tmp] = true;
    }
    if(N == 100){
        cout << 0;
        return 0;
    }
    min_click = abs(N-100);
    for(int i = 1; i <= 6; i++){
        tgt.clear();
        tgt.resize(i);
        perm(0);
    }
    cout << min_click;
}