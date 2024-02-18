#include <iostream>
#include <vector>
#define fastio cin.tie(0)->ios_base::sync_with_stdio(0)

using namespace std;
// 신발끈 공식
int main(void){
    fastio;
    int N;
    long double tmp, sum = 0;
    vector<long double> x, y;
    cin >> N;
    for(int i = 0; i < N; i++){
        cin >> tmp;
        x.push_back(tmp);
        cin >> tmp;
        y.push_back(tmp);
    }
    for(int i = 0; i <N-1; i++){
        sum += x[i]*y[i+1];
    }
    sum += x[N-1]*y[0];
    for(int i = 0; i <N-1; i++){
        sum -= y[i]*x[i+1];
    }
    sum -= y[N-1]*x[0];
    sum = abs(sum);
    cout.precision(1);
    cout << fixed << sum*0.5;
}