#include <iostream>

using namespace std;

int arr[100002] = { 0 };

int main(void) {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
	int N, S, start = 0, end = 0, sum = 0;
	cin >> N >> S;
	int min = N+1;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
    while(start<N && end <= N){
        if(sum < S){
            sum += arr[end];
            end++;
        }else if(sum >= S){
            if(min>end-start){
                min = end-start;
            }
            sum -= arr[start];
            start++;
        }
    }
	if(min == N+1){
	    cout << 0;
	}else{
	    cout << min;
	}
}