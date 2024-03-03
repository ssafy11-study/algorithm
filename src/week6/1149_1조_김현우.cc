#include <iostream>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int dp[1001][3] = {0,};

int main(void){
    fastio;
    int N;
    cin >> N;
    for(int i = 1; i <= N; i++){
        cin >> dp[i][0];
        dp[i][0] += min(dp[i-1][1],dp[i-1][2]);
        cin >> dp[i][1];
        dp[i][1] += min(dp[i-1][0],dp[i-1][2]);
        cin >> dp[i][2];
        dp[i][2] += min(dp[i-1][0],dp[i-1][1]);
    }
    cout << min(dp[N][0],min(dp[N][1],dp[N][2]));
}