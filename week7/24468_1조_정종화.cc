// Subject: Study of Algorithm with SSAFY
// ProblemNo: B24468
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

int L, N, T, x, res;
char d;

struct Marble{
    int x, dir;
    Marble(){}
    Marble(int _x, char _c):x(_x){
        dir = (_c == 'L'? -1 : 1);
    }
    void move() {
        x += dir;
        if(x == 0 || x == L) dir *= -1;
    }
    bool operator <(Marble tar){
        return x < tar.x;
    }
} m[100];


int main(int argc, char** argv){
    fastio;
    
    cin >> L >> N >> T;
    for(int i = 0; i < N; i++){
        cin >> x >> d;
        m[i] = Marble(x, d);
    }
    sort(m, m + N);
    for(int i = 0; i < T; i++){
        for(int j = 0; j < N; j++) m[j].move();
        for(int j = 1; j < N; j++){
            if(m[j - 1].x == m[j].x){
                m[j - 1].dir *= -1;
                m[j].dir *= -1;
                res++;
            }
        }
    }
    cout << res;
    
    return 0;
}

