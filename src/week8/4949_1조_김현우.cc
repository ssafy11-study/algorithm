#include <iostream>
#include <stack>
#include <string>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    string s;
    while(true){
        getline(cin,s);
        if(s == ".") break;
        stack <char> st;
        bool answer = true;
        for(int i = 0; i < s.length(); i++){
            if(s[i] == '('){
                st.push('(');
            }
            else if(s[i] == '['){
                st.push('[');
            }
            else if(s[i] == ')'){
                if(!st.empty() && st.top() == '(') st.pop();
                else {
                    answer = false;
                    break;
                }
            }
            else if(s[i] == ']'){
                if(!st.empty() && st.top() == '[') st.pop();
                else {
                    answer = false;
                    break;
                }
            }
        }
        if(answer && st.empty()) cout << "yes\n";
        else cout << "no\n";
    }
}