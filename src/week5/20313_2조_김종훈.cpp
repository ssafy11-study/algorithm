#include <iostream>
#include <vector>
#include <queue>
using namespace std;
using ll = long long;

constexpr ll INF = 1'000'000'000'000'000;

struct Edge {
	int dst;
	ll cost;
};

struct Info {
	int cur;
	ll cost;

	bool operator<(Info const& i) const {
		return cost > i.cost;
	}
};

struct Edges {
	int src, dst;
	vector<ll> costs;

	Edges() { costs.reserve(101); }
};

int N, M, A, B, K;
vector<vector<Edge>> graph;

vector<ll> dijkstra(int src) {
	vector<ll> res(graph.size(), INF);
	priority_queue<Info> pq;
	pq.push({ src, 0 });

	while (!pq.empty()) {
		auto info = pq.top(); pq.pop();
		if (info.cost > res[info.cur]) continue;

		for (auto& nxt : graph[info.cur]) {
			if (info.cost + nxt.cost < res[nxt.dst]) {
				res[nxt.dst] = info.cost + nxt.cost;
				pq.push({ nxt.dst, res[nxt.dst] });
			}
		}
	}

	return res;
}

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N >> M >> A >> B; --A; --B;

	vector<Edges> edges(M);

	for (int i = 0; i < M; ++i) {
		int a, b, c; cin >> a >> b >> c;
		--a; --b;
		edges[i].src = a;
		edges[i].dst = b;
		edges[i].costs.push_back(c);
	}

	cin >> K;
	for (int k = 1; k <= K; ++k) {
		for (int m = 0; m < M; ++m) {
			int c; cin >> c;
			edges[m].costs.push_back(c);
		}
	}

	graph.assign(N * (K + 1), {});

	for (int k = 0; k < K; ++k) {
		for (int i = 0; i < N; ++i) {
			graph[i + k * N].push_back({ i + (k + 1) * N, 0 });
		}
	}

	for (int k = 0; k <= K; ++k) {
		for (int m = 0; m < M; ++m) {
			auto& es = edges[m];
			int src = es.src + k * N;
			int dst = es.dst + k * N;
			graph[src].push_back({ dst, es.costs[k] });
			graph[dst].push_back({ src, es.costs[k] });
		}
	}

	auto res = dijkstra(A);

	ll min_cost = INF;
	for (int k = 0; k <= K; ++k) {
		min_cost = min(min_cost, res[B + k * N]);
	}

	cout << min_cost << '\n';
}