#include <iostream>
#include <queue>
using namespace std;

// 부울경_4반_배선영

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	priority_queue<int, vector<int>, greater<int>> q; // 오름차순 
	int N;
	cin >> N;

	int input;
	while (N--) {
		cin >> input;
		if (input == 0) {
			if (!q.empty()) {
				cout << q.top() << '\n'; // 가장 작은 값 출력
				q.pop();
			}
			else {
				cout << 0 << '\n';
			}
		}
		else {
			q.push(input);
		}
	}
}