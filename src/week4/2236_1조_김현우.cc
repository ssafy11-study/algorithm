#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, K;
    vector <pair<int,int>> v;
    cin >> N >> K;
    int arr[N+1] = {0}, answer[N+1] ={0};
    v.resize(N+1);
    for(int i = 1; i <= N; i++) {
        cin >> arr[i];
        v[i] = {arr[i],i};
    }
    if(N<=K){
        for(int i = 1; i<=N; i++){
            cout << i <<'\n';
        }
        for(int i = 0; i < K-N; i++){
            cout << 0 <<'\n';
        }
        for(int i = 1; i<=N; i++){
            cout << i <<'\n';
        }
        return 0;
    }
    sort(v.begin(),v.end());
    for(int i = N-K+1; i <= N; i++){
        answer[v[i].second] = v[i].second;
        cout << v[i].second<<"\n";
    }
    for(int i = 1; i <= N; i++){
        cout << answer[i] << "\n";
    }
}