#include <iostream>
#include <vector>
//김현우
using namespace std;

int computer, N, first, second, countV = 0, arr[101][101] = { 0 };

void dfs(int virus) {
	for (int i = 1; i <= computer; i++) {
		if (arr[virus][i]&&arr[i][0] == 0) {
			arr[i][0] = 1;
			countV++;
			dfs(i);
		}
	}
	return;
}

int main(void) {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> computer >> N;
	for (int i = 0; i < N; i++) {
		cin >> first >> second;
		arr[first][second] = 1;
		arr[second][first] = 1;
	}
	arr[1][0] = 1;
	dfs(1);
	cout << countV;
}