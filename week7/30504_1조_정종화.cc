// Subject: Study of Algorithm with SSAFY
// ProblemNo: B30504
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <numeric>
using namespace std;
using lld = long long;
#define MX 200000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

int N, B[MX], res[MX];
pi A[MX];

int main(int argc, char** argv){
    fastio;
    
    cin >> N;
    for(int i = 0; i < N; i++) {
        cin >> A[i].first;
        A[i].second = i;
    }
    for(int i = 0; i < N; i++) cin >> B[i];
    sort(A, A + N);
    sort(B, B + N);
    bool FLAG = true;
    for(int i = 0; i < N; i++) {
        FLAG &= (A[i].first <= B[i]);
        res[A[i].second] = B[i];
    }
    if(!FLAG) cout << -1;
    else for(int i = 0; i < N; i++) cout << res[i] << ' ';
    
    return 0;
}

