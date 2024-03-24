#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int N;
int dy[4] = {-1,1,0,0}, dx[4] = {0,0,-1,1};
bool visited[25][25] = {false,};
vector<int> result;

void bfs(int y, int x){
    int count = 1;
    visited[y][x] = true;
    queue<pair<int,int>> q;
    q.push({y,x});
    while(!q.empty()){
        pair<int,int> tmp = q.front();
        q.pop();
        for(int d = 0; d < 4; d++){
            int ny = tmp.first+dy[d], nx = tmp.second+dx[d];
            if(ny < 0 || nx < 0 || ny >= N || nx >= N || visited[ny][nx])continue;
            visited[ny][nx] = true;
            count++;
            q.push({ny,nx});
        }
    }
    result.push_back(count);
}

int main(void){
    fastio;
    cin >> N;
    string s;
    for(int i = 0; i < N; i++){
        cin >> s;
        for(int j = 0; j < N; j++){
            if(s[j] == '0')visited[i][j] = true;
        }
    }
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            if(!visited[i][j])bfs(i,j);
        }
    }
    sort(result.begin(),result.end());
    cout << result.size() << "\n";
    for(int i = 0; i < result.size(); i++) cout << result[i] << "\n";
}