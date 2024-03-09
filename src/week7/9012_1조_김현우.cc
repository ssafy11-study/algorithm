#include <iostream>
#include <stack>
#include <string>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    stack<int> stack;
    int T;
    string s;
    cin >> T;
    getline(cin,s);
    for(int t = 0; t<T; t++){
        int flag = 0;
        getline(cin, s);
        for(int i = 0; i < s.length(); i++){
            switch(s[i]){
            case '(': 
                stack.push(1);
                break;
            case ')':
                if(!stack.empty()){ 
                    stack.pop();
                }
                else{
                   flag = 1;
                }
            }
            if(flag)break;
        }
        if(flag || !stack.empty()) cout << "NO\n";
        else cout << "YES\n";
        while(!stack.empty())stack.pop();
    }
}