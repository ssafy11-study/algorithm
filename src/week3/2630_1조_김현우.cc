#include <iostream>
#define fastio cin.tie(0)-> ios_base::sync_with_stdio(0)

using namespace std;

int arr[129][129];

int wc = 0, bc = 0;

void count(int si, int sj, int ei, int ej){
    int n = ei-si;
    if(arr[ei][ej] - arr[si][ej] - arr[ei][sj] + arr[si][sj] == n*n){
        bc++;
        return;
    }else if(arr[ei][ej] - arr[si][ej] - arr[ei][sj] + arr[si][sj] == 0){
        wc++;
        return;
    }
    else{
        int mi = ei-(n/2), mj = ej- n/2; 
        count(si,sj,mi,mj);
        count(si,mj,mi,ej);
        count(mi,sj,ei,mj);
        count(mi,mj,ei,ej);
    }
}

int main(void){
    fastio;
    int N;
    cin >> N;
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= N; j++){
            cin >> arr[i][j];
            arr[i][j] = arr[i-1][j] + arr[i][j-1] +arr[i][j] - arr[i-1][j-1];
        }
    }
    count(0,0,N,N);
    cout << wc << "\n" << bc;
}