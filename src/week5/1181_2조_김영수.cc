#include <iostream>
#include <algorithm>
using namespace std;

bool cmp(string a, string b) {
    if (a.length() == b.length())
        return a < b;
    return a.length() < b.length();
}

int main() {
    int n;
    string s[20000];

    cin >> n;
    for (int i = 0; i < n; i++) cin >> s[i];

    sort(s, s + n, cmp);

    for (int i = 0; i < n; i++) {
        if ((i > 0) && (s[i]==s[i-1])) continue;
        cout << s[i] << endl;
    }
    
    return 0;
}