#include <iostream>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[101][101] = {0,};

int main(void){
    fastio;
    int N;
    cin >> N;
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cin >> arr[i][j];
        }
    }
    for(int k = 1; k <= N; k++){
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(arr[i][j] == 1)continue;
                if(arr[i][k]==1&&arr[k][j]==1)arr[i][j] = 1;
            }
        }
    }
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cout << arr[i][j] << " ";
        }
        cout << "\n";
    }
}