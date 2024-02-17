#include <iostream>
#include <string>
#include <vector>
#include <unordered_set>
#include <map>
#include <algorithm>
using namespace std;

unordered_set<string> us;

struct TrieNode {
	bool is_end_of_word = false;
	map<char, TrieNode*> next_chars;

	~TrieNode() {
		for (auto& iter : next_chars) {
			delete iter.second;
			iter.second = nullptr;
		}
	}
};

struct Trie {
	TrieNode root;

	// 문자열 추가
	void insert(string& text) {
		TrieNode* node = &root;
		for (int i = 0; i < text.size(); ++i) {
			if (node->next_chars.find(text[i]) == node->next_chars.end()) {
				node->next_chars[text[i]] = new TrieNode();
			}
			node = node->next_chars[text[i]];
		}
		node->is_end_of_word = true;
	}

	// 문자열 검색
	bool search(string& text) {
		TrieNode* node = &root;
		string rev = text; reverse(rev.begin(), rev.end());
		for (int i = 0; i < text.size(); ++i) {
		    if (node->is_end_of_word && us.count(rev)) return true;
			if (node->next_chars.find(text[i]) == node->next_chars.end()) {
				return false;
			}
			node = node->next_chars[text[i]];
			rev.pop_back();
		}
		return false;
	}
};

Trie tr;

int main() {
    cin.tie(nullptr)->sync_with_stdio(false);
    int N, M; cin >> N >> M;
    for (int i = 0; i < N; ++i) {
        string s; cin >> s;
        tr.insert(s);
    }
    for (int i = 0; i < M; ++i) {
        string s; cin >> s; reverse(s.begin(), s.end());
        us.insert(s);
    }
    int Q; cin >> Q;
    for (int i = 0; i < Q; ++i) {
        string s; cin >> s;
        cout << (tr.search(s)? "Yes\n" : "No\n");
    }
}