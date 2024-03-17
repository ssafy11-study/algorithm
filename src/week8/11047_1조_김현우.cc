#include <iostream>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N,K, count = 0;
    cin >> N >> K;
    int arr[N];
    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }
    for(int i = N-1; i >=0; i--){
        if(K>=arr[i]){
            count += K/arr[i];
            K %= arr[i];
            if(K == 0)break;
        }
    }
    cout << count;
}