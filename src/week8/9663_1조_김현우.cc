#include <iostream>
#include <cmath>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int N, count = 0;
bool straight[15] = {false,};
bool left_cross[30] = {false,};
bool right_cross[30] = {false,};

void search(int idx){
    if(idx == N){
        count++;
        return;
    }
    for(int i = 0; i < N; i++){
        if(!straight[i] && !left_cross[idx-i+15] && !right_cross[i+idx]){
            straight[i] = true;
            left_cross[idx-i+15] = true;
            right_cross[i+idx] = true;
            search(idx+1);
            straight[i] = false;
            left_cross[idx-i+15] = false;
            right_cross[i+idx] = false;
        }
    }
}

int main(void){
    fastio;
    cin >> N;
    search(0);
    cout << count;
}