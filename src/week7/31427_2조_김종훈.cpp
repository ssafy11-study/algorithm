#include <iostream>
#include <array>
#include <vector>
#include <unordered_map>
#include <algorithm>
using namespace std;
using ll = long long;

int N, M, Q;

struct Edge {
	int a, b;
};

array<vector<Edge>, 5> edges;
unordered_map<int, array<int, 5>> mem;

vector<int> parent;

int getParent(int n) {
	if (parent[n] == n) return n;
	return parent[n] = getParent(parent[n]);
}

bool unionParent(int a, int b) {
	int pa = getParent(a), pb = getParent(b);
	if (pa == pb) return false;

	if (pa < pb) parent[pb] = pa;
	else parent[pa] = pb;

	return true;
}

void calc(int sel) {
	for (int i = 0; i < N; ++i) parent[i] = i;
	auto& m = mem[sel] = { 0, 0, 0, 0, 0 };

	for (int i = 0; i < 5; ++i) {
		int n = sel % 10;

		for (auto& e : edges[n]) {
			if (unionParent(e.a, e.b)) ++m[n];
		}

		sel /= 10;
	}
}

// sel이 40312이면 2, 1, 3, 0, 4 순서라는 뜻
void perm(int sel, int mask) {
	if (mask == 0x1F) {
		calc(sel);
		return;
	}

	for (int i = 0; i < 5; ++i) {
		if (mask & (1 << i)) continue;
		perm(sel * 10 + i, mask | (1 << i));
	}
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N >> M >> Q;
	parent.assign(N, 0);

	for (int m = 0; m < M; ++m) {
		int a, b; char c;
		cin >> a >> b >> c; --a; --b;
		edges[c - 'A'].push_back({ a, b });
	}

	perm(0, 0);

	for (int q = 0; q < Q; ++q) {
		struct Info { int idx, val; };
		vector<Info> ns(5);
		for (int i = 0; i < 5; ++i) { ns[i].idx = i; cin >> ns[i].val; }
		sort(ns.begin(), ns.end(), [](Info const& a, Info const& b) { return a.val < b.val; });

		int sel = 0;
		for (int i = 4; i >= 0; --i) sel = sel * 10 + ns[i].idx;

		auto& m = mem[sel];

		ll res = 0;
		for (int i = 0; i < 5; ++i) res += (ll)m[ns[i].idx] * ns[i].val;

		cout << res << '\n';
	}
}