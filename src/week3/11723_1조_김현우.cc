#include <iostream>
#include <algorithm>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

int arr[21];

int main(void){
    fastio;
    int M, tmp;
    string s;
    cin >> M;
    for(int i = 0; i < M; i++){
        cin >> s;
        if(s == "all"){
            fill(arr,arr+21,1);
        }else if(s == "empty"){
            fill(arr,arr+21,0);
        }else{
            cin >> tmp;
            if(s == "add") arr[tmp] = 1;
            else if(s == "remove") arr[tmp] = 0;
            else if(s == "check") cout << arr[tmp] << "\n";
            else arr[tmp] ^= 1;
        }
    }
}