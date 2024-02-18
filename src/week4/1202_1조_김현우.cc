#include <iostream>
#include <queue>
#include <vector>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>> arr;
    priority_queue<int,vector<int>,greater<int>> bag;
    int N,K,tmp1,tmp2;
    long long sum = 0;
    cin >> N >> K;
    for(int i = 0 ; i < N; i++){
        cin >> tmp1 >> tmp2;
        arr.push({tmp1,tmp2});
    }
    for(int i = 0 ;i < K; i++){
        cin >> tmp1;
        bag.push(tmp1);
    }
    priority_queue<pair<int,int>> pq;
    while(!bag.empty()){
        int bw = bag.top();
        bag.pop();
        while(!arr.empty() && arr.top().first<=bw){
            pq.push({arr.top().second,arr.top().first});
            arr.pop();
        }
        if(!pq.empty()){
            sum+=pq.top().first;
            pq.pop();
        }
    }
    cout <<sum;
}