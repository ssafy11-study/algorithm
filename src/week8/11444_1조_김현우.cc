#include <iostream>
#include <vector>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

vector<vector<long long>> mult(vector<vector<long long>> &A, vector<vector<long long>> &B){
    vector<vector<long long>> C = {{0,0},{0,0}};
    for(int i = 0; i < 2; i++){
        for(int j = 0; j < 2; j++){
            for(int k = 0; k < 2; k++){
                C[i][j] = (C[i][j]+(A[i][k]*B[k][j]))%1000000007;
            }
        }
    }
    return C;
}


int main(void){
    fastio;
    long long N;
    cin >> N;
    vector<vector<long long>> result = {{1,0},{0,1}}, tmp = {{1,1},{1,0}};
    while(N>0){
        if(N%2 == 1) result = mult(result,tmp);
        tmp = mult(tmp,tmp);
        N/=2;
    }
    cout << result[0][1];
}