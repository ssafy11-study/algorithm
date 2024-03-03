#include <iostream>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, M, tmp;
    cin >> N;
    int arr[N];
    for(int i = 0; i < N; i++) cin >> arr[i];
    sort(arr,arr+N);
    cin >> M;
    for(int i = 0; i < M; i++){
        cin >> tmp;
        cout << upper_bound(arr,arr+N,tmp)-lower_bound(arr,arr+N,tmp) <<" ";
    }
}