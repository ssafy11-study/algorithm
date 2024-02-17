#include <iostream>
#include <queue>
#include <vector>
#include <algorithm>
#define fastio cin.tie(0) -> ios_base::sync_with_stdio(0)

using namespace std;

vector<int> MST[10002];
bool vertex[10001];
bool test(int idx, int key){
    return find(MST[idx].begin(),MST[idx].end(), key) != MST[idx].end();
}

int main(void){
    fastio;
    int V, E, A, B, C, sum = 0, mstcount = 0;
    cin >> V >> E;
    priority_queue <pair<int,pair<int,int>>, vector<pair<int,pair<int,int>>>, greater<pair<int,pair<int,int>>>> pq;
    
    for(int i = 0; i <E; i++){
        cin >> A >> B >> C;
        pq.push({C,{A,B}});
    }
    while(!pq.empty()){
        int v1 = pq.top().second.first , v2 = pq.top().second.second, data = pq.top().first;
        pq.pop();
        if(vertex[v1] && vertex[v2]){
            // cout << v1 <<" "<< v2 << endl;;
            int i;
            int mstnum1, mstnum2;
            for(i = 0; i < mstcount; i++){
                if(test(i, v1) && test(i, v2)) break;
                if(find(MST[i].begin(),MST[i].end(), v1) != MST[i].end()) mstnum1 = i;
                if(find(MST[i].begin(),MST[i].end(), v2) != MST[i].end()) mstnum2 = i;
            }
            if(i < mstcount) continue;
            else{
                if(mstnum1 > mstnum2) swap(mstnum1, mstnum2);
                for(auto x : MST[mstnum2]) MST[mstnum1].push_back(x);
                MST[mstnum2].clear();
            }
        }
        else if(!vertex[v1] && !vertex[v2]){
            if(v1 == v2) continue;
            MST[mstcount].push_back(v1);
            MST[mstcount].push_back(v2);
            vertex[v1] = true;
            vertex[v2] = true;
            mstcount++;
        }else if(vertex[v1]){
            for(int i = 0; i < mstcount; i++){
                if(find(MST[i].begin(),MST[i].end(), v1) != MST[i].end()) {
                    MST[i].push_back(v2);
                    break;
                }
            }
            vertex[v2] = true;
        }else{
           for(int i = 0; i < mstcount; i++){
                if(find(MST[i].begin(),MST[i].end(), v2) != MST[i].end()) {
                    MST[i].push_back(v1);
                    break;
                }
            } 
            vertex[v1] = true;
        }
        sum += data;
        if(MST[0].size() == V){
            break;
        }
    }
    cout << sum << endl;
    //cout << sum;
}
