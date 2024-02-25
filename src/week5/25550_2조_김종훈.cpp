#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

int N, M;

vector<vector<int>> boxes;

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    cin >> N >> M;
    boxes.assign(N, vector<int>(M));
    for (auto& i : boxes) for (auto& j : i) cin >> j;
    
    ll res = 0;
    for (int i = 1; i < N - 1; ++i) {
        for (int j = 1; j < M - 1; ++j) {
            res += max(0, min({ boxes[i][j] - 1, boxes[i - 1][j], boxes[i + 1][j], boxes[i][j - 1], boxes[i][j + 1] }));
        }
    }
    
    cout << res << '\n';
}