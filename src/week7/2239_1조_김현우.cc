#include <iostream>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[9][9] = {0,};
bool cols[9][10] = {false,}; // 행
bool rows[9][10] = {false,}; // 열 
bool square[9][10] = {false,}; // 사각형

int get_square(int i, int j){
    if(i < 3 && j < 3) return 0;
    if(i < 3 && j < 6) return 1;
    if(i < 3 && j < 9) return 2;
    if(i < 6 && j < 3) return 3;
    if(i < 6 && j < 6) return 4;
    if(i < 6 && j < 9) return 5;
    if(i < 9 && j < 3) return 6;
    if(i < 9 && j < 6) return 7;
    return 8;
}

bool search(int idx){
    if(idx == 81){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                cout << arr[i][j];
            }
            cout << "\n";
        }
        return true;
    }
    int y = idx/9, x = idx%9;
    if(arr[y][x] != 0)return search(idx+1);
    else {
        for(int i = 1; i <= 9; i++){
            if(!cols[y][i] && !rows[x][i] && !square[get_square(y,x)][i]){
                cols[y][i] = true;
                rows[x][i] = true;
                square[get_square(y,x)][i] = true;
                arr[y][x] = i;
                if(search(idx+1))return true;
                arr[y][x] = 0;
                cols[y][i] = false;
                rows[x][i] = false;
                square[get_square(y,x)][i] = false;
            }
        }
    }
    return false;
}

int main(void){
    fastio;
    string s;
    for(int i = 0; i < 9; i++){
        cin >> s;
        for(int j = 0; j < 9; j++){
            arr[i][j] = (int)s[j]-48;
            if(arr[i][j] != 0){
                cols[i][arr[i][j]] = true;
                rows[j][arr[i][j]] = true;
                square[get_square(i,j)][arr[i][j]] = true;
            }
        }
    }
    search(0);
}