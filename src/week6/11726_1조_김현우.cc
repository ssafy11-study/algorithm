#include <iostream>
#include <cmath>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int n;
    cin >> n;
    int arr[n+1];
    arr[1] = 1;
    arr[2] = 2;
    for(int i = 3; i <=n; i++){
        arr[i] = (arr[i-1]+arr[i-2])%10007;
    }
    cout << arr[n];
}