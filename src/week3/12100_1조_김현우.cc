#include <iostream>
#include <vector>
#include <queue>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, max = 0, tmp, count;
    cin >> N;
    vector<vector<int>> arr;
    queue<pair<int,vector<vector<int>>>> q;
    queue<int> q2;
    for(int i = 0; i < N; i++){
        vector<int> v;
        for(int j = 0; j < N; j++){
            cin >> tmp;
            if(tmp > max) max = tmp;
            v.push_back(tmp);
        }
        arr.push_back(v);
    }
    q.push({0,arr});
    while(!q.empty()){
        arr =  q.front().second;
        count = q.front().first;
        for(int i = 0; i < N; i++){//내려주기
            for(int j = N-1; j >=0; j--){
                if(arr[j][i] != 0){
                    q2.push(arr[j][i]);
                    arr[j][i] = 0;
                }
            }
            for(int j = N-1; j>=0; j--){
                if(q2.empty()){
                    break;
                }
                tmp = q2.front();
                q2.pop();
                if(q2.empty()){  
                    arr[j][i] = tmp;
                    break;
                }
                else if(tmp == q2.front()){
                    arr[j][i] = tmp*2;
                    if(arr[j][i] > max) max = arr[j][i];
                    q2.pop();
                }else{
                    arr[j][i] = tmp;
                }
            }
        }
        if(count < 4) q.push({count+1,arr});
        arr = q.front().second;
        for(int i = 0; i < N; i++){// 올려주기
            for(int j = 0; j < N; j++){
                if(arr[j][i] != 0){
                    q2.push(arr[j][i]);
                    arr[j][i] = 0;
                }
            }
            for(int j = 0; j < N; j++){
                if(q2.empty()){
                    break;
                }
                tmp = q2.front();
                q2.pop();
                if(q2.empty()){  
                    arr[j][i] = tmp;
                    break;
                }
                else if(tmp == q2.front()){
                    arr[j][i] = tmp*2;
                    if(arr[j][i] > max) max = arr[j][i];
                    q2.pop();
                }else{
                    arr[j][i] = tmp;
                }
            }
        }
        if(count <4) q.push({count+1,arr});
        arr = q.front().second;
        for(int i = 0; i < N; i++){ // 좌측으로 쓸어주기
            for(int j = 0; j < N; j++){
                if(arr[i][j] != 0){
                    q2.push(arr[i][j]);
                    arr[i][j] = 0;
                }
            }
            for(int j = 0; j < N; j++){
                if(q2.empty()){
                    break;
                }
                tmp = q2.front();
                q2.pop();
                if(q2.empty()){  
                    arr[i][j] = tmp;
                    break;
                }
                else if(tmp == q2.front()){
                    arr[i][j] = tmp*2;
                    if(arr[i][j] > max) max = arr[i][j];
                    q2.pop();
                }else{
                    arr[i][j] = tmp;
                }
            }
        }
        if(count <4) q.push({count+1,arr});
        arr = q.front().second;
        for(int i = 0; i < N; i++){ // 우측으로 쓸어주기
            for(int j = N-1; j >=0; j--){
                if(arr[i][j] != 0){
                    q2.push(arr[i][j]);
                    arr[i][j] = 0;
                }
            }
            for(int j = N-1; j >=0; j--){
                if(q2.empty()){
                    break;
                }
                tmp = q2.front();
                q2.pop();
                if(q2.empty()){  
                    arr[i][j] = tmp;
                    break;
                }
                else if(tmp == q2.front()){
                    arr[i][j] = tmp*2;
                    if(arr[i][j] > max) max = arr[i][j];
                    q2.pop();
                }else{
                    arr[i][j] = tmp;
                }
            }
        }
        if(count <4) q.push({count+1,arr});
        q.pop();
    }
    cout << max;
}

