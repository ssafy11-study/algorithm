#include <iostream>
#include <vector>
using namespace std;

int iceil(int a, int b) {
    return a / b + (a % b != 0);
}

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int N, D; cin >> N >> D;
    vector<int> cnt(N + 1, 0);
    for (int i = 0; i < N; ++i) {
        int n; cin >> n; ++cnt[n];
    }

    int res = 0;
    for (int i = 0; i <= N; ++i) {
        if (cnt[i] - D < 0) continue;
        res += iceil(cnt[i] - D, D - 1);
    }
    cout << res << '\n';
}