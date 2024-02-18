#include <iostream>
#include <vector>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int result[100001]= {0};
vector<int> v[100001];

void dfs(int tmp){
    for(int i = 0; i<v[tmp].size(); i++){
        if(result[v[tmp][i]] == 0){
            result[v[tmp][i]] = tmp;
            dfs(v[tmp][i]);
        }
    }
}

int main(void){
    fastio;
    int N, tmp1, tmp2, count = 0;
    cin >> N;
    for(int i = 1; i < N; i++){
        cin >> tmp1 >> tmp2;
        v[tmp1].push_back(tmp2);
        v[tmp2].push_back(tmp1);
    }
    dfs(1);
    for(int i =2; i <= N; i++){
        cout << result[i] <<"\n";
    }
}