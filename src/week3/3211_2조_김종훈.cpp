#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int N; cin >> N;
    vector<int> ns(N); for (auto& n : ns) cin >> n;
    sort(ns.begin(), ns.end());
    int idx = 0;
    while (ns[idx] > idx) idx = ns[idx];
    cout << idx + 1 << '\n';
}