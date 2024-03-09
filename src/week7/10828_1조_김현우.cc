#include <iostream>
#include <stack>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    stack<int> stack;
    int N, tmp;
    string s;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> s;
        if(s == "push"){
            cin >> tmp;
            stack.push(tmp);
        }
        else if(s == "pop"){
            if(stack.empty()) cout << -1 <<"\n";
            else{
                cout << stack.top() << "\n";
                stack.pop();
            }
        }
        else if(s == "size"){
            cout << stack.size() << "\n";
        }
        else if(s == "empty"){
            if(stack.empty()) cout << 1 <<"\n";
            else cout << 0 <<"\n";
        }else{
            if(stack.empty()) cout << -1 <<"\n";
            else cout << stack.top() << "\n";
        }
    }
}