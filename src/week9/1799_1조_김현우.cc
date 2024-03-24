#include <iostream>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int max_value, N;
bool map[10][10] = {false,}, left_cross[20] = {false,}, right_cross[20] = {false,};

void backtracking(int y, int x, int count,bool flag){
    if(x >= N){
        if(flag)backtracking(y+1,(y+1)%2,count,flag);
        else backtracking(y+1,y%2,count,flag);
        return;
    }
    if(y >= N){
        if(count> max_value)max_value = count;
        return;
    }
    if(!map[y][x] && !left_cross[y-x+10] && !right_cross[y+x]){
        left_cross[y-x+10] = true;
        right_cross[y+x] = true;
        backtracking(y,x+2,count+1,flag);
        left_cross[y-x+10] = false;
        right_cross[y+x] = false;
    }
    backtracking(y,x+2,count,flag);
}

int main(void){
    fastio;
    int tmp;
    fill(&map[0][0],&map[9][9],false);
    cin >> N;
    for(int i = 0; i < N; i++){
        for(int j = 0; j < N; j++){
            cin >> tmp;
            if(tmp == 0)map[i][j] = true;
        }
    }
    backtracking(0,1,0,false);
    int result = max_value;
    max_value = 0;
    backtracking(0,0,0,true);
    cout << result + max_value;
}