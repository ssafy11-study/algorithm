#include <iostream>
#include <vector>
#include <queue>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, M, tmp1, tmp2, count = 0;
    bool visited[1001];
    vector<int> arr[1001];
    cin >> N >> M;
    for(int i = 0; i < M; i++){
        cin >> tmp1>> tmp2;
        arr[tmp1].push_back(tmp2);
        arr[tmp2].push_back(tmp1);
    }
    queue<int> q;
    for(int i = 1; i <= N; i++){
        if(visited[i])continue;
        count++;
        q.push(i);
        visited[i] = true;
        while(!q.empty()){
            int n = q.front();
            q.pop();
            for(int j = 0; j < arr[n].size(); j++){
                if(visited[arr[n][j]])continue;
                q.push(arr[n][j]);
                visited[arr[n][j]] = true;
            }
        }
    }
    cout <<count;
}