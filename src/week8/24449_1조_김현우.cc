#include <iostream>
#include <algorithm>
#include <tuple>
#include <queue>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

struct info{
    char carpet;
    int count = 0;
    int y,x;
};

char map[501][501];
bool visited[501][501] = {false,};
int N, M;
int dy[4] = {-1,1,0,0}, dx[4] = {0,0,-1,1};

int main(void){
    fastio;
    fill(&map[0][0],&map[500][500],'!');
    cin >> N >> M;
    for(int i = 1; i <= N; i++){
        for(int j =1; j <= M; j++){
            cin >> map[i][j];
        }
    }
    queue<info> q;
    info start;
    start.y = 1;
    start.x = 1;
    start.carpet = map[1][1];
    start.count = 0;
    q.push(start);
    while(!q.empty()){
        info tmp = q.front();
        q.pop();
        if(tmp.y == N && tmp.x == M){
            cout << tmp.count;
            return 0;
        }
        for(int d = 0; d < 4; d++){
            int ny = tmp.y+dy[d], nx = tmp.x+dx[d];
            if(ny<1||nx<1||ny>N||nx>M||visited[ny][nx]||map[ny][nx] == tmp.carpet)continue;
            visited[ny][nx] = true;
            info tmp2;
            tmp2.y = ny;
            tmp2.x = nx;
            tmp2.carpet = map[ny][nx];
            tmp2.count = tmp.count+1;
            q.push(tmp2);
        }
    }
    cout << -1;
}