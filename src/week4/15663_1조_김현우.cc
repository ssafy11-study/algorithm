#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int N, M, tmp, tgt[8];
bool selects[8];
vector<int> v;
vector<vector<int>> result;

void perm(int tgtIdx){
    if(tgtIdx == M){
        vector<int> temp;
        for(int i = 0; i < M; i++){
            temp.push_back(tgt[i]);
        }
        result.push_back(temp);
    }
    
    for(int i = 0; i<v.size(); i++){
        if(selects[i]) continue;
        tgt[tgtIdx] = v[i];
        selects[i] = true;
        perm(tgtIdx+1);
        selects[i] = false;
    }
}

int main(void){
    fastio;
    cin >> N >> M;
    for(int i = 0; i < N; i++){
        cin >> tmp;
        v.push_back(tmp);
    }
    perm(0);
    sort(result.begin(),result.end());
    result.erase(unique(result.begin(),result.end()),result.end());
    for(int i = 0; i < result.size(); i++){
        for(int j = 0; j<result[i].size(); j++){
            cout << result[i][j] << " ";
        }
        cout << "\n";
    }
}