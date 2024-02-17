#include <iostream>
#include <vector>
#include <map>
#include <string>

using namespace std;
//김현우
int main(void) {
	cin.tie(NULL);
	cout.tie(NULL);
	map < string, int> pokemon;
	vector <string> pokemon2;
	int N, M;
	string s;
	cin >> N >> M;
	getline(cin, s);
	for (int i = 1; i <= N; i++) {
		getline(cin, s);
		pokemon.insert({ s,i });
		pokemon2.push_back(s);
	}
	for (int i = 0; i < M; i++) {
		getline(cin, s);
		if (isdigit(s[0])) {
			cout << pokemon2[stoi(s)-1] <<"\n";
		}
		else {
			cout << pokemon.find(s)->second << "\n";
		}
	}
}