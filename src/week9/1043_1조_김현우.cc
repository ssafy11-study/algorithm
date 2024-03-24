#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int N, M;
bool people[51] = {false,}, visited[51] = {false,};
bool find_people[51][51] = {false,};
vector<int> party[51];

int main(void){
    int tmp, tmp2, tmp3;
    fill(&find_people[0][0],&find_people[50][50],false);
    cin >> N >> M >> tmp;
    queue<int> q;
    for(int i = 0; i < tmp; i++){
        cin>> tmp2;
        q.push(tmp2);
        people[tmp2] = true;
    }
    for(int i = 0; i < M; i++){
        cin >> tmp2;
        for(int j = 0; j < tmp2; j++){
            cin >> tmp3;
            find_people[i][tmp3] = true;
            party[i].push_back(tmp3);
        }
    }
    if(tmp == 0){
        cout << M;
        return 0;
    }
    if(N == tmp){
        cout << 0;
        return 0;
    }
    int result = M;
    while(!q.empty()){
        int idx = q.front();
        q.pop();
        for(int i = 0; i < M; i++){
            if(find_people[i][idx] && !visited[i]){
                visited[i] = true;
                result--;
                for(int j = 0; j < party[i].size(); j++){
                    if(!people[party[i][j]]){
                        q.push(party[i][j]);
                        people[party[i][j]] = true;
                    }
                }
            }
        }
    }
    cout << result;
}