#include <iostream>

using namespace std;

int arr[15][15] = {0};

int search(int n, int r, int c){
    if(n == 1){
        return r*2 + c;
    }
    else{
        int tmp = 1<< (n-1);
        if(r>=tmp && c>=tmp){
            return (tmp*tmp*3) + search(n-1,r-tmp,c-tmp);
        }else if(r >= tmp){
            return (tmp*tmp*2) + search(n-1,r-tmp,c);
        }else if(c >= tmp){
            return (tmp*tmp) + search(n-1,r,c-tmp);   
        }else{
            return search(n-1,r,c);
        }
    }
}

int main(void){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, r, c;
    cin >> N >> r>> c;
    N = 1 << N;
    cout <<search(N,r,c);
}