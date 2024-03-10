#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

constexpr ll INF = 1'000'000'000'000'000LL;

int N; ll M;

vector<ll> knapsack;
vector<int> apps_cost;
vector<ll> apps_mem;

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N >> M;
	apps_cost.assign(N, 0);
	apps_mem.assign(N, 0);
	for (auto& n : apps_mem) cin >> n;
	for (auto& n : apps_cost) cin >> n;

	knapsack.assign(10'001, -1);
	knapsack[0] = 0;

	for (int i = 0; i < N; ++i) {
		int cost = apps_cost[i];
		ll mem = apps_mem[i];

		for (int j = 10'000; j >= cost; --j) {
			if (knapsack[j - cost] == -1) continue;
			knapsack[j] = max(knapsack[j], knapsack[j - cost] + mem);
		}
	}

	for (int i = 0; i <= 10'000; ++i) {
		if (knapsack[i] >= M) {
			cout << i << '\n';
			break;
		}
	}
}