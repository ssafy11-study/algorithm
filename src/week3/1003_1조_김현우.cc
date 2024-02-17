#include <iostream>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int dp[41][2];

int main(void){
    fastio;
    dp[0][0] = 1;
    dp[1][1] = 1;
    for(int i = 2; i <= 40; i++){
        dp[i][0] = dp[i-1][0] + dp[i-2][0];
        dp[i][1] = dp[i-1][1] + dp[i-2][1];
    }
    int T ,N;
    cin >> T;
    for(int i = 0; i < T; i++){
        cin >> N;
        cout << dp[N][0] <<" "<< dp[N][1]<< "\n"; 
    }
}