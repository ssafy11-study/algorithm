#include <iostream>
#include <vector>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

bool visited[10001];
int maxT = 0, maxV = 0;
vector <pair<int,int>> d[10001];

void dfs(int idx, int count){
    for(int i = 0; i <d[idx].size(); i++){
        if(!visited[d[idx][i].first]){
            visited[d[idx][i].first] = true;
            if(maxT < count+d[idx][i].second){
                maxV =d[idx][i].first;
                maxT = count+d[idx][i].second;
            }
            dfs(d[idx][i].first,count+d[idx][i].second);
            visited[d[idx][i].first]  = false;
        }
    }
}

int main(void){
    fastio;
    int V, tmp, tmp2, tmp3;
    cin >> V;
    for(int i = 1; i < V; i++){
        cin >> tmp >> tmp2 >> tmp3;
        d[tmp].push_back({tmp2,tmp3});
        d[tmp2].push_back({tmp,tmp3});
    }
    visited[1] = true;
    dfs(1,0) ;
    visited[1] = false;
    maxT = 0;
    visited[maxV] = true;
    dfs(maxV,0);
    cout<< maxT;
}

