#include <iostream>
#include <algorithm>
#include <stack>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    string s1, s2, tmp;
    cin >> s1 >> s2;
    stack<char> st;
    reverse(s2.begin(),s2.end());
    for(int i = 0; i < s1.length(); i++){
        st.push(s1[i]);
        if(s1[i]==s2[0] && st.size()>=s2.length()){
            tmp = "";
            for(int j = 0; j < s2.length(); j++){
                tmp += st.top();
                st.pop();
            }
            if(tmp != s2){
                for(int j = tmp.length()-1; j >= 0; j--)st.push(tmp[j]);
            }
        }
    }
    if(st.empty())cout << "FRULA";
    else{
        tmp = "";
        while(!st.empty()){
            tmp += st.top();
            st.pop();
        }
        reverse(tmp.begin(),tmp.end());
        cout << tmp;
    }
}