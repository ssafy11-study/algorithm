#include <iostream>
#include <algorithm>
#include <climits>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[501][2] = {0,};
int dp[501][501] = {0,};

int make_matrix(int first, int last){
    if(dp[first][last] != 0)return dp[first][last];
    if(first == last) return 0;
    dp[first][last] = (arr[first][0]*arr[first][1]*arr[last][1])+make_matrix(first+1,last);
    for(int i = first+1; i < last; i++){
        dp[first][last] = min(dp[first][last], (arr[first][0]*arr[i][1]*arr[last][1])+make_matrix(first,i)+make_matrix(i+1,last));
    }
    return dp[first][last];
}

int main(void){
   fastio;
   int N;
   cin >> N;
   for(int i = 1; i <= N; i++){
       cin >> arr[i][0]  >> arr[i][1];
   }
   cout << make_matrix(1,N);
}
