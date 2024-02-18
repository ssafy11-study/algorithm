#include <iostream>
#include <queue>
#include <cmath>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int N, G, tmp1, tmp2, point = 0;
    priority_queue <int> q;
    cin >> N >> G;
    for(int i = 0; i < N; i++){
        cin >> tmp1 >> tmp2;
        if(tmp1>tmp2)point +=3;
        else if(tmp1 == tmp2){
            point+=1;
            q.push(0);
        }else{
            q.push(tmp1-tmp2);
        }
    }
    while(!q.empty()&& G != 0){
        tmp1 = q.top();
        q.pop();
        if(tmp1 == 0){
            G--;
            point+=2;
        }else{
            if(G == abs(tmp1)){
                G = 0;
                point+=1;
            }
            else if (G > abs(tmp1)){
                G += tmp1;
                G--;
                point+=3;
            }else{
                G = 0;
            }
        }
    }
    cout << point;
}