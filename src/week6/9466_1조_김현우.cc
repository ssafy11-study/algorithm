#include <iostream>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[100001] = {0,};
int visited[100001] = {0,};

void search(int idx){
    if(visited[idx] == 2 || arr[idx] == -1)return;
    visited[idx]++;
    search(arr[idx]);
    arr[idx] = -1;
}

int main(void){
    fastio;
    int T, n;
    cin >> T;
    for(int t = 0; t <T; t++){
        fill(arr,arr+100001,0);
        fill(visited,visited+100001,0);
        cin >> n;
        for(int i = 1; i <= n; i++) cin >> arr[i];
        for(int i = 1; i <= n; i++) if(visited[i] == 0) search(i);
        int count = 0;
        for(int i = 1; i <= n; i++)  if(visited[i]<2)count++;
        cout << count << '\n';
    }
}