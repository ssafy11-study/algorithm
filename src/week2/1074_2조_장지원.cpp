#include <iostream>
#include <math.h>
using namespace std;

int N, r, c;

int rlen;

int ans = 0;

void recur(int row, int col, int gisu){
    
    if(row == r && col == c){
        cout << ans;
        return;
    }
    
    int size = pow(2, gisu);
    int len = pow(2, gisu-1);
    
    if(r>= row && r < row + size && c >= col && c < col + size){
        recur(row, col, gisu-1);
        recur(row, col + len, gisu-1);
        recur(row + len, col, gisu-1);
        recur(row + len, col + len, gisu-1);
    }
    else{
        ans += size * size;
        return;
    }
  
}



int main(){
    
    cin >> N >> r >> c;
    
    rlen = (2 << N) - 1;

    recur(0, 0, N);

    return 0;
}


