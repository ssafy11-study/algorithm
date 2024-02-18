#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int n, N = 0, tmp, count =1, count2 = 0, result = 0;
    cin >> n;
    vector<int> arr,sum;
    for(int i = 1; i <= n; i++) N+=i;
    arr.push_back(0);
    sum.push_back(0);
    for(int i = 1; i <= N; i++){
        cin >> tmp;
        arr.push_back(tmp);
        sum.push_back(0);
    }
    sum[1] = arr[1];
    for(int i = 1; i<=N-n; i++){
        count2++;
        sum[i+count] = max(sum[i+count],sum[i]+arr[i+count]);
        sum[i+count+1] = max(sum[i+count+1],sum[i]+arr[i+count+1]);
        if(count2 == count){
            count++;
            count2 = 0;
        }
    }
    for(int i = N; i>N-n; i--){
        if(result<sum[i])result = sum[i];
    }
    cout << result;
}