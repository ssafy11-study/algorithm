#include<iostream>
#include<algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int dp[50001] = {0,};

int main(void){
    fastio;
    int n;
    cin >> n;
    for(int i = 1; i <= n; i++){
        dp[i] = dp[i-1]+1;
        for(int j = 1; j*j<=i; j++){
            dp[i] = min(dp[i],dp[i-j*j]+1);
        }
    }
    cout << dp[n];
}