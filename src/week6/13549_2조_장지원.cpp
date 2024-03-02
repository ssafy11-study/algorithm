#include <iostream>
#include <algorithm>
#include <deque>
#define INF 1e9

using namespace std;

int N, K;
int cost[100001];
deque<int> dq;

// 0-1 bfs

int main(){
    cin >> N >> K;
    
    fill_n(cost, 100001, INF);
    cost[N] = 0;
    dq.push_back(N);
    
    while(!dq.empty()){
        int cur = dq.front();
        dq.pop_front();
        
        if(cur == K){
            cout << cost[K];
            break;
        }
        
        // 가중치가 0인 것 --> 큐의 앞
        if(cur*2 <=100000 && cost[cur] < cost[cur*2]){
            cost[cur*2] = cost[cur];
            dq.push_front(cur*2);
        }
        
        // 그 다음에 1인 것 --> 큐의 뒤
        if(cur-1 >= 0 && cost[cur] + 1 < cost[cur-1]){
            cost[cur-1] = cost[cur] + 1;
            dq.push_back(cur-1);
        }
        if(cur+1 <= 100000 && cost[cur] + 1 < cost[cur+1]){
            cost[cur+1] = cost[cur] + 1;
            dq.push_back(cur+1);
        }
    }
    
    return 0;
}
