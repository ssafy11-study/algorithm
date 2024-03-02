#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;


bool comp(pair<int,int> o1, pair<int,int> o2){
    if(o1.second != o2.second)
        return o1.second < o2.second;
    else 
        return o1.first < o2.first;
}

int main(){
    int N;  cin >> N;
    vector<pair<int,int>> v;
    
    for(int i=0; i<N; i++){
        int s, e;
        cin >> s >> e;
        v.push_back({s,e});
    }
   
    sort(v.begin(), v.end(), comp);
    
    int limit = (*v.end()).second;
    int end = v[0].second;
    int cnt = 1;
    
    for(int i=1; i<N; i++){
        if(end <= v[i].first){
            cnt++;
            end = v[i].second;
        }
    }
    
    cout << cnt;
    
    return 0;
}
