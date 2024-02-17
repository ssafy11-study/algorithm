#include <iostream>
#include <vector>
#include <string>
#include <algorithm>
using namespace std;

vector<string> words[26];
int idx[26];

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int N, M; cin >> N >> M;
    for (int i = 0; i < N; ++i) {
        string s; cin >> s;
        words[s[0] - 'a'].push_back(s);
    }
    for (auto& w : words) sort(w.begin(), w.end());
    for (int i = 0; i < M; ++i) {
        char ch; cin >> ch; ch -= 'a';
        cout << words[ch][(idx[ch]++) % words[ch].size()] << '\n';
    }
}