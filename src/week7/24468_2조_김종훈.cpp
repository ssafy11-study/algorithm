#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Info {
	int pos, direction;
};

int L, N, T;

vector<Info> info;

void move() {
	for (int i = 0; i < N; ++i) {
		Info& ball = info[i];
		ball.pos += ball.direction;

		if (ball.pos == 0 || ball.pos == L) ball.direction = -ball.direction;
	}
}

int collision() {
	int ret = 0;
	for (int i = 0; i < N - 1; ++i) {
		Info& cur = info[i];
		Info& nxt = info[i + 1];

		if (cur.pos == nxt.pos) {
			++ret;
			swap(cur.direction, nxt.direction);
		}
	}
	return ret;
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> L >> N >> T;

	info.assign(N, {});

	for (Info& i : info) {
		char c;
		cin >> i.pos >> c;
		i.direction = c == 'L' ? -1 : 1;
	}

	sort(info.begin(), info.end(), [](Info const& a, Info const& b) {
		return a.pos < b.pos;
	});

	int cnt = 0;
	for (int t = 0; t < T; ++t) {
		move();
		cnt += collision();
	}
	
	cout << cnt << '\n';
}