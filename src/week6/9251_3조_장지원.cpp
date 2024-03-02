#include <iostream>
using namespace std;

int dp[1001][1001];

int main(){
    string str1, str2;
    cin >> str1;
    cin >> str2;

    int cnt = 0;
    int idx = 0;
    
    
    for(int i=0; i<str1.length(); i++){
        for(int j=0; j<str2.length(); j++){
            if(str1[i] == str2[j]){
                // str1[i]와 str2[j]에서 --> 1개
                // str1의 i번째 바로 직전인 i-1 길이에서, 
                // str2의 j번째 바로 직전인 j-1개의 
                // 문자 비교 --> 최대 개수(dp[i-1][j-1]) 구함
                // dp[i-1][j-1]에 str1[i] == str2[j] 값인 1 추가
                dp[i+1][j+1] = dp[i][j] + 1;
            }else{
                dp[i+1][j+1] = max(dp[i][j+1], dp[i+1][j]);
            }
        }
    }
    
    cout << dp[str1.length()][str2.length()];

    return 0;
}
