#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

vector<int> graph[1001];
int counts[1001] = {0,};
vector<int> result;

int main(void){
   fastio;
   int N, M, tmp, first, second;
   cin >> N >> M;
   for(int i = 0; i < M; i++){
       cin >> tmp >> second;
       for(int j = 1; j < tmp; j++){
           first = second;
           cin >> second;
           graph[first].push_back(second);
           counts[second]++;
       }
   }
   queue<int> q;
   for(int i = 1; i <= N; i++) if(counts[i] == 0) q.push(i);
   while(!q.empty()){
       int node = q.front();
       q.pop();
       for(int i = 0; i < graph[node].size(); i++){
           counts[graph[node][i]]--;
           if(counts[graph[node][i]] == 0) q.push(graph[node][i]);
       }
       result.push_back(node);
   }
   if(result.size() != N) cout << 0;
   else{
       for(int i = 0; i < result.size(); i++){
           cout << result[i] << '\n';
       }
   }
   
}