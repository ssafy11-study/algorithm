// Subject: Study of Algorithm with SSAFY
// ProblemNo: B14012
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 100000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct info{
    int A, B;
} v[MX];

struct cmp{
    bool operator()(info a, info b){
        return a.A > b.A;
    }
};

priority_queue<info, vector<info>, cmp> pq;
lld total;
int N, a, b;

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> total;
    for(int i = 0; i < N; i++) cin >> v[i].A;
    for(int i = 0; i < N; i++) cin >> v[i].B;
    for(int i = 0; i < N; i++) pq.push(v[i]);

    while(!pq.empty()){
        info now = pq.top(); pq.pop();
        if(now.A > total) continue;
        if(now.B > now.A) total += now.B - now.A;
    }
    cout << total;
    
    return 0;
}
