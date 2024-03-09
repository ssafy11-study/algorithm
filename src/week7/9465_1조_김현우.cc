#include <iostream>
#include <cmath>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int dp[100001][2] = {0,};
int arr[100001][2] = {0,};

int main(void){
    fastio;
    int T, N;
    cin >> T;
    for(int t = 0; t < T; t++){
        cin >> N;
        for(int i = 0; i < 2; i++){
            for(int j = 1; j <= N; j++){
                cin >> arr[j][i];
            }
        }
        dp[1][0] = arr[1][0];
        dp[1][1] = arr[1][1];
        dp[2][0] = dp[1][1] + arr[2][0];
        dp[2][1] = dp[1][0] + arr[2][1];
        for(int i = 3; i <=N; i++){
            dp[i][0] = max(dp[i-1][1],dp[i-2][1]) + arr[i][0];
            dp[i][1] = max(dp[i-1][0],dp[i-2][0]) + arr[i][1];
        }
        cout << max(dp[N][0],dp[N][1]) << "\n";
    }
}