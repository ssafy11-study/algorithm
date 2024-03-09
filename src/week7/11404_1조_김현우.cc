#include <iostream>
#include <algorithm>
#include <cmath>
#include <climits>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[101][101];

int main(void){
    fastio;
    fill(&arr[0][0],&arr[100][100],10000001);
    int n, m, tmp1, tmp2, tmp3;
    cin>> n >> m;
    for(int i = 0; i < m; i++){
        cin >> tmp1 >> tmp2 >> tmp3;
        arr[tmp1][tmp2] = min(arr[tmp1][tmp2],tmp3);
    }
    for(int i = 1; i <= n; i++) arr[i][i] = 0;
    for(int k = 1; k <=n; k++){
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = min(arr[i][j],arr[i][k]+arr[k][j]);
            }
        }
    }
    for(int i = 1; i <= n; i++){
        for(int j = 1; j<=n; j++){
            if(arr[i][j] >= 10000001) cout << 0 <<" ";
            else cout << arr[i][j] <<" ";
        }
        cout <<"\n";
    }
}
