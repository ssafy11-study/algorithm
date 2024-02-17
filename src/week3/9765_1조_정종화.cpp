//https://www.acmicpc.net/submit/9765
#include <iostream>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;
using lld = long long;
#define MX 10000
#define MOD 100000007
#define fastio cin.tie(0)->sync_with_stdio(0)
#define pi pair<int, int>
#define pl pair<lld, lld>

lld c1, c2, c3, c4, c5, c6;
lld x1, x2, x3, x4, x5, x6, x7, x8;

lld gcd(lld x, lld y){
    if(!y) return x;
    return gcd(y, x % y);
}

bool test1() { return c1 == x1 * x2; }
bool test2() { return x4 == c4 * x1; }
bool test3() { return c3 == x6 * x7; }
bool test4() { return x8 == x7 * c2; }
bool test5() { return c5 == x2 * x3; }
bool test6() { return c6 == x6 * x5; }
//c1 = x1 * x2;
//c5 = x2 * x3;
//c6 = x5 * x6;
//c3 = x6 * x7;

int main(int argc, char** argv){
    fastio;

    cin >> c1 >> c2 >> c3 >> c4 >> c5 >> c6;
    x2 = gcd(c1, c5);
    x6 = gcd(c3, c6);
    x1 = c1 / x2; x3 = c5 / x2;
    x5 = c6 / x6; x7 = c3 / x6;
    cout << x1 << ' ' << x2 << ' ' << x3 << ' ' << x5 << ' ' << x6 << ' ' << x7;
    
    return 0;
}
