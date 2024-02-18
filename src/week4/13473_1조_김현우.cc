#include <iostream>

#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

int main(void){
    fastio;
    int w,h,sx,sy,ex,ey;
    cin >> w >> h >> sx >> sy >> ex >> ey;
    if(sx == ex){
        cout << 0 <<" " <<sy <<" "<< w << " "<<ey;
    }else{
        cout << sx <<" " << 0 << " " << ex << " " << h;
    }
}