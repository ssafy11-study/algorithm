#include <iostream>
#include <algorithm>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;

long long ccw(long long px1, long long py1, long long px2, long long py2, long long px3, long long py3){
    long long result = (px1*py2+px2*py3+px3*py1)-(px2*py1+px3*py2+px1*py3);
    if(result < 0) return -1;
    else if(result >0) return 1;
    else return 0;
}

bool check(long long x1, long long y1, long long x2, long long y2, long long x3, long long y3){
    long long i1 = x1, i2 = x2, i3 = x3, j1 = y1, j2 = y2, j3 = y3;
    if(i1>i2)swap(i1,i2);
    if(j1>j2)swap(j1,j2);
    if(i1<=i3&&i3<=i2&&j1<=j3&&j3<=j2){
                return true;
    }
    return false;
}

int main(void){
    fastio;
    long long px1,px2,px3,px4,py1,py2,py3,py4;
    cin >> px1 >> py1 >> px2 >> py2 >> px3 >> py3 >> px4 >> py4;
    long long i1 = ccw(px1,py1,px2,py2,px3,py3);
    long long i2 = ccw(px1,py1,px2,py2,px4,py4);
    long long j1 = ccw(px3,py3,px4,py4,px1,py1);
    long long j2 = ccw(px3,py3,px4,py4,px2,py2);
    
    if(i1*i2 == -1 && j1*j2 == -1){
        cout << 1;
    }else if( i1*i2*j1*j2 == 0){
        if(i1 == 0 && check(px1,py1,px2,py2,px3,py3)){
            cout << 1;
            return 0;
        }if(i2== 0 && check(px1,py1,px2,py2,px4,py4)){
            cout << 1;
            return 0;
        }if(j1 == 0 && check(px3,py3,px4,py4,px1,py1)){
            cout << 1;
            return 0;
        }if(j2 == 0 && check(px3,py3,px4,py4,px2,py2)){
            cout << 1;
            return 0;
        }
        cout << 0;
    }else{
        cout << 0;
    }
}
