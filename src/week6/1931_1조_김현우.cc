#include <iostream>
#include <vector>
#include <algorithm>

#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, sum = 0, end = 0;
    cin >> N;
    vector<pair<int,int>> v;
    v.resize(N);
    for(int i = 0; i < N; i++){
        cin >> v[i].first >> v[i].second;
    }
    sort(v.begin(),v.end());
    for(int i = 0; i < N; i++){
        if(end>v[i].second)end = v[i].second;
        else if(end<=v[i].first){
            end = v[i].second;
            sum++;
        }
    }
    cout << sum;
}