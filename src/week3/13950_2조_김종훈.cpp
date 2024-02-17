#include <iostream>
#include <vector>
using namespace std;

int N, cnt = 0;
vector<int> cur, goal;

void pop(int n) {
    if (cur[n] == 0) return;
    ++cnt;
    int par = cur[n];
    cur[n] = 0;
    pop(par);
}

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    
    cin >> N;
    cur.assign(N + 1, 0);
    goal.assign(N + 1, 0);
    for (int i = 1; i <= N; ++i) cin >> cur[i];
    for (int i = 1; i <= N; ++i) cin >> goal[i];
    
    for (int i = 1; i <= N; ++i) {
        if (cur[i] == goal[i]) continue;
        pop(i);
        pop(goal[i]);
    }
    for (int i = 1; i <= N; ++i) {
        if (cur[i] == 0 && cur[i] != goal[i]) ++cnt;
    }
    cout << cnt << '\n';
}