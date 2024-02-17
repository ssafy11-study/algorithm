#include <iostream>
#include <string>
#include <stack>

#define fastio cin.tie(0) -> ios_base::sync_with_stdio

using namespace std;

int main(void){
    fastio;
    stack <char> st;
    string s;
    getline(cin, s);
    for(int i = 0; i < s.length(); i++){
        if(s[i] == '('){
            st.push('(');
        }
        else if(s[i] == '*' || s[i] == '/'){
            if(!st.empty()){
                if(st.top() == '*' || st.top() == '/'){
                    cout << st.top();
                    st.pop();
                }
            }
            st.push(s[i]);
        }
        else if(s[i] == ')'){
            while(st.top() != '('){
                cout << st.top();
                st.pop();
            }
            st.pop();
        }else if(s[i] == '+' || s[i] == '-'){
            if(!st.empty()){
                if(st.top() == '*' || st.top() == '/'){
                    cout << st.top();
                    st.pop();
                }
                if(!st.empty() && (st.top() == '+' || st.top() == '-')){
                    cout << st.top();
                    st.pop();
                }
            }
            st.push(s[i]);
        }
        else{
            cout << s[i];
        }
    }
    while(!st.empty()){
        cout << st.top();
        st.pop();
    }
}