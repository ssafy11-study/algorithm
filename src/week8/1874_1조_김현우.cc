#include <iostream>
#include <vector>
#include <stack>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;


int main(void){
    fastio;
    int n, idx = 0;
    cin >> n;
    vector<int> v;
    vector<char> c;
    stack<int> s;
    v.resize(n);
    for(int i = 0; i <n; i++){
        cin >> v[i];
    }
    for(int i = 1; i<=n; i++){
        s.push(i);
        c.push_back('+');
        while(!s.empty()&&s.top() == v[idx]){
            idx++;
            c.push_back('-');
            s.pop();
        }
    }
    if(!s.empty()) cout << "NO";
    else for(int i = 0; i<c.size(); i++) cout << c[i] <<"\n";
}