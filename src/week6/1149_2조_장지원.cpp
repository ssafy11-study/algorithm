#include <iostream>
#include <algorithm>
using namespace std;

int dp[1001][3];
int arr[1001][3];

int main(){
    
    int N;  cin >> N;
    
    for(int i=1; i<=N; i++){
        cin >> arr[i][0] >> arr[i][1] >> arr[i][2];
    }
    
    dp[1][0] = arr[1][0];
    dp[1][1] = arr[1][1];
    dp[1][2] = arr[1][2];
    
    for(int i=2; i<=N; i++){
        dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + arr[i][0];
        dp[i][1] = min(dp[i-1][0], dp[i-1][2]) + arr[i][1];
        dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + arr[i][2];
    }

    int m = min(dp[N][0], min(dp[N][1], dp[N][2]));
    
    cout << m;

    return 0;
}
