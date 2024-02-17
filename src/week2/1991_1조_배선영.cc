#include <iostream>
#include <algorithm>
#define MAX 101
using namespace std;

int N;
char arr[MAX][2];

// 전위 순회
void pre(int tmp) {
	if (tmp + 'A' == '.') return;
	char output = tmp + 'A';
	cout << output;
	pre(arr[tmp][0] - 'A');
	pre(arr[tmp][1] - 'A');
}

// 중위 순회
void in(int tmp) {
	if (tmp + 'A' == '.') return;
	in(arr[tmp][0] - 'A');
	char output = tmp + 'A';
	cout << output;
	in(arr[tmp][1] - 'A');
}

// 후위 순회
void post(int tmp) {
	if (tmp + 'A' == '.') return;
	post(arr[tmp][0] - 'A');
	post(arr[tmp][1] - 'A');
	char output = tmp + 'A';
	cout << output;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> N;

	char node, left, right;
	for (int i = 0; i < N; i++) {
		cin >> node >> left >> right;
		arr[node - 'A'][0] = left;
		arr[node - 'A'][1] = right;
	}
	pre(0);
	cout << '\n';
	in(0);
	cout << '\n';
	post(0);
	cout << '\n';
}
