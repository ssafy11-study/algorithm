#include <iostream>
#include <vector>
#include <string>
#include <map>
#include <set>
using namespace std;

int N, M;
set<map<int, int>> mem;
map<int, int> travel;
vector<int> idxs;
string incdec;

int main() {
	cin.tie(nullptr)->sync_with_stdio(false);
	cin >> N >> M;
	
	idxs.assign(M, 0);
	incdec.assign(M, 0);
	
	for (int& i : idxs) cin >> i;
	cin >> incdec;

	for (int& i : idxs) travel.insert({ i, 0 });
	mem.insert(travel);

	for (int i = 0; i < M; ++i) {
		if (incdec[i] == '+') {
			++travel[idxs[i]];
			if (mem.find(travel) != mem.end()) {
				cout << "0\n";
				return 0;
			}
			mem.insert(travel);
		}
		else {
			--travel[idxs[i]];
			if (mem.find(travel) != mem.end()) {
				cout << "0\n";
				return 0;
			}
			mem.insert(travel);
		}
	}

	cout << "1\n";
}