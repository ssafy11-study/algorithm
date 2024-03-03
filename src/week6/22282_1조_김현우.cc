#include <iostream>
#include <vector>
#define fastio cin.tie(0)->ios_base::sync_with_stdio

using namespace std;

int main(void){
    fastio;
    int n, max = 0;
    cin >> n;
    vector<int> v;
    v.resize(n);
    for(int i = 0; i < n; i++){
        cin>> v[i];
        if(max < v[i]) max = v[i];
    }
    int left = 0, right= max, result = n;
    while(left<=right){
        int mid = (left+right)/2;
        int count = 0;
        for(int i = 0; i < n; i++)if(mid<=v[i])count++;
        if(mid > count)right = mid-1;
        else{
            result = mid;
            left = mid+1;
        }
    }
    cout << result;
}