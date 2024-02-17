#include <iostream>
#include <queue>

//김현우

using namespace std;

int main(void) {
	cin.tie(NULL);
	cout.tie(NULL);
	int N, K , tmp  = 0, count = 0;
	cin >> N >> K;
	queue <int> q;
	for (int i = 1; i <= N; i++) {
		q.push(i);
	}
	cout << "<";
	while (q.empty() == false) {
		for (int i = 1; i < K; i++) {
			q.push(q.front());
			q.pop();
		}
		cout << q.front();
		q.pop();
		if (q.empty() == false) {
			cout << ", ";
		}
	}
	cout << ">";
}