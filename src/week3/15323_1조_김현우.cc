#include <iostream>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int K, N;
    string s;
    char c;
    vector<string> v[26];
    int arr[26];
    cin >> K >> N;
    for(int k = 0; k < K; k++){
        cin >> s;
        v[s[0]-97].push_back(s);
    }
    for(int i = 0; i < 26; i++)sort(v[i].begin(),v[i].end());
    for(int n = 0; n < N; n++){
        cin >> c;
        int i = c-97;
        cout <<v[i][arr[i]%v[i].size()] <<"\n";
        arr[i]++;
    }
}