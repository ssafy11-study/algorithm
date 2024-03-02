#include <iostream>
#include <algorithm>
using namespace std;

int N, M;
int visited[10001] = { 0 };
int selected[10001] = { 0 };
int arr[10001] = { 0 };

void output(int cnt) {
	if (cnt == M) {
		for (int i = 0; i < M; i++) {
			cout << selected[i] << ' ';
		}
		cout << '\n';
		return;
	}

	for (int i = 0; i < N; i++) {
		if (visited[i] == 1) continue;
		selected[cnt] = arr[i];
		visited[i] = 1;
		output(cnt + 1);
		visited[i] = 0;
	}
}

int main() {
	cin >> N >> M;

	for (int i = 0; i < N; i++) {
		cin >> arr[i];
	}
	sort(arr, arr + N);
	output(0);
}
