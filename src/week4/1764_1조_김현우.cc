#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    vector<string> v, result;
    string s;
    int N, M;
    cin >> N >> M;
    for(int i = 0; i < N; i++){
        cin >> s;
        v.push_back(s);
    }
    sort(v.begin(),v.end());
    for(int i = 0; i < M; i++){
        cin >> s;
        if(binary_search(v.begin(),v.end(),s))result.push_back(s);
    }
    sort(result.begin(),result.end());
    cout << result.size() <<"\n";
    for(int i = 0; i <result.size(); i++){
        cout << result[i] <<"\n";
    }
    
}