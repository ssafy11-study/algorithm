#include <iostream>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[101][2] = {0,};
int dp[101][10001] = {0,};

int main(void){
    fastio;
    int N, M, sum = 0;
    cin >> N >> M;
    for(int i = 1; i <= N; i++){
        cin >> arr[i][0];
    }
    for(int i = 1; i <= N; i++){
        cin >> arr[i][1];
        sum += arr[i][1];
    }
    for(int i = 1; i <= N; i++){
        for(int j = 0; j <= sum; j++){
            if(arr[i][1]<=j){
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-arr[i][1]] + arr[i][0]);
            }else{
                dp[i][j] = dp[i-1][j];
            }
        }
    }
    for(int i = 0; i <=10000; i++){
        if(dp[N][i]>=M){
            cout << i;
            return 0;
        }
    }
}