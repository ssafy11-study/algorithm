// Subject: Study of Algorithm with SSAFY
// ProblemNo: B31427
// Language: C++
// Author: pasta (JungJonghwa)
#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <numeric>
using namespace std;
using lld = long long;
#define MX 100000
#define MOD 1000000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

struct Edge{
    int x, y;
    Edge(){}
    Edge(int _x, int _y):x(_x),y(_y){}
};

struct query{
    int val, idx;
    bool operator < (query tar){
        return val < tar.val;
    }
} q[5];

vector<Edge> edge[5];
int N, M, Q, order[5], lock[5], par[MX], ptr;
unordered_map<int, int> key;
int cnt[120][5]; //all possibility 

int find(int X){
    if(X == par[X]) return X;
    return par[X] = find(par[X]);
}

bool merge(int a, int b){
    a = find(a); b = find(b);
    if(a == b) return false;
    if(a > b) swap(a, b);
    par[b] = a;
    return true;
}

int get_key(int tmp[]){
    int ret = 0;
    for(int i = 0; i < 5; i++) ret = 10 * ret + tmp[i];
    if(key.count(ret)) return key[ret];
    return key[ret] = ptr++;
}

void do_kruskal(int idx){
    iota(par, par + N, 0);
    for(int i = 0; i < 5; i++){
        int tar = order[i];
        for(Edge e : edge[tar]){
            if(merge(e.x, e.y)){
                cnt[idx][i]++;
            }
        }
    }
}

void do_permutation(int cnt){
    if(cnt == 5){
        do_kruskal(get_key(order));
        return;
    }
    for(int i = 0; i < 5; i++){
        if(!lock[i]){
            lock[i] = true;
            order[cnt] = i;
            do_permutation(cnt + 1);
            lock[i] = false;
        }
    }
}

int x, y;
char c;

int main(int argc, char** argv){
    fastio;
    
    cin >> N >> M >> Q;
    for(int i = 0; i < M; i++){
        cin >> x >> y >> c;
        x--; y--;
        edge[c - 'A'].push_back(Edge(x, y));
    }
    do_permutation(0);
    for(int i = 0; i < Q; i++){
        for(int j = 0; j < 5; j++){
            cin >> q[j].val;
            q[j].idx = j;
        }
        sort(q, q + 5);
        for(int j = 0; j < 5; j++) order[j] = q[j].idx;
        int id = get_key(order);
        
        lld res = 0;
        for(int j = 0; j < 5; j++) res += (lld)q[j].val * cnt[id][j];
        cout << res << '\n';
    }
    
    return 0;
}
