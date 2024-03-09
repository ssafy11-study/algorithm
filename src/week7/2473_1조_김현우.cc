#include <iostream>
#include <algorithm>
#include <climits>
#include <cmath>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

long long arr[100001] = {0,};

int main(void){
    fastio;
    int N;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> arr[i];
    }
    sort(arr,arr+N);
    int resultI = 0, resultM = 0, resultJ = N-1;
    long long sum = LLONG_MAX;
    for(int m = 0; m < N-2; m++){
        int i = m+1, j = N-1;
        while(i < j){
            if(abs(arr[i]+arr[j]+arr[m])<sum){
                sum = abs(arr[i]+arr[j] + arr[m]);
                resultI = i;
                resultJ = j;
                resultM = m;
            }
            if(arr[i]+ arr[j] + arr[m] == 0)break;
            else if(arr[i] + arr[j] + arr[m] <0) i++;
            else j--;
        }
        if(arr[resultI]+ arr[resultJ] + arr[resultM] == 0)break;
    }
    cout << arr[resultM] << " " << arr[resultI] << " " << arr[resultJ];
}
