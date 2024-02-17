#include <iostream>
#include <cstring>
#include <string>
#include <queue>
#include <tuple>
#define fastio cin.tie(0) -> sync_with_stdio(0)

using namespace std;

int map[1001][1001];
int dist[1001][1001][2];
int dx[4] = {0,0,1,-1}, dy[4] = {1,-1,0,0};
bool visited[1001][1001][2];

int main(void){
    fastio;
    int N, M;
    string s;
    cin >> N >> M;
    memset(dist,-1,sizeof(dist));
    getline(cin,s);
    for(int i = 1; i <= N; i++){
        getline(cin,s);
        for(int j = 1; j <= M; j++){
            map[i][j] = (int)s[j-1]-48;
        }
    }
    visited[1][1][0] = true;
    dist[1][1][0] = 1;
    queue<tuple<int,int,bool>> q;
    q.push({1,1,false});
    while(!q.empty()){
        int y = get<0>(q.front()), x = get<1>(q.front());
        bool check = get<2>(q.front());
        q.pop();
        if(y == N && x == M){
            break;
        }
        for(int d = 0; d < 4; d++){
            int my = y+dy[d], mx = x +dx[d];
            if((my>0)&&(mx>0)&&(my<=N)&&(mx<=M)){
                if(map[my][mx] == 0){
                    if(!visited[my][mx][0] && !check){ 
                        dist[my][mx][0] = dist[y][x][0] +1;
                        visited[my][mx][0] = true;
                        q.push({my,mx,check});
                    }
                    else if(!visited[my][mx][1] && check) {
                        dist[my][mx][1] = dist[y][x][1] +1;
                        visited[my][mx][1] = true;
                        q.push({my,mx,check});
                    }
                }else{
                    if(!visited[my][mx][1] && !check){ 
                        dist[my][mx][1] = dist[y][x][0] +1;
                        visited[my][mx][1] = true;
                        q.push({my,mx,!check});
                    }
                }
            }
        }
    }
    if(dist[N][M][0] == -1 && dist[N][M][1] == -1) cout << -1;
    else if(dist[N][M][0] == -1) cout << dist[N][M][1];
    else if(dist[N][M][1] == -1) cout << dist[N][M][0];
    else if(dist[N][M][0] < dist[N][M][1]) cout << dist[N][M][0];
    else cout << dist[N][M][1];
}


