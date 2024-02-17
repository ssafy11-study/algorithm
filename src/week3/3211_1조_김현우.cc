#include <iostream>

#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[10001];

int main(void) {
    fastio;
    int N, tmp;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> tmp;
        arr[tmp+1]++;
    }
    
    for(int i = 2; i <=10000; i++){
        arr[i] = arr[i] + arr[i-1];
        if(i <= arr[i]){
            cout << i;
            break;
        }
    }
}
