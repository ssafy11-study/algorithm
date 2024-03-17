#include <iostream>
#include <algorithm>
#include <stack>
#include <cstring>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)
 
using namespace std;
 
int dp[1001][1001] = {0,};
 
int main(void){
    fastio;
    string s1, s2;
    cin >> s1 >> s2;
    for(int i = 1; i<= s1.length(); i++){
        for(int j = 1; j <= s2.length(); j++){
            if(s1[i-1] == s2[j-1]) dp[i][j] = dp[i-1][j-1] + 1;
            else dp[i][j] = max(dp[i-1][j],dp[i][j-1]);
        }
    }
    cout << dp[s1.length()][s2.length()] << "\n";
    stack<int> st;
    int i = s1.length(), j = s2.length();
    while(i > 0 && j > 0){
        if(dp[i-1][j] == dp[i][j])i--;
        else if(dp[i][j-1] == dp[i][j])j--;
        else{
            st.push(i-1);
            i--;
            j--;
        }
    }
    while(!st.empty()){
        cout << s1[st.top()];
        st.pop();
    }
}