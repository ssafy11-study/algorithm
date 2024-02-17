#include <iostream>
#include <queue>

using namespace std;
//김현우
int main(void) {
	cin.tie(NULL);
	cout.tie(NULL);
	priority_queue<int, vector<int>, greater<int>> q;
	int N, tmp, count = 0;
	cin >> N;
	for (int i = 0; i < N; i++) {
		cin >> tmp;
		if (tmp == 0) {
			if (q.empty() == true) {
				cout << 0 << "\n";
			}
			else {
				cout << q.top() <<"\n";
				q.pop();
			}
		}
		else {
			q.push(tmp);
		}
	}
}