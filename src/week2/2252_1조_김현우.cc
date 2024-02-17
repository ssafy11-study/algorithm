#include <iostream>
#include <vector>
#include <queue>

#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

vector<int> graph[32001];
int count[32001]; 

int main(void){
    int N, M, A, B;
    cin >> N >> M;
    for(int i = 0 ; i< M; i++){
        cin >> A >> B;
        graph[A].push_back(B);
        count[B]++;
    }
    queue<int> indegree;
    for(int i = 1; i <= N; i++){
        if(count[i] == 0) indegree.push(i);
    }
    while(!indegree.empty()){
        int x = indegree.front();
        indegree.pop();
        for(int i = 0; i < graph[x].size(); i++){
            count[graph[x][i]]--;
            if(count[graph[x][i]] == 0){
                indegree.push(graph[x][i]);
            }
        }
        cout << x << " ";
    }
}