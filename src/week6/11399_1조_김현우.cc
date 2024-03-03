#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N;
    long tmp, sum = 0;
    vector<long> v;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> tmp;
        v.push_back(tmp);
    }
    sort(v.begin(),v.end());
    for(int i = 0; i < N; i++){
        sum += (v[i]*(N-i));
    }
    cout <<sum;
}