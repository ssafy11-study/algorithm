#include <iostream>
#include <cstring>
#include <queue>
#include <vector>

#define fastio cin.tie(0)->sync_with_stdio(0)

using namespace std;

int N, M, X;
int arr[1002][1002];
int dist[1002];

int dijkstra(int i, int d){
    memset(dist,-1,sizeof(dist));
    priority_queue <pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
    dist[i] = 0;
    for(int village = 1; village <= N; village++){
        if(arr[i][village] != -1){
            pq.push({arr[i][village],village});
            dist[village] = arr[i][village];
        }
    }
    while(!pq.empty()){
        int x = pq.top().second; // 마을
        int y = pq.top().first; // 시간
        pq.pop();
        if(x == d){
            return dist[d];
        }
        else{
            for(int village = 1; village <= N; village++){
                if(arr[x][village] == -1) continue;
                if((arr[x][village]+y < dist[village])||(village != i && dist[village] == -1)){
                    pq.push({arr[x][village]+y,village});
                    dist[village] = arr[x][village]+y;
                }
            }
        }
    }
    return 0;
}


int main(void){
    fastio;
    int tmp1,tmp2,tmp3;
    cin >> N >> M >> X;
    memset(arr,-1,sizeof(arr));
    for(int m = 0; m < M; m++){
        cin >> tmp1 >> tmp2 >> tmp3;
        arr[tmp1][tmp2] = tmp3;
    }
    int max = 0, tmp;
    for(int i = 1; i <= N; i++){
        if(i == X) continue;
        tmp = dijkstra(i,X) + dijkstra(X,i);
        if(max<tmp) max = tmp;
    }
    cout << max;
}