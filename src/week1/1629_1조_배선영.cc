#include <iostream>
using namespace std;

#include <iostream>
#include <queue>
using namespace std;

// 부울경_4반_배선영

long long pow(int A, int B, int C) {
	if (B == 1) return A;

	long long tmp = pow(A, B / 2, C);
	tmp = tmp * tmp % C;
	if (B % 2 == 1) return (tmp * A) % C; // 홀
	else return tmp; // 짝
}

int main() {
	// b % 2 == 0; a^b * a^(b/2)
	// b % 2 == 1; a^(b/2) * a^(b/2 + 1)

	// 2^10 = 2^5 * 2^5 (2(a)^5(b) == tmp)
	// 2^5 = 2^2 * 2^2 * 2

	//지수법칙: a ^ (n + m) = a ^ n * a ^ m
	//모듈러 성질 : (a * b) % c = (a % c * b % c) % c

	ios_base::sync_with_stdio(0);
	cin.tie(0);

	long long A, B, C;
	cin >> A >> B >> C;
	cout << pow(A % C, B, C) << '\n';
	return 0;
}
