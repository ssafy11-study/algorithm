#include <iostream>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, K, tmp = 1, tmp2 = 1;
    cin >> N >> K;
    for(int i = N; i>N-K; i--){
        tmp *= i;
    }
    for(int i = K; i>0; i--){
        tmp2*=i;
    }
    cout << tmp/tmp2;
}
