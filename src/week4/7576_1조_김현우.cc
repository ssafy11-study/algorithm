#include <iostream>
#include <queue>
#include <tuple>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int dx[4] = {0,0,-1,1}, dy[4] ={-1,1,0,0};

int main(void){
    fastio;
    int arr[1001][1001];
    int M , N, tcount = 0, day = 0;
    cin >> M >> N;
    queue<tuple<int,int,int>> q;
    for(int i = 0; i < N; i++){
        for(int j = 0; j<M; j++){
            cin >> arr[i][j];
            if(arr[i][j] == 0) tcount++;
            else if(arr[i][j] == 1) q.push({i,j,0});
        }
    }
    while(!q.empty()){
        int Y = get<0>(q.front()), X = get<1>(q.front());
        day = get<2>(q.front());
        q.pop();
        for(int i = 0; i < 4; i++){
            int y = Y+dy[i], x = X +dx[i];
            if(y<0||x<0||y>=N||x>=M||arr[y][x] != 0)continue;
            else{
                arr[y][x] = 1;
                tcount--;
                q.push({y,x,day+1});
            }
        }
    }
    if(tcount != 0) cout << -1;
    else cout << day;
}