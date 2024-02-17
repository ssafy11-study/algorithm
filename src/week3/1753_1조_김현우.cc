#include <iostream>
#include <vector>
#include <queue>

#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

vector <pair<int,int>> arr[20001];
int arr2[20001];

void dijkstra(int k){
    priority_queue <pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> pq;
    arr2[k] = 0;
    pq.push({0,k});
    while(!pq.empty()){
        int dist = pq.top().first, end = pq.top().second;
        pq.pop();
        if(dist > arr2[end]) continue;
        for(int i = 0; i < arr[end].size(); i++){
            if(arr2[arr[end][i].first] == -1 || arr2[arr[end][i].first] > dist+arr[end][i].second){
                arr2[arr[end][i].first] = dist+arr[end][i].second;
                pq.push({dist+arr[end][i].second,arr[end][i].first});
            }
        }
    }
}


int main(void){
    fastio;
    int V, E, K, u, v, w;
    cin >> V >> E >> K;
    for(int i = 0; i < E; i++){
        cin >> u >> v >> w;
        arr[u].push_back({v,w});
    }
    fill(arr2,arr2+20001,-1);
    dijkstra(K);
    for(int i = 1; i <= V; i++){
        if(arr2[i] == -1) cout<<"INF" << "\n";
        else cout << arr2[i] << "\n";
    }
}