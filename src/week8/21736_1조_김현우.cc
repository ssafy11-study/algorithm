#include <iostream>
#include <queue>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[600][600] = {0,};
bool visited[600][600] = {false,};
int dy[4] = {-1,1,0,0}, dx[4] = {0,0,-1,1};
int main(void){
    fastio;
    int N, M, px, py, result = 0;
    char c;
    cin >> N >> M;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < M; j++){
           cin >> c;
           if(c == 'O') arr[i][j] = 0;
           else if(c == 'P') arr[i][j] = 1;
           else if(c == 'X') {
               arr[i][j] = -1;
               visited[i][j] = true;
           }
           else {
               arr[i][j] = 0;
               py = i;
               px = j;
           }
        }
    }
    visited[py][px] = true;
    queue <pair<int, int>> q;
    q.push({py,px});
    while(!q.empty()){
        int y = q.front().first, x = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int ny = y + dy[i], nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny>=N || nx >= M || visited[ny][nx]) continue;
            if(arr[ny][nx] == 1) result++;
            visited[ny][nx] = true;
            q.push({ny,nx});
        }
    }
    if(result == 0) cout <<"TT";
    else cout << result;
}