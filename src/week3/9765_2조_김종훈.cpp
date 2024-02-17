#include <iostream>
#include <vector>
#include <numeric>
using namespace std;
using ll = long long;

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    vector<ll> ns(6); for (auto& n : ns) cin >> n;
    
    ll x2 = gcd(ns[0], ns[4]);
    ll x1 = ns[0] / x2;
    ll x3 = ns[4] / x2;
    ll x6 = gcd(ns[2], ns[5]);
    ll x5 = ns[5] / x6;
    ll x7 = ns[2] / x6;
    
    cout << x1 << ' ' << x2 << ' ' << x3 << ' ' << x5 << ' ' << x6 << ' ' << x7 << '\n';
}