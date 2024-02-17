#include <iostream>
#include <vector>
#include <stack>
#include <algorithm>
using namespace std;

vector<vector<int>> graph;

int dfs(int at, int& id, int& sid, vector<int>& ids, vector<bool>& on_stack, stack<int>& s, vector<int>& scc) {
	s.push(at);
	on_stack[at] = true;
	int low_link = ids[at] = id++;

	for (auto& to : graph[at]) {
		if (ids[to] == -1) low_link = min(low_link, dfs(to, id, sid, ids, on_stack, s, scc));
		if (on_stack[to]) low_link = min(low_link, ids[to]);
	}
	
	// at 정점의 id가 low_link와 같다면 at 정점 이후로 스택에 쌓인 정점들은 하나의 scc를 이루므로
	// at 정점이 스택에서 나올 때까지 스택에서 pop하면서 scc 그룹에 저장한다
	if (ids[at] == low_link) {
		while (true) {
			auto node = s.top(); s.pop();
			on_stack[node] = false;
			scc[node] = sid;
			if (node == at) break;
		}
		++sid;
	}

	return low_link;
}

vector<int> getSCC() {
	// scc 그룹을 저장
	// 각 그룹에는 scc를 이루는 정점들의 번호가 저장된다
	vector<int> scc(graph.size(), -1);
	// 각 정점의 고유한 id를 저장한다(dfs를 통해)
	// 초기값은 -1로 초기화한다(unvisited 상태)
	vector<int> ids(graph.size(), -1);
	// 정점이 스택에 존재하는지 여부를 저장한다(스택에 존재해야 scc를 이룰 가능성이 존재하므로)
	vector<bool> on_stack(graph.size(), false);
	stack<int> s;
	int id = 0, sid = 0;

	for (int i = 0; i < graph.size(); ++i) {
		if (ids[i] == -1) dfs(i, id, sid, ids, on_stack, s, scc);
	}
	
	return scc;
}

int getNodeIdx(int n) {
    if (n < 0) return -(n + 1) * 2 + 1;
    return (n - 1) * 2;
}

int getOpIdx(int n) {
    if (n & 1) return n - 1;
    return n + 1;
}

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int N, M; cin >> N >> M;
    graph.assign(2 * N, vector<int>{});
    for (int m = 0; m < M; ++m) {
        int a, b; cin >> a >> b;
        a = getNodeIdx(a);
        b = getNodeIdx(b);
        graph[getOpIdx(a)].push_back(b);
        graph[getOpIdx(b)].push_back(a);
    }
    
    auto res = getSCC();
    for (int i = 0; i < N; ++i) {
        if (res[2 * i] == res[2 * i + 1]) {
            cout << "0\n";
            return 0;
        }
    }
    cout << "1\n";
}