// Subject: Study of Algorithm with SSAFY
// ProblemNo: B12867
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <set>
using namespace std;
using lld = long long;
#define MX 200000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N, M, v[51];
multiset<int> S[51];
string s;

bool isEqual(int i, int j){
    if(S[i].size() != S[j].size()) return false;
    multiset<int>::iterator a = S[i].begin();
    multiset<int>::iterator b = S[j].begin();
    while(a != S[i].end()){
        if((*a) != (*b)) return false;
        a++; b++;
    }
    return true;
}

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> M;
    for(int i = 0; i < M; i++) cin >> v[i];
    cin >> s;
    bool FLAG = true;
    for(int i = 0; i < M; i++){
        S[i + 1] = S[i];
        int tar = v[i] * (s[i] == '+'? 1 : -1);
        if(S[i + 1].count(-tar)) S[i + 1].erase(S[i + 1].find(-tar));
        else S[i + 1].insert(tar);
        for(int j = 0; j <= i; j++) if(isEqual(j, i + 1)) FLAG = false;
    }
    cout << FLAG;
    
    return 0;
}
