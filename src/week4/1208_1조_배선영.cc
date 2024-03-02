#include <iostream>
#include <map>
#define MAX 41
using namespace std;

int N, S;
int arr[MAX] = { 0 };
long long output = 0;
map<int, int> m;

// 반례
// 6 3
// 1 1 1 -1 -1 -1

void leftCheck(int start, int sum) {
	if (start == N / 2) {
		m[sum]++;
		return;
	}
	leftCheck(start + 1, sum + arr[start]);
	leftCheck(start + 1, sum);
}

void rightCheck(int start, int sum) {
	if (start == N) {
		output += m[S - sum];
		return;
	}
	rightCheck(start + 1, sum + arr[start]);
	rightCheck(start + 1, sum);
}

int main() {
	cin >> N >> S;
	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	leftCheck(0, 0);
	rightCheck(N / 2, 0);
	
	if (S == 0) output -= 1;
	cout << output << '\n';
}