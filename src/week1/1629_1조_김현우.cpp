#include <iostream>

using namespace std;

// 모듈러 성질: (a*b)%c = (a%c * b%c)%c

long long pow(long long A, long long B, long long C) {
	if (B == 0) return 1;
	long long tmp = pow(A, B / 2, C);
	tmp = (tmp * tmp) % C;
	if (B % 2 == 0) return tmp;
	else return (tmp * A)%C;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	long long A, B, C;
	cin >> A >> B >> C;
	cout << pow(A, B, C);

}