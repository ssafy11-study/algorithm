#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;
using ll = long long;

struct Info {
	ll cost, earn;
};

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	ll N, M; cin >> N >> M;
	vector<ll> costs(N), earns(N);
	vector<Info> prob; prob.reserve(N);

	for (auto& n : costs) cin >> n;
	for (auto& n : earns) cin >> n;

	for (int i = 0; i < N; ++i) {
		if (earns[i] <= costs[i]) continue;
		prob.push_back({ costs[i], earns[i] });
	}

	sort(prob.begin(), prob.end(), [](Info const& a, Info const& b) {
		return a.cost < b.cost;
	});

	for (int i = 0; i < prob.size(); ++i) {
		if (M >= prob[i].cost) M += prob[i].earn - prob[i].cost;
		else break;
	}

	cout << M << '\n';
}