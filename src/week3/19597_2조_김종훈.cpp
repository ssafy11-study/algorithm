#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Info {
    bool reverse;
    int group;  
    string str;
    
    bool operator<(Info const& a) const {
        return str < a.str;
    }
};

int N;

vector<Info> info;
vector<int> order;

bool print(int idx, string& res) {
    if (idx == N) {
        cout << res << '\n';
        return true;
    }
    
    int prev = 2 * (idx - 1) + (res.back() - '0');
    
    if (order[2 * idx] > order[prev]) {
        res.push_back('0');
        bool chk = print(idx + 1, res);
        res.pop_back();
        if (chk) return true;
    }
    if (order[2 * idx + 1] > order[prev]) {
        res.push_back('1');
        bool chk = print(idx + 1, res);
        res.pop_back();
        if (chk) return true;
    }
    
    return false;
}

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int TC; cin >> TC;
    for (int tc = 0; tc < TC; ++tc) {
        cin >> N;
        info.assign(2 * N, {});
        order.assign(2 * N, 0);
        
        for (int i = 0; i < N; ++i) {
            string str; cin >> str;
            info[2 * i] = { false, i, str };
            reverse(str.begin(), str.end());
            info[2 * i + 1] = { true, i, str };
        }
        
        sort(info.begin(), info.end());
        
        for (int i = 0; i < 2 * N; ++i) {
            order[info[i].group * 2 + info[i].reverse] = i;
        }
        
        string s = "0";
        bool chk = print(1, s);
        if (chk) continue;
        s = "1";
        print(1, s);
    }
}