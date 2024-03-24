#include <iostream>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int arr[100001] = {0,};

int find(int x){
    if (arr[x] == x)return x;
    else return arr[x] = find(arr[x]);
}

void merge(int x, int y){
    int px = find(x), py = find(y);
    if(px>py)arr[px] = py;
    else arr[py] = px;
}

int main(void){
    fastio;
    int G, P, count = 0, tmp;
    cin >> G >> P;
    bool closed = false;
    for(int i = 1; i <=G; i++)arr[i] = i;
    for(int i = 0; i < P; i++){
        cin >> tmp;
        int tmp2 = find(tmp);
        if(tmp2 != 0 && !closed){
            merge(tmp2,tmp2-1);
            count++;
        }else{
            closed = true;   
        }
    }
    cout << count;
}