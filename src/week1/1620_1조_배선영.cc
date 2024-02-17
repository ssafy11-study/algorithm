#include <iostream>
#include <map>
#include <string>
using namespace std;

// 부울경_4반_배선영

int main() {
    cin.tie(NULL);
	ios_base::sync_with_stdio(false);
	int N, M; // 포켓몬의 개수, 맞춰야 하는 문제의 개수
	map<string, int> strM; // 포켓몬 이름 - 번호
	map<int, string> numM; // 번호 - 포켓몬 이름

	cin >> N >> M;

	for (int i = 1; i <= N; i++) {
		string input;
		cin >> input;
		strM[input] = i;
		numM[i] = input;
	}

	for (int i = 0; i < M; i++) {
		string q;
		cin >> q;
		if (!isdigit(q[0])) { // 입력 받은 데이터가 문자인 경우
			cout << strM[q] << '\n';
		}
		else {
			cout << numM[stoi(q)] << '\n';
		}
	}
	return 0;
}
