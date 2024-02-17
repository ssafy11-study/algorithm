#include <iostream>
#include <algorithm>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    long long c1,c2,c3,c4,c5,c6,x1,x2,x3,x5,x6,x7;
    cin >> c1 >> c2 >> c3 >> c4 >> c5 >> c6;
    x2 = __gcd(c1,c5); // 최대 공약수 구하는 함수
    x1= c1/x2;
    x3 = c5/x2;
    x6 = __gcd(c3,c6);
    x5 = c6/x6;
    x7 = c3/x6;
    cout << x1 << " " << x2 << " " << x3 << " " << x5 << " " << x6 << " " << x7;  
}