#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
using namespace std;

pair<int, int> jewelry[300001]; // 보석 무게, 가격
priority_queue<int> pBag;
int N, K; // 보석 개수, 가방 개수
int bag[300001] = { 0 };
long long result = 0;

int main() {
	cin >> N >> K;

	for (int i = 0; i < N; i++) {
		cin >> jewelry[i].first >> jewelry[i].second;
	}

	for (int i = 0; i < K; i++) {
		cin >> bag[i];
	}

	sort(jewelry, jewelry + N);
	sort(bag, bag + K);
	
	int idx = 0;
	for (int i = 0; i < K; i++) {
		while (idx < N && bag[i] >= jewelry[idx].first) {
			pBag.push(jewelry[idx].second);
			idx++;
		}

		if (pBag.empty()) continue;

		result += pBag.top(); pBag.pop();
	}

	cout << result << '\n';
}