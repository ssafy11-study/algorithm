#include <iostream>
#include <queue>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

bool visited[100001];

int main(void){
    fastio;
    int N ,K;
    cin >> N >> K;
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> q;
    q.push({0,N});
    visited[N] = true;
    fill(visited, visited+100001, false);
    if(N == K){
        cout << 0;
        return 0;
    }
    while(!q.empty()){
        int x = q.top().second, t = q.top().first;
        q.pop();
        if(x == K){
            cout << t;
            return 0;
        }
        int tmp = x;
        while(2*tmp<=100000 && tmp != 0 && !visited[2*tmp]){
            if(visited[2*tmp])continue;
            visited[2*tmp] = true;
            q.push({t,2*tmp});
            tmp *= 2;
        }
        if(x!=100000&&!visited[x+1]){
            visited[x+1] = true;
            q.push({t+1,x+1});
        }
        if(x != 0 &&!visited[x-1]){
            visited[x-1] = true;
            q.push({t+1,x-1});
        }
    }
}